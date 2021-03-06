package Sustainability;
// Generated Jan 18, 2013 4:54:08 PM by Hibernate Tools 3.2.1.GA


import java.util.HashSet;
import java.util.Set;

/**
 * Category generated by hbm2java
 */
public class Category  implements java.io.Serializable {


     private String categoryName;
     private Double quantity;
     private Integer status;
     private String unit;
     private Set diversionsavings = new HashSet(0);
     private Set revenues = new HashSet(0);
     private Set productionsavings = new HashSet(0);

    public Category() {
    }

	
    public Category(String categoryName) {
        this.categoryName = categoryName;
    }
    public Category(String categoryName, Double quantity, Integer status, String unit, Set diversionsavings, Set revenues, Set productionsavings) {
       this.categoryName = categoryName;
       this.quantity = quantity;
       this.status = status;
       this.unit = unit;
       this.diversionsavings = diversionsavings;
       this.revenues = revenues;
       this.productionsavings = productionsavings;
    }
   
    public String getCategoryName() {
        return this.categoryName;
    }
    
    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
    public Double getQuantity() {
        return this.quantity;
    }
    
    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }
    public Integer getStatus() {
        return this.status;
    }
    
    public void setStatus(Integer status) {
        this.status = status;
    }
    public String getUnit() {
        return this.unit;
    }
    
    public void setUnit(String unit) {
        this.unit = unit;
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
    public Set getProductionsavings() {
        return this.productionsavings;
    }
    
    public void setProductionsavings(Set productionsavings) {
        this.productionsavings = productionsavings;
    }




}


