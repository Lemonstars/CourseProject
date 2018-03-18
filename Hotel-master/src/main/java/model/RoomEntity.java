package model;

import javax.persistence.*;

/**
 * Created by starrylemon on 2017/3/9.
 */
@Entity
@Table(name = "room", schema = "hotel", catalog = "")
public class RoomEntity {
    private int id;
    private String type;
    private int price;
    private BranchEntity branchByHid;

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
    @Column(name = "type", nullable = false, length = 1)
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Basic
    @Column(name = "price", nullable = false)
    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RoomEntity that = (RoomEntity) o;

        if (id != that.id) return false;
        if (price != that.price) return false;
        if (type != null ? !type.equals(that.type) : that.type != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + price;
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "hid", referencedColumnName = "id", nullable = false)
    public BranchEntity getBranchByHid() {
        return branchByHid;
    }

    public void setBranchByHid(BranchEntity branchByHid) {
        this.branchByHid = branchByHid;
    }
}
