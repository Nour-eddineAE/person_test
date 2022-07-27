package org.test.person.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.test.person.PersonServiceInterface;
import org.test.person.entities.Person;

@Controller
public class PersonController 
{
	@Autowired 
	private PersonServiceInterface personService;
	
	@RequestMapping(value = "/saveNewPerson" , method = RequestMethod.POST)
	public String saveNewPerson(Person person) {
		personService.savePerson(person);
		return "redirect:/Persons";// here we suppose that we have an html page called Persons
	}
	
	/**
	 *for updating, we suppose that first we'll select a person, and then find him based on his id, this will launch a form 
	 *that will be used to edit this person's data  
	 */
	@RequestMapping(value = "/editPerson" , method = RequestMethod.GET)
	public String edit(Long id, Model model) {
		Person person = personService.findPersonById(id);
		model.addAttribute("person",person);// to transfer the person to the updating form
		return "/UpdatingForm";//we suppose that we have a page for updating persons data
	}
	/**
	 *After we launch the updating form with the perosn's old data, we can use the same "savePerson" method  
	 */
	@RequestMapping(value = "saveUpdate" , method = RequestMethod.PUT)
	public String UpdatePerson(Person person) {
		personService.savePerson(person);
		return "redirect:/Persons";// we can return some confirmation page or just go back to "Persons"
	}
	
	/**
	 *for deleting, we will first get the id of the person that we want to delete, then display some confirmation pop-up or even a 
	 *customised confirmation page 
	 */
	@RequestMapping(value = "/delete" , method = RequestMethod.DELETE)
	public String delete(Long id, String keyword, int page , int size) {
		personService.deletePerson(id);
		return "redirect:/Persons";
	}
	
	
}
