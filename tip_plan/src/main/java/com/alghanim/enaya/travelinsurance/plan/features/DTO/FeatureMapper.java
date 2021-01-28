package com.alghanim.enaya.travelinsurance.plan.features.DTO;

import java.util.List;

import org.mapstruct.Mapper;

import com.alghanim.enaya.travelinsurance.plan.features.model.Feature;

@Mapper(componentModel = "spring")
public interface FeatureMapper {

	FeatureDTO toFeatureDTO(Feature feature);

	List<FeatureDTO> toFeatureDTOs(List<Feature> features);

	Feature toFeature(FeatureDTO featureDTO);

}
