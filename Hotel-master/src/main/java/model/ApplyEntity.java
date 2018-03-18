package model;

import javax.persistence.*;
import java.sql.Date;

/**
 * Created by starrylemon on 2017/3/13.
 */
@Entity
@Table(name = "apply", schema = "hotel", catalog = "")
public class ApplyEntity {
    private int id;
    private String address;
    private String bankNumber;
    private Date applyTime;
    private String status;
    private String name;
    private String icard;
    private int numOfRoom;
    private String password;
    private String applyerName;

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "address", nullable = false, length = 50)
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Basic
    @Column(name = "bank_number", nullable = false, length = 20)
    public String getBankNumber() {
        return bankNumber;
    }

    public void setBankNumber(String bankNumber) {
        this.bankNumber = bankNumber;
    }

    @Basic
    @Column(name = "apply_time", nullable = false)
    public Date getApplyTime() {
        return applyTime;
    }

    public void setApplyTime(Date applyTime) {
        this.applyTime = applyTime;
    }

    @Basic
    @Column(name = "status", nullable = false, length = 1)
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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
    @Column(name = "numOfRoom", nullable = false)
    public int getNumOfRoom() {
        return numOfRoom;
    }

    public void setNumOfRoom(int numOfRoom) {
        this.numOfRoom = numOfRoom;
    }

    @Basic
    @Column(name = "password", nullable = false, length = 20)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "applyerName", nullable = false, length = 20)
    public String getApplyerName() {
        return applyerName;
    }

    public void setApplyerName(String applyerName) {
        this.applyerName = applyerName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ApplyEntity that = (ApplyEntity) o;

        if (id != that.id) return false;
        if (numOfRoom != that.numOfRoom) return false;
        if (address != null ? !address.equals(that.address) : that.address != null) return false;
        if (bankNumber != null ? !bankNumber.equals(that.bankNumber) : that.bankNumber != null) return false;
        if (applyTime != null ? !applyTime.equals(that.applyTime) : that.applyTime != null) return false;
        if (status != null ? !status.equals(that.status) : that.status != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (icard != null ? !icard.equals(that.icard) : that.icard != null) return false;
        if (password != null ? !password.equals(that.password) : that.password != null) return false;
        if (applyerName != null ? !applyerName.equals(that.applyerName) : that.applyerName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (bankNumber != null ? bankNumber.hashCode() : 0);
        result = 31 * result + (applyTime != null ? applyTime.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (icard != null ? icard.hashCode() : 0);
        result = 31 * result + numOfRoom;
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (applyerName != null ? applyerName.hashCode() : 0);
        return result;
    }
}
