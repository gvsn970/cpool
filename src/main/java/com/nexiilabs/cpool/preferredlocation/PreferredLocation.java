package com.nexiilabs.cpool.preferredlocation;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "cpool_preffered_location")
public class PreferredLocation {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	//@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "prefered_location_id")
	private Long id;

	@Column(name = "preferedlocation_name")
	private String preferedlocation_name;

	public Long getId() {
		return id;
	}

	public PreferredLocation() {
		super();
	}

	public PreferredLocation(Long id, String preferedlocation_name) {
		super();
		this.id = id;
		this.preferedlocation_name = preferedlocation_name;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPreferedlocation_name() {
		return preferedlocation_name;
	}

	public void setPreferedlocation_name(String preferedlocation_name) {
		this.preferedlocation_name = preferedlocation_name;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("PreferredLocation [id=");
		builder.append(id);
		builder.append(", preferedlocation_name=");
		builder.append(preferedlocation_name);
		builder.append("]");
		return builder.toString();
	}
	

}
