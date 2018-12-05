package dbdemo.mysql.repository;

/**
 * @ClassName: dbdemo.mysql.repository.RoleRepository
 * @Description:
 * @author: Yu Wenjie
 * @version: V1.0
 * @date: 2018/12/3 18:23
 */


import dbdemo.mysql.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

}