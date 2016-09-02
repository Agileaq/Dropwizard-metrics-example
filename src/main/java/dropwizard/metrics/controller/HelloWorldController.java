package dropwizard.metrics.controller;

import com.codahale.metrics.Histogram;
import com.codahale.metrics.UniformReservoir;
import com.codahale.metrics.annotation.*;
import dropwizard.metrics.bean.Person;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * Created by Arc on 17/8/2016.
 */
@RestController
@RequestMapping("say")
public class HelloWorldController {

    @Gauge
    private long helloTime;

    @RequestMapping("hello")
    public String sayHello() {
        helloTime ++;
        return "Hello world!";
    }

    @Metric
    public Histogram histogram = new Histogram(new UniformReservoir());

    @Timed
    @RequestMapping("person")
    public Person getPerson() {
        return new Person().setName("shenglong").setPassword("wobugaosuni");
    }

    @Counted
    @RequestMapping("count")
    public Person count() {
        return new Person().setName("countExample").setPassword("I like you.");
    }

    @ExceptionMetered
    @RequestMapping("exception-meter")
    public Person exception() {
        throw new NullPointerException("test");
        //return new Person().setName("exceptionExample").setPassword("I admire you.");
    }

    Random random = new Random();
    @CachedGauge(name = "queueSize", timeout = 30, timeoutUnit = TimeUnit.SECONDS)
    public int getQueueSize() {
        //return queue.getSize();
        return random.nextInt();
    }


}
