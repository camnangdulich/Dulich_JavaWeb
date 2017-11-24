package entities;
// Generated Nov 24, 2017 2:13:28 AM by Hibernate Tools 5.1.0.Alpha1

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
@Table(name = "congty", catalog = "db_dulich", uniqueConstraints = { @UniqueConstraint(columnNames = "email"),
		@UniqueConstraint(columnNames = "sodienthoai"), @UniqueConstraint(columnNames = "tencongty") })
public class Congty implements java.io.Serializable {

	private Integer idcongty;
	private Taikhoan taikhoan;
	private String tencongty;
	private String diachi;
	private String mota;
	private String email;
	private String sodienthoai;
	private Date ngaytao;
	private Set<Tour> tours = new HashSet<Tour>(0);

	public Congty() {
	}

	public Congty(Taikhoan taikhoan, String tencongty, String diachi, String email, String sodienthoai) {
		this.taikhoan = taikhoan;
		this.tencongty = tencongty;
		this.diachi = diachi;
		this.email = email;
		this.sodienthoai = sodienthoai;
	}

	public Congty(Taikhoan taikhoan, String tencongty, String diachi, String mota, String email, String sodienthoai,
			Date ngaytao, Set<Tour> tours) {
		this.taikhoan = taikhoan;
		this.tencongty = tencongty;
		this.diachi = diachi;
		this.mota = mota;
		this.email = email;
		this.sodienthoai = sodienthoai;
		this.ngaytao = ngaytao;
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
	@JoinColumn(name = "idtaikhoan", nullable = false)
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

	@Column(name = "email", unique = true, nullable = false, length = 100)
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	@OneToMany(mappedBy = "congty")
	public Set<Tour> getTours() {
		return this.tours;
	}

	public void setTours(Set<Tour> tours) {
		this.tours = tours;
	}

}
