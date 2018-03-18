package model;

import javax.persistence.*;
import java.sql.Date;

/**
 * Created by starrylemon on 2017/3/12.
 */
@Entity
@Table(name = "consume", schema = "hotel", catalog = "")
public class ConsumeEntity {
    private int id;
    private int aid;
    private int hid;
    private Date time;
    private String payType;
    private String roomType;
    private double price;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "aid", nullable = false)
    public int getAid() {
        return aid;
    }

    public void setAid(int aid) {
        this.aid = aid;
    }

    @Basic
    @Column(name = "hid", nullable = false)
    public int getHid() {
        return hid;
    }

    public void setHid(int hid) {
        this.hid = hid;
    }

    @Basic
    @Column(name = "time", nullable = false)
    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    @Basic
    @Column(name = "pay_type", nullable = false, length = 1)
    public String getPayType() {
        return payType;
    }

    public void setPayType(String payType) {
        this.payType = payType;
    }

    @Basic
    @Column(name = "room_type", nullable = false, length = 1)
    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    @Basic
    @Column(name = "price", nullable = false, precision = 0)
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ConsumeEntity that = (ConsumeEntity) o;

        if (id != that.id) return false;
        if (aid != that.aid) return false;
        if (hid != that.hid) return false;
        if (Double.compare(that.price, price) != 0) return false;
        if (time != null ? !time.equals(that.time) : that.time != null) return false;
        if (payType != null ? !payType.equals(that.payType) : that.payType != null) return false;
        if (roomType != null ? !roomType.equals(that.roomType) : that.roomType != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = id;
        result = 31 * result + aid;
        result = 31 * result + hid;
        result = 31 * result + (time != null ? time.hashCode() : 0);
        result = 31 * result + (payType != null ? payType.hashCode() : 0);
        result = 31 * result + (roomType != null ? roomType.hashCode() : 0);
        temp = Double.doubleToLongBits(price);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}
