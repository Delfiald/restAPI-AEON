package com.example.aeon.models.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Transactional
@Table(name = "karyawan")
@EntityListeners(AuditingEntityListener.class)
public class Karyawan implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long idKaryawan;
	
	@CreatedDate
	@Column(name = "created_date", nullable = false, updatable = false)
	private Date createdDate = new Date();
	
	@Column(name = "deleted_date")
	private Date deletedDate;
	
	@LastModifiedDate
	@Column(name = "updated_date")
	private Date updatedDate = new Date();
	
	@NotEmpty(message = "Alamat is required")
	private String alamat;
	
	private Date dob = new Date();
	
	@NotEmpty(message = "Jenis Kelamin is required")
	@Column(name="jk", length=10)
	private String jk;
	
	@NotEmpty(message = "Nama is required")
	@Column(name="nama", length=100)
	private String nama;
	
	@NotEmpty(message = "Status is required")
	@Column(name="status", length=16)
	private String status;

	@JsonManagedReference
	@OneToOne(mappedBy = "karyawan", cascade = CascadeType.ALL)
	private DetailKaryawan detailKaryawan;
	
	@OneToMany(mappedBy = "karyawan")
	private List<Rekening> rekening;
	
	@OneToMany(mappedBy = "karyawan")
	private List<KaryawanTraining> karyawanTraining;
	
	public Karyawan() {
	}
	
	public Karyawan(Long idKaryawan, Date createdDate, Date deletedDate, Date updatedDate, String alamat, Date dob,
			String jk, String nama, String status, DetailKaryawan detailKaryawan, List<Rekening> rekening,
			List<KaryawanTraining> karyawanTraining) {
		super();
		this.idKaryawan = idKaryawan;
		this.createdDate = createdDate;
		this.deletedDate = deletedDate;
		this.updatedDate = updatedDate;
		this.alamat = alamat;
		this.dob = dob;
		this.jk = jk;
		this.nama = nama;
		this.status = status;
		this.detailKaryawan = detailKaryawan;
		this.rekening = rekening;
		this.karyawanTraining = karyawanTraining;
	}

	public Long getIdKaryawan() {
		return this.idKaryawan;
	}
	
	public void setIdKaryawan(Long idKaryawan) {
		this.idKaryawan = idKaryawan;
	}
	
	public Date getCreatedDate() {
		return this.createdDate;
	}
	
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	
	public Date getDeletedDate() {
		return this.deletedDate;
	}
	
	public void setDeletedDate(Date deletedDate) {
		this.deletedDate = deletedDate;
	}
	
	public Date getUpdatedDate() {
		return this.updatedDate;
	}
	
	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}
	
	public String getAlamat() {
		return this.alamat;
	}
	
	public void setAlamat(String alamat) {
		this.alamat = alamat;
	}
	
	public Date getDob() {
		return this.dob;
	}
	
	public void setDob(Date dob) {
		this.dob = dob;
	}
	
	public String getJk() {
		return this.jk;
	}
	
	public void setJk(String jk) {
		this.jk = jk;
	}
	
	public String getNama() {
		return this.nama;
	}
	
	public void setNama(String nama) {
		this.nama = nama;
	}
	
	public String getStatus() {
		return this.status;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}
	
	public DetailKaryawan getDetailKaryawan() {
		return detailKaryawan;
	}

	public void setDetailKaryawan(DetailKaryawan detailKaryawan) {
		this.detailKaryawan = detailKaryawan;
	}

	public List<Rekening> getRekening() {
		return rekening;
	}

	public void setRekening(List<Rekening> rekening) {
		this.rekening = rekening;
	}

	public List<KaryawanTraining> getKaryawanTraining() {
		return karyawanTraining;
	}

	public void setKaryawanTraining(List<KaryawanTraining> karyawanTraining) {
		this.karyawanTraining = karyawanTraining;
	}
}
