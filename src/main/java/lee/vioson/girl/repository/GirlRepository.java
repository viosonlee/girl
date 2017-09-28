package lee.vioson.girl.repository;

import lee.vioson.girl.model.Girl;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GirlRepository extends JpaRepository<Girl, Integer> {
    List<Girl> findByAge(Integer age);//自定义查询，但是命名要规范
}
