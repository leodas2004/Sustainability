package Sustainability;
// Generated Jan 18, 2013 4:54:08 PM by Hibernate Tools 3.2.1.GA


import java.util.HashSet;
import java.util.Set;

/**
 * Users generated by hbm2java
 */
public class Users  implements java.io.Serializable {


     private String username;
     private String firstname;
     private String lastname;
     private String password;
     private String role;
     private Integer status;
     private Set productionsavings = new HashSet(0);
     private Set diversionsavings = new HashSet(0);
     private Set revenues = new HashSet(0);

    public Users() {
    }

	
    public Users(String username, String firstname, String lastname) {
        this.username = username;
        this.firstname = firstname;
        this.lastname = lastname;
    }
    public Users(String username, String firstname, String lastname, String password, String role, Integer status, Set productionsavings, Set diversionsavings, Set revenues) {
       this.username = username;
       this.firstname = firstname;
       this.lastname = lastname;
       this.password = password;
       this.role = role;
       this.status = status;
       this.productionsavings = productionsavings;
       this.diversionsavings = diversionsavings;
       this.revenues = revenues;
    }
   
    public String getUsername() {
        return this.username;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }
    public String getFirstname() {
        return this.firstname;
    }
    
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }
    public String getLastname() {
        return this.lastname;
    }
    
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
    public String getPassword() {
        return this.password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    public String getRole() {
        return this.role;
    }
    
    public void setRole(String role) {
        this.role = role;
    }
    public Integer getStatus() {
        return this.status;
    }
    
    public void setStatus(Integer status) {
        this.status = status;
    }
    public Set getProductionsavings() {
        return this.productionsavings;
    }
    
    public void setProductionsavings(Set productionsavings) {
        this.productionsavings = productionsavings;
    }
    public Set getDiversionsavings() {
        return this.diversionsavings;
    }
    
    public void setDiversionsavings(Set diversionsavings) {
        this.diversionsavings = diversionsavings;
    }
    public Set getRevenues() {
        return this.revenues;
    }
    
    public void setRevenues(Set revenues) {
        this.revenues = revenues;
    }




}


