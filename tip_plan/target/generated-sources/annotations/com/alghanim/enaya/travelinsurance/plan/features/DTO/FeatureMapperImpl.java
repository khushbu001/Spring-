package com.alghanim.enaya.travelinsurance.plan.features.DTO;

import com.alghanim.enaya.travelinsurance.plan.features.model.Feature;
import com.alghanim.enaya.travelinsurance.plan.model.Plan;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    comments = "version: 1.3.0.Final, compiler: javac, environment: Java 11.0.4 (Ubuntu)"
)
@Component
public class FeatureMapperImpl implements FeatureMapper {

    @Override
    public FeatureDTO toFeatureDTO(Feature feature) {
        if ( feature == null ) {
            return null;
        }

        FeatureDTO featureDTO = new FeatureDTO();

        featureDTO.setFeatureId( feature.getFeatureId() );
        featureDTO.setName( feature.getName() );
        featureDTO.setDescription( feature.getDescription() );
        Set<Plan> set = feature.getPlan();
        if ( set != null ) {
            featureDTO.setPlan( new HashSet<Plan>( set ) );
        }

        return featureDTO;
    }

    @Override
    public List<FeatureDTO> toFeatureDTOs(List<Feature> features) {
        if ( features == null ) {
            return null;
        }

        List<FeatureDTO> list = new ArrayList<FeatureDTO>( features.size() );
        for ( Feature feature : features ) {
            list.add( toFeatureDTO( feature ) );
        }

        return list;
    }

    @Override
    public Feature toFeature(FeatureDTO featureDTO) {
        if ( featureDTO == null ) {
            return null;
        }

        Feature feature = new Feature();

        feature.setFeatureId( featureDTO.getFeatureId() );
        feature.setName( featureDTO.getName() );
        feature.setDescription( featureDTO.getDescription() );
        Set<Plan> set = featureDTO.getPlan();
        if ( set != null ) {
            feature.setPlan( new HashSet<Plan>( set ) );
        }

        return feature;
    }
}
