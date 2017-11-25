package entities;
// Generated Nov 25, 2017 10:49:23 PM by Hibernate Tools 5.1.0.Alpha1

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
 * Trangthai generated by hbm2java
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "trangthai", catalog = "db_dulich", uniqueConstraints = { @UniqueConstraint(columnNames = "trangthai"),
		@UniqueConstraint(columnNames = "slug") })
public class Trangthai implements java.io.Serializable {

	private Integer idtrangthai;
	private String trangthai;
	private String mota;
	private String slug;
	private Set<Datphong> datphongs = new HashSet<Datphong>(0);
	private Set<Khachsan> khachsans = new HashSet<Khachsan>(0);
	private Set<Taikhoan> taikhoans = new HashSet<Taikhoan>(0);
	private Set<Dattour> dattours = new HashSet<Dattour>(0);

	public Trangthai() {
	}

	public Trangthai(String trangthai) {
		this.trangthai = trangthai;
	}

	public Trangthai(String trangthai, String mota, String slug, Set<Datphong> datphongs, Set<Khachsan> khachsans,
			Set<Taikhoan> taikhoans, Set<Dattour> dattours) {
		this.trangthai = trangthai;
		this.mota = mota;
		this.slug = slug;
		this.datphongs = datphongs;
		this.khachsans = khachsans;
		this.taikhoans = taikhoans;
		this.dattours = dattours;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "idtrangthai", unique = true, nullable = false)
	public Integer getIdtrangthai() {
		return this.idtrangthai;
	}

	public void setIdtrangthai(Integer idtrangthai) {
		this.idtrangthai = idtrangthai;
	}

	@Column(name = "trangthai", unique = true, nullable = false, length = 50)
	public String getTrangthai() {
		return this.trangthai;
	}

	public void setTrangthai(String trangthai) {
		this.trangthai = trangthai;
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

	@OneToMany( mappedBy = "trangthai")
	public Set<Datphong> getDatphongs() {
		return this.datphongs;
	}

	public void setDatphongs(Set<Datphong> datphongs) {
		this.datphongs = datphongs;
	}

	@OneToMany( mappedBy = "trangthai")
	public Set<Khachsan> getKhachsans() {
		return this.khachsans;
	}

	public void setKhachsans(Set<Khachsan> khachsans) {
		this.khachsans = khachsans;
	}

	@OneToMany( mappedBy = "trangthai")
	public Set<Taikhoan> getTaikhoans() {
		return this.taikhoans;
	}

	public void setTaikhoans(Set<Taikhoan> taikhoans) {
		this.taikhoans = taikhoans;
	}

	@OneToMany( mappedBy = "trangthai")
	public Set<Dattour> getDattours() {
		return this.dattours;
	}

	public void setDattours(Set<Dattour> dattours) {
		this.dattours = dattours;
	}

}
