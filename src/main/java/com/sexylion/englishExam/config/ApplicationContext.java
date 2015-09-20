package com.sexylion.englishExam.config;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.*;
import org.springframework.context.support.ResourceBundleMessageSource;

/**
 * @author Petri Kainulainen
 */
@Configuration
@ComponentScan(basePackages = {
		"com.sexylion.englishExam.todo.service",
		"com.sexylion.englishExam.model",
		"com.sexylion.englishExam.service"
		
})
@Import({WebAppContext.class, PersistenceContext.class})
@PropertySource("classpath:application.properties")
public class ApplicationContext {

    private static final String MESSAGE_SOURCE_BASE_NAME = "i18n/messages";

    @Bean
    public MessageSource messageSource() {
        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();

        messageSource.setBasename(MESSAGE_SOURCE_BASE_NAME);
        messageSource.setUseCodeAsDefaultMessage(true);

        return messageSource;
    }
}
