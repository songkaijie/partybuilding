package com.changfa.frame.data.repository.user;

import com.changfa.frame.data.entity.user.User;
import com.changfa.frame.data.repository.AdvancedJpaRepository;


/**
 * @Author: Song Kaijie
 * @Date: 2019/4/10
 */
public interface UserRepository extends AdvancedJpaRepository<User, Integer> {

    User findByToken(String token);

}
