package com.xrafece;

import com.xrafece.entry.YamlEntry;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ConfigurationApplicationTests {

	@Autowired
	private YamlEntry yamlEntry;

	@Test
	void contextLoads() {
		System.out.println(yamlEntry);
	}

}
