package dbdemo.mysql.test;

import dbdemo.mysql.entity.Department;
import dbdemo.mysql.entity.Role;
import dbdemo.mysql.entity.User;
import dbdemo.mysql.repository.DepartmentRepository;
import dbdemo.mysql.repository.RoleRepository;
import dbdemo.mysql.repository.UserRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.Assert;

import java.util.Date;
import java.util.List;

/**
 * @ClassName: dbdemo.mysql.test.MysqlTest
 * @Description:
 * @author: Yu Wenjie
 * @version: V1.0
 * @date: 2018/12/3 18:18
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {JpaConfiguration.class})
public class MysqlTest {
    private static Logger logger = LoggerFactory.getLogger(MysqlTest.class);

    @Autowired
    UserRepository userRepository;
    @Autowired
    DepartmentRepository departmentRepository;
    @Autowired
    RoleRepository roleRepository;

    @Before
    public void initData(){
        //初始化
        userRepository.deleteAll();
        roleRepository.deleteAll();
        departmentRepository.deleteAll();

        //新建部门表
        Department department = new Department();
        department.setName("开发部");
        departmentRepository.save(department);
        Assert.notNull(department.getId());

        //角色表
        Role role = new Role();
        role.setName("admin");
        roleRepository.save(role);
        Assert.notNull(role.getId());

        //用户表
        User user = new User();
        user.setName("user");
        user.setCreatedate(new Date());
        user.setDepartment(department);

        List<Role> roles = roleRepository.findAll();
        Assert.notNull(roles);
        user.setRoles(roles);

        userRepository.save(user);
        Assert.notNull(user.getId());
    }

//    @Test
    public void findPage(){
        Pageable pageable = new PageRequest(0, 10, new Sort(Sort.Direction.ASC, "id"));
        Page<User> page = userRepository.findAll(pageable);
        Assert.notNull(page);
        for(User user : page.getContent()) {
            logger.info("====user==== user name:{}, department name:{}, role name:{}",
                    user.getName(), user.getDepartment().getName(), user.getRoles().get(0).getName());
        }
    }

    @Test
    public void test(){
        User user1 = userRepository.findByNameLike("u%");
        Assert.notNull(user1);

        User user2 = userRepository.readByName("user");
        Assert.notNull(user2);

        List<User> users = userRepository.getByCreatedateLessThan(new Date());
        Assert.notNull(users);
    }
}
