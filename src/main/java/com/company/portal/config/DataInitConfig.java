package com.company.portal.config;

import com.company.portal.model.Email;
import com.company.portal.model.Notice;
import com.company.portal.model.User;
import com.company.portal.repository.EmailRepository;
import com.company.portal.repository.NoticeRepository;
import com.company.portal.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.LocalDateTime;

@Configuration
public class DataInitConfig {
    private final PasswordEncoder passwordEncoder;

    public DataInitConfig(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Bean
    public CommandLineRunner initData(UserRepository userRepository,
                                       EmailRepository emailRepository,
                                       NoticeRepository noticeRepository) {
        return args -> {
            // 기본 사용자 생성
            User user = new User();
            user.setUsername("user1");
            user.setPassword(passwordEncoder.encode("password123"));
            user.setName("김철수");
            user.setEmail("kim@company.com");
            user.setRole("ROLE_USER");
            userRepository.save(user);

            User admin = new User();
            admin.setUsername("admin");
            admin.setPassword(passwordEncoder.encode("admin123"));
            admin.setName("박관리");
            admin.setEmail("admin@company.com");
            admin.setRole("ROLE_ADMIN");
            userRepository.save(admin);

            // 샘플 이메일 생성
            for (int i = 1; i <= 10; i++) {
                Email email = new Email();
                email.setSender("sender" + i + "@company.com");
                email.setReceiver("user1");
                email.setSubject("[중요] 프로젝트 진행 상황 보고서 " + i);
                email.setContent("프로젝트 진행 중입니다. 상세 내용은 첨부 파일을 참조해주세요.");
                email.setIsRead(i % 3 == 0); // 일부만 읽음 표시
                email.setReceivedAt(LocalDateTime.now().minusDays(i));
                emailRepository.save(email);
            }

            // 샘플 공지사항 생성
            for (int i = 1; i <= 6; i++) {
                Notice notice = new Notice();
                notice.setTitle("공지사항 제목 " + i);
                notice.setContent("이것은 공지사항 내용입니다. 모든 직원이 숙지하시기 바랍니다.");
                notice.setAuthor("박관리");
                notice.setCreatedAt(LocalDateTime.now().minusDays(i));
                notice.setViewCount(100 - (i * 10));
                noticeRepository.save(notice);
            }
        };
    }
}
