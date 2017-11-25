package entities;
// Generated Nov 25, 2017 10:49:23 PM by Hibernate Tools 5.1.0.Alpha1

import static javax.persistence.GenerationType.IDENTITY;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

/**
 * Danhgia generated by hbm2java
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "danhgia", catalog = "db_dulich", uniqueConstraints = @UniqueConstraint(columnNames = "slug") )
public class Danhgia implements java.io.Serializable {

	private Integer iddanhgia;
	private Khachsan khachsan;
	private Taikhoan taikhoan;
	private Tour tour;
	private int star;
	private String noidung;
	private Date thoigian;
	private String slug;

	public Danhgia() {
	}

	public Danhgia(Taikhoan taikhoan, int star, String noidung, Date thoigian) {
		this.taikhoan = taikhoan;
		this.star = star;
		this.noidung = noidung;
		this.thoigian = thoigian;
	}

	public Danhgia(Khachsan khachsan, Taikhoan taikhoan, Tour tour, int star, String noidung, Date thoigian,
			String slug) {
		this.khachsan = khachsan;
		this.taikhoan = taikhoan;
		this.tour = tour;
		this.star = star;
		this.noidung = noidung;
		this.thoigian = thoigian;
		this.slug = slug;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "iddanhgia", unique = true, nullable = false)
	public Integer getIddanhgia() {
		return this.iddanhgia;
	}

	public void setIddanhgia(Integer iddanhgia) {
		this.iddanhgia = iddanhgia;
	}

	@ManyToOne()
	@JoinColumn(name = "idkhachsan")
	public Khachsan getKhachsan() {
		return this.khachsan;
	}

	public void setKhachsan(Khachsan khachsan) {
		this.khachsan = khachsan;
	}

	@ManyToOne()
	@JoinColumn(name = "idtaikhoan", nullable = false)
	public Taikhoan getTaikhoan() {
		return this.taikhoan;
	}

	public void setTaikhoan(Taikhoan taikhoan) {
		this.taikhoan = taikhoan;
	}

	@ManyToOne()
	@JoinColumn(name = "idtour")
	public Tour getTour() {
		return this.tour;
	}

	public void setTour(Tour tour) {
		this.tour = tour;
	}

	@Column(name = "star", nullable = false)
	public int getStar() {
		return this.star;
	}

	public void setStar(int star) {
		this.star = star;
	}

	@Column(name = "noidung", nullable = false, length = 65535)
	public String getNoidung() {
		return this.noidung;
	}

	public void setNoidung(String noidung) {
		this.noidung = noidung;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "thoigian", nullable = false, length = 19)
	public Date getThoigian() {
		return this.thoigian;
	}

	public void setThoigian(Date thoigian) {
		this.thoigian = thoigian;
	}

	@Column(name = "slug", unique = true, length = 100)
	public String getSlug() {
		return this.slug;
	}

	public void setSlug(String slug) {
		this.slug = slug;
	}

}
