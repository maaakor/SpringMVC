package model;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by huangfei on 2015/8/31.
 */
@Entity
@Table(name = "log", schema = "", catalog = "test")
public class LogEntity {
    private int id;
    private String ip;
    private Timestamp time;
    private String method;
    private String content;
    private String username;

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
    @Column(name = "ip")
    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    @Basic
    @Column(name = "time")
    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }

    @Basic
    @Column(name = "method")
    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    @Basic
    @Column(name = "content")
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Basic
    @Column(name = "username")
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LogEntity logEntity = (LogEntity) o;

        if (id != logEntity.id) return false;
        if (ip != null ? !ip.equals(logEntity.ip) : logEntity.ip != null) return false;
        if (time != null ? !time.equals(logEntity.time) : logEntity.time != null) return false;
        if (method != null ? !method.equals(logEntity.method) : logEntity.method != null) return false;
        if (content != null ? !content.equals(logEntity.content) : logEntity.content != null) return false;
        if (username != null ? !username.equals(logEntity.username) : logEntity.username != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (ip != null ? ip.hashCode() : 0);
        result = 31 * result + (time != null ? time.hashCode() : 0);
        result = 31 * result + (method != null ? method.hashCode() : 0);
        result = 31 * result + (content != null ? content.hashCode() : 0);
        result = 31 * result + (username != null ? username.hashCode() : 0);
        return result;
    }
}
