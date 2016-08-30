package dropwizard.metrics.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({WebConfig.class, SpringMetricsConfig.class})
public class MyAppSpringConfig {

}
