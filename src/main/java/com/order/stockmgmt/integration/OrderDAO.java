/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.order.stockmgmt.integration;

import com.order.stockmgmt.domaine.Order;
import java.util.List;

/**
 *
 * @author Numalama
 */
public interface OrderDAO {
    
    //stockage d'une commande dans une Map
    Order add(Order order);
    //suppression d'une commande
    Order delete(Long id);
    //recherche d'une commande en fonction de son id
    Order find(Long id);
    //obtention d'une liste contenant les commandes créés non supprimés
    List<Order> getAllStoredOrders();
    
}
