package com.changfa.frame.website.service.user;

import com.changfa.frame.core.util.Constant;
import com.changfa.frame.data.enums.ArticleType;
import com.changfa.frame.data.dto.user.UserArticleHistoryDTO;
import com.changfa.frame.data.entity.article.CmsArticle;
import com.changfa.frame.data.entity.article.CmsSubjectArticle;
import com.changfa.frame.data.entity.user.UserArticleHistory;
import com.changfa.frame.data.repository.article.CmsArticleRepository;
import com.changfa.frame.data.repository.article.CmsSubjectArticleRepository;
import com.changfa.frame.data.repository.user.UserArticleHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: Song Kaijie
 * @Date: 2019/4/12
 */
@Service
@Transactional
public class UserArticleHistoryService {
    @Autowired
    private UserArticleHistoryRepository userArticleHistoryRepository;
    @Autowired
    private CmsArticleRepository cmsArticleRepository;
    @Autowired
    private CmsSubjectArticleRepository cmsSubjectArticleRepository;

    public List<UserArticleHistoryDTO> findByUserId(Integer userId) {
        List<UserArticleHistory> userArticleHistories = userArticleHistoryRepository.findByUserId(userId);
        List<UserArticleHistoryDTO> userArticleHistoryDTOList = new ArrayList<>();
        for (UserArticleHistory userArticleHistory : userArticleHistories) {
            UserArticleHistoryDTO userArticleHistoryDTO = new UserArticleHistoryDTO();
            userArticleHistoryDTO.setCreateTime(userArticleHistory.getCreateTime());
            userArticleHistoryDTO.setArticleHistoryId(userArticleHistory.getId());
            String articleType = userArticleHistory.getArticleType();
            userArticleHistoryDTO.setArticleType(articleType);
            Integer articleId = userArticleHistory.getArticleId();
            userArticleHistoryDTO.setArticleId(articleId);
            if (articleType.equals(ArticleType.CMS_ARTICLE.getValue())) {
                CmsArticle cmsArticle = cmsArticleRepository.findOne(articleId);
                userArticleHistoryDTO.setTitle(cmsArticle.getTitle());
                String images = cmsArticle.getImages();
                List<String> imageList = Arrays.asList(images.split(","));
                userArticleHistoryDTO.setImages(Constant.DANGJIAN_ICON_PATH + imageList.get(0));
            }
            if (articleType.equals(ArticleType.CMS_SUBJECT_ARTICLE.getValue())) {
                CmsSubjectArticle cmsSubjectArticle = cmsSubjectArticleRepository.findOne(articleId);
                userArticleHistoryDTO.setTitle(cmsSubjectArticle.getTitle());
                String images = cmsSubjectArticle.getImages();
                List<String> imageList = Arrays.asList(images.split(","));
                userArticleHistoryDTO.setImages(Constant.DANGJIAN_ICON_PATH + imageList.get(0));
            }
            userArticleHistoryDTOList.add(userArticleHistoryDTO);
        }
        return userArticleHistoryDTOList;
    }
}
