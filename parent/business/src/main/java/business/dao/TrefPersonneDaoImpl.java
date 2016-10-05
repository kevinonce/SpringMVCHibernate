package business.dao;

import java.util.List;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import business.model.TrefPersonne;

@Repository("trefPersonneDao")
public class TrefPersonneDaoImpl extends AbstractDao<Integer, TrefPersonne> implements TrefPersonneDao {

	public List<TrefPersonne> list() {
		Session session = getSession();
		List<TrefPersonne> personList = session.createQuery("from TrefPersonne").list();
		return personList;
	}

	public TrefPersonne findById(Integer id) {
		return getByKey(id);
	}

	public void saveTrefPersonne(TrefPersonne trefPersonne) {
		persist(trefPersonne);
		
	}

	public void updateTrefPersonne(TrefPersonne trefPersonne) {
		update(trefPersonne);
	}

	public void deleteTrefPersonne(TrefPersonne trefPersonne) {
		delete(trefPersonne);
	}

}
