package lee.vioson.girl.cotrollers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @Value("${customValue}")
    private String name;

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String say() {
        return "hello " + name;
    }
}
