package com.redhat.demo.mcombi;
import com.redhat.demo.mcombi.model.Order;
import com.redhat.demo.mcombi.model.OrderEntity;
import io.smallrye.reactive.messaging.kafka.Record;
import org.eclipse.microprofile.reactive.messaging.Incoming;
import org.jboss.logging.Logger;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import java.util.UUID;

@ApplicationScoped
public class OrderConsumer {

    private final Logger logger = Logger.getLogger(OrderConsumer.class);

    @Incoming("orders")
    @Transactional
    public void receive(Record<UUID, Order> record) {
        logger.infof("message received");

        OrderEntity oe = OrderEntity.findByDescription(record.value().description);
        if (oe==null){
            oe=new OrderEntity();
            oe.description=record.value().description;
            oe.quantity=record.value().quantity;
            oe.persist();
            logger.infof("message persisted successfully");
        }
    }
}