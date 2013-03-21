/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import net.sf.jasperreports.engine.JRChart;
import net.sf.jasperreports.engine.JRChartCustomizer;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.plot.Plot;
import org.jfree.chart.plot.XYPlot;
import org.jfree.ui.RectangleInsets;


/**
 *
 * @author S405364
 */
public class LabelDisplayer implements JRChartCustomizer{ 
    public LabelDisplayer() {} 
    @Override
    public void customize(JFreeChart jfc, JRChart chart){ 
        double top = 15.0;    // this is the inset you need to adjust to make sure
                              // that there is enough space to display the truncated label 
        double bottom = 5.0;
        double left = 5.0;
        double right = 5.0;
        XYPlot plot = (XYPlot)jfc.getPlot();
        plot.setInsets(new RectangleInsets(top, bottom, left, right)); 
        //adjust the "top" value to make sure it is big enough to accommodate the missing label 
    }
}
