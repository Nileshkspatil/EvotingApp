package com.evotingapp.model;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name="candidate_info")
public class Candidate {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int cid;
	private String fullName;
	private String city;
	@Temporal(TemporalType.DATE)
	private Date dob;
	private int mob;
	private String email;
	private int vote;
	private boolean isVoted;
	private String candidatePhoto;
	private String symbol;
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public int getMob() {
		return mob;
	}
	public void setMob(int mob) {
		this.mob = mob;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getVote() {
		return vote;
	}
	public void setVote(int vote) {
		this.vote = vote;
	}
	public boolean isVoted() {
		return isVoted;
	}
	public void setVoted(boolean isVoted) {
		this.isVoted = isVoted;
	}
	public String getCandidatePhoto() {
		return candidatePhoto;
	}
	public void setCandidatePhoto(String candidatePhoto) {
		this.candidatePhoto = candidatePhoto;
	}
	public String getSymbol() {
		return symbol;
	}
	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}
	public Candidate(int cid, String fullName, String city, Date dob, int mob, String email, int vote, boolean isVoted,
			String candidatePhoto, String symbol) {
		super();
		this.cid = cid;
		this.fullName = fullName;
		this.city = city;
		this.dob = dob;
		this.mob = mob;
		this.email = email;
		this.vote = vote;
		this.isVoted = isVoted;
		this.candidatePhoto = candidatePhoto;
		this.symbol = symbol;
	}
	public Candidate() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	

}
