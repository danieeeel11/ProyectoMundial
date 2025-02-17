package com.example.mundial;

import com.example.mundial.services.FichaService;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import java.util.Arrays;
import java.util.List;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MundialBackApplication{
   /* @Autowired
    private FichaService fichaServicio;*/

	public static void main(String[] args) {
		SpringApplication.run(MundialBackApplication.class, args);
	}
        
        @Bean
public Jackson2ObjectMapperBuilderCustomizer customizer()
{
    return builder -> builder.serializerByType(ObjectId.class,new ToStringSerializer());
}
/*
@Override
    public void run(String... args) throws Exception {
        fichaServicio.eliminarTodo();
    }*/
}
