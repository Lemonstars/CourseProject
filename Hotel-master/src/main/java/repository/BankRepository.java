package repository;

import model.BankEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * Created by starrylemon on 2017/3/16.
 */

@Repository
public interface BankRepository extends JpaRepository<BankEntity,Integer> {

    @Modifying
    @Query("update BankEntity bank set bank.balance = ?1 where bank.bankId= ?2")
    void setBankBalanc(double balance,String id);

    @Query("select balance from BankEntity where bankId=?1")
    double getBalanceById(String id);

}
