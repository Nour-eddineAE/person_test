package org.test.person.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.test.person.PersonServiceInterface;
import org.test.person.dao.PersonRepositoryInterface;
import org.test.person.entities.Person;

@Service
@Transactional
public class PersonServiceImplementation  implements PersonServiceInterface
{
	@Autowired
	private PersonRepositoryInterface personRepository;
	
	@Override
	public void savePerson(Person person) {// this serves for both adding and updating new nodes
		personRepository.save(person);
	}

	@Override
	public Person findPersonById(Long id) {
		Optional<Person> optPerson = personRepository.findById(id);
		Person person = optPerson.orElse(null);
		if(person == null)
			throw new RuntimeException("This person does not exist ");
		return person;
	}

	@Override
	public List<Person> findAllPersons() {
		List<Person> listOfPersons = personRepository.findAll();
		return listOfPersons;
	}

	@Override
	public void deletePerson(Long id) {
		Person person = findPersonById(id);
		personRepository.delete(person);;
	}

}
