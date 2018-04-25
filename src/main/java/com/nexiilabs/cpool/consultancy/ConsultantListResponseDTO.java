package com.nexiilabs.cpool.consultancy;

public class ConsultantListResponseDTO {

	private int consultant_id;
	private String mobile;
	private String email;
	private String name;
	private String fname;
	private String lname;
	private String skillset_name;
	private String experience;
	private String education;
	private String previous_organization;
	private String current_organization;
	private String current_designation;
	private String current_location;
	private String preferedlocation_name;
	private double current_ctc;
	private int notice_period;
	private String days;
	private String sourceofprofile;
	public int getConsultant_id() {
		return consultant_id;
	}
	public void setConsultant_id(int consultant_id) {
		this.consultant_id = consultant_id;
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
	public String getSkillset_name() {
		return skillset_name;
	}
	public void setSkillset_name(String skillset_name) {
		this.skillset_name = skillset_name;
	}
	public String getExperience() {
		return experience;
	}
	public void setExperience(String experience) {
		this.experience = experience;
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
	public String getCurrent_designation() {
		return current_designation;
	}
	public void setCurrent_designation(String current_designation) {
		this.current_designation = current_designation;
	}
	public String getCurrent_location() {
		return current_location;
	}
	public void setCurrent_location(String current_location) {
		this.current_location = current_location;
	}
	public String getPreferedlocation_name() {
		return preferedlocation_name;
	}
	public void setPreferedlocation_name(String preferedlocation_name) {
		this.preferedlocation_name = preferedlocation_name;
	}
	public double getCurrent_ctc() {
		return current_ctc;
	}
	public void setCurrent_ctc(double current_ctc) {
		this.current_ctc = current_ctc;
	}
	public int getNotice_period() {
		return notice_period;
	}
	public void setNotice_period(int notice_period) {
		this.notice_period = notice_period;
	}
	public String getDays() {
		return days;
	}
	public void setDays(String days) {
		this.days = days;
	}
	public String getSourceofprofile() {
		return sourceofprofile;
	}
	public void setSourceofprofile(String sourceofprofile) {
		this.sourceofprofile = sourceofprofile;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ConsultantListResponseDTO [consultant_id=");
		builder.append(consultant_id);
		builder.append(", mobile=");
		builder.append(mobile);
		builder.append(", email=");
		builder.append(email);
		builder.append(", name=");
		builder.append(name);
		builder.append(", fname=");
		builder.append(fname);
		builder.append(", lname=");
		builder.append(lname);
		builder.append(", skillset_name=");
		builder.append(skillset_name);
		builder.append(", experience=");
		builder.append(experience);
		builder.append(", education=");
		builder.append(education);
		builder.append(", previous_organization=");
		builder.append(previous_organization);
		builder.append(", current_organization=");
		builder.append(current_organization);
		builder.append(", current_designation=");
		builder.append(current_designation);
		builder.append(", current_location=");
		builder.append(current_location);
		builder.append(", preferedlocation_name=");
		builder.append(preferedlocation_name);
		builder.append(", current_ctc=");
		builder.append(current_ctc);
		builder.append(", notice_period=");
		builder.append(notice_period);
		builder.append(", days=");
		builder.append(days);
		builder.append(", sourceofprofile=");
		builder.append(sourceofprofile);
		builder.append("]");
		return builder.toString();
	}
	

}
