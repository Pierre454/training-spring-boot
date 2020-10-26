package com.ecommerce.microcommerce;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MicrocommerceApplicationTests {
	
	@Autowired
	private WebApplicationContext webApplicationContext;
	
	private MockMvc mockMvc;
	
	@Before
	public void setup() {
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}
	
	@Test
	public void testListeProduits() throws Exception {
		mockMvc.perform(get("/Produits"))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.[0].id",is(1)))
				.andExpect(jsonPath("$.[0].nom",is("Ordinateur portable")))
				.andExpect(jsonPath("$.[0].prix",is(350)))
				.andExpect(jsonPath("$.[0].prixAchat",is(120)))

				.andExpect(jsonPath("$.[1].id",is(2)))
				.andExpect(jsonPath("$.[1].nom",is("Aspirateur Robot")))
				.andExpect(jsonPath("$.[1].prix",is(500)))
				.andExpect(jsonPath("$.[1].prixAchat",is(200)))
				
				.andExpect(jsonPath("$.[2].id",is(3)))
				.andExpect(jsonPath("$.[2].nom",is("Table de Ping Pong")))
				.andExpect(jsonPath("$.[2].prix",is(750))) 
			    .andExpect(jsonPath("$.[2].prixAchat",is(400)));			
	}
	
	@Test
	public void testProduitsParId() throws Exception {
		mockMvc.perform(get("/Produits/1"))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.id",is(1)))
				.andExpect(jsonPath("$.nom",is("Ordinateur portable")))
				.andExpect(jsonPath("$.prix",is(350)))
				.andExpect(jsonPath("$.prixAchat",is(120)));
		
	    mockMvc.perform(get("/Produits/2"))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.id",is(2)))
				.andExpect(jsonPath("$.nom",is("Aspirateur Robot")))
				.andExpect(jsonPath("$.prix",is(500)))
				.andExpect(jsonPath("$.prixAchat",is(200)));
	    
		mockMvc.perform(get("/Produits/3"))
				.andExpect(status().isOk())	
				.andExpect(jsonPath("$.id",is(3)))
				.andExpect(jsonPath("$.nom",is("Table de Ping Pong")))
				.andExpect(jsonPath("$.prix",is(750)))
				.andExpect(jsonPath("$.prixAchat",is(400)));			
	}
	
/*	@Test
	public void testCalculerMargesProduits() throws Exception {
		mockMvc.perform(get("/AdminProduits"))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.[0].id",is(1)))
				.andExpect(jsonPath("$.[0].nom",is("Ordinateur portable")))
				.andExpect(jsonPath("$.[0].prix",is(350)))
				.andExpect(jsonPath("$.[0].prixAchat",is(120)))
		
				.andExpect(jsonPath("$.[1].id",is(2)))
				.andExpect(jsonPath("$.[1].nom",is("Aspirateur Robot")))
				.andExpect(jsonPath("$.[1].prix",is(500)))
				.andExpect(jsonPath("$.[1].prixAchat",is(200)))
				
				.andExpect(jsonPath("$.[2].id",is(3)))
				.andExpect(jsonPath("$.[2].nom",is("Table de Ping Pong")))
				.andExpect(jsonPath("$.[2].prix",is(750)))
				.andExpect(jsonPath("$.[2].prixAchat",is(400)))
				
				.andExpect(jsonPath("$.[0].marge",is(230)))
				.andExpect(jsonPath("$.[1].marge",is(300)))
				.andExpect(jsonPath("$.[2].marge",is(350)));
	}*/

	@Test
	public void testOrdreAlphaProduits() throws Exception {
		mockMvc.perform(get("/OrdreAlpha"))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.[0].id",is(2)))
				.andExpect(jsonPath("$.[0].nom",is("Aspirateur Robot")))
				.andExpect(jsonPath("$.[0].prix",is(500)))
				.andExpect(jsonPath("$.[0].prixAchat",is(200)))
				
				.andExpect(jsonPath("$.[1].id",is(1)))
				.andExpect(jsonPath("$.[1].nom",is("Ordinateur portable")))
				.andExpect(jsonPath("$.[1].prix",is(350)))
				.andExpect(jsonPath("$.[1].prixAchat",is(120)))
				
				.andExpect(jsonPath("$.[2].id",is(3)))
				.andExpect(jsonPath("$.[2].nom",is("Table de Ping Pong")))
				.andExpect(jsonPath("$.[2].prix",is(750)))
				.andExpect(jsonPath("$.[2].prixAchat",is(400)));	
	}

}
