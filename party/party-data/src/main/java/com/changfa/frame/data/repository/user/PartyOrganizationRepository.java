package com.changfa.frame.data.repository.user;

import com.changfa.frame.data.entity.user.PartyOrganization;
import com.changfa.frame.data.repository.AdvancedJpaRepository;

import java.util.List;

/**
 * @Author: Song Kaijie
 * @Date: 2019/4/12
 */
public interface PartyOrganizationRepository extends AdvancedJpaRepository<PartyOrganization, Integer> {
    PartyOrganization findById(Integer id);

    List<PartyOrganization> findByIdIn(List<Integer> ids);
}
