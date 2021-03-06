package entities;
// Generated Dec 2, 2017 7:44:26 PM by Hibernate Tools 5.1.0.Alpha1

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
 * Huong generated by hbm2java
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "huong", catalog = "db_dulich", uniqueConstraints = @UniqueConstraint(columnNames = "tenhuong") )
public class Huong implements java.io.Serializable {

	private Integer idhuong;
	private String tenhuong;
	private String mota;
	private Set<Loaiphong> loaiphongs = new HashSet<Loaiphong>(0);

	public Huong() {
	}

	public Huong(String tenhuong) {
		this.tenhuong = tenhuong;
	}

	public Huong(String tenhuong, String mota, Set<Loaiphong> loaiphongs) {
		this.tenhuong = tenhuong;
		this.mota = mota;
		this.loaiphongs = loaiphongs;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "idhuong", unique = true, nullable = false)
	public Integer getIdhuong() {
		return this.idhuong;
	}

	public void setIdhuong(Integer idhuong) {
		this.idhuong = idhuong;
	}

	@Column(name = "tenhuong", unique = true, nullable = false, length = 45)
	public String getTenhuong() {
		return this.tenhuong;
	}

	public void setTenhuong(String tenhuong) {
		this.tenhuong = tenhuong;
	}

	@Column(name = "mota", length = 65535)
	public String getMota() {
		return this.mota;
	}

	public void setMota(String mota) {
		this.mota = mota;
	}

	@OneToMany(mappedBy = "huong")
	public Set<Loaiphong> getLoaiphongs() {
		return this.loaiphongs;
	}

	public void setLoaiphongs(Set<Loaiphong> loaiphongs) {
		this.loaiphongs = loaiphongs;
	}

}
