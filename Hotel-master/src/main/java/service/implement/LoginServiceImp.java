package service.implement;

import model.AssociatorEntity;
import model.EmployeeEntity;
import model.ManagerEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.AssociatorRepository;
import repository.EmployeeRepository;
import repository.ManagerRepository;
import service.LoginService;

/**
 * Created by starrylemon on 2017/3/6.
 */

@Service
public class LoginServiceImp implements LoginService{

    @Autowired
    AssociatorRepository associatorRepository;

    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    ManagerRepository managerRepository;

    @Override
    public boolean judgeAssociator(String id, String password) {
        boolean result=false;
        AssociatorEntity entity=associatorRepository.findOne(Integer.parseInt(id));
        if(entity!=null&&entity.getPassword().equals(password)){
            result=true;
        }

        return result;
    }

    @Override
    public boolean judgeManager(String id, String password) {
        boolean result=false;
        ManagerEntity entity=managerRepository.findOne(Integer.parseInt(id));
        if(entity!=null&&entity.getPassword().equals(password)){
            result=true;
        }
        return result;
    }

    @Override
    public boolean judgeEmployee(String id, String password) {
        boolean result=false;
        EmployeeEntity entity=employeeRepository.findOne(Integer.parseInt(id));
        if(entity!=null&&entity.getPassword().equals(password)){
            result=true;
        }
        return result;
    }

}
