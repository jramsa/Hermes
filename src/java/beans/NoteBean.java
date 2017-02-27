/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;

/**
 *
 * @author Jerry
 */
@Named(value = "noteBean")
@SessionScoped
public class NoteBean implements Serializable {

    /**
     * Creates a new instance of NoteBean
     */
    public NoteBean() {
    }
    
}
