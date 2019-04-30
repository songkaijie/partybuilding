package com.changfa.frame.data.repository.user;

import com.changfa.frame.data.entity.user.UserArticleHistory;
import com.changfa.frame.data.entity.user.UserInfo;
import com.changfa.frame.data.repository.AdvancedJpaRepository;

import java.util.List;

/**
 * @Author: Song Kaijie
 * @Date: 2019/4/12
 */
public interface UserArticleHistoryRepository extends AdvancedJpaRepository<UserArticleHistory, Integer> {

    List<UserArticleHistory> findByUserId(Integer userId);

}
