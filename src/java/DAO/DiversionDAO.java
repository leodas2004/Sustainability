package DAO;

import DTO.TotalDTO;
import Sustainability.Category;
import Sustainability.ChartType;
import Sustainability.HibernateUtil;
import Sustainability.Diversionsaving;
import Sustainability.Users;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Row;
import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author Alok Shrestha
 */


public class DiversionDAO {

    SessionFactory sessionFactory = null;
    Session session = null;
    Diversionsaving diversionSaving;
    ArrayList<Diversionsaving> diversionList;

    
    
    public void insertDiversionRecord(Diversionsaving _diversionsaving) {
        try {
            sessionFactory = HibernateUtil.getSessionFactory();
            session = sessionFactory.getCurrentSession();
            org.hibernate.Transaction tx = session.beginTransaction();
            diversionSaving = new Diversionsaving();
            tx.begin();
            session.save(_diversionsaving);
            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Diversionsaving> getDiversionSaving(Date startDate, Date endDate) {
        diversionList = new ArrayList<Diversionsaving>();
        try {
            sessionFactory = HibernateUtil.getSessionFactory();
            session = sessionFactory.getCurrentSession();
            org.hibernate.Transaction tx = session.beginTransaction();
            Query query = session.createSQLQuery("select * from DiversionSaving u where u.Date>=:sDate && u.Date<=:eDate")
                    .addEntity(Diversionsaving.class)
                    .setParameter("sDate", startDate)
                    .setParameter("eDate", endDate);
            List result = query.list();
            Iterator<Diversionsaving> iterator = result.iterator();
            while (iterator.hasNext()) {
                Diversionsaving dSaving = new Diversionsaving();
                dSaving = iterator.next();
                diversionList.add(dSaving);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        session.close();
        return diversionList;
    }

    /**
     * This method is used to create an excel report based on date range
     *
     * @param startDate start date to create report
     * @param endDate end date to create report.
     * @param filepath path of the file
     */
    public void exportToExcel(Date startDate, Date endDate, String filepath) {
        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet("Sample sheet");
        CreationHelper createHelper = workbook.getCreationHelper();
        DiversionDAO dDAO = new DiversionDAO();
        ArrayList<Diversionsaving> savingList = dDAO.getDiversionSaving(startDate, endDate);
        int rownum = 0;
        sheet.setColumnWidth(0, 6000);
        sheet.setColumnWidth(1, 5000);
        Row headerrow = sheet.createRow(rownum++);
        Cell headerCategory = headerrow.createCell(0);
        Cell headerDate = headerrow.createCell(1);
        Cell headerQuantity = headerrow.createCell(2);
        Cell headerUser = headerrow.createCell(3);
        Cell headerRate = headerrow.createCell(4);
        Cell headerUnit = headerrow.createCell(5);
        Cell headerLandFillDate = headerrow.createCell(6);
        Cell headerSavingAmount = headerrow.createCell(7);
        headerCategory.setCellValue("Category");
        headerDate.setCellValue("Date");
        headerQuantity.setCellValue("Quantity");
        headerUser.setCellValue("User");
        headerRate.setCellValue("Landfill Rate");
        headerUnit.setCellValue("Unit");
        headerLandFillDate.setCellValue("Landfill Rate Date");
        headerSavingAmount.setCellValue("Saving Amount");
        for (Diversionsaving saving : savingList) {
            Row row = sheet.createRow(rownum++);
            for (int cellnum = 0; cellnum < 8; cellnum++) {
                Cell cell = row.createCell(cellnum);

                if (cellnum == 0) {
                    System.out.println((String) saving.getCategory().getCategoryName());
                    cell.setCellValue((String) saving.getCategory().getCategoryName());
                }
                if (cellnum == 1) {
                    CellStyle cellStyle = workbook.createCellStyle();
                    cellStyle.setDataFormat(createHelper.createDataFormat().getFormat("m/d/yy"));
                    System.out.println((Date) saving.getDate());
                    cell.setCellStyle(cellStyle);
                    cell.setCellValue((Date) saving.getDate());
                }
                if (cellnum == 2) {
                    System.out.println((Double) saving.getQuantity());
                    cell.setCellValue((Double) saving.getQuantity());
                }
                if (cellnum == 3) {
                    System.out.println((String) saving.getUsers().getUsername());
                    cell.setCellValue((String) saving.getUsers().getUsername());
                }
                if (cellnum == 4) {
                    System.out.println((Double) saving.getLandfillRate());
                    cell.setCellValue((Double) saving.getLandfillRate());
                }
                if (cellnum == 5) {
                    System.out.println((String) saving.getUnit());
                    cell.setCellValue((String) saving.getUnit());
                }
                if (cellnum == 6) {
                    CellStyle cellStyle = workbook.createCellStyle();
                    cellStyle.setDataFormat(createHelper.createDataFormat().getFormat("m/d/yy"));
                    System.out.println((Date) saving.getLandfillDate());
                    cell.setCellStyle(cellStyle);
                    cell.setCellValue((Date) saving.getLandfillDate());
                }
                if (cellnum == 7) {
                    cell.setCellValue(0.0);
                }
            }
        }

        try {
            FileOutputStream out =
                    new FileOutputStream(new File(filepath));
            workbook.write(out);
            out.close();
            System.out.println("Excel written successfully..");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * This method is used to print the chart for the diversion saving.
     *
     * @param startDate Start date of the report. Date in format of "YYYY-MM-DD"
     * @param endDate End date of the report. Date in format of "YYYY-MM-DD"
     * @param filepath Path and filename where the pdf will be saved.
     * @param chartType Type of chart pie or bar
     */
    public void printChart(String startDate, String endDate, String filepath, ChartType chart) {
        JasperReport jasperReport;
        JasperPrint jasperPrint;
        SessionFactory sessionFactory = null;
        Session session = null;
        Query query;
        String sampleReportFile;
        if (chart == ChartType.PIE) {
            sampleReportFile = new String("c://reportPie.jrxml");
        } else {
            sampleReportFile = new String("c://reportBar.jrxml");
        }
        HashMap jasperParameter = new HashMap();
        try {
            sessionFactory = HibernateUtil.getSessionFactory();
            session = sessionFactory.getCurrentSession();
            org.hibernate.Transaction tx = session.beginTransaction();
            sessionFactory = HibernateUtil.getSessionFactory();
            session = sessionFactory.getCurrentSession();

            HashMap parameters = new HashMap();


//			parameters.put("NoOfGames", new Integer(3));
            if (chart == ChartType.PIE) {
                query = session.createSQLQuery("select CategoryName as categoryName, sum(Quantity) as total from diversionsaving where Date>=:sDate && Date<=:eDate group by CategoryName")
                        .addScalar("categoryName", Hibernate.STRING)
                        .addScalar("total", Hibernate.DOUBLE);
                query.setParameter("sDate", startDate);
                query.setParameter("eDate", endDate);
            }
            else{
                query = session.createSQLQuery("select  CategoryName, Sum(Quantity) as total,EXTRACT(YEAR FROM Date) as year from diversionsaving where Date>=:sDate && Date<=:eDate group by CategoryName, Year")
                        .addScalar("categoryName", Hibernate.STRING)
                        .addScalar("total", Hibernate.DOUBLE)
                        .addScalar("year",Hibernate.INTEGER);
                query.setParameter("sDate", startDate);
                query.setParameter("eDate", endDate);
            }

            //String q="select CategoryName as categoryName, sum(Quantity) as total from diversionsaving  where date>='1/1/2010' && date<='6/1/2010' group by CategoryName";

            // parameters.put("mySqlQuery", q);


            List result = query.list();
            ArrayList<TotalDTO> arraylist = new ArrayList<TotalDTO>();
            Iterator iterator = result.iterator();
            while (iterator.hasNext()) {
                Object[] objects = (Object[]) iterator.next();
                String categoryName = (String) objects[0];
                Double quantity = (Double) objects[1];
                System.out.println(categoryName + quantity);
                TotalDTO t = new TotalDTO();
                t.setCategoryName(categoryName);
                t.setTotal(quantity);
                if (chart == ChartType.BAR) {
                    Integer year=(Integer)objects[2];
                    t.setYear(year);
                }
                arraylist.add(t);
            }


            JasperDesign design = JRXmlLoader.load(sampleReportFile);

            JasperReport report = JasperCompileManager.compileReport(design);
            System.out.println(arraylist.size());
            for(TotalDTO a:arraylist){
                System.out.println("Hello:"+a.getCategoryName());
            }
            JasperPrint print = JasperFillManager.fillReport(report, parameters, new JRBeanCollectionDataSource(arraylist, false));
            System.out.println("hello");
            JasperExportManager.exportReportToPdfFile(print, filepath);
        } catch (JRException ex) {
            ex.printStackTrace();
        }
    }
}