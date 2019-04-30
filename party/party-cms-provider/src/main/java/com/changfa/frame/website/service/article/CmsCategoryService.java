package com.changfa.frame.website.service.article;

import com.changfa.frame.data.entity.article.CmsCategory;
import com.changfa.frame.data.repository.article.CmsCategoryRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.awt.*;


@Service
@Transactional
public class CmsCategoryService {

    private static Logger log = LoggerFactory.getLogger(CmsCategoryService.class);

    @Autowired
    private CmsCategoryRepository cmsCategoryRepository;


    public CmsCategory findCmsCategoryById(Integer categoryId) {
        return cmsCategoryRepository.findOne(categoryId);
    }
}
