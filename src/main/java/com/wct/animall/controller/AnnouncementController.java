package com.wct.animall.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wct.animall.model.Announcement;
import com.wct.animall.repository.AnnouncementRepository;

@CrossOrigin(origins = "http://localhost:4200")
@Controller
public class AnnouncementController {

	@Autowired
	AnnouncementRepository AnnouncementRepository;

	@GetMapping("/Announcements")
	public List<Announcement> getCategories() {
		return AnnouncementRepository.findAll();
	}

	@GetMapping("/Announcement/{id}")
	public Announcement getSingleAnnouncement(@PathVariable Long id) {
		Optional<Announcement> optionalAnnouncement = AnnouncementRepository.findById(id);
		if (optionalAnnouncement.isPresent()) {
			return optionalAnnouncement.get();
		}
		return null;

	}

	// Save the announcement with its new changes
	@RequestMapping(value = "/Announcement/update")
	public void saveTheAnnouncement(@RequestBody Announcement announcement) {
		AnnouncementRepository.save(announcement);
	}

	// update the announcement
	@RequestMapping(value = "/Announcement/save")
	public void updateTheUser(Announcement a) {
		AnnouncementRepository.save(a);

	}

	// Remove announcement
	@RequestMapping(value = "/Announcement/remove/{id}")
	public void RemoveAnnouncement(@PathVariable Long id) {
		AnnouncementRepository.deleteById(id);
	}

}
