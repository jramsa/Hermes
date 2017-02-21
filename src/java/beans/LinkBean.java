/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;


import javax.faces.bean.ManagedBean;

 
@ManagedBean
public class LinkBean {
     
    public LinkBean() {
    }
    
    private int secuId; 
 
    public int getProductId() {
        return secuId;
    }
 
    public void setProductId(String productId) {
        this.secuId = secuId;
    }
}
