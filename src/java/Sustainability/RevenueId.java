//package Sustainability;
//// Generated Feb 1, 2013 7:21:23 PM by Hibernate Tools 3.2.1.GA
//
//
//import java.util.Date;
//
///**
// * RevenueId generated by hbm2java
// */
//public class RevenueId  implements java.io.Serializable {
//
//
//     private String categoryName;
//     private Date date;
//
//    public RevenueId() {
//    }
//
//    public RevenueId(String categoryName, Date date) {
//       this.categoryName = categoryName;
//       this.date = date;
//    }
//   
//    public String getCategoryName() {
//        return this.categoryName;
//    }
//    
//    public void setCategoryName(String categoryName) {
//        this.categoryName = categoryName;
//    }
//    public Date getDate() {
//        return this.date;
//    }
//    
//    public void setDate(Date date) {
//        this.date = date;
//    }
//
//
//   public boolean equals(Object other) {
//         if ( (this == other ) ) return true;
//		 if ( (other == null ) ) return false;
//		 if ( !(other instanceof RevenueId) ) return false;
//		 RevenueId castOther = ( RevenueId ) other; 
//         
//		 return ( (this.getCategoryName()==castOther.getCategoryName()) || ( this.getCategoryName()!=null && castOther.getCategoryName()!=null && this.getCategoryName().equals(castOther.getCategoryName()) ) )
// && ( (this.getDate()==castOther.getDate()) || ( this.getDate()!=null && castOther.getDate()!=null && this.getDate().equals(castOther.getDate()) ) );
//   }
//   
//   public int hashCode() {
//         int result = 17;
//         
//         result = 37 * result + ( getCategoryName() == null ? 0 : this.getCategoryName().hashCode() );
//         result = 37 * result + ( getDate() == null ? 0 : this.getDate().hashCode() );
//         return result;
//   }   
//
//
//}
//
//
