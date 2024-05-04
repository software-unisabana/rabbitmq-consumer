package co.edu.unisabana.bancocliente.suscriptor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class Consumer {

    @RabbitListener(queues = {"cafeteria_embarcadero"})
    public void atenderEstudianteCafeteriaEmbarcadero(@Payload String estudiante) {
        log.info("Escuche de la cola cafeteria_embarcadero {}", estudiante);
    }

    @RabbitListener(queues = {"cafeteria_escuela"})
    public void atenderEstudianteCafeteriaEscuela(@Payload String estudiante) {
        log.info("Escuche de la cola escuela {}", estudiante);
    }
}