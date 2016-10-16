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
		initModelForListeBateauxView(model,id,false,false,null);
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
		TrefBateaux trefBateaux = trefBateauxService.findById(id);
		initModelForAddBateauxView(model,true,trefBateaux);
		return "addBateaux";
	}
	
	@RequestMapping(value = { "/edit-*-bateau" }, method = RequestMethod.POST)
	public String updateBateau(@Valid TrefBateaux trefBateaux, BindingResult result,
			ModelMap model) {

		if (result.hasErrors()) {
			initModelForAddBateauxView(model, true,trefBateaux);
			return "addBateaux";
		}

		trefBateauxService.updateTrefBateaux(trefBateaux);
		initModelForListeBateauxView(model,trefBateaux.getBpBatelier().getPeIcd(),true,false,trefBateaux);

		return "listeBateaux";
	}
	
	@RequestMapping(value = { "/new/{id}" }, method = RequestMethod.GET)
	public String newTrefBateaux(ModelMap model, @PathVariable Integer id) {
		TrefBateaux trefBateaux = new TrefBateaux();
		TrefPersonne personne = new TrefPersonne();
		personne.setPeIcd(id);
		trefBateaux.setBpBatelier(personne);
		initModelForAddBateauxView(model,false,trefBateaux);
		return "addBateaux";
	}

	@RequestMapping(value = { "/new/*" }, method = RequestMethod.POST)
	public String saveTrefBateau(@Valid TrefBateaux trefBateaux, BindingResult result,
			ModelMap model) {

		if (result.hasErrors()) {
			initModelForAddBateauxView(model, false,trefBateaux);
			return "addBateaux";
		}
		
		trefBateauxService.saveTrefBateaux(trefBateaux);
		initModelForListeBateauxView(model,trefBateaux.getBpBatelier().getPeIcd(),true,true,trefBateaux);

		return "listeBateaux";
	}

	private void initModelForAddBateauxView(ModelMap model, boolean edit, TrefBateaux trefBateaux){
		List<TrefPersonne> listePersons = trefPersonneService.findAllTrefPersonne();
		model.addAttribute("trefBateaux", trefBateaux);
		model.addAttribute("edit", edit);
		model.addAttribute("listePersons",listePersons);
	}
	
	private void initModelForListeBateauxView(ModelMap model, Integer personneId, boolean successSentence, boolean created, TrefBateaux trefBateaux){
		TrefPersonne personne = trefPersonneService.findById(personneId);
		List<TrefBateaux> listeBateaux = trefBateauxService.finByBatelier(personneId);
		model.addAttribute("listeBateaux", listeBateaux);
		model.addAttribute("personne",personne);
		if(successSentence){
			model.addAttribute("success","Boat "+trefBateaux.getBpDevise() + "[ID "+trefBateaux.getBpIcd()+"] "+(created ? "registered":"updated")+" successfully");
		}
	}
}
