/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.order.stockmgmt.facade;

import com.order.stockmgmt.domaine.Component;
import com.order.stockmgmt.domaine.Order;
import com.order.stockmgmt.integration.OrderDAO;
import java.io.StringWriter;
import java.util.List;
import java.util.Set;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.jms.JMSContext;
import javax.jms.Queue;
import javax.jms.TextMessage;
import javax.jws.WebService;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

/**
 *
 * @author Numalama
 */
@Stateless
@WebService( 
        endpointInterface = "com.order.stockmgmt.facade.OrderingServiceEndpointInterface",
        portName = "OrderingPort",
        serviceName = "OrderingService"  
)
public class OrderingServiceBean  implements OrderingServiceEndpointInterface, OrderingServiceRemote{
    
    
    @Inject
    private OrderDAO orderDAO; 
    /*
    @Inject //paquetage javax.inject
    private JMSContext context; //paquetage javax.jms
    
    @Resource(lookup = "jms/paymentQueue") //paquetage javax.annotation
    private Queue orderQueue; //paquetage javax.jms
    
    */
    
    @Override
    public Boolean checkObjectOrder(Order order) {
        if (order.getId() != null && order.getName() != null ){//&& order.getComponents() != null){
            System.out.println("order.getName : " + order.getName());
            return true;
        }else{
            return false;
        }
    }
    
    
    @Override
    public Boolean checkOrder(Long id, String name, Set<Component> components) {
      System.out.println("composants.size()" + components.size());
      if(id >= 0){
        System.out.println("Nom du  bon de commande : "+name);
        //Order o = new Order();
        //o.setId(id);
        //o.setName(name);
        //o.setComponents(components);
        //pour l’instant le retour n’est pas utilisé
        //o = orderDAO.add(o);
        //envoi du paiement sous forme de message JMS
        //formaté en XML
        //sendOrder(o);
        return true;
      } else {
        return false;
      }
    }
    
    
    
    //méthodes déclarées dans BankingServiceRemote
    @Override
    public List<Order> lookupAllStoredOrders() {
        return orderDAO.getAllStoredOrders();
    }

    @Override
    public Order lookupStoredOrder(Long id) {
        return orderDAO.find(id);
    }
    
    @Override
    public Order deleteStoredOrder(Long id) {
        Order o = orderDAO.delete(id);
        if(o!=null){
        //sendOrder(o);
        }
        return o;
    }
    

    /*
    private void sendOrder(Order order){
        //utilisation de l'API JAX-B de gestion de flux pour marshaller (transformer) l'objet
        //Payment en chaine XML
        JAXBContext jaxbContext;
        try {
            //obtention d'une instance JAXBContext associée au type Payment annoté avec JAX-B
            jaxbContext = JAXBContext.newInstance(Order.class);
            //création d'un Marshaller pour transfomer l'objet Java en flux XML
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
            StringWriter writer = new StringWriter();
            //transformation de l'objet en flux XML stocké dans un Writer
            jaxbMarshaller.marshal(order, writer);
            String xmlMessage = writer.toString();
            //affichage du XML dans la console de sortie
            System.out.println(xmlMessage);
            //Encapsulation du message xml dans un objet textmessage
            TextMessage msg = context.createTextMessage(xmlMessage);
            //envoi du message à la queue PaymentQueue
            context.createProducer().send(orderQueue, msg);
        } catch (JAXBException ex) {
            Logger.getLogger(OrderingServiceBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
*/


}
