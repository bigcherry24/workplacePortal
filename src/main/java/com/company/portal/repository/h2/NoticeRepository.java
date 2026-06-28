package com.company.portal.repository.h2;

import com.company.portal.model.h2.Notice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NoticeRepository extends JpaRepository<Notice, Long> {
    // 최신 공지 상위 4개
    @Query(value = "SELECT * FROM notices ORDER BY created_at DESC LIMIT 4", nativeQuery = true)
    List<Notice> findTop4Recent();
}
