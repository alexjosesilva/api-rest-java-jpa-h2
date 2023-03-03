package com.techinterface.swagger;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import com.techinterface.SwaggerIntegrationApplication;
import com.techinterface.models.Person;
import com.techinterface.repository.PersonRepository;

import org.mockito.MockedStatic;
import org.mockito.Mockito;
import static org.assertj.core.api.Assertions.*;

@SpringBootTest
class SwaggerIntegrationApplicationTests {

    @Autowired
	private PersonRepository personRepository;
	
 
    
	@Test
    void test_application() {
        MockedStatic<SpringApplication> utilities = Mockito.mockStatic(SpringApplication.class);
        utilities.when((MockedStatic.Verification) SpringApplication.run(SwaggerIntegrationApplication.class, new String[]{})).thenReturn(null);
        SwaggerIntegrationApplication.main(new String[]{});
        assertThat(SpringApplication.run(SwaggerIntegrationApplication.class, new String[]{})).isEqualTo(null);
    }
	
	@Test
	void test_personresoure_save() {
		Person person = new Person("nome",1);
		personRepository.save(person);
		Optional<Person> person2 = personRepository.findById(person.getId());
		assertEquals(person.getId(), person2.get().getId());
		
	}
	
	@Test
	void test_personresoure_put() {
	
	}
	
	@Test
	void test_personresoure_delete() {
	
	}
	
	@Test
	void test_personresoure_list() {
	
	}
	
	@Test
	void test_personresoure_search() {
	
	}
	
	@Test
	void test_person() {
		Person person = new Person("nome",1);
	    person.setId(2);
		person.setAge(1);
		person.setName("nome");
		assertEquals(person.getAge(), 1);
		assertEquals(person.getName(),"nome");
		assertEquals(person.getId(), 2);
		
	}

}
