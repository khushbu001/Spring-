package com.alghanim.enaya.travelinsurance.plan.template.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 * @Description Template is mainly an entity class which mainly defines the
 *              property of a template.
 */
@Entity
public class Template {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long templateId;

	@NotBlank
	@Column(unique = true)
	@Pattern(regexp = "^[a-zA-Z][a-zA-Z ]+[a-zA-Z0-9]$")
	@Size(min = 5, max = 40)
	private String templateName;

	@NotBlank
	@Pattern(regexp = "^\\.[A-Za-z]+$")
	@Size(min = 4, max = 10)
	private String format;

	public Template() {
		super();

	}

	public Template(Long templateId, @NotBlank @Size(min = 10, max = 20) String templateName,
			@NotBlank @Size(min = 2, max = 10) String format) {
		super();
		this.templateId = templateId;
		this.templateName = templateName;
		this.format = format;
	}

	public Long getTemplateId() {
		return templateId;
	}

	public void setTemplateId(Long templateId) {
		this.templateId = templateId;
	}

	public String getTemplateName() {
		return templateName;
	}

	public void setTemplateName(String templateName) {
		this.templateName = templateName;
	}

	public String getFormat() {
		return format;
	}

	public void setFormat(String format) {
		this.format = format;
	}

	@Override
	public String toString() {
		return "Template [templateId=" + templateId + ", templateName=" + templateName + ", format=" + format + "]";
	}

}