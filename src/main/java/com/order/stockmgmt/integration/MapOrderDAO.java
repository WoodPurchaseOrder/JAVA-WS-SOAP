/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.order.stockmgmt.integration;

import com.order.stockmgmt.domaine.Order;
import com.order.stockmgmt.domaine.OrderStatus;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
import javax.enterprise.context.ApplicationScoped;

/**
 *
 * @author Numalama
 */
@ApplicationScoped
public class MapOrderDAO implements OrderDAO{

   //compteur initialisé à 1
    private AtomicLong count = new AtomicLong(1);
    private Map<Long,Order> orders = new ConcurrentHashMap<>();
    
    @Override
    public Order add(Order order) {
        //order.setId(count.getAndIncrement());//on génère l'id
        order.setStatus(OrderStatus.VALIDATED);
        //on stocke la commande dans la Map - la clé est l'id.
        orders.put(order.getId(), order);
        return order;
    }
    
    @Override
    public Order delete(Long id) {
        Order deletedOrder = orders.remove(id); //on supprime de l'entrée
        //correspondant à l'id passé
        if (deletedOrder == null) {
            return null;
        }
        deletedOrder.setStatus(OrderStatus.CANCELLED);
        return deletedOrder;
    }
    
    @Override
    public Order find(Long id) {
        return orders.get(id);//récupération dans la Map de l'objet commande
                                //associé à la clé
    }
    
    @Override
    public List<Order> getAllStoredOrders() {
        List<Order> orderList = new ArrayList<>(orders.values());
        //Boucle pour tracer la liste - pourra être supprimée par la suite
        for (Order o : orderList) {
            System.out.println(o);
        }
        return orderList;
    }
    
}
