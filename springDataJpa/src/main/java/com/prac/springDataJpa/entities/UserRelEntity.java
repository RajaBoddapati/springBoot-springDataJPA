package com.prac.springDataJpa.entities;

import java.util.Objects;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotBlank;

@Entity
public class UserRelEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@NotBlank(message = "username should not be null")
	private String username;

	@NotBlank(message = "password should not be null")
	private String password;

	/*
	 * send request body in this format to map to this entity class 
	 * {
	 * "username":"User2", 
	 * "password":"user2pass", 
	 * "profileRel":{ 
	 *     "id":1  // this value of id should present in ProfileRelEntity database table
	 *  }
	 * 
	 */
    
	//@OneToOne
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "profile-id")
	private ProfileRelEntity profileRel;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public ProfileRelEntity getProfileRel() {
		return profileRel;
	}

	public void setProfileRel(ProfileRelEntity profileRel) {
		this.profileRel = profileRel;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, password, profileRel, username);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserRelEntity other = (UserRelEntity) obj;
		return Objects.equals(id, other.id) && Objects.equals(password, other.password)
				&& Objects.equals(profileRel, other.profileRel) && Objects.equals(username, other.username);
	}

	@Override
	public String toString() {
		return "UserRelEntity [id=" + id + ", username=" + username + ", password=" + password + ", profileRel="
				+ profileRel + "]";
	}

}
