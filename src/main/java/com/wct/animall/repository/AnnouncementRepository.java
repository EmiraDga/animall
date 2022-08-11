package com.wct.animall.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wct.animall.model.Announcement;

public interface AnnouncementRepository extends JpaRepository<Announcement, Long> {

}
