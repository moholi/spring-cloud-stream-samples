package tech.moho.stream.spring.channel;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

public interface MohoChannel {
	String CHANNEL_NAME = "moho-channel";

	@Input(MohoChannel.CHANNEL_NAME)
	SubscribableChannel input();
	
	@Output(MohoChannel.CHANNEL_NAME)
	MessageChannel output();
}
