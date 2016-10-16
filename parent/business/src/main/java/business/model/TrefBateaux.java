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
import org.hibernate.validator.constraints.NotEmpty;

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
	
	@NotEmpty
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bpBatelier == null) ? 0 : bpBatelier.hashCode());
		result = prime * result + ((bpDevise == null) ? 0 : bpDevise.hashCode());
		result = prime * result + ((bpIcd == null) ? 0 : bpIcd.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TrefBateaux other = (TrefBateaux) obj;
		if (bpBatelier == null) {
			if (other.bpBatelier != null)
				return false;
		} else if (!bpBatelier.equals(other.bpBatelier))
			return false;
		if (bpDevise == null) {
			if (other.bpDevise != null)
				return false;
		} else if (!bpDevise.equals(other.bpDevise))
			return false;
		if (bpIcd == null) {
			if (other.bpIcd != null)
				return false;
		} else if (!bpIcd.equals(other.bpIcd))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "TrefBateaux [bpIcd=" + bpIcd + ", bpDevise=" + bpDevise + ", bpBatelier=" + bpBatelier + "]";
	}
}
