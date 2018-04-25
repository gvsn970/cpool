package com.nexiilabs.cpool.experience;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "cpool_experience")
public class Experience {

	public Experience() {
		
	}
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	//@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "experience_id", unique = true, nullable = false)
	private int consultant_id;
	@Column(name = "experience", length = 50)
	private String experience;
	
 
	public Experience(String experience) {
		super();
		this.experience = experience;
	}

	public int getConsultant_id() {
		return consultant_id;
	}

	public void setConsultant_id(int consultant_id) {
		this.consultant_id = consultant_id;
	}

	public String getExperience() {
		return experience;
	}

	public void setExperience(String experience) {
		this.experience = experience;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Experience [consultant_id=");
		builder.append(consultant_id);
		builder.append(", experience=");
		builder.append(experience);
		builder.append("]");
		return builder.toString();
	}


}
