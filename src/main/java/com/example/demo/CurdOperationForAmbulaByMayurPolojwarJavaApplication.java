package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



/*
to post data
 "/create_data" hasRole("ADMIN") to access and username is "admin" and password is "admin"

* //http://localhost:8080/data/create_data


"/get_users/**" hasRole("READER") to access and username is "reader" and password is "reader"

//http://localhost:8080/data/get_users/**

for logout
//http://localhost:8080/data/logout



 h2 database console
 username=sa
 password=


 */


@SpringBootApplication
public class CurdOperationForAmbulaByMayurPolojwarJavaApplication {

	public static void main(String[] args) {
		SpringApplication.run(CurdOperationForAmbulaByMayurPolojwarJavaApplication.class, args);
	}

}
