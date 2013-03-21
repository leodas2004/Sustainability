
import DTO.TotalDTO;
import Sustainability.Diversionsaving;
import Sustainability.HibernateUtil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author s405364
 */
public class TestJasper {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        JasperReport jasperReport;
        JasperPrint jasperPrint;
        SessionFactory sessionFactory = null;
        Session session = null;
        String sampleReportFile =
			new String("c://report4.jrxml");
        HashMap jasperParameter = new HashMap();
        try {
          sessionFactory = HibernateUtil.getSessionFactory();
          session = sessionFactory.getCurrentSession();
          org.hibernate.Transaction tx = session.beginTransaction();
          sessionFactory = HibernateUtil.getSessionFactory();
          session = sessionFactory.getCurrentSession();
          
          HashMap parameters = new HashMap();
        
          
//			parameters.put("NoOfGames", new Integer(3));
            
          Query query = session.createSQLQuery("select CategoryName as categoryName, sum(Quantity) as total from diversionsaving where Date>='2010-1-1' && Date<='2011-02-3' group by CategoryName")
                  .addScalar("categoryName", Hibernate.STRING)
                  .addScalar("total",Hibernate.DOUBLE);
                  
         //String q="select CategoryName as categoryName, sum(Quantity) as total from diversionsaving  where date>='1/1/2010' && date<='6/1/2010' group by CategoryName";
                
         // parameters.put("mySqlQuery", q);
          
             
          List result = query.list();
          ArrayList<TotalDTO> arraylist=new ArrayList<TotalDTO>();
          Iterator iterator=result.iterator();
          while(iterator.hasNext()){
              Object[] objects = (Object[]) iterator.next();
              String categoryName  = (String) objects[0];
              Double quantity=(Double)objects[1];
              System.out.println(categoryName+quantity);
              TotalDTO t=new TotalDTO();
              t.setCategoryName(categoryName);
              t.setTotal(quantity);
              arraylist.add(t);
          }
         
          
          JasperDesign design =JRXmlLoader.load(sampleReportFile);
       
         JasperReport report =JasperCompileManager.compileReport(design);
            System.out.println(arraylist.size());
         JasperPrint print =JasperFillManager.fillReport(report, parameters, new JRBeanCollectionDataSource(arraylist,false));
         System.out.println("hello");
         JasperExportManager.exportReportToPdfFile(print,"c:\\simpleHibernatExample4.pdf");
        } catch (JRException ex) {
            ex.printStackTrace();
        } 
    }
}
