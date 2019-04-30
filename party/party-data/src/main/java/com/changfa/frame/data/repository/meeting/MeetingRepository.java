package com.changfa.frame.data.repository.meeting;

import com.changfa.frame.data.entity.meeting.Meeting;
import com.changfa.frame.data.repository.AdvancedJpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MeetingRepository extends AdvancedJpaRepository<Meeting, Integer> {


    @Query(value = "select * from meeting where status=?1 and begin_time between ?2 and ?3 order by begin_time desc ", nativeQuery = true)
    List<Meeting> findByStatusAndBeginTime(String status, String beginTime, String endTime);

    @Query(value = "select * from meeting where status=?1 order by begin_time desc ", nativeQuery = true)
    List<Meeting> findByStatus(String status);

    @Query(value = "select * from meeting where begin_time between ?1 and ?2 order by begin_time desc ", nativeQuery = true)
    List<Meeting> findByBeginTime(String beginTime, String endTime);

}
