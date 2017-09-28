package lee.vioson.girl.cotrollers;

import org.springframework.web.bind.annotation.*;

@RestController
public class ParamRequestController {
    @RequestMapping(value = "/test/{id}", method = RequestMethod.GET)
    public String say(@PathVariable("id") Integer id) {
        return "id is " + id;
    }

    //    @RequestMapping(value = "/page", method = RequestMethod.GET)
    @GetMapping(value = "/page")//上面的简化写法
    public String say2(@RequestParam("page") Integer page,
                       @RequestParam(value = "pageSize", required = false, defaultValue = "30") Integer pageSize) {
        return "page:" + page + "\npageSize:" + pageSize;
    }

}
