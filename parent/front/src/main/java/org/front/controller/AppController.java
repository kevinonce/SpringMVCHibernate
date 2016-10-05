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

		List<TrefPersonne> trefPersonnes = trefPersonneService.findAllTrefPersonne();
		model.addAttribute("trefPersonnes", trefPersonnes);
		return "alltrefpersonne";
	}

	/*
	 * This method will provide the medium to add a new trefPersonne.
	 */
	@RequestMapping(value = { "/new" }, method = RequestMethod.GET)
	public String newTrefPersonne(ModelMap model) {
		TrefPersonne trefPersonne = new TrefPersonne();
		model.addAttribute("trefPersonne", trefPersonne);
		model.addAttribute("edit", false);
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
			return "registration";
		}
		
		trefPersonneService.saveTrefPersonne(trefPersonne);

		model.addAttribute("success", "TrefPersonne " + trefPersonne.getPeName() + " registered successfully");
		return "success";
	}


	/*
	 * This method will provide the medium to update an existing employee.
	 */
	@RequestMapping(value = { "/edit-{id}-trefPersonne" }, method = RequestMethod.GET)
	public String editEmployee(@PathVariable Integer id, ModelMap model) {
		TrefPersonne trefPersonne = trefPersonneService.findById(id);
		model.addAttribute("trefPersonne", trefPersonne);
		model.addAttribute("edit", true);
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
			return "registration";
		}

		trefPersonneService.updateTrefPersonne(trefPersonne);

		model.addAttribute("success", "TrefPersonne " + trefPersonne.getPeName()	+ " updated successfully");
		return "success";
	}

	
	/*
	 * This method will delete an employee by it's SSN value.
	 */
	@RequestMapping(value = { "/delete-{id}-trefPersonne" }, method = RequestMethod.GET)
	public String deleteEmployee(@PathVariable Integer id) {
		TrefPersonne trefPersonne = trefPersonneService.findById(id);
		if(trefPersonne != null){
			trefPersonneService.deleteTrefPersonne(trefPersonne);
		}
		return "redirect:/list";
	}

}
