package model;

import javax.persistence.*;

/**
 * Created by starrylemon on 2017/3/9.
 */
@Entity
@Table(name = "branch", schema = "hotel", catalog = "")
public class BranchEntity {
    private int id;
    private String address;
    private String bankNumber;
    private String name;
    private String icard;
    private int freeNumber;
    private int reserveNumber;
    private int useNumber;

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
    @Column(name = "free_number", nullable = false)
    public int getFreeNumber() {
        return freeNumber;
    }

    public void setFreeNumber(int freeNumber) {
        this.freeNumber = freeNumber;
    }

    @Basic
    @Column(name = "reserve_number", nullable = false)
    public int getReserveNumber() {
        return reserveNumber;
    }

    public void setReserveNumber(int reserveNumber) {
        this.reserveNumber = reserveNumber;
    }

    @Basic
    @Column(name = "use_number", nullable = false)
    public int getUseNumber() {
        return useNumber;
    }

    public void setUseNumber(int useNumber) {
        this.useNumber = useNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BranchEntity that = (BranchEntity) o;

        if (id != that.id) return false;
        if (freeNumber != that.freeNumber) return false;
        if (reserveNumber != that.reserveNumber) return false;
        if (useNumber != that.useNumber) return false;
        if (address != null ? !address.equals(that.address) : that.address != null) return false;
        if (bankNumber != null ? !bankNumber.equals(that.bankNumber) : that.bankNumber != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (icard != null ? !icard.equals(that.icard) : that.icard != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (bankNumber != null ? bankNumber.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (icard != null ? icard.hashCode() : 0);
        result = 31 * result + freeNumber;
        result = 31 * result + reserveNumber;
        result = 31 * result + useNumber;
        return result;
    }
}
