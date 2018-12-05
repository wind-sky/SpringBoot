package dbdemo.mongo.config;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: dbdemo.mongo.config.DataSourceConfig
 * @Description:
 * @author: Yu Wenjie
 * @version: V1.0
 * @date: 2018/12/5 15:20
 */
@Configuration
@PropertySource({"classpath:data-source.properties"})
@EnableMongoRepositories(basePackages = "dbdemo.mongo.repositories")
public class DataSourceConfig extends AbstractMongoConfiguration {
    @Autowired
    private Environment env;

    @Override
    public String getDatabaseName(){
        return env.getRequiredProperty("mongo.name");
    }
    

    @Override
    @Bean
    public MongoClient mongoClient() {
        ServerAddress serverAddress = new ServerAddress(env.getRequiredProperty("mongo.host"));
        List<MongoCredential> credentials = new ArrayList<>();
        return new MongoClient(serverAddress, credentials);
    }
}
