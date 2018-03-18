package model;

import javax.persistence.*;

/**
 * Created by starrylemon on 2017/3/16.
 */
@Entity
@Table(name = "bank", schema = "hotel", catalog = "")
public class BankEntity {
    private String bankId;
    private double balance;

    @Id
    @Column(name = "bank_ID", nullable = false, length = 20)
    public String getBankId() {
        return bankId;
    }

    public void setBankId(String bankId) {
        this.bankId = bankId;
    }

    @Basic
    @Column(name = "balance", nullable = false, precision = 0)
    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BankEntity that = (BankEntity) o;

        if (Double.compare(that.balance, balance) != 0) return false;
        if (bankId != null ? !bankId.equals(that.bankId) : that.bankId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = bankId != null ? bankId.hashCode() : 0;
        temp = Double.doubleToLongBits(balance);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}
