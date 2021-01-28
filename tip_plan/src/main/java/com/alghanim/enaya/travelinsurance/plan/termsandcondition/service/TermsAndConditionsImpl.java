package com.alghanim.enaya.travelinsurance.plan.termsandcondition.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alghanim.enaya.travelinsurance.plan.exceptions.CustomExceptions;
import com.alghanim.enaya.travelinsurance.plan.termsandcondition.DTO.TermsAndConditionsDTO;
import com.alghanim.enaya.travelinsurance.plan.termsandcondition.DTO.TermsAndConditionsMapper;
import com.alghanim.enaya.travelinsurance.plan.termsandcondition.exceptions.TermsNotFoundException;
import com.alghanim.enaya.travelinsurance.plan.termsandcondition.model.TermsAndConditions;
import com.alghanim.enaya.travelinsurance.plan.termsandcondition.repo.TermsAndConditionsRepo;

/**
 * @author Khushbu
 * @Description This is a service class which holds the business logic with it
 *              and this class will interact with the repository.
 */
@Service
public class TermsAndConditionsImpl extends Exception {

	private static final long serialVersionUID = 1L;

	Logger LOG = LoggerFactory.getLogger(TermsAndConditionsImpl.class);

	@Autowired
	private TermsAndConditionsRepo termsRepo;

	@Autowired
	private TermsAndConditionsMapper termsAndConditionsMapper;

	@Autowired
	private TermsNotFoundException termsNotFoundException;

	/**
	 * @throws TermsExceptions
	 * @throws Exception
	 * @Description This method will use to create a term and condition and save it
	 *              to repository.
	 */
	public TermsAndConditionsDTO createTerms(TermsAndConditionsDTO data) throws CustomExceptions {
		LOG.info("TermsAndConditionsImpl::createTerm::Start");

		TermsAndConditions termsAndConditions = termsAndConditionsMapper.toTermsAndConditions(data);
		LOG.debug("data: {}, termsAndConditions:{} ", data, termsAndConditions);
		termsNotFoundException.validateTerms(termsAndConditions);
		TermsAndConditions termsData = termsRepo.save(termsAndConditions);

		TermsAndConditionsDTO terms = termsAndConditionsMapper.toTermsAndConditionsDTO(termsData);

		LOG.debug("Exiting method {}", data);

		return terms;
	}

	/**
	 * @Description This method is use to update a term and condition.
	 * @return terms
	 * @throws CustomExceptions
	 */
	public TermsAndConditionsDTO updateTerms(Long termId, TermsAndConditionsDTO termsData) throws CustomExceptions {
		LOG.info("TermsAndConditionsImpl::updateTerms::Start");

		TermsAndConditions termsAndConditions = termsAndConditionsMapper.toTermsAndConditions(termsData);

		LOG.debug("termId: {}, termsAndConditions: {}", termId, termsAndConditions);

		termsNotFoundException.validateTerms(termsAndConditions);

		termsAndConditions.setTermsId(termId);

		TermsAndConditions updateTerms = termsRepo.getOne(termsAndConditions.getTermsId());

		updateTerms.setName(termsAndConditions.getName());
		updateTerms.setFormat(termsAndConditions.getFormat());

		updateTerms.setVersion(termsAndConditions.getVersion());

		TermsAndConditions termsUpdateData = termsRepo.save(updateTerms);
		TermsAndConditionsDTO terms = termsAndConditionsMapper.toTermsAndConditionsDTO(termsUpdateData);

		LOG.info("TermsAndConditionsImpl::updateTerms::End");
		return terms;
	}

	/**
	 * @Description This method will use to delete a terms and conditions from
	 *              repository based on id given.
	 * @param termId
	 * @throws CustomExceptions
	 */
	public void deleteTermsById(Long termsId) throws CustomExceptions {

		LOG.info("TermsAndConditionsImpl::deleteTermsById::Start");

		termsNotFoundException.validateId(termsId);
		LOG.debug("termsId: {}", termsId);
		
		TermsAndConditions tId = new TermsAndConditions();
		tId.setTermsId(termsId);
		
		if (termsRepo.deleteByTermId(tId).isEmpty()) {
			termsRepo.deleteById(termsId);
		} else {
			LOG.info("This term id cannot be deleted it is maped with a plan");
		}
		LOG.info("TermsAndConditionsImpl::deleteTermsById::End");

	}

	/**
	 * @Description This method will use to retrieve a single terms data from the
	 *              repo.
	 * @return TermsAndConditionsDTO
	 * @throws CustomExceptions
	 */
	public TermsAndConditionsDTO getOneTerm(Long termsId) throws CustomExceptions {

		LOG.info("TermsAndConditionsImpl::getOneTerm::Start");
		LOG.debug("termsId: {}", termsId);

		termsNotFoundException.validateId(termsId);
		Optional<TermsAndConditions> terms = termsRepo.findById(termsId);
		TermsAndConditionsDTO termsAndConditionsDTO = termsAndConditionsMapper.toTermsAndConditionsDTO(terms.get());

		LOG.info("TermsAndConditionsImpl::getOneTerm::End");
		return termsAndConditionsDTO;
	}

	/**
	 * @Description This method will use to install the terms and conditions.
	 */
	public List<TermsAndConditionsDTO> getAllTerms() {
		LOG.info("TermsAndConditionsImpl::getAllTerms::Start");

		List<TermsAndConditions> allterms = new ArrayList<TermsAndConditions>();
		termsRepo.findAll().forEach(s -> allterms.add(s));
		List<TermsAndConditionsDTO> termsAndConditionsDTO = termsAndConditionsMapper.toTermsAndConditionsDTOs(allterms);
		LOG.debug("TermsAndConditionsImpl::getAllTerms::End");

		return termsAndConditionsDTO;

	}
}