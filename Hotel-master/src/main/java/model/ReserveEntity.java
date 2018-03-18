package model;

import javax.persistence.*;
import java.sql.Date;

/**
 * Created by starrylemon on 2017/3/9.
 */
@Entity
@Table(name = "reserve", schema = "hotel", catalog = "")
public class ReserveEntity {
    private int id;
    private Date operatTime;
    private Date targetTime;
    private String status;
    private AssociatorEntity associatorByAid;
    private BranchEntity branchByHid;
    private String roomType;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "operat_time", nullable = false)
    public Date getOperatTime() {
        return operatTime;
    }

    public void setOperatTime(Date operatTime) {
        this.operatTime = operatTime;
    }

    @Basic
    @Column(name = "target_time", nullable = false)
    public Date getTargetTime() {
        return targetTime;
    }

    public void setTargetTime(Date targetTime) {
        this.targetTime = targetTime;
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

        ReserveEntity that = (ReserveEntity) o;

        if (id != that.id) return false;
        if (operatTime != null ? !operatTime.equals(that.operatTime) : that.operatTime != null) return false;
        if (targetTime != null ? !targetTime.equals(that.targetTime) : that.targetTime != null) return false;
        if (status != null ? !status.equals(that.status) : that.status != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (operatTime != null ? operatTime.hashCode() : 0);
        result = 31 * result + (targetTime != null ? targetTime.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "aid", referencedColumnName = "aid", nullable = false)
    public AssociatorEntity getAssociatorByAid() {
        return associatorByAid;
    }

    public void setAssociatorByAid(AssociatorEntity associatorByAid) {
        this.associatorByAid = associatorByAid;
    }

    @ManyToOne
    @JoinColumn(name = "hid", referencedColumnName = "id", nullable = false)
    public BranchEntity getBranchByHid() {
        return branchByHid;
    }

    public void setBranchByHid(BranchEntity branchByHid) {
        this.branchByHid = branchByHid;
    }

    @Basic
    @Column(name = "room_type", nullable = false, length = 1)
    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }
}
