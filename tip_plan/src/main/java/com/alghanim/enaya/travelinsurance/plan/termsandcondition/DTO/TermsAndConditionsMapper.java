package com.alghanim.enaya.travelinsurance.plan.termsandcondition.DTO;

import java.util.List;

import org.mapstruct.Mapper;

import com.alghanim.enaya.travelinsurance.plan.termsandcondition.model.TermsAndConditions;

@Mapper(componentModel = "spring")
public interface TermsAndConditionsMapper {

	TermsAndConditionsDTO toTermsAndConditionsDTO(TermsAndConditions termsAndConditions);

	List<TermsAndConditionsDTO> toTermsAndConditionsDTOs(List<TermsAndConditions> termsAndConditions);

	TermsAndConditions toTermsAndConditions(TermsAndConditionsDTO termsAndConditionsDTO);
}
