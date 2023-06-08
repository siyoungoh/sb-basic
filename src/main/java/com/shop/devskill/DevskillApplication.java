package com.shop.devskill;

import java.util.UUID;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DevskillApplication {

	public static void main(String[] args) {
		SpringApplication.run(DevskillApplication.class, args);
	}

}
class Skill {
	private final String id;
	private String name;

	public Skill(String id, String name) {
		this.id = id;
		this.name = name;
	}

	public Skill(String name) {
		this(UUID.randomUUID().toString(), name);
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}