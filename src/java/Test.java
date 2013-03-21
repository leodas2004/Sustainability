
import DAO.CategoryDAO;
import DAO.DiversionDAO;
import DAO.LandfillRateDAO;
import DAO.RevenueDAO;
import DAO.TransportationDAO;
import DAO.UsersDAO;
import Sustainability.Category;
import Sustainability.ChartType;
import Sustainability.Diversionsaving;
import Sustainability.LandFillRate;
import Sustainability.Revenue;
import Sustainability.Transportation;
import Sustainability.Users;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import net.sf.jasperreports.engine.JRChartCustomizer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author S405364
 */
public class Test {

    SessionFactory sessionFactory = null;
    Session session = null;
    //Diversionsaving diversionSaving;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ParseException {
// TODO code application logic here
        //Testing again
//        UsersDAO uDAO = new UsersDAO();
//        Users user = uDAO.verifyCredentials("alok.shrestha", "12345");
//        if (user != null) {
//            System.out.println("user exist" + user.getRole());
//        } else {
//            System.out.println("user does not exist");
//        }
//
//        CategoryDAO catDAO = new CategoryDAO();
//        ArrayList<Category> catList = catDAO.getCategoryList();
//        for (Category cat : catList) {
//            System.out.println(cat.getCategoryName());
//        }

//        Category category = new Category();
//            category.setCategoryName("Steel");
//
//       
//            DateFormat formatter = null;
//            Date convertedDate = null;
//            Users user=new Users();
//            user.setUsername("alok.shrestha");
//            String yyyyMMdd = "20130731";
//            formatter = new SimpleDateFormat("yyyyMMdd");
//            convertedDate = (Date) formatter.parse(yyyyMMdd);
//           // System.out.println("INFO:gggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggg"+convertedDate);
//            Diversionsaving diversionSaving=new Diversionsaving();
//            diversionSaving.setLandfillDate(convertedDate);
//            diversionSaving.setDate(convertedDate);
//            diversionSaving.setCategory(category);
//            diversionSaving.setQuantity(555.00);
//            diversionSaving.setUnit("lbs");
//            diversionSaving.setUsers(user);
//            diversionSaving.setDiversionSaving(1000.00);
//            DiversionDAO ddao=new DiversionDAO();
//            ddao.insertDiversionRecord(diversionSaving);


//        Category category = new Category();
//        category.setCategoryName("Aluminum");
//
//        DateFormat formatter = null;
//        Date convertedDate = null;
//        Users user = new Users();
//        user.setUsername("alok.shrestha");
//        String yyyyMMdd = "19840731";
//        formatter = new SimpleDateFormat("yyyyMMdd");
//        convertedDate = (Date) formatter.parse(yyyyMMdd);
//        Revenue rev=new Revenue();
//        rev.setCategory(category);
//    
       // Transportation trans=new Transportation();
        //trans.setDate(convertedDate);
       // trans.setCost(50.00);
//        
//        rev.setSellDate(convertedDate);
//        rev.setQuantity(40.0);
//        rev.setUsers(user);
//        rev.setMarketRate(4.0f);
//        rev.setUnit("lb");
//        rev.setAmount(500.00);
//        rev.setComment("This is revenue comment");
//        
//        RevenueDAO rDAO=new RevenueDAO();
//        rDAO.insertRevenueRecord(rev);
//        TransportationDAO tDAO=new TransportationDAO();
//        tDAO.insertTransportationCost(trans);
        
        
        //Test code for adding new user
//        Users user=new Users();
//        user.setUsername("gary.mcdonald");
//        user.setFirstname("Gary");
//        user.setLastname("McDonald");
//        user.setPassword("hellomerry");
//        user.setRole("Administrator");
//        user.setStatus(1);
//        
//        UsersDAO uDAO=new UsersDAO();
//        uDAO.addUsers(user);
        
        //Test code for editing existing user. In the following code , I am changing the
        //lasname and password for user with username gary.mcdonald. User can just change 
        //profile using username.
//        Users user=new Users();
//        user.setUsername("gary.mcdonald");
//        user.setFirstname("Garry");
//        user.setLastname("McDonaldoa");
//        user.setPassword("hellomcgary");
//        user.setRole("staff");
//        user.setStatus(1);
//        UsersDAO uDAO=new UsersDAO();
//        uDAO.editUsers(user);
//        
        
        //Test code to test adding landfill rate
//        LandFillRate lr=new LandFillRate();
//        lr.setLandfilldate(new Date("2/1/2013"));
//        lr.setRate(50.00);
//        
//        LandfillRateDAO lrdao=new LandfillRateDAO();
//        lrdao.addLandFillRate(lr);
        
        //Testing code to add revenue
//        Revenue rev=new Revenue();
//        //rev.setAmount(2000.00);
//        
//        Category category1 = new Category();
//        category1.setCategoryName("Aluminum");
//        
//        Users user=new Users();
//        user.setUsername("gary.mcdonald");
//        
//        rev.setCategory(category1);
//        rev.setUsers(user);
//        rev.setSellingdate(new Date("2/1/2013"));
//        rev.setQuantity(20.00);
//        
//        //Users user=new Users();
//        user.setUsername("gary.mcdonald");
////        
//        rev.setUsers(user);
//        
//        rev.setMarketRate(20.00);
//        rev.setUnit("lbs");
//        rev.setAmount(5000.00);
//        rev.setComment("hello this is comment");
////        
//        RevenueDAO revDAO=new RevenueDAO();
//       // revDAO.insertRevenueRecord(rev);
////        
//        Revenue rev1=new Revenue();
//        rev1.setAmount(2000.00);
////       
////        
      
        //rev1.setCategory(category);
//        rev1.setSellingdate(new Date("2/4/2013"));
//        rev1.setQuantity(20.00);
//        
//        user.setUsername("gary.mcdonald");
//        
//        rev1.setUsers(user);
//        Category category2 = new Category();
//        category2.setCategoryName("Trash");
//        rev1.setMarketRate(20.00);
//        rev1.setUnit("lbs");
//        rev1.setAmount(5000.00);
//        rev1.setCategory(category2);
//        rev1.setComment("hello this is comment");
//        
//        ArrayList<Revenue> rList=new ArrayList<Revenue>();
//        rList.add(rev1);
//        rList.add(rev);
//        revDAO.insertRevenueRecords(rList);
        
        //Testing getDiversionSaving
//        Date sdate=new Date("1/1/2011");
//        Date edate=new Date("12/21/2011");
//        DiversionDAO dao=new DiversionDAO();
//        ArrayList<Diversionsaving> dList=dao.getDiversionSaving(sdate, edate);
//        for(Diversionsaving s:dList){
//            System.out.println(s.getDate()+" "+s.getCategory().getCategoryName()+" "+s.getQuantity());
//        }
        
        //Testing method getUser();
//        String username="alok.shrestha";
//        UsersDAO uDAO=new UsersDAO();
//        Users user=uDAO.getUser(username);
//        user.setRole("staff");
//        uDAO.editUsers(user);
        
        //Testing exporting to excel
//        DiversionDAO dDao=new DiversionDAO();
//        dDao.exportToExcel(new Date("1/1/2011"), new Date("12/31/2012"),"c:\\alok.xls");
        
        //Testing changeStatus method
//        Category cat=new Category();
//        cat.setCategoryName("Aluminum");
//        cat.setStatus(0);
//        
//        CategoryDAO catDAO=new CategoryDAO();
//        catDAO.changeStatus(cat);
//    }
        //Testing print chart
//        DiversionDAO dao=new DiversionDAO();
//        dao.printChart("2008-5-1", "2012-12-31", "c://alok.pdf", ChartType.BAR);
        RevenueDAO rDAO=new RevenueDAO();
        ArrayList<Revenue> rList=new ArrayList<Revenue>();
        rList= rDAO.getRevenues(new Date("1/1/2011"), new Date("12/31/2013"));
        for(Revenue r:rList){
            System.out.println(r.getCategory().getCategoryName());
        }
    }

}
