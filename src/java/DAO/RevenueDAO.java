/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Sustainability.Diversionsaving;
import Sustainability.HibernateUtil;
import Sustainability.Revenue;
import Sustainability.Transportation;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Row;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author S405364
 */
public class RevenueDAO {

    SessionFactory sessionFactory = null;
    Session session = null;
    Revenue revenue;
    ArrayList<Revenue> revenueList;

    /**
     * Inserts single instance of revenue into database.
     *
     * @param _revenue
     */
    public void insertRevenueRecord(Revenue _revenue) {
        Long recentLot;
        try {
            sessionFactory = HibernateUtil.getSessionFactory();
            session = sessionFactory.openSession();
            org.hibernate.Transaction tx = session.beginTransaction();
//            Transportation trans = new Transportation();
//            trans.setDate(new Date());
//            trans.setCost(60.00);
            TransportationDAO tDAO = new TransportationDAO();
//            tDAO.insertTransportationCost(trans);
            ArrayList<Transportation> list = tDAO.getTransCosts();
            Collections.sort(list, new Comparator<Transportation>() {
                @Override
                public int compare(Transportation object1, Transportation object2) {
                    return object1.getLot().compareTo(object1.getLot());
                }
            });
            Transportation temp=list.get(list.size()-1);
            
            _revenue.setTransportation(temp);
            System.out.println(_revenue.getCategory().getCategoryName());
            System.out.println(_revenue.getTransportation().getLot());
            session.save(_revenue);
            tx.commit();
            System.out.println("Revenue recorded successfully");
        } catch (Exception e) {
            //e.printStackTrace();
            e.printStackTrace();
            System.out.println("Cannot insert revenue.\n"+e.getMessage());
        }
    }

    /**
     * This method is used to insert a group of revenues.
     *
     * @param _revenues Arraylist of revenue objects to be inserted into
     * database.
     */
    public void insertRevenueRecords(ArrayList<Revenue> _revenues) {
        sessionFactory = HibernateUtil.getSessionFactory();
        session = sessionFactory.getCurrentSession();
        org.hibernate.Transaction tx = session.beginTransaction();
        tx.begin();
        Transportation trans = new Transportation();
        trans.setDate(new Date());
        TransportationDAO tDAO = new TransportationDAO();
        tDAO.insertTransportationCost(trans);
        for (Revenue r : _revenues) {
            System.out.println("helloman:"+r.getCategory().getCategoryName());
            insertRevenueRecord(r);
        }
        //tx.commit();
    }
    
    public ArrayList<Revenue> getRevenues(Date startDate, Date endDate) {
        revenueList = new ArrayList<Revenue>();
        try {
            sessionFactory = HibernateUtil.getSessionFactory();
            session = sessionFactory.getCurrentSession();
            org.hibernate.Transaction tx = session.beginTransaction();
            Query query = session.createSQLQuery("select * from Revenue u where u.Date>=:sDate && u.Date<=:eDate")
                    .addEntity(Revenue.class)
                    .setParameter("sDate", startDate)
                    .setParameter("eDate", endDate);
            List result = query.list();
            Iterator<Revenue> iterator = result.iterator();
            while (iterator.hasNext()) {
                Revenue r = new Revenue();
                r = iterator.next();
                revenueList.add(r);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        session.close();
        return revenueList;
    }
    
    /**
    * This method is used to export the revenue data for a date range to a excel file.
    * @param startDate Start date of the data to be extracted
    * @param endDate End date of the data to be extracted
    * @param filepath Path of the excel file where the file will be stored
    */
    public void exportToExcel(Date startDate, Date endDate, String filepath) {
        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet("Sample sheet");
        CreationHelper createHelper = workbook.getCreationHelper();
        RevenueDAO dDAO = new RevenueDAO();
        ArrayList<Revenue> revenueList = dDAO.getRevenues(startDate, endDate);
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
        Cell headerRevenueAmount = headerrow.createCell(6);
        Cell headerComment = headerrow.createCell(7);
        Cell headerLot = headerrow.createCell(8);
        
        headerCategory.setCellValue("Category");
        headerDate.setCellValue("Date");
        headerQuantity.setCellValue("Quantity");
        headerUser.setCellValue("User");
        headerRate.setCellValue("Landfill Rate");
        headerUnit.setCellValue("Unit");
        headerRevenueAmount.setCellValue("Amount");
        headerRevenueAmount.setCellValue("Comment");
        headerRevenueAmount.setCellValue(("Lot"));
        //headerLandFillDate.setCellValue("Landfill Rate Date");
       // headerSavingAmount.setCellValue("Saving Amount");
        for (Revenue revenue : revenueList) {
            Row row = sheet.createRow(rownum++);
            for (int cellnum = 0; cellnum < 8; cellnum++) {
                Cell cell = row.createCell(cellnum);

                if (cellnum == 0) {
                    System.out.println((String) revenue.getCategory().getCategoryName());
                    cell.setCellValue((String) revenue.getCategory().getCategoryName());
                }
                if (cellnum == 1) {
                    CellStyle cellStyle = workbook.createCellStyle();
                    cellStyle.setDataFormat(createHelper.createDataFormat().getFormat("m/d/yy"));
                    System.out.println((Date) revenue.getSellingdate());
                    cell.setCellStyle(cellStyle);
                   //System.out.println("Test:"+saving.getDiversiondate());
                    cell.setCellValue((Date) revenue.getSellingdate());
                }
                if (cellnum == 2) {
                    System.out.println((Double) revenue.getQuantity());
                    cell.setCellValue((Double) revenue.getQuantity());
                }
                if (cellnum == 3) {
                    System.out.println((String) revenue.getUsers().getUsername());
                    cell.setCellValue((String) revenue.getUsers().getUsername());
                }
                if (cellnum == 4) {
                    System.out.println("Check"+(Double) revenue.getMarketRate());
         
                    cell.setCellValue((Double) revenue.getMarketRate());
                }
                if (cellnum == 5) {
                    System.out.println((String) revenue.getUnit());
                    cell.setCellValue((String) revenue.getUnit());
                }
                if (cellnum == 7) {
                    cell.setCellValue((String)revenue.getComment());
                }
                if (cellnum == 6) {
                    cell.setCellValue(revenue.getAmount());
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
}
