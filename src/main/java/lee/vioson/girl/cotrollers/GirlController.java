package lee.vioson.girl.cotrollers;

import lee.vioson.girl.enums.ResultStatus;
import lee.vioson.girl.exceptions.GirlException;
import lee.vioson.girl.results.Result;
import lee.vioson.girl.service.GirlService;
import lee.vioson.girl.model.Girl;
import lee.vioson.girl.repository.GirlRepository;
import lee.vioson.girl.utils.ResultUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class GirlController {

    @Autowired
    private GirlRepository girlRepository;

    @Autowired
    private GirlService girlService;

    @GetMapping("/getGirls")
    public Result<List<Girl>> getAllGirls() {
        return ResultUtils.success(girlRepository.findAll());
    }

    @PostMapping(value = "/saveGirl")
    public Result<Girl> saveGirl(@RequestParam("name") String name, @RequestParam("age") Integer age) {
        Girl girl = new Girl();
        girl.setAge(age);
        girl.setName(name);
        return ResultUtils.success(girlRepository.save(girl));
    }

    @PostMapping(value = "/saveGirlWithCheck")
    public Result<Girl> saveGirl(@Valid Girl girl, BindingResult result) {
        if (result.hasErrors()) {
            System.out.print(result.getFieldError().getDefaultMessage());
            return ResultUtils.error(ResultStatus.ERROR_PARAMS);
        }
        return ResultUtils.success(girlRepository.save(girl));
    }

    @GetMapping(value = "/getGirl")
    public Result<Girl> getGirl(@RequestParam("id") Integer id) {
        return ResultUtils.success(girlRepository.findOne(id));
    }

    @PutMapping(value = "/resetGirl")
    public Result<Girl> resetGirl(@RequestParam("id") Integer id,
                                  @RequestParam("age") Integer age,
                                  @RequestParam("name") String name) {
        Girl girl = new Girl();
        girl.setId(id);
        girl.setAge(age);
        girl.setName(name);
        return ResultUtils.success(girlRepository.save(girl));
    }

    @DeleteMapping(value = "/deleteGirl")
    public void deleteGirl(@RequestParam("id") Integer id) {
        girlRepository.delete(id);
    }


    @GetMapping(value = "/getGirlByAge")
    public Result<List<Girl>> getGirlByAge(@RequestParam("age") Integer age) {
        return ResultUtils.success(girlRepository.findByAge(age));
    }

    /**
     * 事务管理
     */
    @PostMapping(value = "/insertTwo")
    public void insertTwo() {
        girlService.insertTwo();
    }

    @GetMapping(value = "/checkAge/{id}")
    public void checkAge(@PathVariable("id") Integer id) throws GirlException {
        girlService.getFitGirl(id);
    }

}
