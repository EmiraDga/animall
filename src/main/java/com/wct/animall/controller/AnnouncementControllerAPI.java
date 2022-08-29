package com.wct.animall.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.wct.animall.converter.AnnouncementConverter;
import com.wct.animall.dto.AnnouncementDto;
import com.wct.animall.dto.AnnouncementSaveDto;
import com.wct.animall.dto.AnnouncementUpdateDto;
import com.wct.animall.model.Announcement;
import com.wct.animall.service.AnnouncementService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/")
public class AnnouncementControllerAPI {

	@Autowired
	private AnnouncementService announcementService;

	@Autowired
	private AnnouncementConverter converter;

	@GetMapping("/Announcement")
	public List<AnnouncementDto> GetAll() {
		return announcementService.findAll();
	}

	@GetMapping("/Announcement/{id}")
	public AnnouncementDto findByID(@PathVariable Long id) {
		Announcement announcement = announcementService.findById(id);
		return converter.convertToDto(announcement);
	}

	@PostMapping("/Announcement/add")
	public AnnouncementSaveDto saveAnnouncementDto(AnnouncementSaveDto dto) throws Exception {
		return announcementService.saveAnnouncementDto(dto);
	}

	@RequestMapping(value = "/Announcement/delete/{id}", method = RequestMethod.DELETE)
	public void deleteUser(Long id) {
		announcementService.RemoveAnnouncement(id);
	}

	@PutMapping("/Announcement/update/{id}")
	public AnnouncementDto updateAnnouncement(@PathVariable("id") Long id,
			@org.springframework.web.bind.annotation.RequestBody AnnouncementUpdateDto dto) {
		return announcementService.updateAnnouncementDto(id, dto);
	}

//	ConcurrentMap<Long, Announcement> annoucements = new ConcurrentHashMap<>();
//
//	/********************* ADD An Announcement ****************/
//	// POST
//	@PostMapping(value = "/Announcement/add")
//	public Announcement addAnnouncement(@RequestBody Announcement announcement) {
//		annoucements.put(announcement.getId(), announcement);
//		return announcement;
//	}
//
//	/****************** ADD An Announcement ********/
//
//	/***** GET *****/
//	// get all announcements
//	@RequestMapping(value = "/Announcements", method = RequestMethod.GET)
//	public List<Announcement> getAnnouncements() {
//		return announcementService.getAllAnnouncements();
//	}
//
//	// get an animal by id
//	@RequestMapping(value = "/Announcement/{id}", method = RequestMethod.GET)
//	public Announcement getSingleAnnouncement(@PathVariable int id) {
//		return announcementService.getSignleAnnouncement(id);
//	}
//
//	/**** POST ****/
//// save
//	@RequestMapping(value = "/Announcement/save", method = RequestMethod.POST)
//	public void saveAnnouncement(Announcement announcement) {
//		announcementService.saveAnnouncement(announcement);
//	}
//
//	/**** PUT ****/
//	@RequestMapping(value = "/Announcement/update", method = RequestMethod.PUT)
//	public void updateAnnouncement(@RequestBody Announcement announcement) {
//		announcementService.updateAnnouncement(announcement);
//	}
//
//	/**** DELETE ****/
//	@RequestMapping(value = "/Announcement/delete", method = RequestMethod.DELETE)
//	public void deleteAnnouncement(int id) {
//		announcementService.deleteAnnouncement(id);
//	}
}
