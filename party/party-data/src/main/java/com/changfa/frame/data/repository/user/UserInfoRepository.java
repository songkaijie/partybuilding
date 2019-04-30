package com.changfa.frame.data.repository.user;

import com.changfa.frame.data.entity.user.UserInfo;
import com.changfa.frame.data.repository.AdvancedJpaRepository;

/**
 * @Author: Song Kaijie
 * @Date: 2019/4/11
 */
public interface UserInfoRepository extends AdvancedJpaRepository<UserInfo, Integer> {

    UserInfo findByUserId(Integer userId);
}
