package com.shop.devskill;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class DevskillApplication {

	public static void main(String[] args) {
		SpringApplication.run(DevskillApplication.class, args);
	}

}

@RestController
	// @RequestMapping("/skills")
class RestApiDemoController {
	private final List<Skill> skills = new ArrayList<>();

	public RestApiDemoController() {
		skills.addAll(List.of(
			new Skill("디버깅 로그 분석 +10"),
			new Skill("레퍼런스 검색 +10"),
			new Skill("데드라인 예측 +10"),
			new Skill("집중 시간 +10")
		));
	}

	@GetMapping("/skills")
	Iterable<Skill> getSkills() {
		return skills;
	}

	@GetMapping("/skills/{id}")
	Optional<Skill> getSkillById(@PathVariable String id) {
		for (Skill c : skills) {
			if (c.getId().equals(id)) {
				return Optional.of(c);
			}
		}

		return Optional.empty();
	}

	@PostMapping("/skills")
	Skill postSkill(@RequestBody Skill skill) {
		skills.add(skill);
		return skill;
	}

	@PutMapping("/skills/{id}")
	Skill putSkill(@PathVariable String id,
		@RequestBody Skill skill) {
		int skillIndex = -1;

		for (Skill c : skills) {
			if (c.getId().equals(id)) {
				skillIndex = skills.indexOf(c);
				skills.set(skillIndex, skill);
			}
		}

		return (skillIndex == -1) ?
			postSkill(skill) : skill;
	}

	@DeleteMapping("/skills/{id}")
	void deleteSkill(@PathVariable String id) {
		skills.removeIf(c -> c.getId().equals(id));
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