package org.front.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import business.model.TrefPersonne;
import business.service.TrefPersonneService;

@Controller
@RequestMapping("/")
public class AppController {

	@Autowired
	TrefPersonneService trefPersonneService;

	/*
	 * This method will list all existing trefPersonnes.
	 */
	@RequestMapping(value = { "/", "/list" }, method = RequestMethod.GET)
	public String listTrefPersonnes(ModelMap model) {
		initModelForAllTrefPersonneView(model,false,false,null);
		return "alltrefpersonne";
	}

	/*
	 * This method will provide the medium to add a new trefPersonne.
	 */
	@RequestMapping(value = { "/new" }, method = RequestMethod.GET)
	public String newTrefPersonne(ModelMap model) {
		initModelForRegistrationView(model, false,new TrefPersonne());
		return "registration";
	}

	/*
	 * This method will be called on form submission, handling POST request for
	 * saving trefPersonne in database. It also validates the user input
	 */
	@RequestMapping(value = { "/new" }, method = RequestMethod.POST)
	public String saveTrefPersonne(@Valid TrefPersonne trefPersonne, BindingResult result,
			ModelMap model) {

		if (result.hasErrors()) {
			initModelForRegistrationView(model,false,trefPersonne);
			return "registration";
		}
		
		trefPersonneService.saveTrefPersonne(trefPersonne);
		initModelForAllTrefPersonneView(model,true,true,trefPersonne);

		return "alltrefpersonne";
	}


	/*
	 * This method will provide the medium to update an existing employee.
	 */
	@RequestMapping(value = { "/edit-{id}-trefPersonne" }, method = RequestMethod.GET)
	public String editEmployee(@PathVariable Integer id, ModelMap model) {
		TrefPersonne trefPersonne = trefPersonneService.findById(id);
		initModelForRegistrationView(model, true,trefPersonne);
		return "registration";
	}
	
	/*
	 * This method will be called on form submission, handling POST request for
	 * updating employee in database. It also validates the user input
	 */
	@RequestMapping(value = { "/edit-{id}-trefPersonne" }, method = RequestMethod.POST)
	public String updateTrefPersonne(@Valid TrefPersonne trefPersonne, BindingResult result,
			ModelMap model, @PathVariable Integer id) {

		if (result.hasErrors()) {
			initModelForRegistrationView(model,true,trefPersonne);
			return "registration";
		}

		trefPersonneService.updateTrefPersonne(trefPersonne);
		initModelForAllTrefPersonneView(model,true,false,trefPersonne);

		return "alltrefpersonne";
	}

	
	/*
	 * This method will delete an employee by it's SSN value.
	 */
	@RequestMapping(value = { "/delete-{id}-trefPersonne" }, method = RequestMethod.GET)
	public String deletePerson(@PathVariable Integer id) {
		TrefPersonne trefPersonne = trefPersonneService.findById(id);
		if(trefPersonne != null){
			trefPersonneService.deleteTrefPersonne(trefPersonne);
		}
		return "redirect:/list";
	}
	
	@RequestMapping(value = { "/search"}, method = RequestMethod.GET)
	public @ResponseBody List<TrefPersonne> searchTrefPersonnes(@RequestParam String query) {
		return trefPersonneService.findByName(query);
	}

	private void initModelForRegistrationView(ModelMap model, boolean edit, TrefPersonne personne){
		model.addAttribute("trefPersonne", personne);
		model.addAttribute("edit", edit);
	}
	
	private void initModelForAllTrefPersonneView(ModelMap model, boolean successSentence, boolean created, TrefPersonne trefPersonne ){
		List<TrefPersonne> trefPersonnes = trefPersonneService.findAllTrefPersonne();
		model.addAttribute("trefPersonnes", trefPersonnes);
		if(successSentence){
			model.addAttribute("success","Person "+trefPersonne.getPeName() + "[ID "+trefPersonne.getPeIcd()+"] "+(created ? "registered":"updated")+" successfully");
		}
		
	}
	
}
