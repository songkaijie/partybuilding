package com.changfa.frame.website.service.meeting;


import com.changfa.frame.core.util.StringUtil;
import com.changfa.frame.data.dto.meeting.MeetingDTO;
import com.changfa.frame.data.entity.meeting.Meeting;
import com.changfa.frame.data.repository.meeting.MeetingRepository;
import org.apache.catalina.LifecycleState;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
@Transactional
public class MeetingService {

    private static Logger log = LoggerFactory.getLogger(MeetingService.class);


    @Autowired
    private MeetingRepository meetingRepository;


    public List<MeetingDTO> getMeetingList(Map<String, Object> map) throws ParseException {
        List<Meeting> meetingList = this.getMeetingByStatusAndTime(map);
        List<MeetingDTO> meetingDTOList = new ArrayList<>();
        for (Meeting meeting : meetingList) {
            MeetingDTO meetingDTO = new MeetingDTO();
            meetingDTO.setTheme(meeting.getTheme());
            meetingDTO.setStatus(meeting.getStatus());
            meetingDTOList.add(meetingDTO);
        }

        return null;
    }

    /* *
     * 根据状态和时间查找会议列表
     * @Author        zyj
     * @Date          2019/4/15 17:18
     * @Description
     * */
    public List<Meeting> getMeetingByStatusAndTime(Map<String, Object> map) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Calendar rightNow = Calendar.getInstance();
        String status = map.get("status") == null ? null : map.get("status").toString();
        String beginTime = map.get("beginTime") == null ? null : map.get("beginTime").toString();
        String endTime = map.get("endTime") == null ? null : map.get("endTime").toString();
        if (StringUtils.isNotBlank(endTime)) {
            rightNow.setTime(formatter.parse(endTime));
            rightNow.add(Calendar.DAY_OF_YEAR, 1);
            endTime = formatter.format(rightNow.getTime());
            rightNow.setTime(new Date());
        }

        if (StringUtils.isNotBlank(status) && StringUtils.isNotBlank(beginTime)) {
            return meetingRepository.findByStatusAndBeginTime(status, beginTime, endTime);
        }

        if (StringUtils.isNotBlank(status) && StringUtils.isBlank(beginTime)) {
            return meetingRepository.findByStatus(status);
        }
        return meetingRepository.findByBeginTime(beginTime, endTime);
    }


}
