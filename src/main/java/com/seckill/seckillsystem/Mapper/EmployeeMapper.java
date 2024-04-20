package com.seckill.seckillsystem.Mapper;

import com.seckill.seckillsystem.Pojo.Employee;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeMapper extends MongoRepository<Employee,String > {
    Employee findByUsername(String username);
}
