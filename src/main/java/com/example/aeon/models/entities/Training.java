package com.example.aeon.models.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.transaction.annotation.Transactional;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;

@Entity
@Transactional
@Table(name = "training")
@EntityListeners(AuditingEntityListener.class)
public class Training implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long idTraining;
	
	@CreatedDate
	@Column(name = "created_date", nullable = false, updatable = false)
	private Date createdDate = new Date();
	
	@Column(name = "deleted_date")
	private Date deletedDate;
	
	@LastModifiedDate
	@Column(name = "updated_date")
	private Date updatedDate = new Date();
	
	@NotEmpty(message = "Nama pengajar is required")
	@Column(name = "nama_pengajar", length = 50)
	private String namaPengajar;
	
	@NotEmpty(message = "Tema is required")
	@Column(length = 100)
	private String tema;
	
	@OneToMany(mappedBy = "training")
	private List<KaryawanTraining> karyawanTraining;
	
	public Training() {
	}

	public Training(Long idTraining, Date createdDate, Date deletedDate, Date updatedDate, String namaPengajar,
			String tema, List<KaryawanTraining> karyawanTraining) {
		super();
		this.idTraining = idTraining;
		this.createdDate = createdDate;
		this.deletedDate = deletedDate;
		this.updatedDate = updatedDate;
		this.namaPengajar = namaPengajar;
		this.tema = tema;
		this.karyawanTraining = karyawanTraining;
	}

	public Long getIdTraining() {
		return idTraining;
	}

	public void setIdTraining(Long idTraining) {
		this.idTraining = idTraining;
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

	public String getNamaPengajar() {
		return namaPengajar;
	}

	public void setNamaPengajar(String namaPengajar) {
		this.namaPengajar = namaPengajar;
	}

	public String getTema() {
		return tema;
	}

	public void setTema(String tema) {
		this.tema = tema;
	}

	public List<KaryawanTraining> getKaryawanTraining() {
		return karyawanTraining;
	}

	public void setKaryawanTraining(List<KaryawanTraining> karyawanTraining) {
		this.karyawanTraining = karyawanTraining;
	}
	
}
