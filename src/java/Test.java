
import DAO.CategoryDAO;
import DAO.UsersDAO;
import Sustainability.Category;
import Sustainability.Users;
import java.util.ArrayList;
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author S405364
 */
public class Test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
// TODO code application logic here
        UsersDAO uDAO = new UsersDAO();
        Users user = uDAO.verifyCredentials("alok.shrestha", "12345");
        if (user != null) {
            System.out.println("user exist" + user.getRole());
        } else {
            System.out.println("user does not exist");
        }

        CategoryDAO catDAO = new CategoryDAO();
        ArrayList<Category> catList = catDAO.getCategoryList();
        for (Category cat : catList) {
            System.out.println(cat.getCategoryName());
        }
    }
}
