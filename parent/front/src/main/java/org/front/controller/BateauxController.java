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

import business.model.TrefBateaux;
import business.model.TrefPersonne;
import business.service.TrefBateauxService;
import business.service.TrefPersonneService;

@Controller
@RequestMapping("/bateaux")
public class BateauxController {
	
	@Autowired
	TrefPersonneService trefPersonneService;
	
	@Autowired
	TrefBateauxService trefBateauxService;
	
	@RequestMapping(value = {"/list/{id}" }, method = RequestMethod.GET)
	public String listBateau( @PathVariable Integer id,ModelMap model) {
		TrefPersonne personne = trefPersonneService.findById(id);
		List<TrefBateaux> listeBateaux = trefBateauxService.finByBatelier(id);
		model.addAttribute("listeBateaux", listeBateaux);
		model.addAttribute("personne",personne);
		return "listeBateaux";
	}
	
	@RequestMapping(value = { "/delete-{id}-bateau" }, method = RequestMethod.GET)
	public String deleteBateau(@PathVariable Integer id) {
		TrefBateaux trefBateau = trefBateauxService.findById(id);
		Integer idPerson = null;
		if(trefBateau != null){
			idPerson = trefBateau.getBpBatelier().getPeIcd();
			trefBateauxService.deleteTrefBateaux(trefBateau);
		}
		return idPerson != null ? "redirect:/bateaux/list/"+idPerson : "redirect:/list/";
	}
	
	@RequestMapping(value = { "/edit-{id}-bateau" }, method = RequestMethod.GET)
	public String editBateau(@PathVariable Integer id, ModelMap model) {
		TrefBateaux trefBateau = trefBateauxService.findById(id);
		List<TrefPersonne> listePersons = trefPersonneService.findAllTrefPersonne();
		model.addAttribute("trefBateau", trefBateau);
		model.addAttribute("edit", true);
		model.addAttribute("listePersons",listePersons);
		return "addBateaux";
	}
	
	@RequestMapping(value = { "/edit-*-bateau" }, method = RequestMethod.POST)
	public String updateBateau(@Valid TrefBateaux trefBateaux, BindingResult result,
			ModelMap model) {

		if (result.hasErrors()) {
			return "addBateaux";
		}

		trefBateauxService.updateTrefBateaux(trefBateaux);
		
		TrefPersonne personne = trefPersonneService.findById(trefBateaux.getBpBatelier().getPeIcd());
		List<TrefBateaux> listeBateaux = trefBateauxService.finByBatelier(personne.getPeIcd());
		model.addAttribute("listeBateaux", listeBateaux);
		model.addAttribute("personne",personne);
		
		model.addAttribute("success","Boat "+trefBateaux.getBpDevise() + "[ID "+trefBateaux.getBpIcd()+"] updated successfully");
		return "listeBateaux";
	}
	
	@RequestMapping(value = { "/new/{id}" }, method = RequestMethod.GET)
	public String newTrefBateaux(ModelMap model, @PathVariable Integer id) {
		TrefBateaux trefBateau = new TrefBateaux();
		TrefPersonne personne = new TrefPersonne();
		personne.setPeIcd(id);
		trefBateau.setBpBatelier(personne);
		List<TrefPersonne> listePersons = trefPersonneService.findAllTrefPersonne();
		model.addAttribute("trefBateau", trefBateau);
		model.addAttribute("edit", false);
		model.addAttribute("listePersons",listePersons);
		return "addBateaux";
	}

	@RequestMapping(value = { "/new/*" }, method = RequestMethod.POST)
	public String saveTrefBateau(@Valid TrefBateaux trefBateaux, BindingResult result,
			ModelMap model) {

		if (result.hasErrors()) {
			return "addBateaux";
		}
		
		trefBateauxService.saveTrefBateaux(trefBateaux);
		TrefPersonne personne = trefPersonneService.findById(trefBateaux.getBpBatelier().getPeIcd());
		List<TrefBateaux> listeBateaux = trefBateauxService.finByBatelier(personne.getPeIcd());
		model.addAttribute("listeBateaux", listeBateaux);
		model.addAttribute("personne",personne);
		
		model.addAttribute("success","Boat "+trefBateaux.getBpDevise() + "[ID "+trefBateaux.getBpIcd()+"] registered successfully");
		return "listeBateaux";
	}

}
