package com.wct.animall.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.wct.animall.model.Announcement;
import com.wct.animall.security.service.AnnouncementService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/")
public class AnnouncementControllerAPI {

	@Autowired
	private AnnouncementService announcementService;

	/***** GET *****/
	// get all announcements
	@RequestMapping(value = "/Announcements", method = RequestMethod.GET)
	public List<Announcement> getAnnouncements() {
		return announcementService.getAllAnnouncements();
	}

	// get an animal by id
	@RequestMapping(value = "/Announcement/{id}", method = RequestMethod.POST)
	public Announcement getSingleAnnouncement(@PathVariable int id) {
		return announcementService.getSignleAnnouncement(id);
	}

	/**** POST ****/
// save
	@RequestMapping(value = "/Announcement/save", method = RequestMethod.POST)
	public void saveAnnouncement(Announcement announcement) {
		announcementService.saveAnnouncement(announcement);
	}

	/**** PUT ****/
	@RequestMapping(value = "/Announcement/update", method = RequestMethod.PUT)
	public void updateAnnouncement(@RequestBody Announcement announcement) {
		announcementService.updateAnnouncement(announcement);
	}

	/**** DELETE ****/
	@RequestMapping(value = "/Announcement/delete", method = RequestMethod.DELETE)
	public void deleteAnnouncement(int id) {
		announcementService.deleteAnnouncement(id);
	}
}
