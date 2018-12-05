package dbdemo.mysql.entity;

import javax.persistence.*;

/**
 * @ClassName: dbdemo.mysql.entity.Department
 * @Description: 部门表（数据库表名：department）
 * @author: Yu Wenjie
 * @version: V1.0
 * @date: 2018/12/3 17:06
 */
@Entity //ORM 映射框架实体类描述
@Table(name="department") //指定关联的数据库的表名
public class Department {
    @Id //定义一条记录的唯一标识
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private  String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
