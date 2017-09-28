package com.score.config;

import com.rabbitmq.client.Channel;
import org.axonframework.amqp.eventhandling.spring.SpringAMQPMessageSource;
import org.axonframework.serialization.Serializer;
import org.slf4j.Logger;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static org.slf4j.LoggerFactory.getLogger;

/**
 * Created by Edison on 2017/3/25.
 */
@Configuration
public class AMQPConfiguration {

    private static final Logger LOGGER = getLogger(AMQPConfiguration.class);

    @Value("${axon.amqp.exchange}")
    private String exchangeName;

    @Bean
    public Queue teachingClassQueue(){
        return new Queue("teachingClass", false);
    }

    @Bean
    public Exchange exchange(){
        return ExchangeBuilder.topicExchange(exchangeName).durable(false).build();
    }

    @Bean
    public Binding teachingClassQueueBinding() {
        return BindingBuilder.bind(teachingClassQueue()).to(exchange()).with("#.teachingClass.#").noargs();
    }



    @Bean
    public SpringAMQPMessageSource teachingClassQueueMessageSource(Serializer serializer){
        return new SpringAMQPMessageSource(serializer){
            @RabbitListener(queues = "teachingClass")
            @Override
            public void onMessage(Message message, Channel channel) throws Exception {
                LOGGER.debug("TeachingClass message received: "+message.toString());
                super.onMessage(message, channel);
            }
        };
    }


}
