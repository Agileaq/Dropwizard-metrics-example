package dropwizard.metrics.bean;

/**
 * Created by Arc on 17/8/2016.
 */
public class Person {

    private String name;
    private String password;

    public String getName() {
        return name;
    }

    public Person setName(String name) {
        this.name = name;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public Person setPassword(String password) {
        this.password = password;
        return this;
    }

}
