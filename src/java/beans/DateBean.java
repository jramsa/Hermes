/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;


import javax.faces.bean.ManagedBean;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;
import java.util.Locale;
 
@ManagedBean
public class DateBean {
    
    private DateFormat df;
    private Date date;
    private int style; 
     
    public DateBean() {
        date = new Date();
        style = DateFormat.MEDIUM; 
        df = DateFormat.getDateInstance(style, Locale.FRANCE);
    } 
 
    public String getDate() throws ParseException {
        return df.format(date);
    }
}
