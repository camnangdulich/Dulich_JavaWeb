package entities;
// Generated Nov 24, 2017 9:45:39 PM by Hibernate Tools 5.1.0.Alpha1

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Chitiettin generated by hbm2java
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "chitiettin", catalog = "db_dulich")
public class Chitiettin implements java.io.Serializable {

	private Integer idchitiet;
	private Loaitin loaitin;
	private Tintuc tintuc;

	public Chitiettin() {
	}

	public Chitiettin(Loaitin loaitin, Tintuc tintuc) {
		this.loaitin = loaitin;
		this.tintuc = tintuc;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "idchitiet", unique = true, nullable = false)
	public Integer getIdchitiet() {
		return this.idchitiet;
	}

	public void setIdchitiet(Integer idchitiet) {
		this.idchitiet = idchitiet;
	}

	@ManyToOne()
	@JoinColumn(name = "idloaitin", nullable = false)
	public Loaitin getLoaitin() {
		return this.loaitin;
	}

	public void setLoaitin(Loaitin loaitin) {
		this.loaitin = loaitin;
	}

	@ManyToOne()
	@JoinColumn(name = "idtintuc", nullable = false)
	public Tintuc getTintuc() {
		return this.tintuc;
	}

	public void setTintuc(Tintuc tintuc) {
		this.tintuc = tintuc;
	}

}
