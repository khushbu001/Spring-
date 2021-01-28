package com.alghanim.enaya.travelinsurance.plan.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import com.alghanim.enaya.travelinsurance.plan.features.model.Feature;
import com.alghanim.enaya.travelinsurance.plan.template.model.Template;
import com.alghanim.enaya.travelinsurance.plan.termsandcondition.model.TermsAndConditions;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author khushbu
 * @Description Plan is an entity class under plan management micro service.
 */
@Entity
public class Plan {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Plan_Id")
	private Long planId;

	@NotBlank
	@Column(unique = true)
	@Pattern(regexp = "^[a-zA-Z][a-zA-Z ]+[a-zA-Z]$")
	@Size(min = 5, max = 40)
	private String planName;

	@NotNull
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	@DateTimeFormat
	@Temporal(TemporalType.TIMESTAMP)
	private Date planStartDate;

	@NotNull
	@Temporal(TemporalType.TIMESTAMP)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	@DateTimeFormat
	private Date planEndDate;

	@NotBlank
	@Pattern(regexp = "^[a-zA-Z][a-zA-Z0-9,.;!-: ]+[.?!]$")
	@Size(min = 10, max = 500)
	private String planDescription;

	@NotBlank
	@Pattern(regexp = "^[A-Za-z0-9]+$")
	@Size(min = 2, max = 10)
	private String planVersion;

	@JsonProperty
	@Column(nullable = false, columnDefinition = "BOOLEAN")
	private Boolean planStatus = true;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "plan_feature", joinColumns = { @JoinColumn(name = "plan_id") }, inverseJoinColumns = {
			@JoinColumn })
	private Set<Feature> feature = new HashSet<>();

	@OneToOne
	@JoinColumn(name = "templateId", unique = true)
	private Template template;

	@OneToOne
	@JoinColumn(name = "termsId", unique = true)
	private TermsAndConditions terms;

	public Plan() {
		super();
	}

	public Plan(Long planId, @NotBlank @Size(min = 5, max = 40) String planName, @NotNull Date planStartDate,
			@NotNull Date planEndDate, @NotBlank @Size(min = 10, max = 500) String planDescription,
			@NotBlank @Size(min = 2, max = 10) String planVersion, Boolean planStatus, Set<Feature> feature,
			Template template, TermsAndConditions terms) {
		super();
		this.planId = planId;
		this.planName = planName;
		this.planStartDate = planStartDate;
		this.planEndDate = planEndDate;
		this.planDescription = planDescription;
		this.planVersion = planVersion;
		this.planStatus = planStatus;
		this.feature = feature;
		this.template = template;
		this.terms = terms;
	}

	public Long getPlanId() {
		return planId;
	}

	public void setPlanId(Long planId) {
		this.planId = planId;
	}

	public String getPlanName() {
		return planName;
	}

	public void setPlanName(String planName) {
		this.planName = planName;
	}

	public Date getPlanStartDate() {
		return planStartDate;
	}

	public void setPlanStartDate(Date planStartDate) {
		this.planStartDate = planStartDate;
	}

	public Date getPlanEndDate() {
		return planEndDate;
	}

	public void setPlanEndDate(Date planEndDate) {
		this.planEndDate = planEndDate;
	}

	public String getPlanDescription() {
		return planDescription;
	}

	public void setPlanDescription(String planDescription) {
		this.planDescription = planDescription;
	}

	public String getPlanVersion() {
		return planVersion;
	}

	public void setPlanVersion(String planVersion) {
		this.planVersion = planVersion;
	}

	public Template getTemplate() {
		return template;
	}

	public void setTemplate(Template template) {
		this.template = template;
	}

	public TermsAndConditions getTerms() {
		return terms;
	}

	public void setTerms(TermsAndConditions terms) {
		this.terms = terms;
	}

	public Boolean getPlanStatus() {
		return planStatus;
	}

	public Set<Feature> getFeature() {
		return feature;
	}

	public void setFeature(Set<Feature> feature) {
		this.feature = feature;
	}

	public void setPlanStatus(Boolean planStatus) {
		this.planStatus = planStatus;
	}

	@Override
	public String toString() {
		return "Plan [planId=" + planId + ", planName=" + planName + ", planStartDate=" + planStartDate
				+ ", planEndDate=" + planEndDate + ", planDescription=" + planDescription + ", planVersion="
				+ planVersion + ", planStatus=" + planStatus + ", features=" + feature + ", template=" + template
				+ ", terms=" + terms + ", feature=" + feature + "]";
	}

}
