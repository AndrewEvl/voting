package by.voting.config;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableAutoConfiguration
@EntityScan(basePackages = "by.voting.entity")
@EnableJpaRepositories(basePackages = "by.voting.repository")
@EnableTransactionManagement
@ComponentScan(basePackages = "by.voting.service")
public class RepositoryConfigurationTest {
}
