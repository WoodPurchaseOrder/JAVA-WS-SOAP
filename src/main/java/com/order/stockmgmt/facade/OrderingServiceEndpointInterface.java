/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.order.stockmgmt.facade;


import com.order.stockmgmt.domaine.Component;
import com.order.stockmgmt.domaine.Order;
import java.util.Set;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

/**
 *
 * @author Numalama
 */
@WebService(name = "OrderingEndpoint") 
public interface OrderingServiceEndpointInterface {
     @WebMethod(operationName = "orderOperation")
     @WebResult(name = "acceptedOrder")
     Boolean checkOrder(@WebParam(name="id") Long id,
                        @WebParam(name="name") String name,
                        @WebParam(name="components") Set<Component> components);
     
     @WebMethod(operationName = "orderObjectOperation")
     @WebResult(name = "acceptedOrder")
     Boolean checkObjectOrder(@WebParam(name="order") Order order);
}
