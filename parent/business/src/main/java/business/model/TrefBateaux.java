package business.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name= "TREF_BATEAUX", schema="public")
public class TrefBateaux {

	private Integer bpIcd;
	private String bpDevise;
	private TrefPersonne bpBatelier;
	
	public TrefBateaux() {
		super();
	}
	
	@Id
	@Column(name = "bp_icd")
	@GeneratedValue(generator="increment")
	@GenericGenerator(name="increment", strategy = "increment")
	public Integer getBpIcd() {
		return bpIcd;
	}
	public void setBpIcd(Integer bpIcd) {
		this.bpIcd = bpIcd;
	}
	
	@Column(name="bp_devise")
	public String getBpDevise() {
		return bpDevise;
	}
	public void setBpDevise(String bpDevise) {
		this.bpDevise = bpDevise;
	}
	
	@ManyToOne
	@JoinColumn(name="bp_batelier")
	@NotNull
	public TrefPersonne getBpBatelier() {
		return bpBatelier;
	}
	public void setBpBatelier(TrefPersonne bpBatelier) {
		this.bpBatelier = bpBatelier;
	}
}
