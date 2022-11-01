package co.edu.unisabana.bancocliente.suscriptor;

import co.edu.unisabana.pagos.controller.Pago;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class Consumer {

    @RabbitListener(queues = {"unisabana.pagos.notificar"})
    public void receive(@Payload Pago pago) {
        log.info("Escuche de la cola unisabana.pagos.notificar {}", pago.getMonto());
    }
}