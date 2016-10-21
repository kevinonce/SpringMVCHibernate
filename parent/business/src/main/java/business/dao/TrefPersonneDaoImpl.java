package business.dao;

import java.util.List;

import org.hibernate.Query;
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

	public List<TrefPersonne> findByName(String name) {
		Query query = getSession().createQuery("from TrefPersonne where upper(peName) like upper(?))");
		query.setParameter(0, "%"+name+"%");
		return query.list();
	}

}
