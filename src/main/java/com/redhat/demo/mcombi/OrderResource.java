package com.redhat.demo.mcombi;

import com.redhat.demo.mcombi.model.OrderEntity;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;


@Path("/order")
@Produces(MediaType.APPLICATION_JSON)


public class OrderResource {
    @GET
    public List<OrderEntity> getAllOrders(){
        return OrderEntity.findAllOrderEntity();
    }

    @DELETE
    public void deleteOrder(@PathParam("id") int id){
        OrderEntity.deleteById(id);
    }
}
