package model;

import javax.persistence.*;

@Entity
@Table(name = "associator", schema = "hotel", catalog = "")
public class AssociatorEntity {
    private int aid;
    private String name;
    private String icard;
    private String phone;
    private String password;
    private double balace;
    private int point;
    private int level;
    private String status;
    private String bankId;

    @Id
    @Column(name = "aid", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getAid() {
        return aid;
    }

    public void setAid(int aid) {
        this.aid = aid;
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
    @Column(name = "icard", nullable = false, length = 18)
    public String getIcard() {
        return icard;
    }

    public void setIcard(String icard) {
        this.icard = icard;
    }

    @Basic
    @Column(name = "phone", nullable = false, length = 11)
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
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
    @Column(name = "balace", nullable = false, precision = 0)
    public double getBalace() {
        return balace;
    }

    public void setBalace(double balace) {
        this.balace = balace;
    }

    @Basic
    @Column(name = "point", nullable = false)
    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    @Basic
    @Column(name = "level", nullable = false)
    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    @Basic
    @Column(name = "status", nullable = false, length = 9)
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Basic
    @Column(name = "bankId", nullable = true, length = 20)
    public String getBankId() {
        return bankId;
    }

    public void setBankId(String bankId) {
        this.bankId = bankId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AssociatorEntity that = (AssociatorEntity) o;

        if (aid != that.aid) return false;
        if (Double.compare(that.balace, balace) != 0) return false;
        if (point != that.point) return false;
        if (level != that.level) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (icard != null ? !icard.equals(that.icard) : that.icard != null) return false;
        if (phone != null ? !phone.equals(that.phone) : that.phone != null) return false;
        if (password != null ? !password.equals(that.password) : that.password != null) return false;
        if (status != null ? !status.equals(that.status) : that.status != null) return false;
        if (bankId != null ? !bankId.equals(that.bankId) : that.bankId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = aid;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (icard != null ? icard.hashCode() : 0);
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        temp = Double.doubleToLongBits(balace);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + point;
        result = 31 * result + level;
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (bankId != null ? bankId.hashCode() : 0);
        return result;
    }
}
