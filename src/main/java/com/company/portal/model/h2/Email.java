package com.company.portal.model.h2;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "emails")
public class Email {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String sender;

    @Column(nullable = false)
    private String subject;

    @Column(columnDefinition = "TEXT")
    private String content;

    @Column(nullable = false)
    private Boolean isRead = false;

    private LocalDateTime receivedAt;

    @Column(nullable = false)
    private String receiver; // 받는 사람

    @PrePersist
    public void prePersist() {
        this.receivedAt = LocalDateTime.now();
    }

    // Getters
    public Long getId() {
        return id;
    }

    public String getSender() {
        return sender;
    }

    public String getSubject() {
        return subject;
    }

    public String getContent() {
        return content;
    }

    public Boolean getIsRead() {
        return isRead;
    }

    public LocalDateTime getReceivedAt() {
        return receivedAt;
    }

    public String getReceiver() {
        return receiver;
    }

    // Setters
    public void setId(Long id) {
        this.id = id;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setIsRead(Boolean isRead) {
        this.isRead = isRead;
    }

    public void setReceivedAt(LocalDateTime receivedAt) {
        this.receivedAt = receivedAt;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }
}

