package com.company.portal.repository.h2;

import com.company.portal.model.h2.Email;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmailRepository extends JpaRepository<Email, Long> {
    // 특정 수신자의 최신 이메일 상위 5개
    @Query(value = "SELECT * FROM emails WHERE receiver = ?1 ORDER BY received_at DESC LIMIT 5", nativeQuery = true)
    List<Email> findTop5ByReceiver(String receiver);
}
