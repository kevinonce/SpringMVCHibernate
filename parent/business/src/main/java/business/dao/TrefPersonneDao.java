package business.dao;

import java.util.List;

import business.model.TrefPersonne;

public interface TrefPersonneDao {
		
	public List<TrefPersonne> list();

    public  TrefPersonne findById(Integer id);
    
    public void saveTrefPersonne(TrefPersonne trefPersonne);
    
    public void updateTrefPersonne(TrefPersonne trefPersonne);
    
    public void deleteTrefPersonne(TrefPersonne trefPersonne);
    
    public List<TrefPersonne> findByName(String name);

}
