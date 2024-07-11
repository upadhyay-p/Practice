package com.testproject.rest_api_project;

import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RestApiProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestApiProjectApplication.class, args);
		Scanner scanner = new Scanner(System.in);
		boolean appRunning = true;
		while(appRunning) {
			String input = scanner.nextLine();
			switch (input) {
				case "EXIT":
					appRunning = false;
					System.out.println("System exit, no more taking input");
					break;
				default:
				System.out.println("User input: " + input);
					break;
			}
		}
		System.exit(0);
		scanner.close();
	}

}
