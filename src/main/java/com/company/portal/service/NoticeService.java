package com.company.portal.service;

import com.company.portal.model.h2.Notice;
import com.company.portal.repository.h2.NoticeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoticeService {
    private final NoticeRepository noticeRepository;

    public NoticeService(NoticeRepository noticeRepository) {
        this.noticeRepository = noticeRepository;
    }

    public List<Notice> getTop4Notices() {
        return noticeRepository.findTop4Recent();
    }

    public void saveNotice(Notice notice) {
        noticeRepository.save(notice);
    }
}

