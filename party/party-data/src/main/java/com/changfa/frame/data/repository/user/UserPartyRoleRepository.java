package com.changfa.frame.data.repository.user;

import com.changfa.frame.data.entity.user.UserPartyRole;
import com.changfa.frame.data.repository.AdvancedJpaRepository;

import java.util.List;

/**
 * @Author: Song Kaijie
 * @Date: 2019/4/12
 */
public interface UserPartyRoleRepository extends AdvancedJpaRepository<UserPartyRole, Integer> {
    List<UserPartyRole> findByUserId(Integer userId);
}
