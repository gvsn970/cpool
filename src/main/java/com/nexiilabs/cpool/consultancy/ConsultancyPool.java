package com.nexiilabs.cpool.consultancy;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "cpool_consultant")
public class ConsultancyPool {

	public ConsultancyPool() {

	}

	@Id
	// @GeneratedValue(strategy = GenerationType.AUTO)
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	@Column(name = "consultant_id", unique = true, nullable = false)
	private int consultant_id;

	

	@Column(name = "name", length = 50)
	private String name;
	@Column(name = "fname", length = 50)
	private String fname;
	@Column(name = "lname", length = 50)
	private String lname;

	@Column(name = "mobile")
	private String mobile;

	@Column(name = "email")
	private String email;

	@Column(name = "education")
	private String education;

	@Column(name = "previous_organization")
	private String previous_organization;

	@Column(name = "current_organization")
	private String current_organization;

	@Column(name = "fk_currentlocation_id")
	private String fk_currentlocation_id;

	@Column(name = "current_designation")
	private String current_designation;

	@Column(name = "current_ctc")
	private double current_ctc;

	@Column(name = "fk_sourceof_profile_id")
	private String fk_sourceof_profile_id;

	@Column(name = "notice_period")
	private int notice_period;

	@Column(name = "fk_skillset_id")
	private String fk_skillset_id;

	@Column(name = "fk_prefered_location_id")
	private String fk_prefered_location_id;

	@Column(name = "fk_experience_id")
	private String fk_experience_id;

	@Column(name = "delete_status")
	private int delete_status;

	@Column(name = "updated_on")
	private String updated_on;

	@Transient
	@Column(name = "created_on")
	private String created_on;

	@Column(name = "deleted_on")
	private String deleted_on;

	public int getConsultant_id() {
		return consultant_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEducation() {
		return education;
	}

	public void setEducation(String education) {
		this.education = education;
	}

	public String getPrevious_organization() {
		return previous_organization;
	}

	public void setPrevious_organization(String previous_organization) {
		this.previous_organization = previous_organization;
	}

	public String getCurrent_organization() {
		return current_organization;
	}

	public void setCurrent_organization(String current_organization) {
		this.current_organization = current_organization;
	}

	public String getFk_currentlocation_id() {
		return fk_currentlocation_id;
	}

	public void setFk_currentlocation_id(String fk_currentlocation_id) {
		this.fk_currentlocation_id = fk_currentlocation_id;
	}

	public String getCurrent_designation() {
		return current_designation;
	}

	public void setCurrent_designation(String current_designation) {
		this.current_designation = current_designation;
	}

	public double getCurrent_ctc() {
		return current_ctc;
	}

	public void setCurrent_ctc(double current_ctc) {
		this.current_ctc = current_ctc;
	}

	public String getFk_sourceof_profile_id() {
		return fk_sourceof_profile_id;
	}

	public void setFk_sourceof_profile_id(String fk_sourceof_profile_id) {
		this.fk_sourceof_profile_id = fk_sourceof_profile_id;
	}

	public int getNotice_period() {
		return notice_period;
	}

	public void setNotice_period(int notice_period) {
		this.notice_period = notice_period;
	}

	public String getFk_skillset_id() {
		return fk_skillset_id;
	}

	public void setFk_skillset_id(String fk_skillset_id) {
		this.fk_skillset_id = fk_skillset_id;
	}

	public String getFk_prefered_location_id() {
		return fk_prefered_location_id;
	}

	public void setFk_prefered_location_id(String fk_prefered_location_id) {
		this.fk_prefered_location_id = fk_prefered_location_id;
	}

	public String getFk_experience_id() {
		return fk_experience_id;
	}

	public void setFk_experience_id(String fk_experience_id) {
		this.fk_experience_id = fk_experience_id;
	}

	public int getDelete_status() {
		return delete_status;
	}

	public void setDelete_status(int delete_status) {
		this.delete_status = delete_status;
	}

	public String getUpdated_on() {
		return updated_on;
	}

	public void setUpdated_on(String updated_on) {
		this.updated_on = updated_on;
	}

	public String getCreated_on() {
		return created_on;
	}

	public void setCreated_on(String created_on) {
		this.created_on = created_on;
	}

	public String getDeleted_on() {
		return deleted_on;
	}

	public void setDeleted_on(String deleted_on) {
		this.deleted_on = deleted_on;
	}

	public void setConsultant_id(int consultant_id) {
		this.consultant_id = consultant_id;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ConsultancyPool [consultant_id=");
		builder.append(consultant_id);
		builder.append(", name=");
		builder.append(name);
		builder.append(", fname=");
		builder.append(fname);
		builder.append(", lname=");
		builder.append(lname);
		builder.append(", mobile=");
		builder.append(mobile);
		builder.append(", email=");
		builder.append(email);
		builder.append(", education=");
		builder.append(education);
		builder.append(", previous_organization=");
		builder.append(previous_organization);
		builder.append(", current_organization=");
		builder.append(current_organization);
		builder.append(", fk_currentlocation_id=");
		builder.append(fk_currentlocation_id);
		builder.append(", current_designation=");
		builder.append(current_designation);
		builder.append(", current_ctc=");
		builder.append(current_ctc);
		builder.append(", fk_sourceof_profile_id=");
		builder.append(fk_sourceof_profile_id);
		builder.append(", notice_period=");
		builder.append(notice_period);
		builder.append(", fk_skillset_id=");
		builder.append(fk_skillset_id);
		builder.append(", fk_prefered_location_id=");
		builder.append(fk_prefered_location_id);
		builder.append(", fk_experience_id=");
		builder.append(fk_experience_id);
		builder.append(", delete_status=");
		builder.append(delete_status);
		builder.append(", updated_on=");
		builder.append(updated_on);
		builder.append(", created_on=");
		builder.append(created_on);
		builder.append(", deleted_on=");
		builder.append(deleted_on);
		builder.append("]");
		return builder.toString();
	}

	public ConsultancyPool(String name, String fname, String lname, String mobile, String email, String education,
			String previous_organization, String current_organization, String fk_currentlocation_id,
			String current_designation, double current_ctc, String fk_sourceof_profile_id, int notice_period,
			String fk_skillset_id, String fk_prefered_location_id, String fk_experience_id, int delete_status,
			String updated_on, String created_on, String deleted_on) {
		super();
		this.name = name;
		this.fname = fname;
		this.lname = lname;
		this.mobile = mobile;
		this.email = email;
		this.education = education;
		this.previous_organization = previous_organization;
		this.current_organization = current_organization;
		this.fk_currentlocation_id = fk_currentlocation_id;
		this.current_designation = current_designation;
		this.current_ctc = current_ctc;
		this.fk_sourceof_profile_id = fk_sourceof_profile_id;
		this.notice_period = notice_period;
		this.fk_skillset_id = fk_skillset_id;
		this.fk_prefered_location_id = fk_prefered_location_id;
		this.fk_experience_id = fk_experience_id;
		this.delete_status = delete_status;
		this.updated_on = updated_on;
		this.created_on = created_on;
		this.deleted_on = deleted_on;
	}

	

}