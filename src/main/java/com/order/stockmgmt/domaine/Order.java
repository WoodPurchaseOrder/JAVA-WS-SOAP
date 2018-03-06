/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.order.stockmgmt.domaine;

import java.io.Serializable;
import java.util.List;
import java.util.Set;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Numalama
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Order implements Serializable {

    
    private Long id;
    
    private OrderStatus status;
    
    private String name;
    @XmlElement(name = "component_list")
    private Set<Component> components;
   
   
    /**
     * @return the components
     */
    public Set<Component> getComponents() {
        return components;
    }
    
    public void add(Component c){
        components.add(c);
    }

    /**
     * @param components the components to set
     */
    public void setComponents(Set<Component> components) {
        this.components = components;
    }

    

    
    
    

    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return the status
    */
    public OrderStatus getStatus() {
        return status;
    }

    /**
     * @param status the status to set
    */
    public void setStatus(OrderStatus status) {
        this.status = status;
    }
    
    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }
    


    
    @Override public String toString() {
        return "business.domain.Order[id="+id+" name=" + name +"]";     
    }  

}
