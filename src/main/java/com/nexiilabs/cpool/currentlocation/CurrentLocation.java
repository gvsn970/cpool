package com.nexiilabs.cpool.currentlocation;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="cpool_current_location")
public class CurrentLocation {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "currentlocation_id")
	private Long id;
	@Column(name = "currentlocation_name")
	private String currentlocation_name;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCurrentlocation_name() {
		return currentlocation_name;
	}
	public void setCurrentlocation_name(String currentlocation_name) {
		this.currentlocation_name = currentlocation_name;
	}
	public CurrentLocation(Long id, String currentlocation_name) {
		super();
		this.id = id;
		this.currentlocation_name = currentlocation_name;
	}
	public CurrentLocation() {
		super();
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("CurrentLocation [id=");
		builder.append(id);
		builder.append(", currentlocation_name=");
		builder.append(currentlocation_name);
		builder.append("]");
		return builder.toString();
	}
	

}
