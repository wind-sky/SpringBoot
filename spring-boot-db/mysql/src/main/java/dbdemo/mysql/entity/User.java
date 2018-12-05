package dbdemo.mysql.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @ClassName: dbdemo.mysql.entity.User
 * @Description:
 * @author: Yu Wenjie
 * @version: V1.0
 * @date: 2018/12/3 17:12
 */
@Entity
@Table(name="user")
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createdate;

    @ManyToOne //一个人只属于一个部门 定义它与部门是多对一关系
    @JoinColumn(name="did")  //在数据库表中用字段did来表示部门的ID
    @JsonBackReference
    private  Department department;

    @ManyToMany(cascade = {},fetch = FetchType.EAGER)
    @JoinTable(
            name="user_role",
            joinColumns ={@JoinColumn(name="user_id")},
            inverseJoinColumns = {@JoinColumn(name="roles_id")}
    )
    private List<Role> roles;

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

    public Date getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }
}
