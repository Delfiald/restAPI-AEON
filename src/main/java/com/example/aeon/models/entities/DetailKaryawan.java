package com.example.aeon.models.entities;

import java.io.Serializable;

import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;

@Entity
@Transactional
@Table(name="detail_karyawan")
public class DetailKaryawan implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private long idDetail;
	
	@NotEmpty(message = "NIK is required")
	@Column(length=16)
	private String nik;
	
	@NotEmpty(message = "NPWP is required")
	@Column(length=16)
	private String npwp;
	
	@JsonBackReference
	@OneToOne
	@JoinColumn(name = "id_karyawan", referencedColumnName = "id", nullable=false, updatable=false)
	private Karyawan karyawan;
	
	public DetailKaryawan() {
	}

	public DetailKaryawan(long idDetail, String nik, String npwp, Karyawan karyawan) {
		super();
		this.idDetail = idDetail;
		this.nik = nik;
		this.npwp = npwp;
		this.karyawan = karyawan;
	}

	public long getIdDetail() {
		return idDetail;
	}

	public void setIdDetail(long idDetail) {
		this.idDetail = idDetail;
	}

	public String getNik() {
		return nik;
	}

	public void setNik(String nik) {
		this.nik = nik;
	}

	public String getNpwp() {
		return npwp;
	}

	public void setNpwp(String npwp) {
		this.npwp = npwp;
	}
	
	public Karyawan getKaryawan() {
		return karyawan;
	}

	public void setKaryawan(Karyawan karyawan) {
		this.karyawan = karyawan;
	}
}
