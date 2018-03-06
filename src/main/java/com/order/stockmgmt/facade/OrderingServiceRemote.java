/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.order.stockmgmt.facade;

import com.order.stockmgmt.domaine.Order;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author Numalama
 */
@Remote
public interface OrderingServiceRemote extends OrderingServiceEndpointInterface{
    // Récupère tous les paiement stockés dans la Map du DAO
    List<Order> lookupAllStoredOrders();
    // Récupère un paiement en fonction de sonidentité.
    Order lookupStoredOrder(Long id);
    // Payment deleteStoredPayment(Long id)
    Order deleteStoredOrder(Long id);
}
