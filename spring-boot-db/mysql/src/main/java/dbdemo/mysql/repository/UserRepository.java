package dbdemo.mysql.repository;

import dbdemo.mysql.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

/**
 * @ClassName: dbdemo.mysql.repository.UserRepository
 * @Description:
 * @author: Yu Wenjie
 * @version: V1.0
 * @date: 2018/12/3 17:59
 */
@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    User findByNameLike(String name);
    User readByName(String name);
    List<User> getByCreatedateLessThan(Date star);
}


//JpaRepository extends PagingAndSortingRepository extends CurdRepository extend Repository