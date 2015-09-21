package model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by huangfei on 2015/9/7.
 */
@Entity
@Table(name = "stu", schema = "", catalog = "test")
public class StuEntity {
    private Integer id;
    private String name;
    private String sex;

    @Basic
    @Column(name = "id")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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
    @Column(name = "sex")
    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StuEntity stuEntity = (StuEntity) o;

        if (id != null ? !id.equals(stuEntity.id) : stuEntity.id != null) return false;
        if (name != null ? !name.equals(stuEntity.name) : stuEntity.name != null) return false;
        if (sex != null ? !sex.equals(stuEntity.sex) : stuEntity.sex != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (sex != null ? sex.hashCode() : 0);
        return result;
    }
}
