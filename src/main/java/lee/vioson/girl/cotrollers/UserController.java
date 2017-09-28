package lee.vioson.girl.cotrollers;

import lee.vioson.girl.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/user")
public class UserController {
    @Autowired
    private User user;

    @RequestMapping(value = "/sex", method = RequestMethod.GET)
    public String print() {
        return user.getSex();
    }

    @RequestMapping(value = "/age", method = RequestMethod.GET)
    public String age() {
        return String.valueOf(user.getAge());
    }
}
