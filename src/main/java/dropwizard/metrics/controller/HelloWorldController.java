package dropwizard.metrics.controller;

import com.codahale.metrics.annotation.Gauge;
import com.codahale.metrics.annotation.Timed;
import dropwizard.metrics.bean.Person;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Arc on 17/8/2016.
 */
@RestController
@RequestMapping("say")
public class HelloWorldController {
    @Gauge
    private long helloTime;

    @RequestMapping("hello")
    @Timed
    public String sayHello() {
        helloTime ++;
        return "Hello world!";
    }

    @RequestMapping("person")
    @Timed
    public Person getPerson() {
        return new Person().setName("shenglong").setPassword("wobugaosuni");
    }

}
