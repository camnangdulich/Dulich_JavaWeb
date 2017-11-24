package entities;
// Generated Nov 25, 2017 1:22:36 AM by Hibernate Tools 5.1.0.Alpha1

import static javax.persistence.GenerationType.IDENTITY;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * Dichvu generated by hbm2java
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "dichvu", catalog = "db_dulich", uniqueConstraints = @UniqueConstraint(columnNames = "tendichvu") )
public class Dichvu implements java.io.Serializable {

	private Integer iddichvu;
	private String tendichvu;
	private String mota;
	private Set<Chitietdichvu> chitietdichvus = new HashSet<Chitietdichvu>(0);

	public Dichvu() {
	}

	public Dichvu(String tendichvu) {
		this.tendichvu = tendichvu;
	}

	public Dichvu(String tendichvu, String mota, Set<Chitietdichvu> chitietdichvus) {
		this.tendichvu = tendichvu;
		this.mota = mota;
		this.chitietdichvus = chitietdichvus;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "iddichvu", unique = true, nullable = false)
	public Integer getIddichvu() {
		return this.iddichvu;
	}

	public void setIddichvu(Integer iddichvu) {
		this.iddichvu = iddichvu;
	}

	@Column(name = "tendichvu", unique = true, nullable = false, length = 100)
	public String getTendichvu() {
		return this.tendichvu;
	}

	public void setTendichvu(String tendichvu) {
		this.tendichvu = tendichvu;
	}

	@Column(name = "mota", length = 65535)
	public String getMota() {
		return this.mota;
	}

	public void setMota(String mota) {
		this.mota = mota;
	}

	@OneToMany( mappedBy = "dichvu")
	public Set<Chitietdichvu> getChitietdichvus() {
		return this.chitietdichvus;
	}

	public void setChitietdichvus(Set<Chitietdichvu> chitietdichvus) {
		this.chitietdichvus = chitietdichvus;
	}

}
