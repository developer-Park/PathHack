package com.example.pathhack;

import java.io.InputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


import lombok.RequiredArgsConstructor;

@SpringBootApplication
@RequiredArgsConstructor
public class PathHackApplication{
	public static void main(String[] args) {

		SpringApplication.run(PathHackApplication.class, args);
	}
}
