package com.giodad.lil.roomwebapp;

import com.giodad.lil.roomwebapp.data.repository.EmployeeRepository;
import com.giodad.lil.roomwebapp.data.repository.RoomRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class RoomWebAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(RoomWebAppApplication.class, args);
    }

    @Bean
    public CommandLineRunner run(RoomRepository roomRepository, EmployeeRepository employeeRepository) {
        return args -> {
			System.out.println("==============ROOMS==============");
			roomRepository.findAll().forEach(System.out::println);
			System.out.println("==============EMPLOYEES==============");
            employeeRepository.findAll().forEach(System.out::println);
        };
    }

}
