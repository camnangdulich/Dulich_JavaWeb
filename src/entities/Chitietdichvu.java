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

/**
 * Chitietdichvu generated by hbm2java
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "chitietdichvu", catalog = "db_dulich")
public class Chitietdichvu implements java.io.Serializable {

	private Integer idchitietdichvu;
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

	@Column(name = "idchitietdichvu", unique = true, nullable = false)
	public Integer getIdchitietdichvu() {
		return this.idchitietdichvu;
	}

	public void setIdchitietdichvu(Integer idchitietdichvu) {
		this.idchitietdichvu = idchitietdichvu;
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
