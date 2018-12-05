package dbdemo.mysql.repository;

/**
 * @ClassName: dbdemo.mysql.repository.DepartmentRepository
 * @Description:
 * @author: Yu Wenjie
 * @version: V1.0
 * @date: 2018/12/3 18:24
 */

import dbdemo.mysql.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {

}
