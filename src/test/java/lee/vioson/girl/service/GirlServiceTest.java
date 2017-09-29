package lee.vioson.girl.service;

import lee.vioson.girl.model.Girl;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GirlServiceTest {
    @Autowired
    GirlService service;

    @Test
    public void findOne() throws Exception {
        Girl girl = service.findOne(2);
        Assert.assertEquals(new Integer(13), girl.getAge());
    }

}