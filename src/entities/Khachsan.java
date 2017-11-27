package entities;
// Generated Nov 27, 2017 3:24:45 PM by Hibernate Tools 5.1.0.Alpha1

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
 * Khachsan generated by hbm2java
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "khachsan", catalog = "db_dulich", uniqueConstraints = { @UniqueConstraint(columnNames = "tenkhachsan"),
		@UniqueConstraint(columnNames = "sodienthoai"), @UniqueConstraint(columnNames = "idtaikhoan"),
		@UniqueConstraint(columnNames = "slug") })
public class Khachsan implements java.io.Serializable {

	private Integer idkhachsan;
	private Taikhoan taikhoan;
	private Tinhthanh tinhthanh;
	private Trangthai trangthai;
	private String tenkhachsan;
	private String hinhanh;
	private String sodienthoai;
	private String diachi;
	private Date ngaydang;
	private String slug;
	private Set<Chitietdichvu> chitietdichvus = new HashSet<Chitietdichvu>(0);
	private Set<Danhgia> danhgias = new HashSet<Danhgia>(0);
	private Set<Chitietloaiphong> chitietloaiphongs = new HashSet<Chitietloaiphong>(0);

	public Khachsan() {
	}

	public Khachsan(Taikhoan taikhoan, Tinhthanh tinhthanh, Trangthai trangthai, String tenkhachsan, String hinhanh,
			String sodienthoai, String diachi, Date ngaydang) {
		this.taikhoan = taikhoan;
		this.tinhthanh = tinhthanh;
		this.trangthai = trangthai;
		this.tenkhachsan = tenkhachsan;
		this.hinhanh = hinhanh;
		this.sodienthoai = sodienthoai;
		this.diachi = diachi;
		this.ngaydang = ngaydang;
	}

	public Khachsan(Taikhoan taikhoan, Tinhthanh tinhthanh, Trangthai trangthai, String tenkhachsan, String hinhanh,
			String sodienthoai, String diachi, Date ngaydang, String slug, Set<Chitietdichvu> chitietdichvus,
			Set<Danhgia> danhgias, Set<Chitietloaiphong> chitietloaiphongs) {
		this.taikhoan = taikhoan;
		this.tinhthanh = tinhthanh;
		this.trangthai = trangthai;
		this.tenkhachsan = tenkhachsan;
		this.hinhanh = hinhanh;
		this.sodienthoai = sodienthoai;
		this.diachi = diachi;
		this.ngaydang = ngaydang;
		this.slug = slug;
		this.chitietdichvus = chitietdichvus;
		this.danhgias = danhgias;
		this.chitietloaiphongs = chitietloaiphongs;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "idkhachsan", unique = true, nullable = false)
	public Integer getIdkhachsan() {
		return this.idkhachsan;
	}

	public void setIdkhachsan(Integer idkhachsan) {
		this.idkhachsan = idkhachsan;
	}

	@ManyToOne()
	@JoinColumn(name = "idtaikhoan", unique = true, nullable = false)
	public Taikhoan getTaikhoan() {
		return this.taikhoan;
	}

	public void setTaikhoan(Taikhoan taikhoan) {
		this.taikhoan = taikhoan;
	}

	@ManyToOne()
	@JoinColumn(name = "idtinhthanh", nullable = false)
	public Tinhthanh getTinhthanh() {
		return this.tinhthanh;
	}

	public void setTinhthanh(Tinhthanh tinhthanh) {
		this.tinhthanh = tinhthanh;
	}

	@ManyToOne()
	@JoinColumn(name = "idtrangthai", nullable = false)
	public Trangthai getTrangthai() {
		return this.trangthai;
	}

	public void setTrangthai(Trangthai trangthai) {
		this.trangthai = trangthai;
	}

	@Column(name = "tenkhachsan", unique = true, nullable = false, length = 100)
	public String getTenkhachsan() {
		return this.tenkhachsan;
	}

	public void setTenkhachsan(String tenkhachsan) {
		this.tenkhachsan = tenkhachsan;
	}

	@Column(name = "hinhanh", nullable = false, length = 250)
	public String getHinhanh() {
		return this.hinhanh;
	}

	public void setHinhanh(String hinhanh) {
		this.hinhanh = hinhanh;
	}

	@Column(name = "sodienthoai", unique = true, nullable = false, length = 11)
	public String getSodienthoai() {
		return this.sodienthoai;
	}

	public void setSodienthoai(String sodienthoai) {
		this.sodienthoai = sodienthoai;
	}

	@Column(name = "diachi", nullable = false, length = 250)
	public String getDiachi() {
		return this.diachi;
	}

	public void setDiachi(String diachi) {
		this.diachi = diachi;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "ngaydang", nullable = false, length = 19)
	public Date getNgaydang() {
		return this.ngaydang;
	}

	public void setNgaydang(Date ngaydang) {
		this.ngaydang = ngaydang;
	}

	@Column(name = "slug", unique = true, length = 45)
	public String getSlug() {
		return this.slug;
	}

	public void setSlug(String slug) {
		this.slug = slug;
	}

	@OneToMany(mappedBy = "khachsan")
	public Set<Chitietdichvu> getChitietdichvus() {
		return this.chitietdichvus;
	}

	public void setChitietdichvus(Set<Chitietdichvu> chitietdichvus) {
		this.chitietdichvus = chitietdichvus;
	}

	@OneToMany(mappedBy = "khachsan")
	public Set<Danhgia> getDanhgias() {
		return this.danhgias;
	}

	public void setDanhgias(Set<Danhgia> danhgias) {
		this.danhgias = danhgias;
	}

	@OneToMany(mappedBy = "khachsan")
	public Set<Chitietloaiphong> getChitietloaiphongs() {
		return this.chitietloaiphongs;
	}

	public void setChitietloaiphongs(Set<Chitietloaiphong> chitietloaiphongs) {
		this.chitietloaiphongs = chitietloaiphongs;
	}

}
