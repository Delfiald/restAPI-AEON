package com.example.aeon.models.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;

@Entity
@Transactional
@Table(name = "karyawan_training")
@EntityListeners(AuditingEntityListener.class)
public class KaryawanTraining implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long idKaryawanTraining;
	
	@CreatedDate
	@Column(name = "created_date", nullable = false, updatable = false)
	private Date createdDate = new Date();
	
	@Column(name = "deleted_date")
	private Date deletedDate;
	
	@LastModifiedDate
	@Column(name = "updated_date")
	private Date updatedDate = new Date();
	
	@Column(name = "tanggal_training")
	private Date tanggalTraining = new Date();
	
	@ManyToOne
	@JoinColumn(name = "karyawan_id", referencedColumnName = "id")
	private Karyawan karyawan;
	
	@ManyToOne
	@JoinColumn(name = "training_id", referencedColumnName = "id")
	private Training training;
	
	public KaryawanTraining() {
	}

	public KaryawanTraining(Long idKaryawanTraining, Date createdDate, Date deletedDate, Date updatedDate,
			Date tanggalTraining, Karyawan karyawan, Training training) {
		super();
		this.idKaryawanTraining = idKaryawanTraining;
		this.createdDate = createdDate;
		this.deletedDate = deletedDate;
		this.updatedDate = updatedDate;
		this.tanggalTraining = tanggalTraining;
		this.karyawan = karyawan;
		this.training = training;
	}

	public Long getIdKaryawanTraining() {
		return idKaryawanTraining;
	}

	public void setIdKaryawanTraining(Long idKaryawanTraining) {
		this.idKaryawanTraining = idKaryawanTraining;
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

	public Date getTanggalTraining() {
		return tanggalTraining;
	}

	public void setTanggalTraining(Date tanggalTraining) {
		this.tanggalTraining = tanggalTraining;
	}

	public Karyawan getKaryawan() {
		return karyawan;
	}

	public void setKaryawan(Karyawan karyawan) {
		this.karyawan = karyawan;
	}

	public Training getTraining() {
		return training;
	}

	public void setTraining(Training training) {
		this.training = training;
	}
	
}
