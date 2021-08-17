package com.example.spring;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;


@SpringBootTest
@AutoConfigureMockMvc
public class SpringDataTest {

	@Autowired
	MockMvc mvc;
	
	@Test
	public void TestData() throws Exception {
		mvc.perform(get("/data/"))
			.andExpect(status().isOk())
			.andExpect(content().json("[{\"id\":1,\"firstName\":\"Jack\",\"lastName\":\"Bauer\"},{\"id\":2,\"firstName\":\"Chloe\",\"lastName\":\"O'Brian\"},{\"id\":3,\"firstName\":\"Kim\",\"lastName\":\"Bauer\"},{\"id\":4,\"firstName\":\"David\",\"lastName\":\"Palmer\"},{\"id\":5,\"firstName\":\"Michelle\",\"lastName\":\"Dessler\"}]"));
	}

	
}
