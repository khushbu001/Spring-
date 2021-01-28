package com.alghanim.enaya.travelinsurance.plan.DTO;

import java.util.List;
import java.util.Set;

import org.mapstruct.Mapper;

import com.alghanim.enaya.travelinsurance.plan.model.Plan;
import com.google.common.annotations.Beta;


@Mapper(componentModel = "spring")
public interface PlanMapper {

	PlanDTO toPlanDTO(Plan plan);

	List<PlanDTO> toPlanDTOs(List<Plan> plans);

	Set<PlanDTO> toPlanDTOs(Set<Plan> plans);

	Plan toPlan(PlanDTO planDTO);

}
