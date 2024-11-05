package com.prac.springDataJpa.entities;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class User {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private int uid;
	private String username;
	private String password;
	private String reenteredPassword;
	
	@Enumerated(EnumType.STRING)
	private Status status;

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
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

	public String getReenteredPassword() {
		return reenteredPassword;
	}

	public void setReenteredPassword(String reenteredPassword) {
		this.reenteredPassword = reenteredPassword;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	@Override
	public int hashCode() {
		return Objects.hash(password, reenteredPassword, status, uid, username);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(password, other.password) && Objects.equals(reenteredPassword, other.reenteredPassword)
				&& status == other.status && uid == other.uid && Objects.equals(username, other.username);
	}

	@Override
	public String toString() {
		return "User [uid=" + uid + ", username=" + username + ", password=" + password + ", reenteredPassword="
				+ reenteredPassword + ", status=" + status + "]";
	}

	
	

}

enum Status{
	ACTIVE,INACTIVE,PENDING
}
