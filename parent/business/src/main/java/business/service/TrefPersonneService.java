package business.service;

import java.util.List;

import business.model.TrefPersonne;

public interface TrefPersonneService {
	
	public void saveTrefPersonne(TrefPersonne personne);
	public TrefPersonne findById(Integer id);
	public void deleteTrefPersonne(TrefPersonne personne);
	public List<TrefPersonne> findAllTrefPersonne();
	public void updateTrefPersonne(TrefPersonne personne);
}
