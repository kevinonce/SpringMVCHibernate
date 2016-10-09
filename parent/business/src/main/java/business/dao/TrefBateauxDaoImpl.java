package business.dao;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import business.model.TrefBateaux;
import business.model.TrefPersonne;

@Repository("trefBateauxDao")
public class TrefBateauxDaoImpl extends AbstractDao<Integer, TrefBateaux> implements TrefBateauxDao {

	public List<TrefBateaux> finByBatelier(Integer idBatelier) {
		Query query = getSession().createQuery("From TrefBateaux tb where tb.bpBatelier.peIcd = ?");
		query.setParameter(0, idBatelier);
		
		return query.list();
	}

	public TrefBateaux findById(Integer id) {
		return getByKey(id);
	}

	public void saveTrefBateaux(TrefBateaux trefBateaux) {
		persist(trefBateaux);
	}

	public void updateTrefBateaux(TrefBateaux trefBateaux) {
		update(trefBateaux);
	}

	public void deleteTrefBateaux(TrefBateaux trefBateaux) {
		delete(trefBateaux);
	}

}
