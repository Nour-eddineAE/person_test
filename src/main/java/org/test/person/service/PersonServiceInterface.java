package org.test.person.service;

import java.util.List;

import org.test.person.entities.Person;

public interface PersonServiceInterface 
{
	public void savePerson(Person person);
	public Person findPersonById(Long id);
	public List<Person> findAllPersons();
	public void deletePerson(Long id);
}
