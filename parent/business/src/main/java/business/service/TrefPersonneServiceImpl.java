package business.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import business.dao.TrefPersonneDao;
import business.model.TrefPersonne;

@Service("trefPersonneService")
@Transactional
public class TrefPersonneServiceImpl implements TrefPersonneService {

	@Autowired
	private TrefPersonneDao trefPersonneDao;
	
	public void saveTrefPersonne(TrefPersonne personne) {
		trefPersonneDao.saveTrefPersonne(personne);
		
	}

	public TrefPersonne findById(Integer id) {
		return trefPersonneDao.findById(id);
	}

	public void deleteTrefPersonne(TrefPersonne personne) {
		trefPersonneDao.deleteTrefPersonne(personne);
		
	}

	public List<TrefPersonne> findAllTrefPersonne() {
		return trefPersonneDao.list();
	}

	public void updateTrefPersonne(TrefPersonne personne) {	
		trefPersonneDao.updateTrefPersonne(personne);
	}

}
