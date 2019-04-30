package com.changfa.frame.website.service.user;


import com.changfa.frame.data.dto.user.UserInfoDTO;
import com.changfa.frame.data.entity.user.PartyOrganization;
import com.changfa.frame.data.entity.user.User;
import com.changfa.frame.data.entity.user.UserInfo;
import com.changfa.frame.data.entity.user.UserPartyRole;
import com.changfa.frame.data.repository.user.PartyOrganizationRepository;
import com.changfa.frame.data.repository.user.UserInfoRepository;
import com.changfa.frame.data.repository.user.UserPartyRoleRepository;
import com.changfa.frame.data.repository.user.UserRepository;
import com.querydsl.core.types.Constant;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.Validate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class UserService {

    public static final String PICTUREPATH = File.separator + "vimg";
    private static Logger log = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserInfoRepository userInfoRepository;
    @Autowired
    private UserPartyRoleRepository userPartyRoleRepository;
    @Autowired
    private PartyOrganizationRepository partyOrganizationRepository;

    public User findByToken(String token) {
        return userRepository.findByToken(token);
    }

    public UserInfoDTO findPartyInfoByToken(String token) {
        UserInfoDTO userInfoDTO = new UserInfoDTO();
        User user = userRepository.findByToken(token);
        Validate.notNull(user, "用户不存在");
        Integer userId = user.getId();
        UserInfo userInfo = userInfoRepository.findByUserId(userId);
        Validate.notNull(userInfo, "查询不到指定用户");
        List<UserPartyRole> userPartyRoleList = userPartyRoleRepository.findByUserId(userId);
        List<Integer> partyOrganizationIds = new ArrayList<>();
        for (UserPartyRole userPartyRole : userPartyRoleList) {
            partyOrganizationIds.add(userPartyRole.getPartyOrganizationId());
        }
        List<PartyOrganization> partyOrganizations = partyOrganizationRepository.findByIdIn(partyOrganizationIds);
        List<String> names = new ArrayList<>();
        for (PartyOrganization partyOrganization : partyOrganizations) {
            names.add(partyOrganization.getName());
        }
        String origanizationName = StringUtils.join(names.toArray(), ",");
        userInfoDTO.setPartyOrganization(origanizationName);
        userInfoDTO.setDescri(userInfo.getDescri());
        userInfoDTO.setName(user.getName());
        userInfoDTO.setSex(userInfo.getSex());
        userInfoDTO.setBirthday(userInfo.getBirthday());
        userInfoDTO.setCensusRegister(userInfo.getCensusRegister());
        userInfoDTO.setPhone(user.getPhone());
        userInfoDTO.setNational(userInfo.getNational());
        userInfoDTO.setEducationalBackground(userInfo.getEducationalBackground());
        userInfoDTO.setIdNo(userInfo.getIdNo());
        userInfoDTO.setMajor(userInfo.getMajor());
        userInfoDTO.setGraduateSchool(userInfo.getGraduateSchool());
        userInfoDTO.setApplicationJoinPartyTime(userInfo.getApplicationJoinPartyTime());
        userInfoDTO.setDegreeIn(userInfo.getDegreeIn());
        userInfoDTO.setJoinPartyTime(userInfo.getJoinPartyTime());
        return userInfoDTO;
    }

    public void updatePartyInfo(UserInfoDTO userInfoDTO) {
        User user = userRepository.findByToken(userInfoDTO.getToken());
        Validate.notNull(user, "输入token有误");
        if (StringUtils.isNotBlank(userInfoDTO.getName())) {
            user.setName(userInfoDTO.getName());
        }
        if (StringUtils.isNotBlank(userInfoDTO.getPhone())) {
            user.setPhone(userInfoDTO.getPhone());
        }
        Integer userId = user.getId();
        Validate.notNull(userId, "用户Id为空");
        UserInfo userInfo = userInfoRepository.findByUserId(userId);
        if (StringUtils.isNotBlank(userInfo.getSex())) {
            userInfo.setSex(userInfoDTO.getSex());
        }
        userInfo.setBirthday(userInfoDTO.getBirthday());
        userInfo.setCensusRegister(userInfoDTO.getCensusRegister());
        userInfo.setNational(userInfoDTO.getNational());
        userInfo.setEducationalBackground(userInfoDTO.getEducationalBackground());
        userInfo.setIdNo(userInfoDTO.getIdNo());
        userInfo.setMajor(userInfoDTO.getMajor());
        userInfo.setGraduateSchool(userInfoDTO.getGraduateSchool());
        userInfo.setApplicationJoinPartyTime(userInfoDTO.getApplicationJoinPartyTime());
        userInfo.setDegreeIn(userInfoDTO.getDegreeIn());
        userInfo.setJoinPartyTime(userInfoDTO.getJoinPartyTime());
        userRepository.saveAndFlush(user);
        userInfoRepository.saveAndFlush(userInfo);
    }

    public UserInfoDTO findUserInfoByToken(String token) {
        UserInfoDTO userInfoDTO = new UserInfoDTO();
        User user = userRepository.findByToken(token);
        Validate.notNull(user, "用户不存在");
        Integer userId = user.getId();
        UserInfo userInfo = userInfoRepository.findByUserId(userId);
        Validate.notNull(userInfo, "查询不到指定用户");
        userInfoDTO.setName(user.getName());
        userInfoDTO.setAge(userInfo.getAge());
        userInfoDTO.setSex(userInfo.getSex());
        userInfoDTO.setNational(userInfo.getNational());
        userInfoDTO.setPhone(user.getPhone());
        userInfoDTO.setPoliticsStatus(userInfo.getPoliticsStatus());
        userInfoDTO.setUserIcon(Constant.DANGJIAN_SYSTEM_ICON_PATH + userInfo.getUserIcon());
        return userInfoDTO;
    }

    public void updateUserInfo(UserInfoDTO userInfoDTO) {
        User user = userRepository.findByToken(userInfoDTO.getToken());
        Validate.notNull(user, "输入token有误");
        if (StringUtils.isNotBlank(userInfoDTO.getName())) {
            user.setName(userInfoDTO.getName());
        }
        if (StringUtils.isNotBlank(userInfoDTO.getPhone())) {
            user.setPhone(userInfoDTO.getPhone());
        }
        Integer userId = user.getId();
        Validate.notNull(userId, "用户Id为空");
        UserInfo userInfo = userInfoRepository.findByUserId(userId);
        if (StringUtils.isNotBlank(userInfo.getSex())) {
            userInfo.setSex(userInfoDTO.getSex());
        }
        userInfo.setAge(userInfoDTO.getAge());
        userInfo.setNational(userInfoDTO.getNational());
        userInfo.setPoliticsStatus(userInfoDTO.getPoliticsStatus());
        String userIcon = userInfoDTO.getUserIcon();
        userIcon = userIcon.substring(userIcon.indexOf("/vimg"));
        userInfo.setUserIcon(userIcon);
        userRepository.saveAndFlush(user);
        userInfoRepository.saveAndFlush(userInfo);
    }

    public String updateIcon(MultipartFile file) {
        try {
            String path = System.getProperty("java.io.tmpdir");
            String newPath = "";
            newPath = checkPath(path);
            String filesPath = "";
            /**
             * 随机名字加文件名字
             */
            String name = UUID.randomUUID().toString().substring(0, 10) + file.getOriginalFilename();
            File filePath = new File(newPath);
            if (!filePath.exists()) {
                filePath.mkdirs();//没有文件夹创建
            }
            file.transferTo(new File(filePath, name));
            filesPath = filePath + File.separator + name;
            return filesPath;
        } catch (Exception e) {
            return null;
        }
    }

    private String checkPath(String path) {
        String newPath = PICTUREPATH;
        int lastIndex = path.lastIndexOf("/");
        if (lastIndex == -1) {
            String spmsHome = "D:\\";
            return spmsHome + newPath;
        }
        String substring = path.substring(0, lastIndex);
        substring += "/" + newPath;
        return substring;
    }
}
