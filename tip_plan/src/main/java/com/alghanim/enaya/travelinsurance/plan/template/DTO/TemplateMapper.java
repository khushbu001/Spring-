package com.alghanim.enaya.travelinsurance.plan.template.DTO;

import java.util.List;

import org.mapstruct.Mapper;

import com.alghanim.enaya.travelinsurance.plan.template.model.Template;

/**
 * @Description This class is to map between DTO class and Entity class.
 * @author khushbu
 *
 */
@Mapper(componentModel = "spring")
public interface TemplateMapper {
	TemplateDTO toTemplateDTO(Template template);

	List<TemplateDTO> toTemplateDTOs(List<Template> templates);

	Template toTemplate(TemplateDTO templateDTO);

	List<Template> toTemplates(List<TemplateDTO> templateDTO);

}
