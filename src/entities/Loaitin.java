package entities;
// Generated Nov 27, 2017 11:23:30 AM by Hibernate Tools 5.1.0.Alpha1

import static javax.persistence.GenerationType.IDENTITY;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * Loaitin generated by hbm2java
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "loaitin", catalog = "db_dulich", uniqueConstraints = { @UniqueConstraint(columnNames = "loaitin"),
		@UniqueConstraint(columnNames = "slug") })
public class Loaitin implements java.io.Serializable {

	private Integer idloaitin;
	private String loaitin;
	private String mota;
	private String slug;
	private Set<Tintuc> tintucs = new HashSet<Tintuc>(0);

	public Loaitin() {
	}

	public Loaitin(String loaitin) {
		this.loaitin = loaitin;
	}

	public Loaitin(String loaitin, String mota, String slug, Set<Tintuc> tintucs) {
		this.loaitin = loaitin;
		this.mota = mota;
		this.slug = slug;
		this.tintucs = tintucs;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "idloaitin", unique = true, nullable = false)
	public Integer getIdloaitin() {
		return this.idloaitin;
	}

	public void setIdloaitin(Integer idloaitin) {
		this.idloaitin = idloaitin;
	}

	@Column(name = "loaitin", unique = true, nullable = false, length = 100)
	public String getLoaitin() {
		return this.loaitin;
	}

	public void setLoaitin(String loaitin) {
		this.loaitin = loaitin;
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

	@ManyToMany( mappedBy = "loaitins")
	public Set<Tintuc> getTintucs() {
		return this.tintucs;
	}

	public void setTintucs(Set<Tintuc> tintucs) {
		this.tintucs = tintucs;
	}

}
