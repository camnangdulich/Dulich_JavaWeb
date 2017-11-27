package entities;
// Generated Nov 27, 2017 3:24:45 PM by Hibernate Tools 5.1.0.Alpha1

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
 * Tinhthanh generated by hbm2java
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "tinhthanh", catalog = "db_dulich", uniqueConstraints = { @UniqueConstraint(columnNames = "tinhthanh"),
		@UniqueConstraint(columnNames = "slug") })
public class Tinhthanh implements java.io.Serializable {

	private Integer idtinhthanh;
	private String hinhanh;
	private String tinhthanh;
	private String mota;
	private String slug;
	private Set<Khachsan> khachsans = new HashSet<Khachsan>(0);
	private Set<Tour> tours = new HashSet<Tour>(0);

	public Tinhthanh() {
	}
	
	public Tinhthanh(String hinhanh, String tinhthanh, String mota) {
		this.hinhanh = hinhanh;
		this.tinhthanh = tinhthanh;
		this.mota = mota;
	}

	public Tinhthanh(String hinhanh, String tinhthanh) {
		this.hinhanh = hinhanh;
		this.tinhthanh = tinhthanh;
	}

	public Tinhthanh(String hinhanh, String tinhthanh, String mota, String slug, Set<Khachsan> khachsans,
			Set<Tour> tours) {
		this.hinhanh = hinhanh;
		this.tinhthanh = tinhthanh;
		this.mota = mota;
		this.slug = slug;
		this.khachsans = khachsans;
		this.tours = tours;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "idtinhthanh", unique = true, nullable = false)
	public Integer getIdtinhthanh() {
		return this.idtinhthanh;
	}

	public void setIdtinhthanh(Integer idtinhthanh) {
		this.idtinhthanh = idtinhthanh;
	}

	@Column(name = "hinhanh", nullable = false, length = 250)
	public String getHinhanh() {
		return this.hinhanh;
	}

	public void setHinhanh(String hinhanh) {
		this.hinhanh = hinhanh;
	}

	@Column(name = "tinhthanh", unique = true, nullable = false, length = 100)
	public String getTinhthanh() {
		return this.tinhthanh;
	}

	public void setTinhthanh(String tinhthanh) {
		this.tinhthanh = tinhthanh;
	}

	@Column(name = "mota", length = 65535)
	public String getMota() {
		return this.mota;
	}

	public void setMota(String mota) {
		this.mota = mota;
	}

	@Column(name = "slug", unique = true, length = 100)
	public String getSlug() {
		return this.slug;
	}

	public void setSlug(String slug) {
		this.slug = slug;
	}

	@OneToMany(mappedBy = "tinhthanh")
	public Set<Khachsan> getKhachsans() {
		return this.khachsans;
	}

	public void setKhachsans(Set<Khachsan> khachsans) {
		this.khachsans = khachsans;
	}

	@OneToMany(mappedBy = "tinhthanh")
	public Set<Tour> getTours() {
		return this.tours;
	}

	public void setTours(Set<Tour> tours) {
		this.tours = tours;
	}

}
