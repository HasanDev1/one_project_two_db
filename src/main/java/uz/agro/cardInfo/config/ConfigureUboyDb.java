package uz.agro.cardInfo.config;


import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        transactionManagerRef = "uboyTransactionManager",
        entityManagerFactoryRef = "uboyEntityManagerFactory",
        basePackages = {"uz.agro.cardInfo.entity", "uz.agro.cardInfo.repository"}
)
public class ConfigureUboyDb {

    @Primary
    @Bean(name = "uboyDSprops")
    @ConfigurationProperties("spring.datasource")
    public DataSourceProperties dataSourceProperties(){
        return new DataSourceProperties();
    }

    @Primary
    @Bean(name = "uboyDataSource")
    @ConfigurationProperties("spring.datasource")
    public DataSource dataSource(@Qualifier("uboyDSprops") DataSourceProperties properties){
        return properties.initializeDataSourceBuilder().build();
    }

    @Primary
    @Bean(name = "uboyEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean uboyEntityManagerFactory( EntityManagerFactoryBuilder builder, @Qualifier("uboyDataSource") DataSource uboyDataSource){
        return builder.dataSource(uboyDataSource).packages("uz.agro.cardInfo.entity").persistenceUnit("entity").build();
    }

    @Primary
    @Bean(name = "uboyTransactionManager")
    @ConfigurationProperties("spring.jpa")
    public PlatformTransactionManager uboyTransactionManager(@Qualifier("uboyEntityManagerFactory")EntityManagerFactory uboyEntityManagerFactory){
        return new JpaTransactionManager(uboyEntityManagerFactory);
    }

}
