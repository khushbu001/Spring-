package com.alghanim.enaya.travelinsurance.plan.termsandcondition.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 * @author Khushbu
 * @Description This class will specify all the property of a terms and
 *              conditions.
 */
@Entity
public class TermsAndConditions {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long termsId;

	@NotBlank
	@Column(unique = true)
	@Pattern(regexp = "^[a-zA-Z][a-zA-Z ]+[a-zA-Z]$")
	@Size(min = 5, max = 40)
	String name;

	@NotBlank
	@Pattern(regexp = "^\\.[A-Za-z]+$")
	@Size(min = 2, max = 10)
	private String format;

	@NotBlank
	@Pattern(regexp = "^[A-Za-z0-9]+$")
	@Size(min = 2, max = 10)
	private String version;

	public Long getTermsId() {
		return termsId;
	}

	public void setTermsId(Long termsId) {
		this.termsId = termsId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFormat() {
		return format;
	}

	public void setFormat(String format) {
		this.format = format;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	@Override
	public String toString() {
		return "TermsAndConditions [termsId=" + termsId + ", name=" + name + ", format=" + format + ", version="
				+ version + "]";
	}
}