package dbdemo.mysql.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @ClassName: dbdemo.mysql.config.JpaConfiguration
 * @Description:  ORM框架映射
 * @author: Yu Wenjie
 * @version: V1.0
 * @date: 2018/12/3 17:01
 */
@Order(Ordered.HIGHEST_PRECEDENCE)
@Configuration
@EnableTransactionManagement(proxyTargetClass = true)  //启用JPA事务管理
@EnableJpaRepositories(basePackages = "dbdemo.**.repository") //启用了JPA资源库并指定上面定义的借口资源库的位置
@EntityScan(basePackages = "dbdemo.**.entity") //定义实体的位置
public class JpaConfiguration {
    @Bean
    PersistenceExceptionTranslationPostProcessor persistenceExceptionTranslationPostProcessor(){
        return new PersistenceExceptionTranslationPostProcessor();
    }
}
