package lee.vioson.girl.service;

import lee.vioson.girl.enums.ResultStatus;
import lee.vioson.girl.exceptions.GirlException;
import lee.vioson.girl.model.Girl;
import lee.vioson.girl.repository.GirlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class GirlService {
    @Autowired
    private GirlRepository girlRepository;

    /**
     * 事务管理测试
     * 两条数据同时成功，或者同时不成功
     * 保证数据库数据的完整性和一致性
     */
    @Transactional
    public void insertTwo() {
        Girl girl1 = new Girl();
        girl1.setName("lili");
        girl1.setAge(23);
        girlRepository.save(girl1);

        Girl girl2 = new Girl();
        girl2.setName("lili");
        girl2.setAge(23);
        girlRepository.save(girl2);
    }

    public void getFitGirl(Integer id) throws GirlException {
        Girl one = girlRepository.findOne(id);
        Integer age = one.getAge();
        if (age > 10) {
            throw new GirlException(ResultStatus.ERROR_PARAMS);
        } else if (age < 10) {
            throw new GirlException(ResultStatus.SUCCESSFUL);
        }
    }

    public Girl findOne(Integer id) {
        return girlRepository.findOne(id);
    }
}
