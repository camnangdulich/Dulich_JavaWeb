package entities;
// Generated Dec 2, 2017 7:44:26 PM by Hibernate Tools 5.1.0.Alpha1

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * Dattour generated by hbm2java
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "dattour", catalog = "db_dulich", uniqueConstraints = @UniqueConstraint(columnNames = "slug") )
public class Dattour implements java.io.Serializable {

	private Integer iddattour;
	private Taikhoan taikhoan;
	private Tour tour;
	private Trangthai trangthai;
	private String hodem;
	private String ten;
	private int songuoi;
	private String dienthoai;
	private String email;
	private String yeucau;
	private String slug;

	public Dattour() {
	}
	
	public Dattour(Tour tour, Trangthai trangthai, String hodem, String ten, int songuoi,
			String dienthoai, String email, String yeucau) {
		this.tour = tour;
		this.trangthai = trangthai;
		this.hodem = hodem;
		this.ten = ten;
		this.songuoi = songuoi;
		this.dienthoai = dienthoai;
		this.email = email;
		this.yeucau = yeucau;
	}

	public Dattour(Tour tour, Trangthai trangthai, String hodem, String ten, int songuoi, String dienthoai,
			String email) {
		this.tour = tour;
		this.trangthai = trangthai;
		this.hodem = hodem;
		this.ten = ten;
		this.songuoi = songuoi;
		this.dienthoai = dienthoai;
		this.email = email;
	}

	public Dattour(Taikhoan taikhoan, Tour tour, Trangthai trangthai, String hodem, String ten, int songuoi,
			String dienthoai, String email, String yeucau, String slug) {
		this.taikhoan = taikhoan;
		this.tour = tour;
		this.trangthai = trangthai;
		this.hodem = hodem;
		this.ten = ten;
		this.songuoi = songuoi;
		this.dienthoai = dienthoai;
		this.email = email;
		this.yeucau = yeucau;
		this.slug = slug;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "iddattour", unique = true, nullable = false)
	public Integer getIddattour() {
		return this.iddattour;
	}

	public void setIddattour(Integer iddattour) {
		this.iddattour = iddattour;
	}

	@ManyToOne()
	@JoinColumn(name = "idtaikhoan")
	public Taikhoan getTaikhoan() {
		return this.taikhoan;
	}

	public void setTaikhoan(Taikhoan taikhoan) {
		this.taikhoan = taikhoan;
	}

	@ManyToOne()
	@JoinColumn(name = "idtour", nullable = false)
	public Tour getTour() {
		return this.tour;
	}

	public void setTour(Tour tour) {
		this.tour = tour;
	}

	@ManyToOne()
	@JoinColumn(name = "idtrangthai", nullable = false)
	public Trangthai getTrangthai() {
		return this.trangthai;
	}

	public void setTrangthai(Trangthai trangthai) {
		this.trangthai = trangthai;
	}

	@Column(name = "hodem", nullable = false, length = 50)
	public String getHodem() {
		return this.hodem;
	}

	public void setHodem(String hodem) {
		this.hodem = hodem;
	}

	@Column(name = "ten", nullable = false, length = 50)
	public String getTen() {
		return this.ten;
	}

	public void setTen(String ten) {
		this.ten = ten;
	}

	@Column(name = "songuoi", nullable = false)
	public int getSonguoi() {
		return this.songuoi;
	}

	public void setSonguoi(int songuoi) {
		this.songuoi = songuoi;
	}

	@Column(name = "dienthoai", nullable = false, length = 11)
	public String getDienthoai() {
		return this.dienthoai;
	}

	public void setDienthoai(String dienthoai) {
		this.dienthoai = dienthoai;
	}

	@Column(name = "email", nullable = false, length = 100)
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "yeucau", length = 65535)
	public String getYeucau() {
		return this.yeucau;
	}

	public void setYeucau(String yeucau) {
		this.yeucau = yeucau;
	}

	@Column(name = "slug", unique = true, length = 100)
	public String getSlug() {
		return this.slug;
	}

	public void setSlug(String slug) {
		this.slug = slug;
	}

}
