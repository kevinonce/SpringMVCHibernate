package business.service;

import java.util.List;

import business.model.TrefBateaux;
import business.model.TrefPersonne;

public interface TrefBateauxService {
	
	public List<TrefBateaux> finByBatelier(Integer idBatelier);

    public  TrefBateaux findById(Integer id);
    
    public void saveTrefBateaux(TrefBateaux trefBateaux);
    
    public void updateTrefBateaux(TrefBateaux trefBateaux);
    
    public void deleteTrefBateaux(TrefBateaux trefBateaux);

}
