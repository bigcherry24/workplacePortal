package com.company.portal.service;

import com.company.portal.model.Banner;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class BannerService {

    public List<Banner> getBanners() {
        // 롤링 배너 데이터 (하드코딩 - 학습용)
        return Arrays.asList(
            new Banner("신입 사원 모집", "https://via.placeholder.com/800x400?text=Recruitment", "/recruitment"),
            new Banner("여름 휴가 공지", "https://via.placeholder.com/800x400?text=Summer+Vacation", "/vacation"),
            new Banner("회사 문화 소개", "https://via.placeholder.com/800x400?text=Company+Culture", "/culture")
        );
    }
}
