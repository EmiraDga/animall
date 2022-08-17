package com.wct.animall.security.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.wct.animall.model.Announcement;

@Service
public class AnnouncementService {
	private List<Announcement> announcements = new ArrayList<>();

	// POST
	public void addAnimal(Announcement announcement) {
		announcements.add(announcement);
	}

	// GET
	public Announcement getAnnouncement(Long id) {
		return announcements.stream().filter(a -> a.getId().equals(id)).findFirst().get();

	}

	// Return all Announcements
	public List<Announcement> getAllAnnouncements() {
		return announcements;
	}

	// Return Single Announcement
	public Announcement getSignleAnnouncement(int id) {
		for (Announcement a : announcements) {
			if (a.getId() == id)
				return a;
		}
		return null;
	}

	// Save the Announcement with its new changes
	public void saveAnnouncement(Announcement announcement) {
		this.announcements.add(announcement);
	}

	// update the Announcement
	public void updateAnnouncement(Announcement announcement) {
		for (Announcement a : announcements) {
			if (a.getId() == announcement.getId()) {
				a.setState(announcement.getState());
			}
		}
	}

	// Remove an Announcement
	public void deleteAnnouncement(int id) {
		announcements.remove(id);
	}

}
