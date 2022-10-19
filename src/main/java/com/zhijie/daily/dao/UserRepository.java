package com.zhijie.daily.dao;

import com.zhijie.daily.po.User;
import org.springframework.data.jpa.repository.JpaRepository;
//与数据库连接层：对象，主键类型
public interface UserRepository extends JpaRepository<User,Long> {
    User findByUsernameAndPassword(String username, String password);
}
