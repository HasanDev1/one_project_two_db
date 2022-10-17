package uz.agro.cardInfo.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.HashMap;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        transactionManagerRef = "visaTransactionManager",
        entityManagerFactoryRef = "visaEntityManagerFactory",
        basePackages = {"uz.agro.cardInfo.entity.visa", "uz.agro.cardInfo.repository.visa"}
)
public class ConfigureVisaDb {

    @Bean
    public EntityManagerFactoryBuilder entityManagerFactoryBuilder(){
        return new EntityManagerFactoryBuilder(new HibernateJpaVendorAdapter(), new HashMap<>(), null);
    }

    @Bean(name = "visaDSprops")
    @ConfigurationProperties("visa.datasource")
    public DataSourceProperties dataSourceProperties(){
        return new DataSourceProperties();
    }

    @Bean("visaDatasource")
    @ConfigurationProperties("visa.datasource")
    public DataSource dataSource(@Qualifier("visaDSprops") DataSourceProperties properties){
        return properties.initializeDataSourceBuilder().build();
    }

    @Bean(name = "visaEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean visaEntityManagerFactory(EntityManagerFactoryBuilder builder, @Qualifier("visaDatasource") DataSource visaDataSource){
        return  builder.dataSource(visaDataSource).packages("uz.agro.cardInfo.entity.visa").persistenceUnit("visa").build();
    }

    @Bean(name = "visaTransactionManager")
    @ConfigurationProperties("visa.jpa")
    public PlatformTransactionManager visaTransactionManager(@Qualifier("visaEntityManagerFactory")EntityManagerFactory visaEntitManagerFactory){
        return new JpaTransactionManager(visaEntitManagerFactory);
    }
}
