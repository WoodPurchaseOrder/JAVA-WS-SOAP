/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.order.stockmgmt.facade;

import java.util.Date;
import javax.ejb.Stateless;

/**
 *
 * @author Numalama
 */
@Stateless
public class OrderProcessor {

    public Date date(){
        return new Date();
    }
}
