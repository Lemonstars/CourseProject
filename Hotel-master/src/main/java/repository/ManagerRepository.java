package repository;

import model.ManagerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * Created by starrylemon on 2017/3/6.
 */

@Repository
public interface ManagerRepository extends JpaRepository<ManagerEntity,Integer> {
}
