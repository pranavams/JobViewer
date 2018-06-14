package com.ford.mss.gotd.ogmf.jobviewer.app;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan(basePackages = {"com.ford.mss.gotd.ogmf.jobviewer"})
@EnableJpaRepositories(basePackages = {"com.ford.mss.gotd.ogmf.jobviewer.job"})
@EntityScan(basePackages = {"com.ford.mss.gotd.ogmf.jobviewer.job"})
@EnableTransactionManagement
@EnableAutoConfiguration
public class JobViewerConfiguration {

}
