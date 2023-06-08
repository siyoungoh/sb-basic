package com.shop.devskill;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class DevskillApplication {

	public static void main(String[] args) {
		SpringApplication.run(DevskillApplication.class, args);
	}

}

@RestController
@RequestMapping("/skills")
class RestApiDemoController {
	private List<Skill> skills = new ArrayList<>();

	public RestApiDemoController() {
		skills.addAll(List.of(
			new Skill("디버깅 로그 분석 +10"),
			new Skill("레퍼런스 검색 +10"),
			new Skill("데드라인 예측 +10"),
			new Skill("집중 시간 +10")
		));
	}

	@GetMapping
	Iterable<Skill> getSkills() {
		return skills;
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