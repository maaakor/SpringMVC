package model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by huangfei on 2015/9/7.
 */
@Entity
@Table(name = "tea", schema = "", catalog = "test")
public class TeaEntity {
    private Integer id;
    private String name;
    private String sex;
    private Integer sid;

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

    @Basic
    @Column(name = "sid")
    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TeaEntity teaEntity = (TeaEntity) o;

        if (id != null ? !id.equals(teaEntity.id) : teaEntity.id != null) return false;
        if (name != null ? !name.equals(teaEntity.name) : teaEntity.name != null) return false;
        if (sex != null ? !sex.equals(teaEntity.sex) : teaEntity.sex != null) return false;
        if (sid != null ? !sid.equals(teaEntity.sid) : teaEntity.sid != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (sex != null ? sex.hashCode() : 0);
        result = 31 * result + (sid != null ? sid.hashCode() : 0);
        return result;
    }
}
