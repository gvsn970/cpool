package com.nexiilabs.cpool.skillset;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="cpool_skill_set")
public class SkillSet {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	//@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "skillset_id")
	private Long id;
	@Column(name = "skillset_name")
	private String skillset_name;

	public SkillSet() {
		super();
	}

	public SkillSet(Long id, String skillset_name) {
		super();
		this.id = id;
		this.skillset_name = skillset_name;
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSkillset_name() {
		return skillset_name;
	}

	public void setSkillset_name(String skillset_name) {
		this.skillset_name = skillset_name;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("SkillSet [id=");
		builder.append(id);
		builder.append(", skillset_name=");
		builder.append(skillset_name);
		builder.append("]");
		return builder.toString();
	}
	

}
