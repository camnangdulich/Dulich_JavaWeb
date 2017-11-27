package entities;
// Generated Nov 27, 2017 11:23:30 AM by Hibernate Tools 5.1.0.Alpha1

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
 * Quyen generated by hbm2java
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "quyen", catalog = "db_dulich", uniqueConstraints = { @UniqueConstraint(columnNames = "quyen"),
		@UniqueConstraint(columnNames = "slug") })
public class Quyen implements java.io.Serializable {

	private Integer idquyen;
	private String quyen;
	private String mota;
	private String slug;
	private Set<Taikhoan> taikhoans = new HashSet<Taikhoan>(0);

	public Quyen() {
	}

	public Quyen(String quyen) {
		this.quyen = quyen;
	}
	public Quyen(String quyen, String mota) {
		this.quyen = quyen;
		this.mota = mota;
	}

	public Quyen(String quyen, String mota, String slug, Set<Taikhoan> taikhoans) {
		this.quyen = quyen;
		this.mota = mota;
		this.slug = slug;
		this.taikhoans = taikhoans;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "idquyen", unique = true, nullable = false)
	public Integer getIdquyen() {
		return this.idquyen;
	}

	public void setIdquyen(Integer idquyen) {
		this.idquyen = idquyen;
	}

	@Column(name = "quyen", unique = true, nullable = false, length = 100)
	public String getQuyen() {
		return this.quyen;
	}

	public void setQuyen(String quyen) {
		this.quyen = quyen;
	}

	@Column(name = "mota", length = 65535)
	public String getMota() {
		return this.mota;
	}

	public void setMota(String mota) {
		this.mota = mota;
	}

	@Column(name = "slug", unique = true, length = 45)
	public String getSlug() {
		return this.slug;
	}

	public void setSlug(String slug) {
		this.slug = slug;
	}

	@OneToMany( mappedBy = "quyen")
	public Set<Taikhoan> getTaikhoans() {
		return this.taikhoans;
	}

	public void setTaikhoans(Set<Taikhoan> taikhoans) {
		this.taikhoans = taikhoans;
	}

}
