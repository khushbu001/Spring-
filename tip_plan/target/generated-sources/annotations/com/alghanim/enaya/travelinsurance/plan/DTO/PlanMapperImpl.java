package com.alghanim.enaya.travelinsurance.plan.DTO;

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
public class PlanMapperImpl implements PlanMapper {

    @Override
    public PlanDTO toPlanDTO(Plan plan) {
        if ( plan == null ) {
            return null;
        }

        PlanDTO planDTO = new PlanDTO();

        planDTO.setPlanId( plan.getPlanId() );
        planDTO.setPlanName( plan.getPlanName() );
        planDTO.setPlanStartDate( plan.getPlanStartDate() );
        planDTO.setPlanEndDate( plan.getPlanEndDate() );
        planDTO.setPlanDescription( plan.getPlanDescription() );
        planDTO.setPlanVersion( plan.getPlanVersion() );
        planDTO.setTemplate( plan.getTemplate() );
        planDTO.setTerms( plan.getTerms() );
        Set<Feature> set = plan.getFeature();
        if ( set != null ) {
            planDTO.setFeature( new HashSet<Feature>( set ) );
        }
        planDTO.setPlanStatus( plan.getPlanStatus() );

        return planDTO;
    }

    @Override
    public List<PlanDTO> toPlanDTOs(List<Plan> plans) {
        if ( plans == null ) {
            return null;
        }

        List<PlanDTO> list = new ArrayList<PlanDTO>( plans.size() );
        for ( Plan plan : plans ) {
            list.add( toPlanDTO( plan ) );
        }

        return list;
    }

    @Override
    public Set<PlanDTO> toPlanDTOs(Set<Plan> plans) {
        if ( plans == null ) {
            return null;
        }

        Set<PlanDTO> set = new HashSet<PlanDTO>( Math.max( (int) ( plans.size() / .75f ) + 1, 16 ) );
        for ( Plan plan : plans ) {
            set.add( toPlanDTO( plan ) );
        }

        return set;
    }

    @Override
    public Plan toPlan(PlanDTO planDTO) {
        if ( planDTO == null ) {
            return null;
        }

        Plan plan = new Plan();

        plan.setPlanId( planDTO.getPlanId() );
        plan.setPlanName( planDTO.getPlanName() );
        plan.setPlanStartDate( planDTO.getPlanStartDate() );
        plan.setPlanEndDate( planDTO.getPlanEndDate() );
        plan.setPlanDescription( planDTO.getPlanDescription() );
        plan.setPlanVersion( planDTO.getPlanVersion() );
        plan.setTemplate( planDTO.getTemplate() );
        plan.setTerms( planDTO.getTerms() );
        Set<Feature> set = planDTO.getFeature();
        if ( set != null ) {
            plan.setFeature( new HashSet<Feature>( set ) );
        }
        plan.setPlanStatus( planDTO.getPlanStatus() );

        return plan;
    }
}
