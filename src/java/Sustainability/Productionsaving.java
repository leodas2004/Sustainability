package Sustainability;
// Generated Jan 18, 2013 4:54:08 PM by Hibernate Tools 3.2.1.GA



/**
 * Productionsaving generated by hbm2java
 */
public class Productionsaving  implements java.io.Serializable {


     private ProductionsavingId id;
     private Users users;
     private Category category;
     private Double savingAmount;
     private Double quantity;
     private String unit;

    public Productionsaving() {
    }

	
    public Productionsaving(ProductionsavingId id, Category category) {
        this.id = id;
        this.category = category;
    }
    public Productionsaving(ProductionsavingId id, Users users, Category category, Double savingAmount, Double quantity, String unit) {
       this.id = id;
       this.users = users;
       this.category = category;
       this.savingAmount = savingAmount;
       this.quantity = quantity;
       this.unit = unit;
    }
   
    public ProductionsavingId getId() {
        return this.id;
    }
    
    public void setId(ProductionsavingId id) {
        this.id = id;
    }
    public Users getUsers() {
        return this.users;
    }
    
    public void setUsers(Users users) {
        this.users = users;
    }
    public Category getCategory() {
        return this.category;
    }
    
    public void setCategory(Category category) {
        this.category = category;
    }
    public Double getSavingAmount() {
        return this.savingAmount;
    }
    
    public void setSavingAmount(Double savingAmount) {
        this.savingAmount = savingAmount;
    }
    public Double getQuantity() {
        return this.quantity;
    }
    
    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }
    public String getUnit() {
        return this.unit;
    }
    
    public void setUnit(String unit) {
        this.unit = unit;
    }




}

