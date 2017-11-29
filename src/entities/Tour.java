package entities;
// Generated Nov 29, 2017 3:09:57 PM by Hibernate Tools 5.1.0.Alpha1

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
 * Tour generated by hbm2java
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "tour", catalog = "db_dulich", uniqueConstraints = { @UniqueConstraint(columnNames = "tentour"),
		@UniqueConstraint(columnNames = "slug") })
public class Tour implements java.io.Serializable {

	private Integer idtour;
	private Congty congty;
	private Tinhthanh tinhthanh;
	private String tentour;
	private String mota;
	private int gia;
	private String diemdi;
	private String giokhoihanh;
	private String lichtrinh;
	private String luuy;
	private String slug;
	private int luotxem;
	private String hinhtour;
	private Set<Dattour> dattours = new HashSet<Dattour>(0);

	public Tour() {
	}

	public Tour(Congty congty, Tinhthanh tinhthanh, String tentour, int gia, String diemdi, String giokhoihanh,
			String lichtrinh, int luotxem, String hinhtour) {
		this.congty = congty;
		this.tinhthanh = tinhthanh;
		this.tentour = tentour;
		this.gia = gia;
		this.diemdi = diemdi;
		this.giokhoihanh = giokhoihanh;
		this.lichtrinh = lichtrinh;
		this.luotxem = luotxem;
		this.hinhtour = hinhtour;
	}

	public Tour(Congty congty, Tinhthanh tinhthanh, String tentour, String mota, int gia, String diemdi,
			String giokhoihanh, String lichtrinh, String luuy, String slug, int luotxem, String hinhtour,
			Set<Dattour> dattours) {
		this.congty = congty;
		this.tinhthanh = tinhthanh;
		this.tentour = tentour;
		this.mota = mota;
		this.gia = gia;
		this.diemdi = diemdi;
		this.giokhoihanh = giokhoihanh;
		this.lichtrinh = lichtrinh;
		this.luuy = luuy;
		this.slug = slug;
		this.luotxem = luotxem;
		this.hinhtour = hinhtour;
		this.dattours = dattours;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "idtour", unique = true, nullable = false)
	public Integer getIdtour() {
		return this.idtour;
	}

	public void setIdtour(Integer idtour) {
		this.idtour = idtour;
	}

	@ManyToOne()
	@JoinColumn(name = "idcongty", nullable = false)
	public Congty getCongty() {
		return this.congty;
	}

	public void setCongty(Congty congty) {
		this.congty = congty;
	}

	@ManyToOne()
	@JoinColumn(name = "diemden", nullable = false)
	public Tinhthanh getTinhthanh() {
		return this.tinhthanh;
	}

	public void setTinhthanh(Tinhthanh tinhthanh) {
		this.tinhthanh = tinhthanh;
	}

	@Column(name = "tentour", unique = true, nullable = false, length = 100)
	public String getTentour() {
		return this.tentour;
	}

	public void setTentour(String tentour) {
		this.tentour = tentour;
	}

	@Column(name = "mota", length = 65535)
	public String getMota() {
		return this.mota;
	}

	public void setMota(String mota) {
		this.mota = mota;
	}

	@Column(name = "gia", nullable = false)
	public int getGia() {
		return this.gia;
	}

	public void setGia(int gia) {
		this.gia = gia;
	}

	@Column(name = "diemdi", nullable = false, length = 100)
	public String getDiemdi() {
		return this.diemdi;
	}

	public void setDiemdi(String diemdi) {
		this.diemdi = diemdi;
	}

	@Column(name = "giokhoihanh", nullable = false, length = 50)
	public String getGiokhoihanh() {
		return this.giokhoihanh;
	}

	public void setGiokhoihanh(String giokhoihanh) {
		this.giokhoihanh = giokhoihanh;
	}

	@Column(name = "lichtrinh", nullable = false, length = 65535)
	public String getLichtrinh() {
		return this.lichtrinh;
	}

	public void setLichtrinh(String lichtrinh) {
		this.lichtrinh = lichtrinh;
	}

	@Column(name = "luuy", length = 65535)
	public String getLuuy() {
		return this.luuy;
	}

	public void setLuuy(String luuy) {
		this.luuy = luuy;
	}

	@Column(name = "slug", unique = true, length = 100)
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

	@Column(name = "hinhtour", nullable = false, length = 250)
	public String getHinhtour() {
		return this.hinhtour;
	}

	public void setHinhtour(String hinhtour) {
		this.hinhtour = hinhtour;
	}

	@OneToMany( mappedBy = "tour")
	public Set<Dattour> getDattours() {
		return this.dattours;
	}

	public void setDattours(Set<Dattour> dattours) {
		this.dattours = dattours;
	}

}
