package com.example.sprintbooteventbus;

import java.util.Arrays;

import com.google.common.eventbus.EventBus;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SprintBootEventBusApplication {

	public static void main(String[] args) {
		SpringApplication.run(SprintBootEventBusApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
		return args -> {

			System.out.println("Let's inspect the beans provided by Spring Boot:");

			String[] beanNames = ctx.getBeanDefinitionNames();
			Arrays.sort(beanNames);
			for (String beanName : beanNames) {
				System.out.println(beanName);
			}
		};
	}

	@Bean
	public String getControllerName() {
		return "Tarun's Spring Boot Controller";
	}

	@Bean
	public EventBus getEventBus() {
		return new EventBus();
	}

	@Bean
	public EventListener getEventListener() {
		return new EventListener();
	}

}
