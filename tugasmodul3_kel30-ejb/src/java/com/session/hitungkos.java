/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.session;

import java.text.DecimalFormat;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;

/**
 *
 * @author hp
 */
@Stateless
@LocalBean
public class hitungkos {
    DecimalFormat b = new DecimalFormat("0.00");
    String hasil;
    
    public String hitungkos_satu(double param) {
        return hasil = b.format(param * 700000) ;
    }
    
    public String hitungkos_dua(double param) {
        return hasil = b.format(param * 550000);
    }
    

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
}
