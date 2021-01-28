package com.alghanim.enaya.travelinsurance.template;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.alghanim.enaya.travelinsurance.plan.exceptions.CustomExceptions;
import com.alghanim.enaya.travelinsurance.plan.template.DTO.TemplateDTO;
import com.alghanim.enaya.travelinsurance.plan.template.DTO.TemplateMapper;
import com.alghanim.enaya.travelinsurance.plan.template.model.Template;
import com.alghanim.enaya.travelinsurance.plan.template.repo.TemplateRepo;
import com.alghanim.enaya.travelinsurance.plan.template.service.TemplateImpl;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TemplateTestService {

	@InjectMocks
	private TemplateImpl templateImpl;

	@Mock
	private TemplateRepo templateRepo;

	@Mock
	private TemplateMapper templateMapper;

	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void createTemplate() throws CustomExceptions {
		
		// setup
		Template template = new Template(1L, "template", ".pdf");

		templateImpl.createTemplate(templateMapper.toTemplateDTO(template));

		verify(templateRepo, times(1)).save(template);

		Mockito.when(templateRepo.save(template)).thenReturn(template);

		// invoke
		TemplateDTO savedTemplate = templateImpl.createTemplate(templateMapper.toTemplateDTO(template));

		// asserts/check
//		assertThat(templateImpl.createTemplate(templateMapper.toTemplateDTO(template))
//				.isEqualTo(templateMapper.toTemplateDTO(template)));

		assertThat(savedTemplate.getTemplateId()).isEqualTo(998L);

		// cleanup
	}

////	@Test
////	public void updateTemplate() throws CustomExceptions {
////
////		Template template = new Template();
////		template.setTemplateId(1L);
////		template.setTemplateName("template2");
////		template.setFormat(".pdf");
////
////		Mockito.when(templateRepo.getOne(1L)).thenReturn(template);
////		template.setTemplateName("temp10");
////		
////		Mockito.when(templateRepo.save(template)).thenReturn(template);
////
////		assertThat(templateImpl.updateTempate(1L, templateMapper.toTemplateDTO(template))).isEqualTo(template);
////	}
////	
//
////	@Test
////	public void getOneTemplate() throws CustomExceptions {
////		Template template = new Template();
////		
////		template.setTemplateId(2L);
////		template.setTemplateName("template1");
////		template.setFormat(".doc");
////		
////		 Mockito.when(templateRepo.getOne(2L)).thenReturn(template);
////		 assertThat(templateImpl.getOneTemplate(1L)).isEqualTo(template);
////		
////	}
////	
////	@Test
////	public void getAllTemplate() {
////		Template template = new Template();
////		
////		template.setTemplateId(1L);
////		template.setTemplateName("template2");
////		template.setFormat(".doc");
////		
////		
////	}

//	TemplateDTO templateDto = new TemplateDTO();
//	templateDto.setTemplateName("template");
//	templateDto.setFormat(".pdf");
//
//	Template template = new Template();
//	template.setTemplateName("template");
//	template.setFormat(".pdf");
//
//	Template respTemplate = new Template();
//	respTemplate.setTemplateId(998L);
//	respTemplate.setTemplateName("template");
//	respTemplate.setFormat(".pdf");

}