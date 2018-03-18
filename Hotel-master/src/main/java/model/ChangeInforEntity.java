package model;

import javax.persistence.*;
import java.sql.Date;

/**
 * Created by starrylemon on 2017/3/15.
 */
@Entity
@Table(name = "changeInfor", schema = "hotel", catalog = "")
public class ChangeInforEntity {
    private int changeId;
    private int branchId;
    private String oldIcard;
    private String oldCity;
    private String oldAddress;
    private int oldNumOfRoom;
    private String newIcard;
    private String newCity;
    private String newAddress;
    private int newNumOfRoom;
    private Date date;
    private String status;

    @Id
    @Column(name = "changeId", nullable = false)
    public int getChangeId() {
        return changeId;
    }

    public void setChangeId(int changeId) {
        this.changeId = changeId;
    }

    @Basic
    @Column(name = "branchId", nullable = false)
    public int getBranchId() {
        return branchId;
    }

    public void setBranchId(int branchId) {
        this.branchId = branchId;
    }

    @Basic
    @Column(name = "oldIcard", nullable = false, length = 18)
    public String getOldIcard() {
        return oldIcard;
    }

    public void setOldIcard(String oldIcard) {
        this.oldIcard = oldIcard;
    }

    @Basic
    @Column(name = "oldCity", nullable = false, length = 20)
    public String getOldCity() {
        return oldCity;
    }

    public void setOldCity(String oldCity) {
        this.oldCity = oldCity;
    }

    @Basic
    @Column(name = "oldAddress", nullable = false, length = 30)
    public String getOldAddress() {
        return oldAddress;
    }

    public void setOldAddress(String oldAddress) {
        this.oldAddress = oldAddress;
    }

    @Basic
    @Column(name = "oldNumOfRoom", nullable = false)
    public int getOldNumOfRoom() {
        return oldNumOfRoom;
    }

    public void setOldNumOfRoom(int oldNumOfRoom) {
        this.oldNumOfRoom = oldNumOfRoom;
    }

    @Basic
    @Column(name = "newIcard", nullable = false, length = 18)
    public String getNewIcard() {
        return newIcard;
    }

    public void setNewIcard(String newIcard) {
        this.newIcard = newIcard;
    }

    @Basic
    @Column(name = "newCity", nullable = false, length = 20)
    public String getNewCity() {
        return newCity;
    }

    public void setNewCity(String newCity) {
        this.newCity = newCity;
    }

    @Basic
    @Column(name = "newAddress", nullable = false, length = 30)
    public String getNewAddress() {
        return newAddress;
    }

    public void setNewAddress(String newAddress) {
        this.newAddress = newAddress;
    }

    @Basic
    @Column(name = "newNumOfRoom", nullable = false)
    public int getNewNumOfRoom() {
        return newNumOfRoom;
    }

    public void setNewNumOfRoom(int newNumOfRoom) {
        this.newNumOfRoom = newNumOfRoom;
    }

    @Basic
    @Column(name = "date", nullable = false)
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Basic
    @Column(name = "status", nullable = false, length = 1)
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ChangeInforEntity that = (ChangeInforEntity) o;

        if (changeId != that.changeId) return false;
        if (branchId != that.branchId) return false;
        if (oldNumOfRoom != that.oldNumOfRoom) return false;
        if (newNumOfRoom != that.newNumOfRoom) return false;
        if (oldIcard != null ? !oldIcard.equals(that.oldIcard) : that.oldIcard != null) return false;
        if (oldCity != null ? !oldCity.equals(that.oldCity) : that.oldCity != null) return false;
        if (oldAddress != null ? !oldAddress.equals(that.oldAddress) : that.oldAddress != null) return false;
        if (newIcard != null ? !newIcard.equals(that.newIcard) : that.newIcard != null) return false;
        if (newCity != null ? !newCity.equals(that.newCity) : that.newCity != null) return false;
        if (newAddress != null ? !newAddress.equals(that.newAddress) : that.newAddress != null) return false;
        if (date != null ? !date.equals(that.date) : that.date != null) return false;
        if (status != null ? !status.equals(that.status) : that.status != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = changeId;
        result = 31 * result + branchId;
        result = 31 * result + (oldIcard != null ? oldIcard.hashCode() : 0);
        result = 31 * result + (oldCity != null ? oldCity.hashCode() : 0);
        result = 31 * result + (oldAddress != null ? oldAddress.hashCode() : 0);
        result = 31 * result + oldNumOfRoom;
        result = 31 * result + (newIcard != null ? newIcard.hashCode() : 0);
        result = 31 * result + (newCity != null ? newCity.hashCode() : 0);
        result = 31 * result + (newAddress != null ? newAddress.hashCode() : 0);
        result = 31 * result + newNumOfRoom;
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        return result;
    }
}
