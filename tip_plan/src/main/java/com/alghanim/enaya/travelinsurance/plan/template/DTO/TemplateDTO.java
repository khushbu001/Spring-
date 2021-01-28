package com.alghanim.enaya.travelinsurance.plan.template.DTO;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @Description This class is mainly use to interact between Service and API.
 * @author khushbu
 *
 */
@EnableSwagger2
@ApiModel(value = "Template", description = "Template is a pojo class under plan management")
public class TemplateDTO {

	@ApiModelProperty(notes = "templateId will define a unique template id.")
	private Long templateId;

	@ApiModelProperty(notes = "templateName will define a unique template name.")
	private String templateName;

	@ApiModelProperty(notes = "format will define a format of a template.")
	private String format;

	public TemplateDTO() {
		super();
	}

	public TemplateDTO(Long templateId, String templateName, String format) {
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

}