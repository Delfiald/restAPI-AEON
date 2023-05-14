package com.example.aeon.models.entities;

import java.io.Serializable;
import java.util.Date;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;

@Entity
@Transactional
@Table(name="rekening")
@EntityListeners(AuditingEntityListener.class)
public class Rekening implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long idRekening;
	
	@CreatedDate
	@Column(name = "created_date", nullable = false, updatable = false)
	private Date createdDate = new Date();
	
	@Column(name = "deleted_date")
	private Date deletedDate = new Date();
	
	@LastModifiedDate
	@Column(name = "updated_date")
	private Date updatedDate = new Date();
	
	@Column(length = 50)
	private String jenis;
	
	@NotEmpty(message = "Nama is required")
	@Column(length = 50)
	private String nama;
	
	@NotEmpty(message = "Nomor is required")
	@Column(length = 16)
	private String nomor;
	
	@JsonBackReference
	@ManyToOne
	@JoinColumn(name = "karyawan_id", referencedColumnName = "id", insertable=true, updatable=false)
	private Karyawan karyawan;
	
	public Rekening() {
	}

	public Rekening(Long idRekening, Date createdDate, Date deletedDate, Date updatedDate, String jenis, String nama,
			String nomor, Karyawan karyawan) {
		super();
		this.idRekening = idRekening;
		this.createdDate = createdDate;
		this.deletedDate = deletedDate;
		this.updatedDate = updatedDate;
		this.jenis = jenis;
		this.nama = nama;
		this.nomor = nomor;
		this.karyawan = karyawan;
	}

	public Long getIdRekening() {
		return idRekening;
	}

	public void setIdRekening(Long idRekening) {
		this.idRekening = idRekening;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getDeletedDate() {
		return deletedDate;
	}

	public void setDeletedDate(Date deletedDate) {
		this.deletedDate = deletedDate;
	}

	public Date getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	public String getJenis() {
		return jenis;
	}

	public void setJenis(String jenis) {
		this.jenis = jenis;
	}

	public String getNama() {
		return nama;
	}

	public void setNama(String nama) {
		this.nama = nama;
	}

	public String getNomor() {
		return nomor;
	}

	public void setNomor(String nomor) {
		this.nomor = nomor;
	}

	public Karyawan getKaryawan() {
		return karyawan;
	}

	public void setKaryawan(Karyawan karyawan) {
		this.karyawan = karyawan;
	}

}
