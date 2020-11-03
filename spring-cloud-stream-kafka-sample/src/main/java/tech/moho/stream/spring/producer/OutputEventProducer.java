package tech.moho.stream.spring.producer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.integration.support.MessageBuilder;

import tech.moho.stream.spring.channel.MohoChannel;
import tech.moho.stream.spring.channel.MohoEvent;


@EnableBinding(MohoChannel.class)
public class OutputEventProducer {

    private static final Logger logger = LoggerFactory.getLogger(OutputEventProducer.class);

    @Autowired
    private MohoChannel source;

    public void send(MohoEvent event){
        logger.info("send message -> {}",event);
        source.output().send(MessageBuilder.withPayload(event).build());
    }

}
