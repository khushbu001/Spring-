package com.alghanim.enaya.travelinsurance.plan.features.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alghanim.enaya.travelinsurance.plan.exceptions.CustomExceptions;
import com.alghanim.enaya.travelinsurance.plan.features.DTO.FeatureDTO;
import com.alghanim.enaya.travelinsurance.plan.features.DTO.FeatureMapper;
import com.alghanim.enaya.travelinsurance.plan.features.exceptions.FeatureNotFoundException;
import com.alghanim.enaya.travelinsurance.plan.features.model.Feature;
import com.alghanim.enaya.travelinsurance.plan.features.repo.FeatureRepo;

/**
 * @Description This is a feature implementation class.
 * @author khushbu
 */
@Service
public class FeatureImpl {

	private static final Logger LOG = LoggerFactory.getLogger(FeatureImpl.class);

	@Autowired
	private FeatureRepo featureRepo;

	@Autowired
	private FeatureMapper featureMapper;

	@Autowired
	private FeatureNotFoundException featureNotFoundException;

	/**
	 * This API is used to create the feature.
	 * 
	 * @param feature It will store data of the feature
	 * @throws CustomExceptions
	 */
	public FeatureDTO createFeature(FeatureDTO featureDTO) throws CustomExceptions {

		LOG.debug("FeatureImpl::createFeature::Start");

		Feature feature = featureMapper.toFeature(featureDTO);

		featureNotFoundException.validateFeature(feature);
		Feature featureData = featureRepo.save(feature);
		FeatureDTO features = featureMapper.toFeatureDTO(featureData);

		LOG.debug("FeatureImpl::createFeature::End");

		return features;

	}

	/**
	 * This method will use to update the Feature.
	 * 
	 * @param featureId feature
	 * @throws CustomExceptions
	 */
	public FeatureDTO updateFeature(Long featureId, FeatureDTO featureDTO) throws CustomExceptions {

		LOG.debug("FeatureImpl::updateFeature::Start");

		featureDTO.setFeatureId(featureId);

		Feature updateFeature = featureRepo.getOne(featureDTO.getFeatureId());

		featureNotFoundException.validateFeature(updateFeature);
		updateFeature.setName(featureDTO.getName());
		updateFeature.setDescription(featureDTO.getDescription());

		Feature featureUpdateData = featureRepo.save(updateFeature);
		FeatureDTO features = featureMapper.toFeatureDTO(featureUpdateData);

		LOG.debug("FeatureImpl::updateFeature::End");
		return features;
	}

	/**
	 * This method is used to delete a feature.
	 * 
	 * @param featureId
	 * @throws CustomExceptions
	 */
	public void deleteFeatureById(Long featureId) throws CustomExceptions {
		LOG.debug("FeatureImpl::deleteFeatureById::Start");

		featureNotFoundException.validateId(featureId);

		Set<Feature> fId = new HashSet<>();

		((Feature) fId).setFeatureId(featureId);

		List<Object> featureList = Arrays.asList(fId.toArray());
		Set<Feature> featureObj = (Set<Feature>) featureList.get(0);

		Optional<Feature> feature = featureRepo.findById(featureId);
//		Feature f = feature.get();
		
		if (feature.isPresent()) {

			if (featureId > 20) {
				featureRepo.deleteById(featureId);
			} else {
				LOG.info("This term id cannot be deleted it is maped with a plan");
			}
		}

		LOG.debug("FeatureImpl::deleteFeatureById::End");

	}

	/**
	 * This method will us to get one feature.
	 * 
	 * @param featureId
	 * @throws CustomExceptions
	 */
	public FeatureDTO getOneFeature(Long featureId) throws CustomExceptions {

		LOG.debug("FeatureImpl::getOneFeature::Start");

		featureNotFoundException.validateId(featureId);
		Optional<Feature> feature = featureRepo.findById(featureId);
		FeatureDTO featureDTO = null;
		if(feature.isPresent()) {
		featureDTO = featureMapper.toFeatureDTO(feature.get());
		}
		

		LOG.debug("FeatureImpl::getOneFeature::End");
		
		return featureDTO;
	}

	/**
	 * This method will use to get all the Feature.
	 */
	public List<FeatureDTO> getAllFeature() {
		LOG.debug("FeatureImpl::getAllFeature::Start");

		List<Feature> allFeatures = new ArrayList<Feature>();
		featureRepo.findAll().forEach(s -> allFeatures.add(s));
		List<FeatureDTO> featureDTO = featureMapper.toFeatureDTOs(allFeatures);

		LOG.debug("FeatureImpl::getAllFeature::End");

		return featureDTO;

	}
}