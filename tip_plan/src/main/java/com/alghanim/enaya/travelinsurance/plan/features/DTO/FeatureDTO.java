package com.alghanim.enaya.travelinsurance.plan.features.DTO;

import java.util.HashSet;
import java.util.Set;

import com.alghanim.enaya.travelinsurance.plan.model.Plan;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
@EnableSwagger2
@ApiModel(value = "Feature", description = "This class is used to specify the Feature Property.")
public class FeatureDTO {

	@ApiModelProperty(notes = "unique feature id")
	private Long featureId;

	@ApiModelProperty(notes = " feature name will define name of the feature. ")
	private String name;

	@ApiModelProperty(notes = "feature description will describe the feature. ")
	private String description;

	@ApiModelProperty(notes = "plan will use to bind feature with plan.")
	private Set<Plan> plan = new HashSet<>();

	public FeatureDTO() {
		super();
	}

	public FeatureDTO(Long featureId, String name, String description, Set<Plan> plan) {
		super();
		this.featureId = featureId;
		this.name = name;
		this.description = description;
		this.plan = plan;
	}

	public Long getFeatureId() {
		return featureId;
	}

	public void setFeatureId(Long featureId) {
		this.featureId = featureId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Set<Plan> getPlan() {
		return plan;
	}

	public void setPlan(Set<Plan> plan) {
		this.plan = plan;
	}

	@Override
	public String toString() {
		return "FeatureDTO [featureId=" + featureId + ", name=" + name + ", description=" + description + ", plan="
				+ plan + "]";
	}

}