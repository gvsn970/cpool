package com.nexiilabs.cpool.sourceofprofile;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="cpool_sourceof_profile")
public class SourceProfile {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	//@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "sourceof_profile_id")
	private Long id;
	@Column(name = "sourceof_profile")
	private String sourceofprofile;


	public SourceProfile(String sourceofprofile) {
		super();
		this.sourceofprofile = sourceofprofile;
	}



	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getSourceofprofile() {
		return sourceofprofile;
	}


	public void setSourceofprofile(String sourceofprofile) {
		this.sourceofprofile = sourceofprofile;
	}


	public SourceProfile() {
		super();
	}



	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("SourceProfile [id=");
		builder.append(id);
		builder.append(", sourceofprofile=");
		builder.append(sourceofprofile);
		builder.append("]");
		return builder.toString();
	}

	
}