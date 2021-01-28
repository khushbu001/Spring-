package com.alghanim.enaya.travelinsurance.plan.termsandcondition.DTO;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
/**
 * @Description This class is use to interact between API and Service.
 * @author khushbu
 *
 */
@EnableSwagger2
@ApiModel(value = "TermsAndConditionsDTO", description = "This class will describe the property of the terms and conditons.")
public class TermsAndConditionsDTO {

	@ApiModelProperty(notes = "termsId defines unique terms id.")
	private Long termsId;

	@ApiModelProperty(notes = "name  will store the name of a terms and conditions.")
	private String name;

	@ApiModelProperty(notes = "format will store in which format the terms and conditions will store.")
	private String format;

	@ApiModelProperty(notes = "version will specify a specific version of a terms and conditions.")
	private String version;

	public TermsAndConditionsDTO(Long termsId, String name, String format, String version) {
		super();
		this.termsId = termsId;
		this.name = name;
		this.format = format;
		this.version = version;
	}

	public TermsAndConditionsDTO() {

	}

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

}