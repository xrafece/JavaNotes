package com.xrafece;

import com.xrafece.entry.PropertiesEntry;
import com.xrafece.entry.YamlEntry;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Collections;

@SpringBootTest
class ConfigurationApplicationTests {

	@Autowired
	private YamlEntry yamlEntry;
	@Autowired
	private PropertiesEntry propertiesEntry;


	@Test
	void contextLoads() {
		System.out.println(yamlEntry);
		System.out.println(propertiesEntry);
	}

}
