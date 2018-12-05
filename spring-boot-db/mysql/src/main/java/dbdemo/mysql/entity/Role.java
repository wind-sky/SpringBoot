package dbdemo.mysql.entity;

/**
 * @ClassName: dbdemo.mysql.entity.Role
 * @Description:
 * @author: Yu Wenjie
 * @version: V1.0
 * @date: 2018/12/3 17:21
 */

import javax.persistence.*;

@Entity
@Table(name = "role")
public class Role implements java.io.Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    public Role() {
    }

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
