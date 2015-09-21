package model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by huangfei on 2015/6/22.
 */
@Entity
@Table(name = "user", schema = "", catalog = "test")
public class UserEntity implements Serializable{
    private int id;
    private String name;
    private String passowrd;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)//对于主键需要配置自增长
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "passowrd")
    public String getPassowrd() {
        return passowrd;
    }

    public void setPassowrd(String passowrd) {
        this.passowrd = passowrd;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserEntity that = (UserEntity) o;

        if (id != that.id) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (passowrd != null ? !passowrd.equals(that.passowrd) : that.passowrd != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (passowrd != null ? passowrd.hashCode() : 0);
        return result;
    }
}
