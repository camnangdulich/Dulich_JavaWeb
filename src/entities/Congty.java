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

/**
 * Congty generated by hbm2java
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "congty", catalog = "db_dulich", uniqueConstraints = { @UniqueConstraint(columnNames = "sodienthoai"),
		@UniqueConstraint(columnNames = "tencongty"), @UniqueConstraint(columnNames = "idtaikhoan"),
		@UniqueConstraint(columnNames = "slug") })
public class Congty implements java.io.Serializable {

	private Integer idcongty;
	private Taikhoan taikhoan;
	private String tencongty;
	private String diachi;
	private String mota;
	private String sodienthoai;
	private Date ngaytao;
	private String slug;
	private Set<Tour> tours = new HashSet<Tour>(0);

	public Congty() {
	}
	
	public Congty(Taikhoan taikhoan, String tencongty, String diachi, String mota, String sodienthoai, Date ngaytao,
			String slug) {
		this.taikhoan = taikhoan;
		this.tencongty = tencongty;
		this.diachi = diachi;
		this.mota = mota;
		this.sodienthoai = sodienthoai;
		this.ngaytao = ngaytao;
		this.slug = slug;
	}
	
	public Congty(Taikhoan taikhoan, String tencongty, String diachi, String mota, String sodienthoai,
			Date ngaytao) {
		this.taikhoan = taikhoan;
		this.tencongty = tencongty;
		this.diachi = diachi;
		this.mota = mota;
		this.sodienthoai = sodienthoai;
		this.ngaytao = ngaytao;
	}

	public Congty(Taikhoan taikhoan, String tencongty, String diachi, String sodienthoai) {
		this.taikhoan = taikhoan;
		this.tencongty = tencongty;
		this.diachi = diachi;
		this.sodienthoai = sodienthoai;
	}

	public Congty(Taikhoan taikhoan, String tencongty, String diachi, String mota, String sodienthoai, Date ngaytao,
			String slug, Set<Tour> tours) {
		this.taikhoan = taikhoan;
		this.tencongty = tencongty;
		this.diachi = diachi;
		this.mota = mota;
		this.sodienthoai = sodienthoai;
		this.ngaytao = ngaytao;
		this.slug = slug;
		this.tours = tours;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "idcongty", unique = true, nullable = false)
	public Integer getIdcongty() {
		return this.idcongty;
	}

	public void setIdcongty(Integer idcongty) {
		this.idcongty = idcongty;
	}

	@ManyToOne()
	@JoinColumn(name = "idtaikhoan", unique = true, nullable = false)
	public Taikhoan getTaikhoan() {
		return this.taikhoan;
	}

	public void setTaikhoan(Taikhoan taikhoan) {
		this.taikhoan = taikhoan;
	}

	@Column(name = "tencongty", unique = true, nullable = false, length = 100)
	public String getTencongty() {
		return this.tencongty;
	}

	public void setTencongty(String tencongty) {
		this.tencongty = tencongty;
	}

	@Column(name = "diachi", nullable = false, length = 250)
	public String getDiachi() {
		return this.diachi;
	}

	public void setDiachi(String diachi) {
		this.diachi = diachi;
	}

	@Column(name = "mota", length = 65535)
	public String getMota() {
		return this.mota;
	}

	public void setMota(String mota) {
		this.mota = mota;
	}

	@Column(name = "sodienthoai", unique = true, nullable = false, length = 11)
	public String getSodienthoai() {
		return this.sodienthoai;
	}

	public void setSodienthoai(String sodienthoai) {
		this.sodienthoai = sodienthoai;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "ngaytao", length = 19)
	public Date getNgaytao() {
		return this.ngaytao;
	}

	public void setNgaytao(Date ngaytao) {
		this.ngaytao = ngaytao;
	}

	@Column(name = "slug", unique = true, length = 100)
	public String getSlug() {
		return this.slug;
	}

	public void setSlug(String slug) {
		this.slug = slug;
	}

	@OneToMany(mappedBy = "congty")
	public Set<Tour> getTours() {
		return this.tours;
	}

	public void setTours(Set<Tour> tours) {
		this.tours = tours;
	}

}
