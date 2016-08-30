package dropwizard.metrics.config;

import com.codahale.metrics.MetricRegistry;
import com.ryantenney.metrics.spring.config.annotation.EnableMetrics;
import com.ryantenney.metrics.spring.config.annotation.MetricsConfigurerAdapter;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Arc on 29/8/2016.
 */
@Configuration
@EnableMetrics
public class SpringMetricsConfig extends MetricsConfigurerAdapter {

    @Override
    public void configureReporters(MetricRegistry metricRegistry) {
        // registerReporter allows the MetricsConfigurerAdapter to
        // shut down the reporter when the Spring context is closed
//        registerReporter(ConsoleReporter
//                .forRegistry(metricRegistry)
//                .build())
//                .start(5, TimeUnit.SECONDS);
    }

}
