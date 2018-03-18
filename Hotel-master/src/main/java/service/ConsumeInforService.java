package service;

import model.ConsumeEntity;

import java.util.List;

/**
 * Created by starrylemon on 2017/3/12.
 */
public interface ConsumeInforService {
    List<ConsumeEntity> getConsumeInforByUser(String id);
    double getSumMoneyByUser(String id);
}
