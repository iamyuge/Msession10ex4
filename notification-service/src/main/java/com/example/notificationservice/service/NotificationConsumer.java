package com.example.notificationservice.service;

import com.example.notificationservice.event.OrderEvent;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class NotificationConsumer {

    @KafkaListener(
            topics = "medicine-stock-events",
            groupId = "notification-service-group"
    )
    public void consumeOrderEvent(OrderEvent event) {

        System.out.println("Đã nhận sự kiện đơn hàng từ Kafka");
        System.out.println("Order ID: " + event.getOrderId());
        System.out.println("Medicine ID: " + event.getMedicineId());
        System.out.println("Quantity: " + event.getQuantity());

        System.out.println(
                "Hóa đơn cho đơn hàng "
                        + event.getOrderId()
                        + " đã được gửi tới khách hàng"
        );
    }
}