package Sustainability;
// Generated Feb 1, 2013 7:21:23 PM by Hibernate Tools 3.2.1.GA


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Category generated by hbm2java
 */
public class LandFillRate implements java.io.Serializable {


     private Date landfilldate;
     private Double rate;

    public LandFillRate() {
    }

    public LandFillRate(Date landfilldate, Double rate) {
       this.landfilldate=landfilldate;
       this.rate=rate;
    }

    public Date getLandfilldate() {
        return landfilldate;
    }

    public void setLandfilldate(Date landfilldate) {
        this.landfilldate = landfilldate;
    }

    public Double getRate() {
        return rate;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }
}


