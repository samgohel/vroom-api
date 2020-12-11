package com.carportal.config;

import static com.google.common.collect.Lists.newArrayList;

import java.time.Instant;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.core.Ordered;
import org.springframework.web.bind.annotation.RequestMethod;

import com.fasterxml.classmate.TypeResolver;
import com.google.common.collect.Lists;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.ResponseMessageBuilder;
import springfox.documentation.schema.AlternateTypeRules;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.AuthorizationScope;
import springfox.documentation.service.SecurityReference;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger.web.DocExpansion;
import springfox.documentation.swagger.web.ModelRendering;
import springfox.documentation.swagger.web.OperationsSorter;
import springfox.documentation.swagger.web.TagsSorter;
import springfox.documentation.swagger.web.UiConfiguration;
import springfox.documentation.swagger.web.UiConfigurationBuilder;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
@Import(springfox.bean.validators.configuration.BeanValidatorPluginsConfiguration.class)
public class SwaggerConfig {

	private final Logger logger = LoggerFactory.getLogger(SwaggerConfig.class);

	public static final String AUTHORIZATION_HEADER = "Authorization";
	public static final String DEFAULT_INCLUDE_PATTERN = "/carportal/api/.*";

	@Autowired
	private TypeResolver typeResolver;

	@Bean
	public Docket api() {
		// @formatter:off
		logger.info("Debuging From Swagger");

		return new Docket(DocumentationType.SWAGGER_2)
				.alternateTypeRules(AlternateTypeRules
				.newRule(typeResolver.resolve(Collection.class, Instant.class),
						typeResolver.resolve(Collection.class, Date.class), Ordered.HIGHEST_PRECEDENCE))
				.select()
				.apis(RequestHandlerSelectors.any())
				.paths(PathSelectors.any())
				.build()
				.apiInfo(apiInfo())
				.useDefaultResponseMessages(false)
				.securityContexts(Lists.newArrayList(securityContext()))
				.securitySchemes(Lists.newArrayList(apiKey()))
				.globalResponseMessage(RequestMethod.GET, 
				 newArrayList(new ResponseMessageBuilder().code(500).message("500 message").responseModel(new ModelRef("String")).build(),
						      new ResponseMessageBuilder().code(403).message("Forbidden!!!!!").build()));
		// @formatter:on
	}

	private ApiKey apiKey() {
		return new ApiKey("JWT", AUTHORIZATION_HEADER, "header");
	}

	private SecurityContext securityContext() {
		return SecurityContext.builder().securityReferences(defaultAuth())
				.forPaths(PathSelectors.regex(DEFAULT_INCLUDE_PATTERN)).build();
	}

	List<SecurityReference> defaultAuth() {
		AuthorizationScope authorizationScope = new AuthorizationScope("global", "accessEverything");
		AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
		authorizationScopes[0] = authorizationScope;
		return Lists.newArrayList(new SecurityReference("JWT", authorizationScopes));
	}

	@Bean
	UiConfiguration uiConfig() {
		// @formatter:off
		return UiConfigurationBuilder.builder()
				.deepLinking(true)
				.displayOperationId(false)
				.defaultModelsExpandDepth(1)
				.defaultModelExpandDepth(1)
				.defaultModelRendering(ModelRendering.EXAMPLE)
				.displayRequestDuration(false)
				.docExpansion(DocExpansion.NONE)
				.filter(false)
				.maxDisplayedTags(null)
				.operationsSorter(OperationsSorter.ALPHA)
				.showExtensions(false)
				.tagsSorter(TagsSorter.ALPHA)
				.supportedSubmitMethods(UiConfiguration.Constants.DEFAULT_SUBMIT_METHODS)
				.validatorUrl(null)
				.build();
		// @formatter:on
	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("Car Sell/Buy API")
				.description("Car Selling Portal Design And Develop By Shambhu Gohel").version("1.0.0.1")
				.termsOfServiceUrl("http://terms-of-services.url").license("LICENSE")
				.licenseUrl("http://url-to-license.com").build();
	}

}
