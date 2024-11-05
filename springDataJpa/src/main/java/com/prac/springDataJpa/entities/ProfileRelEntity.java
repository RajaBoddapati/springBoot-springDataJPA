package com.prac.springDataJpa.entities;

import java.util.Objects;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotBlank;

@Entity
public class ProfileRelEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotBlank(message="profileName should not be null")
	private String profileName;
	
	@NotBlank(message="description should not be null")
	private String description;
	
	/*
	 * send request body in this format to map to this entity class 
	 * {
        "profileName":"profileName1",
        "description":"prfileDesc"
       }

	 * */
	
	
	@OneToOne(mappedBy="profileRel",cascade = CascadeType.ALL)
	private UserRelEntity userRelEntity;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getProfileName() {
		return profileName;
	}

	public void setProfileName(String profileName) {
		this.profileName = profileName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public UserRelEntity getUserRelEntity() {
		return userRelEntity;
	}

	public void setUserRelEntity(UserRelEntity userRelEntity) {
		this.userRelEntity = userRelEntity;
	}

	@Override
	public int hashCode() {
		return Objects.hash(description, id, profileName, userRelEntity);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ProfileRelEntity other = (ProfileRelEntity) obj;
		return Objects.equals(description, other.description) && Objects.equals(id, other.id)
				&& Objects.equals(profileName, other.profileName) && Objects.equals(userRelEntity, other.userRelEntity);
	}

	@Override
	public String toString() {
		return "ProfileRelEntity [id=" + id + ", profileName=" + profileName + ", description=" + description
				+ ", userRelEntity=" + userRelEntity + "]";
	}
	
	
	
	

}
