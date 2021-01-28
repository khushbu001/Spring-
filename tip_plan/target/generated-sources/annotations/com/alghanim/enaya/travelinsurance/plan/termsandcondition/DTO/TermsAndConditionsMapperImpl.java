package com.alghanim.enaya.travelinsurance.plan.termsandcondition.DTO;

import com.alghanim.enaya.travelinsurance.plan.termsandcondition.model.TermsAndConditions;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    comments = "version: 1.3.0.Final, compiler: javac, environment: Java 11.0.4 (Ubuntu)"
)
@Component
public class TermsAndConditionsMapperImpl implements TermsAndConditionsMapper {

    @Override
    public TermsAndConditionsDTO toTermsAndConditionsDTO(TermsAndConditions termsAndConditions) {
        if ( termsAndConditions == null ) {
            return null;
        }

        TermsAndConditionsDTO termsAndConditionsDTO = new TermsAndConditionsDTO();

        termsAndConditionsDTO.setTermsId( termsAndConditions.getTermsId() );
        termsAndConditionsDTO.setName( termsAndConditions.getName() );
        termsAndConditionsDTO.setFormat( termsAndConditions.getFormat() );
        termsAndConditionsDTO.setVersion( termsAndConditions.getVersion() );

        return termsAndConditionsDTO;
    }

    @Override
    public List<TermsAndConditionsDTO> toTermsAndConditionsDTOs(List<TermsAndConditions> termsAndConditions) {
        if ( termsAndConditions == null ) {
            return null;
        }

        List<TermsAndConditionsDTO> list = new ArrayList<TermsAndConditionsDTO>( termsAndConditions.size() );
        for ( TermsAndConditions termsAndConditions1 : termsAndConditions ) {
            list.add( toTermsAndConditionsDTO( termsAndConditions1 ) );
        }

        return list;
    }

    @Override
    public TermsAndConditions toTermsAndConditions(TermsAndConditionsDTO termsAndConditionsDTO) {
        if ( termsAndConditionsDTO == null ) {
            return null;
        }

        TermsAndConditions termsAndConditions = new TermsAndConditions();

        termsAndConditions.setTermsId( termsAndConditionsDTO.getTermsId() );
        termsAndConditions.setName( termsAndConditionsDTO.getName() );
        termsAndConditions.setFormat( termsAndConditionsDTO.getFormat() );
        termsAndConditions.setVersion( termsAndConditionsDTO.getVersion() );

        return termsAndConditions;
    }
}
