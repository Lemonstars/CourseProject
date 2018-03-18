package model;

import javax.persistence.*;

/**
 * Created by starrylemon on 2017/3/9.
 */
@Entity
@Table(name = "manager", schema = "hotel", catalog = "")
public class ManagerEntity {
    private int id;
    private String password;
    private String name;
    private String sex;
    private String icard;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "password", nullable = false, length = 10)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "name", nullable = false, length = 20)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "sex", nullable = false, length = 6)
    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Basic
    @Column(name = "icard", nullable = false, length = 18)
    public String getIcard() {
        return icard;
    }

    public void setIcard(String icard) {
        this.icard = icard;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ManagerEntity entity = (ManagerEntity) o;

        if (id != entity.id) return false;
        if (password != null ? !password.equals(entity.password) : entity.password != null) return false;
        if (name != null ? !name.equals(entity.name) : entity.name != null) return false;
        if (sex != null ? !sex.equals(entity.sex) : entity.sex != null) return false;
        if (icard != null ? !icard.equals(entity.icard) : entity.icard != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (sex != null ? sex.hashCode() : 0);
        result = 31 * result + (icard != null ? icard.hashCode() : 0);
        return result;
    }
}
