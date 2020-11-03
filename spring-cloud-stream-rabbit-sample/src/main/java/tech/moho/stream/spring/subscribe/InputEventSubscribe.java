package tech.moho.stream.spring.subscribe;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.Message;

import tech.moho.stream.spring.channel.MohoChannel;
import tech.moho.stream.spring.channel.MohoEvent;

/**
 * 
 * 	输入事件订阅
 * 
 * @author moho
 *
 */
@EnableBinding(MohoChannel.class)
public class InputEventSubscribe {

    private static final Logger logger = LoggerFactory.getLogger(InputEventSubscribe.class);

    @StreamListener(MohoChannel.CHANNEL_NAME)
    public void consume(Message<MohoEvent> message){
    	logger.info("input message -> {}",message.getPayload());
    	int a = 1/0;
    }
    
}
