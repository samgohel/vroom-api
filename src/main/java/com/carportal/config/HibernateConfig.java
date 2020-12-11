package com.carportal.config;

import static org.hibernate.cfg.AvailableSettings.CACHE_REGION_FACTORY;
import static org.hibernate.cfg.AvailableSettings.DIALECT;
import static org.hibernate.cfg.AvailableSettings.FORMAT_SQL;
import static org.hibernate.cfg.AvailableSettings.HBM2DDL_AUTO;
import static org.hibernate.cfg.AvailableSettings.SHOW_SQL;
import static org.hibernate.cfg.AvailableSettings.STORAGE_ENGINE;
import static org.hibernate.cfg.AvailableSettings.USE_QUERY_CACHE;
import static org.hibernate.cfg.AvailableSettings.USE_SECOND_LEVEL_CACHE;

import java.util.Properties;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.validation.beanvalidation.MethodValidationPostProcessor;

import com.google.common.base.Preconditions;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

@Configuration
@EnableTransactionManagement
@PropertySource({ "classpath:db.properties" })
@ComponentScan({ "com.carportal.model", "com.carportal.repository", "com.carportal" })
@EnableJpaRepositories(basePackages = "com.carportal")
public class HibernateConfig {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private Environment env;

	@Bean
	public MethodValidationPostProcessor methodValidationPostProcessor() {
		return new MethodValidationPostProcessor();
	}

	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
		logger.debug("Local Container Entity Manager Factory Bean");
		LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
		em.setDataSource(dataSource());
		em.setPackagesToScan("com.carportal");
		JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		em.setJpaVendorAdapter(vendorAdapter);
		em.setJpaProperties(additionalProperties());
		return em;
	}

	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(Preconditions.checkNotNull(env.getProperty("jdbc.driverClassName")));
		dataSource.setUrl(Preconditions.checkNotNull(env.getProperty("jdbc.url")));
		dataSource.setUsername(Preconditions.checkNotNull(env.getProperty("jdbc.user")));
		dataSource.setPassword(Preconditions.checkNotNull(env.getProperty("jdbc.pass")));
		return dataSource;
	}

	protected HikariConfig hikariConfig(DataSource dataSource) {
		HikariConfig config = new HikariConfig();
		int cpuCores = Runtime.getRuntime().availableProcessors();
		config.setMaximumPoolSize(cpuCores * 4);
		config.setDataSource(dataSource);
		config.setAutoCommit(false);
		return config;
	}

	protected HikariDataSource connectionPoolDataSorce(DataSource dataSource) {
		return new HikariDataSource(hikariConfig(dataSource));
	}

	@Bean
	public PlatformTransactionManager transactionManager() {
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(entityManagerFactory().getObject());
		return transactionManager;
	}

	@Bean
	public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
		return new PersistenceExceptionTranslationPostProcessor();
	}

	Properties additionalProperties() {
		Properties hibernateProperties = new Properties();
		hibernateProperties.setProperty(HBM2DDL_AUTO, env.getProperty("hibernate.hbm2ddl.auto"));
		hibernateProperties.setProperty(DIALECT, env.getProperty("hibernate.dialect"));
		hibernateProperties.setProperty(SHOW_SQL, env.getProperty("hibernate.show_sql"));
		hibernateProperties.setProperty(FORMAT_SQL, env.getProperty("hibernate.format_sql"));
		hibernateProperties.setProperty(CACHE_REGION_FACTORY, env.getProperty("hibernate.cache.region.factory_class"));
		hibernateProperties.setProperty(USE_QUERY_CACHE, env.getProperty("hibernate.cache.use_query_cache"));

		hibernateProperties.setProperty(STORAGE_ENGINE, env.getProperty("hibernate.dialect.storage_engine"));

		hibernateProperties.setProperty(USE_SECOND_LEVEL_CACHE,
				env.getProperty("hibernate.cache.use_second_level_cache"));

		return hibernateProperties;
	}

}
