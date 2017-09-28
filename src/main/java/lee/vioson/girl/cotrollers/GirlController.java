package lee.vioson.girl.cotrollers;

import lee.vioson.girl.GirlService;
import lee.vioson.girl.model.Girl;
import lee.vioson.girl.repository.GirlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class GirlController {

    @Autowired
    private GirlRepository girlRepository;

    @Autowired
    private GirlService girlService;

    @GetMapping("/getGirls")
    public List<Girl> getAllGirls() {
        return girlRepository.findAll();
    }

    @PostMapping(value = "/saveGirl")
    public Girl saveGirl(@RequestParam("name") String name, @RequestParam("age") Integer age) {
        Girl girl = new Girl();
        girl.setAge(age);
        girl.setName(name);
        return girlRepository.save(girl);
    }

    @GetMapping(value = "/getGirl")
    public Girl getGirl(@RequestParam("id") Integer id) {
        return girlRepository.findOne(id);
    }

    @PutMapping(value = "/resetGirl")
    public Girl resetGirl(@RequestParam("id") Integer id,
                          @RequestParam("age") Integer age,
                          @RequestParam("name") String name) {
        Girl girl = new Girl();
        girl.setId(id);
        girl.setAge(age);
        girl.setName(name);
        return girlRepository.save(girl);
    }

    @DeleteMapping(value = "/deleteGirl")
    public void deleteGirl(@RequestParam("id") Integer id) {
        girlRepository.delete(id);
    }


    @GetMapping(value = "/getGirlByAge")
    public List<Girl> getGirlByAge(@RequestParam("age") Integer age) {
        return girlRepository.findByAge(age);
    }

    /**
     * 事务管理
     */
    @PostMapping(value = "/insertTwo")
    public void insertTwo() {
        girlService.insertTwo();
    }
}
