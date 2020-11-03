package tech.moho.stream.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import tech.moho.stream.spring.channel.MohoEvent;
import tech.moho.stream.spring.producer.OutputEventProducer;

@SpringBootApplication
public class Application implements CommandLineRunner{
	
	private @Autowired OutputEventProducer producer;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		MohoEvent me = new MohoEvent();
		me.setMessage("balabala");
		producer.send(me);
	}

}
