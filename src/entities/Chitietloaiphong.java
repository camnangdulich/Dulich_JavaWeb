package entities;
// Generated Dec 1, 2017 6:59:07 PM by Hibernate Tools 5.1.0.Alpha1

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Chitietloaiphong generated by hbm2java
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "chitietloaiphong", catalog = "db_dulich")
public class Chitietloaiphong implements java.io.Serializable {

	private Integer idchitietloaiphong;
	private Khachsan khachsan;
	private Loaiphong loaiphong;

	public Chitietloaiphong() {
	}

	public Chitietloaiphong(Khachsan khachsan, Loaiphong loaiphong) {
		this.khachsan = khachsan;
		this.loaiphong = loaiphong;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "idchitietloaiphong", unique = true, nullable = false)
	public Integer getIdchitietloaiphong() {
		return this.idchitietloaiphong;
	}

	public void setIdchitietloaiphong(Integer idchitietloaiphong) {
		this.idchitietloaiphong = idchitietloaiphong;
	}

	@ManyToOne()
	@JoinColumn(name = "idkhachsan", nullable = false)
	public Khachsan getKhachsan() {
		return this.khachsan;
	}

	public void setKhachsan(Khachsan khachsan) {
		this.khachsan = khachsan;
	}

	@ManyToOne()
	@JoinColumn(name = "idloaiphong", nullable = false)
	public Loaiphong getLoaiphong() {
		return this.loaiphong;
	}

	public void setLoaiphong(Loaiphong loaiphong) {
		this.loaiphong = loaiphong;
	}

}
