package co.edu.unisabana.bancocliente.suscriptor;

import co.edu.unisabana.bancocliente.suscriptor.data.Pago;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
@Slf4j
public class Consumer {

    @RabbitListener(queues = {"pagosEjecutados"})
    public void receive(@Payload Pago pago) {
        log.info("Voy a procesasr el mensaje: {}", pago.getMonto());

        /**
         * Esto de aca abajo simula que la escucha del mensaje se demora 10 segundos.
         *    :)
         */
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        log.info("Procesaimiento Terminado del mensaje: {}", pago);
    }

}
