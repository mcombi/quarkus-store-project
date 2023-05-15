package com.redhat.demo.mcombi;

import com.redhat.demo.mcombi.model.Order;
import com.redhat.demo.mcombi.model.OrderEntity;
/*import org.eclipse.microprofile.openapi.annotations.enums.SchemaType;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.Operation;*/

import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;


@Path("/order")
@Produces(MediaType.APPLICATION_JSON)


public class OrderResource {
    @GET
    public List<OrderEntity> getAllOrders(){


        return OrderEntity.findAllOrderEntity();

    }

    @DELETE
  /*  @Operation(summary = "Save an order")
    @APIResponse(
            responseCode = "200",
            description = "Gets all fights, or empty list if none",
            content = @Content(mediaType = APPLICATION_JSON, schema = @Schema(implementation = Order.class, type = SchemaType.DEFAULT))
    )*/
    @Transactional
    public void deleteOrders(){
        OrderEntity.deleteAll();
    }

}
