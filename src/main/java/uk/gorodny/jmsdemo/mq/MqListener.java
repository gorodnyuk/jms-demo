package uk.gorodny.jmsdemo.mq;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import uk.gorodny.jmsdemo.model.User;


@Component
@Slf4j
public class MqListener {

    //////////////////////////////////////////////////////////////////////////////
    /// - Для прослушивание очереди (consume) добавить ///////////////////////////
    ///   @JmsListener(destination = "имя-прослушиваемой-очереди") ///////////////
    /// - Для ответа в другую очередь добавить @SendTo("имя-ответной-очереди") ///
    //////////////////////////////////////////////////////////////////////////////

    //    @JmsListener(destination = "queue2")
    public void consume(User message) {
        log.info(message.toString());
    }
}
