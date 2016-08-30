package dropwizard.metrics.customize;

import com.codahale.metrics.health.HealthCheck;
import org.springframework.stereotype.Component;

/**
 * Created by Arc on 29/8/2016.
 */
@Component
public class FakeDBHealthCheck extends HealthCheck {
    @Override
    protected Result check() throws Exception {
        return Result.healthy();
    }
}
