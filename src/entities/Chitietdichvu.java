package entities;
// Generated Nov 24, 2017 2:13:28 AM by Hibernate Tools 5.1.0.Alpha1

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Chitietdichvu generated by hbm2java
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "chitietdichvu", catalog = "db_dulich")
public class Chitietdichvu implements java.io.Serializable {

	private Integer idchitiet;
	private Dichvu dichvu;
	private Khachsan khachsan;

	public Chitietdichvu() {
	}

	public Chitietdichvu(Dichvu dichvu, Khachsan khachsan) {
		this.dichvu = dichvu;
		this.khachsan = khachsan;
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
	@JoinColumn(name = "iddichvu", nullable = false)
	public Dichvu getDichvu() {
		return this.dichvu;
	}

	public void setDichvu(Dichvu dichvu) {
		this.dichvu = dichvu;
	}

	@ManyToOne()
	@JoinColumn(name = "idkhachsan", nullable = false)
	public Khachsan getKhachsan() {
		return this.khachsan;
	}

	public void setKhachsan(Khachsan khachsan) {
		this.khachsan = khachsan;
	}

}