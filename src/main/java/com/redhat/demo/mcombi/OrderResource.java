package com.redhat.demo.mcombi;

import com.redhat.demo.mcombi.model.OrderEntity;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;


@Path("/order")
@Produces(MediaType.APPLICATION_JSON)


public class OrderResource {
    @GET
    public List<OrderEntity> getAllOrders(){
        return OrderEntity.findAllOrderEntity();
    }
}
