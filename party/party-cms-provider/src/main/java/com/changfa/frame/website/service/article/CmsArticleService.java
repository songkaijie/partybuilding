package com.changfa.frame.website.service.article;

import com.changfa.frame.core.util.Constant;
import com.changfa.frame.data.dto.article.CmsArticleDTO;
import com.changfa.frame.data.dto.article.CmsSubjectDTO;
import com.changfa.frame.data.entity.article.*;
import com.changfa.frame.data.repository.article.*;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.Validate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
@Transactional
public class CmsArticleService {

    private static Logger log = LoggerFactory.getLogger(CmsArticleService.class);

    @Autowired
    private CmsArticleRepository cmsArticleRepository;

    @Autowired
    private CmsArticleDateRepository cmsArticleDateRepository;

    @Autowired
    private CmsCategoryService cmsCategoryService;

    @Autowired
    private CmsSubjectRepository cmsSubjectRepository;

    @Autowired
    private CmsSubjectArticleRepository cmsSubjectArticleRepository;

    @Autowired
    private CmsSubjectArticleDataRepository cmsSubjectArticleDataRepository;

    @Autowired
    private CmsArticleTypeService cmsArticleTypeService;

    @Autowired
    private CmsSubjectService cmsSubjectService;

    @Autowired
    private CmsSubjectArticleService cmsSubjectArticleService;

    public List<CmsArticle> findCmsArticleByCategoryId(Integer categoryId) {
        return cmsArticleRepository.findByCategoryId(categoryId);
    }

    public CmsArticle findCmsArticleById(Integer id) {
        return cmsArticleRepository.findOne(id);
    }

    /* *
     * 获取文章列表
     * @Author        zyj
     * @Date          2019/4/11 10:41
     * @Description
     * */
    public Map<String, Object> getArticleList(Integer categoryId) {
        Map<String, Object> map = new HashMap<>();
        CmsCategory cmsCategory = cmsCategoryService.findCmsCategoryById(categoryId);
        List<CmsArticle> cmsArticleList = this.findCmsArticleByCategoryId(categoryId);
        CmsArticleType cmsArticleType = cmsArticleTypeService.findById(cmsCategory.getArticleTypeId());
        map.put("artilceType", cmsArticleType.getAbbrId());
        if (cmsArticleType.equals(Constant.ARTICLE_WB)) {
            map.put("articleList", this.getArticleListWB(cmsArticleList));
        }

        if (cmsArticleType.equals(Constant.ARTICLE_OT)) {
            map.put("articleList", this.getArticleListOT(cmsArticleList));
        }

        if (cmsArticleType.equals(Constant.ARTICLE_WT) || cmsArticleType.equals(Constant.ARTICLE_HT)) {
            map.put("articleList", this.getArticleListDT(cmsArticleList, cmsArticleType.getAbbrId()));
        }

        if (cmsArticleType.equals(Constant.ARTICLE_HP)) {
            map.put("articleList", this.getArticleListHP(cmsArticleList));
        }
        return map;
    }


    /* *
     * 获取文章内容列表（文本方式展示）
     * @Author        zyj
     * @Date          2019/4/12 22:48
     * @Description
     * */
    public List<CmsArticleDTO> getArticleListWB(List<CmsArticle> cmsArticleList) {
        List<CmsArticleDTO> cmsArticleDTOList = new ArrayList<>();
        for (CmsArticle cmsArticle : cmsArticleList) {
            CmsArticleDTO cmsArticleDTO = new CmsArticleDTO();
            cmsArticleDTO.setArticleId(cmsArticle.getId());
            cmsArticleDTO.setTitle(cmsArticle.getTitle());
            CmsArticleData cmsArticleData = cmsArticleDateRepository.findByArticleId(cmsArticle.getId());
            cmsArticleDTO.setContent(cmsArticleData.getContent().length() > 50 ? cmsArticleData.getContent().substring(0, 50) + "......" : cmsArticleData.getContent());
            cmsArticleDTO.setCreateTime(cmsArticle.getReleaseTime() == null ? cmsArticle.getCreateTime() : cmsArticle.getReleaseTime());
            cmsArticleDTO.setArticleType(Constant.ARTICLE_WB);
            cmsArticleDTOList.add(cmsArticleDTO);
        }
        return cmsArticleDTOList;
    }


    /* *
     * 获取文章内容列表（单图方式展示）
     * @Author        zyj
     * @Date          2019/4/12 22:48
     * @Description
     * */
    public List<CmsArticleDTO> getArticleListOT(List<CmsArticle> cmsArticleList) {
        List<CmsArticleDTO> cmsArticleDTOList = new ArrayList<>();
        for (CmsArticle cmsArticle : cmsArticleList) {
            CmsArticleDTO cmsArticleDTO = new CmsArticleDTO();
            cmsArticleDTO.setArticleId(cmsArticle.getId());
            cmsArticleDTO.setTitle(cmsArticle.getTitle());
            if (StringUtils.isNotBlank(cmsArticle.getImages())) {
                String[] images = cmsArticle.getImages().split(",");
                cmsArticleDTO.setImage(images[0].startsWith("/vimg") ? Constant.DANGJIAN_ICON_PATH + images[0] : images[0]);
            }
            CmsArticleData cmsArticleData = cmsArticleDateRepository.findByArticleId(cmsArticle.getId());
            cmsArticleDTO.setContent(cmsArticleData.getContent().length() > 50 ? cmsArticleData.getContent().substring(0, 50) + "......" : cmsArticleData.getContent());
            cmsArticleDTO.setCreateTime(cmsArticle.getReleaseTime() == null ? cmsArticle.getCreateTime() : cmsArticle.getReleaseTime());
            cmsArticleDTO.setArticleType(Constant.ARTICLE_OT);
            cmsArticleDTOList.add(cmsArticleDTO);
        }
        return cmsArticleDTOList;
    }


    /* *
     * 获取文章内容列表（文本方式展示）
     * @Author        zyj
     * @Date          2019/4/12 22:48
     * @Description
     * */
    public List<CmsArticleDTO> getArticleListDT(List<CmsArticle> cmsArticleList, String articleType) {
        List<CmsArticleDTO> cmsArticleDTOList = new ArrayList<>();
        for (CmsArticle cmsArticle : cmsArticleList) {
            CmsArticleDTO cmsArticleDTO = new CmsArticleDTO();
            cmsArticleDTO.setArticleId(cmsArticle.getId());
            cmsArticleDTO.setTitle(cmsArticle.getTitle());
            if (StringUtils.isNotBlank(cmsArticle.getImages())) {
                String[] images = cmsArticle.getImages().split(",");
                cmsArticleDTO.setImage(images[0].startsWith("/vimg") ? Constant.DANGJIAN_ICON_PATH + images[0] : images[0]);
            }
            cmsArticleDTO.setArticleType(articleType);
            cmsArticleDTOList.add(cmsArticleDTO);
        }
        return cmsArticleDTOList;
    }


    /* *
     * 获取文章内容列表（混排方式展示）
     * @Author        zyj
     * @Date          2019/4/12 22:48
     * @Description
     * */
    public List<CmsArticleDTO> getArticleListHP(List<CmsArticle> cmsArticleList) {
        List<CmsArticleDTO> cmsArticleDTOList = new ArrayList<>();
        for (CmsArticle cmsArticle : cmsArticleList) {
            CmsArticleDTO cmsArticleDTO = new CmsArticleDTO();
            if (StringUtils.isNotBlank(cmsArticle.getImages())) {
                String[] images = cmsArticle.getImages().split(",");
                if (images.length >= 2) {
                    //多图
                    cmsArticleDTO.setArticleId(cmsArticle.getId());
                    cmsArticleDTO.setTitle(cmsArticle.getTitle());
                    List<String> imageList = new ArrayList<>();
                    for (String image : images) {
                        imageList.add(image.startsWith("/vimg") ? Constant.DANGJIAN_ICON_PATH + image : image);
                    }
                    cmsArticleDTO.setImages(imageList);
                    cmsArticleDTO.setCreateTime(cmsArticle.getReleaseTime() == null ? cmsArticle.getCreateTime() : cmsArticle.getReleaseTime());
                    cmsArticleDTO.setArticleType(Constant.ARTICLE_DT);
                } else {
                    //单图
                    cmsArticleDTO.setArticleId(cmsArticle.getId());
                    cmsArticleDTO.setTitle(cmsArticle.getTitle());
                    cmsArticleDTO.setImage(images[0].startsWith("/vimg") ? Constant.DANGJIAN_ICON_PATH + images[0] : images[0]);
                    CmsArticleData cmsArticleData = cmsArticleDateRepository.findByArticleId(cmsArticle.getId());
                    cmsArticleDTO.setContent(cmsArticleData.getContent().length() > 50 ? cmsArticleData.getContent().substring(0, 50) + "......" : cmsArticleData.getContent());
                    cmsArticleDTO.setCreateTime(cmsArticle.getReleaseTime() == null ? cmsArticle.getCreateTime() : cmsArticle.getReleaseTime());
                    cmsArticleDTO.setArticleType(Constant.ARTICLE_OT);
                }
            } else {
                cmsArticleDTO.setArticleId(cmsArticle.getId());
                cmsArticleDTO.setTitle(cmsArticle.getTitle());
                CmsArticleData cmsArticleData = cmsArticleDateRepository.findByArticleId(cmsArticle.getId());
                cmsArticleDTO.setContent(cmsArticleData.getContent().length() > 50 ? cmsArticleData.getContent().substring(0, 50) + "......" : cmsArticleData.getContent());
                cmsArticleDTO.setCreateTime(cmsArticle.getReleaseTime() == null ? cmsArticle.getCreateTime() : cmsArticle.getReleaseTime());
                cmsArticleDTO.setArticleType(Constant.ARTICLE_WB);
            }
            cmsArticleDTOList.add(cmsArticleDTO);
        }
        return cmsArticleDTOList;
    }


    /* *
     * 获取文章详情
     * @Author        zyj
     * @Date          2019/4/11 10:42
     * @Description
     * */
    public CmsArticleDTO getArticleDTOById(Integer id, String articleType) {
        CmsArticle cmsArticle = this.findCmsArticleById(id);
        CmsArticleDTO cmsArticleDTO = new CmsArticleDTO();
        cmsArticleDTO.setArticleId(cmsArticle.getId());
        cmsArticleDTO.setTitle(cmsArticle.getTitle());
        cmsArticleDTO.setSource(cmsArticle.getSource());
        cmsArticleDTO.setPressTime(cmsArticle.getPressTime() != null ? cmsArticle.getPressTime() : cmsArticle.getCreateTime());
        cmsArticleDTO.setHits(50);
        CmsArticleData cmsArticleData = cmsArticleDateRepository.findByArticleId(cmsArticle.getId());
        cmsArticleDTO.setContent(cmsArticleData.getContent());

        if (articleType.equals(Constant.ARTICLE_HT)) {
            cmsArticleDTO.setAuthor(cmsArticle.getAuthor());
            cmsArticleDTO.setDescri(cmsArticleData.getContent().length() > 50 ? cmsArticleData.getContent().substring(0, 50) : cmsArticleData.getContent());
        }
        String[] relation = cmsArticleData.getRelation().split(",");
        List<Map<String, Object>> relationList = new ArrayList<>();
        for (String rId : relation) {
            Map<String, Object> map = new HashMap<>();
            CmsArticle cmsArticleRelation = cmsArticleRepository.findOne(Integer.valueOf(rId));
            map.put("title", cmsArticleRelation.getTitle());
            map.put("createTime", cmsArticleRelation.getPressTime() != null ? cmsArticleRelation.getPressTime() : cmsArticleRelation.getCreateTime());
            relationList.add(map);
        }
        cmsArticleDTO.setRelation(relationList);
        return cmsArticleDTO;
    }


    /* *
     * 获取专题列表
     * @Author        zyj
     * @Date          2019/4/11 10:43
     * @Description
     * */
    public List<CmsArticleDTO> getCmsSubjectList(Integer categoryId) {
        List<CmsSubject> cmsSubjectList = cmsSubjectService.findCmsSubjectByCategoryId(categoryId);
        ArrayList<CmsArticleDTO> cmsArticleDTOList = new ArrayList<>();
        for (CmsSubject cmsSubject : cmsSubjectList) {
            CmsArticleDTO cmsArticleDTO = new CmsArticleDTO();
            if (StringUtils.isNotBlank(cmsSubject.getImages())) {
                String[] images = cmsSubject.getImages().split(",");
                cmsArticleDTO.setImage(images[0].startsWith("/vimg") ? Constant.DANGJIAN_ICON_PATH + images[0] : images[0]);
            }
            cmsArticleDTO.setSubjectTitle(cmsSubject.getName());
            cmsArticleDTOList.add(cmsArticleDTO);
        }
        return cmsArticleDTOList;

    }

    public List<CmsArticleDTO> getCmsSubjcetArticleList(Integer subjectId) {
        List<CmsSubjectArticle> cmsSubjectArticleList = cmsSubjectArticleService.findCmsSubjectArticleBySubjectId(subjectId);
        List<CmsArticleDTO> cmsArticleDTOList = new ArrayList<>();
        for (CmsSubjectArticle cmsSubjectArticle : cmsSubjectArticleList) {
            CmsArticleDTO cmsArticleDTO = new CmsArticleDTO();
            cmsArticleDTO.setSubjectArticleId(cmsSubjectArticle.getId());
            cmsArticleDTO.setTitle(cmsSubjectArticle.getTitle());
            cmsArticleDTO.setCreateTime(cmsSubjectArticle.getPressTime());
            cmsArticleDTOList.add(cmsArticleDTO);
            /*Validate.notEmpty(cmsArticleDTO.getArticleType());*/
        }
        return cmsArticleDTOList;
    }


    public CmsArticleDTO getCmsSubjectArticleDetail(Integer articleId) {
        CmsSubjectArticle cmsSubjectArticle = cmsSubjectArticleService.findCmsSubjectArticleById(articleId);
        if (cmsSubjectArticle != null) {
            return getCmsSubjectArticleDTO(cmsSubjectArticle);
        }
        return null;
    }

    public CmsArticleDTO getCmsSubjectArticleDTO(CmsSubjectArticle cmsSubjectArticle) {
        CmsArticleDTO cmsArticleDTO = new CmsArticleDTO();
        cmsArticleDTO.setSubjectArticleId(cmsSubjectArticle.getId());
        cmsArticleDTO.setTitle(cmsSubjectArticle.getTitle());
        cmsArticleDTO.setSource(cmsSubjectArticle.getSource());
        cmsArticleDTO.setPressTime(cmsSubjectArticle.getPressTime() != null ? cmsSubjectArticle.getPressTime() : cmsSubjectArticle.getCreateTime());
        cmsArticleDTO.setHits(50);
        cmsArticleDTO.setAuthor(cmsSubjectArticle.getAuthor());
        CmsSubjectArticleData cmsSubjectArticleData = cmsSubjectArticleDataRepository.findBySubjectArticleId(cmsSubjectArticle.getId());
        cmsArticleDTO.setContent(cmsSubjectArticleData.getContent());
        cmsArticleDTO.setDescri(cmsSubjectArticleData.getContent().length() > 50 ? cmsSubjectArticleData.getContent().substring(0, 50) : cmsSubjectArticleData.getContent());
        String[] relation = cmsSubjectArticleData.getRelation().split(",");
        List<Map<String, Object>> relationList = new ArrayList<>();
        for (String rId : relation) {
            Map<String, Object> map = new HashMap<>();
            CmsSubjectArticle cmsSubjectArticleR = cmsSubjectArticleRepository.findOne(Integer.valueOf(rId));
            map.put("title", cmsSubjectArticleR.getTitle());
            map.put("createTime", cmsSubjectArticleR.getPressTime() != null ? cmsSubjectArticleR.getPressTime() : cmsSubjectArticleR.getCreateTime());
            relationList.add(map);
        }
        cmsArticleDTO.setRelation(relationList);
        return cmsArticleDTO;
    }
}
