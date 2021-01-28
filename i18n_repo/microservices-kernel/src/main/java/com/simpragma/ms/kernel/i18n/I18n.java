package com.simpragma.ms.kernel.i18n;

import java.util.Locale;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

@Configuration
@RestController
public class I18n {
	/**
	 * @param not required
	 * @return sessionLocalResolver
	 * @author khushbu
	 * @
	 */
	@Bean
	public LocaleResolver localeResolver() {
		SessionLocaleResolver sessionLocaleResolver = new SessionLocaleResolver();
		sessionLocaleResolver.setDefaultLocale(Locale.US);
		return sessionLocaleResolver;
	}

	/**
	 * 
	 * @return resourceBundleMessageSource
	 */
	@Bean
	public ResourceBundleMessageSource messageSource() {
		ResourceBundleMessageSource resourceBundleMessageSource = new ResourceBundleMessageSource();
		resourceBundleMessageSource.setBasename("i18n/messages");
		resourceBundleMessageSource.setUseCodeAsDefaultMessage(true);
		return resourceBundleMessageSource;

	}

	/**
	 * 
	 * @param msg
	 * @return
	 */
	@RequestMapping(value = "/languages", method = RequestMethod.GET)
	public String getMessage(@RequestHeader("Accept-Language") String msg) {
		return messageSource().getMessage("greeting", null, new Locale(msg));
	}

}

