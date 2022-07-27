package org.test.person;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.test.person.entities.Person;

@SpringBootTest
class PersonApplicationTests {
	@Autowired
	private PersonServiceInterface personInterface;
	
	
	@Test
	void testingSavePerson() {
		/**
		 *this test concerns the updating and saving method.
	 	*/
		Person personTest = new Person("Yassine","male","Yassine21@gmail.com","11111111111","test1");
		personInterface.savePerson(personTest);
		
	}
	@Test
	void testingDeletePerson() {
		/**
		 *we will first try to add a new person 
		 */
		Person personTest2 = new Person("Karim","male","Karim21@gmail.com","22222222222","test2");
		personInterface.savePerson(personTest2);
		/**
		 *then we will try to delete him
		 */
		personInterface.deletePerson(personTest2.getId());
	}
	@Test
	void testFindPersonById() {
		/**
		 *we will first try to add a person, then search him via his id 
		 */
		Person personTest3 = new Person("Salma","female","Salma141@gmail.com","3333333333333","test3");
		personInterface.savePerson(personTest3);
		Person foundPerson = personInterface.findPersonById(personTest3.getId());
		assertNotEquals(null, foundPerson);
	}
	@Test
	void testFindPersonById2(){
	/**
	 *here we will try some invalid id and make sure it throws RuntimeException 
	 */
		assertThrows(RuntimeException.class, 
				() -> {
					Person foundPerson = personInterface.findPersonById(8878l);
				});
	}
	@Test
	void testFindAllPersons() {
		/**
		 *we will first add some persons, then return them in a list 
		 */
		personInterface.savePerson(new Person("kamal","male","kamal@gmail.com","11111111","test2"));
		personInterface.savePerson(new Person("Dounia","female","Salma41@gmail.com","22222222","test2"));
		personInterface.savePerson(new Person("Yassemine","female","Yassemine@gmail.com","33333333","test3"));
		personInterface.savePerson(new Person("Hicham","male","Hicham21@gmail.com","44444444","test4"));
		List<Person> persons = personInterface.findAllPersons();
	}
	
	
}
