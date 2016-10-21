package business.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.DateSerializer;

@Entity
@Table(name= "TREF_PERSONNE", schema="public")
public class TrefPersonne {
	
	private Integer peIcd;
	private String peName;
	private Date createTime;
	
	
	public TrefPersonne() {
		super();
	}
	
	@Id
	@Column(name = "pe_icd")
	@GeneratedValue(generator="increment")
	@GenericGenerator(name="increment", strategy = "increment")
	public Integer getPeIcd() {
		return peIcd;
	}
	
	public void setPeIcd(Integer peIcd) {
		this.peIcd = peIcd;
	}

	@NotEmpty
	@Column(name = "pe_name")
	public String getPeName() {
		return peName;
	}
	
	public void setPeName(String peName) {
		this.peName = peName;
	}
	
	@NotNull
	@DateTimeFormat(pattern="dd/MM/yyyy")
	@Temporal(TemporalType.DATE)
	@Column(name = "create_time")
	@JsonSerialize(using=DateSerializer.class)
	public Date getCreateTime() {
		return createTime;
	}
	
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	@Override
	public String toString() {
		return "TrefPersonne [peIcd=" + peIcd + ", peName=" + peName + ", createTime=" + createTime + "]";
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((createTime == null) ? 0 : createTime.hashCode());
		result = prime * result + ((peIcd == null) ? 0 : peIcd.hashCode());
		result = prime * result + ((peName == null) ? 0 : peName.hashCode());
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
		TrefPersonne other = (TrefPersonne) obj;
		if (createTime == null) {
			if (other.createTime != null)
				return false;
		} else if (!createTime.equals(other.createTime))
			return false;
		if (peIcd == null) {
			if (other.peIcd != null)
				return false;
		} else if (!peIcd.equals(other.peIcd))
			return false;
		if (peName == null) {
			if (other.peName != null)
				return false;
		} else if (!peName.equals(other.peName))
			return false;
		return true;
	}
}
