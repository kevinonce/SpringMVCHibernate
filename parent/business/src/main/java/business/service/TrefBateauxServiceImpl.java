package business.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import business.dao.TrefBateauxDao;
import business.model.TrefBateaux;
import business.model.TrefPersonne;

@Service("trefBateauxService")
@Transactional
public class TrefBateauxServiceImpl implements TrefBateauxService {

	@Autowired
	private TrefBateauxDao trefBateauxDao;
	
	public List<TrefBateaux> finByBatelier(Integer idBatelier) {
		return trefBateauxDao.finByBatelier(idBatelier);
	}

	public TrefBateaux findById(Integer id) {
		return trefBateauxDao.findById(id);
	}

	public void saveTrefBateaux(TrefBateaux trefBateaux) {
		trefBateauxDao.saveTrefBateaux(trefBateaux);
	}

	public void updateTrefBateaux(TrefBateaux trefBateaux) {
		trefBateauxDao.updateTrefBateaux(trefBateaux);

	}

	public void deleteTrefBateaux(TrefBateaux trefBateaux) {
		trefBateauxDao.deleteTrefBateaux(trefBateaux);
	}

}
