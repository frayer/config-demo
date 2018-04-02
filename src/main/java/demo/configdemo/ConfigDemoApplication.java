package demo.configdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.Data;

@SpringBootApplication
public class ConfigDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConfigDemoApplication.class, args);
    }
}

@Component
@ConfigurationProperties(prefix = "endpoint-configs")
@Data
class EndpointConfigs {
    private String resourceA;
    private String resourceB;
}

@RestController
class ConfigViewController {

    @Autowired
    private EndpointConfigs endpointConfigs;

    @GetMapping("/config")
    public EndpointConfigs get() {
        return this.endpointConfigs;
    }
}
