package com.alghanim.enaya.travelinsurance.plan.features.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.alghanim.enaya.travelinsurance.plan.model.Plan;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @Description This is an entity class defines the feature and its attributes.
 */
@Entity
public class Feature {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long featureId;

	@NotBlank(message = "feature name should not be blank")
	@Column(unique = true)
	@Pattern(regexp = "^[a-zA-Z][a-zA-Z ]+[a-zA-Z]$")
	@Size(min = 5, max = 25)
	private String name;

	@NotBlank(message = "feature description should not be blank")
	@Pattern(regexp = "^[a-zA-Z][a-zA-Z0-9,.;!-: ]+[.?!]$")
	@Size(min = 20, max = 500)
	private String description;

	@NotNull
	@ManyToMany(mappedBy = "feature", fetch = FetchType.LAZY)
	@JsonIgnoreProperties("feature")
	private Set<Plan> plan = new HashSet<Plan>();

	public Feature() {
		super();
	}

	public Feature(Long featureId, @Size(min = 5, max = 50) String name, @Size(min = 20, max = 500) String description,
			Set<Plan> plan) {
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
		return "Feature [featureId=" + featureId + ", name=" + name + ", description=" + description + ", plan=" + plan
				+ "]";
	}

}