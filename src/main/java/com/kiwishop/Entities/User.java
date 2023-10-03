package com.kiwishop.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "nguoi_dung")
public class User{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String email;

	private String password;

	private String hoTen;
	private String soDienThoai;
	private String diaChi;
	
	private String role;

		
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}


	public User(long id, String email, String password, String hoTen, String soDienThoai, String diaChi,
			String role) {
		super();
		this.id = id;
		this.email = email;
		this.password = password;
		this.hoTen = hoTen;
		this.soDienThoai = soDienThoai;
		this.diaChi = diaChi;
		this.role = role;
	}


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getHoTen() {
		return hoTen;
	}


	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}


	public String getSoDienThoai() {
		return soDienThoai;
	}


	public void setSoDienThoai(String soDienThoai) {
		this.soDienThoai = soDienThoai;
	}


	public String getDiaChi() {
		return diaChi;
	}


	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}


	public String getRole() {
		return role;
	}


	public void setRole(String role) {
		this.role = role;
	}
	


}
