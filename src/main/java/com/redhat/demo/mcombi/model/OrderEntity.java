package com.redhat.demo.mcombi.model;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.persistence.Entity;
import java.util.List;

@Entity
public class OrderEntity extends PanacheEntity {
//    public int id;
    public int quantity;
    public String description;

    public static OrderEntity findByDescription(String description){
        return  find("description",description).firstResult();
    }

    public static void deleteById(int id){
        deleteById(id);
    }

    public static List<OrderEntity> findAllOrderEntity(){
        return listAll();
    }
}
