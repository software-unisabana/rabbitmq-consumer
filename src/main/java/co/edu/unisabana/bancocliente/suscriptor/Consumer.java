package co.edu.unisabana.bancocliente.suscriptor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class Consumer {

    @RabbitListener(queues = {"pagosEjecutados"})
    public void receive(@Payload String message) {
        log.info("Voy a procesasr el mensaje: {}", message);
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        log.info("Procesaimiento Terminado del mensaje: {}", message);
    }
}
