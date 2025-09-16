package com.jorgemagzul.sportfinal;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@SpringBootApplication
public class SportfinalApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SportfinalApplication.class, args);
	}

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Api funcionando");
    }
}