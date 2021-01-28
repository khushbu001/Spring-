package com.alghanim.enaya.travelinsurance.plan.DTO;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.alghanim.enaya.travelinsurance.plan.features.model.Feature;
import com.alghanim.enaya.travelinsurance.plan.template.model.Template;
import com.alghanim.enaya.travelinsurance.plan.termsandcondition.model.TermsAndConditions;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author khushbu
 *
 */
@EnableSwagger2
@ApiModel(value = "Plan", description = "Plan is a pojo class under plan management")
public class PlanDTO {

	@ApiModelProperty(notes = "unique plan id")
	private Long planId;

	@ApiModelProperty(notes = "plan name")
	private String planName;

	@ApiModelProperty(notes = "plan start date will defines from what date the plan is active ")
	private Date planStartDate;

	@ApiModelProperty(notes = "plan end date will define till what date the plan will active. ")
	private Date planEndDate;

	@ApiModelProperty(notes = "planDescription defines about the plan in detail.")
	private String planDescription;

	@ApiModelProperty(notes = "plan version specifies version sepecific knowledge.")
	private String planVersion;

	@ApiModelProperty(notes = "planStatus defines the active/inactive status of plan.")
	private Boolean planStatus = true;

	@ApiModelProperty(notes = "This property is mainly use to bind with the features.")
	private Set<Feature> feature = new HashSet<>();

	@ApiModelProperty(notes = "This property is mainly use to bind with the template.")
	private Template template;

	@ApiModelProperty(notes = "This property is mainly use to bind with the terms.")
	private TermsAndConditions terms;

	public PlanDTO() {
		super();
	}

	public PlanDTO(Long planId, String planName, Date planStartDate, Date planEndDate, String planDescription,
			String planVersion, Boolean planStatus, Set<Feature> feature, Template template, TermsAndConditions terms) {
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