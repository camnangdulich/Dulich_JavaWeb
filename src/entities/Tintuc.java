package entities;
// Generated Dec 2, 2017 7:44:26 PM by Hibernate Tools 5.1.0.Alpha1

import static javax.persistence.GenerationType.IDENTITY;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * Tintuc generated by hbm2java
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "tintuc", catalog = "db_dulich", uniqueConstraints = { @UniqueConstraint(columnNames = "tieude"),
		@UniqueConstraint(columnNames = "slug") })
public class Tintuc implements java.io.Serializable {

	private Integer idtintuc;
	private Taikhoan taikhoan;
	private String hinhanh;
	private String tieude;
	private String tomtat;
	private String noidung;
	private Date thoigian;
	private String nguon;
	private String slug;
	private int luotxem;
	private Set<Chitiettin> chitiettins = new HashSet<Chitiettin>(0);

	public Tintuc() {
	}

	public Tintuc(Taikhoan taikhoan, String hinhanh, String tieude, String tomtat, String noidung, Date thoigian,
			String nguon, int luotxem) {
		this.taikhoan = taikhoan;
		this.hinhanh = hinhanh;
		this.tieude = tieude;
		this.tomtat = tomtat;
		this.noidung = noidung;
		this.thoigian = thoigian;
		this.nguon = nguon;
		this.luotxem = luotxem;
	}
	
	public Tintuc(Taikhoan taikhoan, String hinhanh, String tieude, String tomtat, String noidung, Date thoigian,
			String nguon, String slug, int luotxem) {
		this.taikhoan = taikhoan;
		this.hinhanh = hinhanh;
		this.tieude = tieude;
		this.tomtat = tomtat;
		this.noidung = noidung;
		this.thoigian = thoigian;
		this.nguon = nguon;
		this.slug = slug;
		this.luotxem = luotxem;
	}

	public Tintuc(Taikhoan taikhoan, String hinhanh, String tieude, String tomtat, String noidung, Date thoigian,
			String nguon, String slug, int luotxem, Set<Chitiettin> chitiettins) {
		this.taikhoan = taikhoan;
		this.hinhanh = hinhanh;
		this.tieude = tieude;
		this.tomtat = tomtat;
		this.noidung = noidung;
		this.thoigian = thoigian;
		this.nguon = nguon;
		this.slug = slug;
		this.luotxem = luotxem;
		this.chitiettins = chitiettins;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "idtintuc", unique = true, nullable = false)
	public Integer getIdtintuc() {
		return this.idtintuc;
	}

	public void setIdtintuc(Integer idtintuc) {
		this.idtintuc = idtintuc;
	}

	@ManyToOne()
	@JoinColumn(name = "idtaikhoan", nullable = false)
	public Taikhoan getTaikhoan() {
		return this.taikhoan;
	}

	public void setTaikhoan(Taikhoan taikhoan) {
		this.taikhoan = taikhoan;
	}

	@Column(name = "hinhanh", nullable = false, length = 250)
	public String getHinhanh() {
		return this.hinhanh;
	}

	public void setHinhanh(String hinhanh) {
		this.hinhanh = hinhanh;
	}

	@Column(name = "tieude", unique = true, nullable = false, length = 250)
	public String getTieude() {
		return this.tieude;
	}

	public void setTieude(String tieude) {
		this.tieude = tieude;
	}

	@Column(name = "tomtat", nullable = false, length = 65535)
	public String getTomtat() {
		return this.tomtat;
	}

	public void setTomtat(String tomtat) {
		this.tomtat = tomtat;
	}

	@Column(name = "noidung", nullable = false, length = 65535)
	public String getNoidung() {
		return this.noidung;
	}

	public void setNoidung(String noidung) {
		this.noidung = noidung;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(pattern="dd/MM/yyyy - hh:mm")
	@Column(name = "thoigian", nullable = false, length = 19)
	public Date getThoigian() {
		return this.thoigian;
	}

	public void setThoigian(Date thoigian) {
		this.thoigian = thoigian;
	}

	@Column(name = "nguon", nullable = false, length = 100)
	public String getNguon() {
		return this.nguon;
	}

	public void setNguon(String nguon) {
		this.nguon = nguon;
	}

	@Column(name = "slug", unique = true, length = 250)
	public String getSlug() {
		return this.slug;
	}

	public void setSlug(String slug) {
		this.slug = slug;
	}

	@Column(name = "luotxem", nullable = false)
	public int getLuotxem() {
		return this.luotxem;
	}

	public void setLuotxem(int luotxem) {
		this.luotxem = luotxem;
	}

	@OneToMany(mappedBy = "tintuc")
	public Set<Chitiettin> getChitiettins() {
		return this.chitiettins;
	}

	public void setChitiettins(Set<Chitiettin> chitiettins) {
		this.chitiettins = chitiettins;
	}

}
