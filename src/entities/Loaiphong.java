package entities;
// Generated Nov 24, 2017 9:45:39 PM by Hibernate Tools 5.1.0.Alpha1

import static javax.persistence.GenerationType.IDENTITY;

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
import javax.persistence.UniqueConstraint;

/**
 * Loaiphong generated by hbm2java
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "loaiphong", catalog = "db_dulich", uniqueConstraints = @UniqueConstraint(columnNames = "tenloai") )
public class Loaiphong implements java.io.Serializable {

	private Integer idloaiphong;
	private Huong huong;
	private String tenloai;
	private String mota;
	private int themgiuong;
	private String hinhanh;
	private int gia;
	private Set<Datphong> datphongs = new HashSet<Datphong>(0);
	private Set<Chitietloaiphong> chitietloaiphongs = new HashSet<Chitietloaiphong>(0);

	public Loaiphong() {
	}

	public Loaiphong(String tenloai, String hinhanh, int gia) {
		this.tenloai = tenloai;
		this.hinhanh = hinhanh;
		this.gia = gia;
	}

	public Loaiphong(Huong huong, String tenloai, String mota, int themgiuong,
			String hinhanh, int gia, Set<Datphong> datphongs, Set<Chitietloaiphong> chitietloaiphongs) {
		this.huong = huong;
		this.tenloai = tenloai;
		this.mota = mota;
		this.themgiuong = themgiuong;
		this.hinhanh = hinhanh;
		this.gia = gia;
		this.datphongs = datphongs;
		this.chitietloaiphongs = chitietloaiphongs;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "idloaiphong", unique = true, nullable = false)
	public Integer getIdloaiphong() {
		return this.idloaiphong;
	}

	public void setIdloaiphong(Integer idloaiphong) {
		this.idloaiphong = idloaiphong;
	}

	@ManyToOne()
	@JoinColumn(name = "huong")
	public Huong getHuong() {
		return this.huong;
	}

	public void setHuong(Huong huong) {
		this.huong = huong;
	}

	@Column(name = "tenloai", unique = true, nullable = false, length = 100)
	public String getTenloai() {
		return this.tenloai;
	}

	public void setTenloai(String tenloai) {
		this.tenloai = tenloai;
	}

	@Column(name = "mota", length = 65535)
	public String getMota() {
		return this.mota;
	}

	public void setMota(String mota) {
		this.mota = mota;
	}

	@Column(name = "themgiuong")
	public int getThemgiuong() {
		return this.themgiuong;
	}

	public void setThemgiuong(int themgiuong) {
		this.themgiuong = themgiuong;
	}

	@Column(name = "hinhanh", nullable = false, length = 250)
	public String getHinhanh() {
		return this.hinhanh;
	}

	public void setHinhanh(String hinhanh) {
		this.hinhanh = hinhanh;
	}

	@Column(name = "gia", nullable = false)
	public int getGia() {
		return this.gia;
	}

	public void setGia(int gia) {
		this.gia = gia;
	}

	@OneToMany( mappedBy = "loaiphong")
	public Set<Datphong> getDatphongs() {
		return this.datphongs;
	}

	public void setDatphongs(Set<Datphong> datphongs) {
		this.datphongs = datphongs;
	}

	@OneToMany( mappedBy = "loaiphong")
	public Set<Chitietloaiphong> getChitietloaiphongs() {
		return this.chitietloaiphongs;
	}

	public void setChitietloaiphongs(Set<Chitietloaiphong> chitietloaiphongs) {
		this.chitietloaiphongs = chitietloaiphongs;
	}

}
