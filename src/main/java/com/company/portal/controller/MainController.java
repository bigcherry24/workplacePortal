package com.company.portal.controller;

import com.company.portal.service.BannerService;
import com.company.portal.service.EmailService;
import com.company.portal.service.NoticeService;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/main")
public class MainController {
    private final BannerService bannerService;
    private final EmailService emailService;
    private final NoticeService noticeService;

    public MainController(BannerService bannerService, EmailService emailService, NoticeService noticeService) {
        this.bannerService = bannerService;
        this.emailService = emailService;
        this.noticeService = noticeService;
    }

    @GetMapping
    public String main(Model model, Authentication authentication) {
        // 현재 로그인한 사용자명 가져오기
        String username = authentication.getName();

        // 롤링 배너 데이터
        model.addAttribute("banners", bannerService.getBanners());

        // 메일 top 5
        model.addAttribute("emails", emailService.getTop5Emails(username));

        // 공지 top 4
        model.addAttribute("notices", noticeService.getTop4Notices());

        return "main";
    }
}
