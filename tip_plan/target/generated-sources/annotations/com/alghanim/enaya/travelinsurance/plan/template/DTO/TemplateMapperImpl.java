package com.alghanim.enaya.travelinsurance.plan.template.DTO;

import com.alghanim.enaya.travelinsurance.plan.template.model.Template;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    comments = "version: 1.3.0.Final, compiler: javac, environment: Java 11.0.4 (Ubuntu)"
)
@Component
public class TemplateMapperImpl implements TemplateMapper {

    @Override
    public TemplateDTO toTemplateDTO(Template template) {
        if ( template == null ) {
            return null;
        }

        TemplateDTO templateDTO = new TemplateDTO();

        templateDTO.setTemplateId( template.getTemplateId() );
        templateDTO.setTemplateName( template.getTemplateName() );
        templateDTO.setFormat( template.getFormat() );

        return templateDTO;
    }

    @Override
    public List<TemplateDTO> toTemplateDTOs(List<Template> templates) {
        if ( templates == null ) {
            return null;
        }

        List<TemplateDTO> list = new ArrayList<TemplateDTO>( templates.size() );
        for ( Template template : templates ) {
            list.add( toTemplateDTO( template ) );
        }

        return list;
    }

    @Override
    public Template toTemplate(TemplateDTO templateDTO) {
        if ( templateDTO == null ) {
            return null;
        }

        Template template = new Template();

        template.setTemplateId( templateDTO.getTemplateId() );
        template.setTemplateName( templateDTO.getTemplateName() );
        template.setFormat( templateDTO.getFormat() );

        return template;
    }

    @Override
    public List<Template> toTemplates(List<TemplateDTO> templateDTO) {
        if ( templateDTO == null ) {
            return null;
        }

        List<Template> list = new ArrayList<Template>( templateDTO.size() );
        for ( TemplateDTO templateDTO1 : templateDTO ) {
            list.add( toTemplate( templateDTO1 ) );
        }

        return list;
    }
}
