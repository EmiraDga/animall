package com.wct.animall.service;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wct.animall.converter.AnnouncementConverter;
import com.wct.animall.dto.AnnouncementDto;
import com.wct.animall.dto.AnnouncementSaveDto;
import com.wct.animall.dto.AnnouncementUpdateDto;
import com.wct.animall.model.Announcement;
import com.wct.animall.model.User;
import com.wct.animall.repository.AnnouncementRepository;
import com.wct.animall.repository.UserRepository;

@Service
public class AnnouncementService {

	@Autowired
	AnnouncementConverter converter;

	@Autowired
	private AnnouncementRepository announcRepository;

	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private UserRepository userRepository;

	// Get all the users
	public List<AnnouncementDto> findAll() {
		List<AnnouncementDto> AnnouncementDtoList = new ArrayList<>();
		announcRepository.findAll().forEach(category -> AnnouncementDtoList.add(converter.convertToDto(category)));
		return AnnouncementDtoList;
	}

	// Get one user
	public Announcement findById(Long id) {
		return announcRepository.findById(id).get();
	}

	public void RemoveAnnouncement(Long id) {
		announcRepository.deleteById(id);
	}

	public AnnouncementSaveDto saveAnnouncementDto(AnnouncementSaveDto dto) throws Exception {
		Announcement announcement = modelMapper.map(dto, Announcement.class);
		User user = userRepository.findById(dto.getUserId()).orElseThrow(() -> new Exception("User Not found"));
		announcement.setUser(user);
		return converter.convertToSaveDto(announcRepository.save(announcement));
	}

	public AnnouncementDto updateAnnouncementDto(Long id, AnnouncementUpdateDto dto) {

		Announcement SavedAnnouncement = announcRepository.findById(id).get();
		Announcement AnnouncementToUpdate = converter.convertToEntityUpdate(dto);
		SavedAnnouncement.setState(AnnouncementToUpdate.getState());
		SavedAnnouncement.setDateCreated(AnnouncementToUpdate.getDateCreated());
		SavedAnnouncement.setLocation(AnnouncementToUpdate.getLocation());
		SavedAnnouncement.setDescription(AnnouncementToUpdate.getDescription());
		SavedAnnouncement.setUser(AnnouncementToUpdate.getUser());
		return converter.convertToDto(announcRepository.save(SavedAnnouncement));
	}

	/*
	 * private List<Announcement> announcements = new ArrayList<>();
	 * 
	 * // POST public void addAnimal(Announcement announcement) {
	 * announcements.add(announcement); }
	 * 
	 * // GET public Announcement getAnnouncement(Long id) { return
	 * announcements.stream().filter(a -> a.getId().equals(id)).findFirst().get();
	 * 
	 * }
	 * 
	 * // Return all Announcements public List<Announcement> getAllAnnouncements() {
	 * return announcements; }
	 * 
	 * // Return Single Announcement public Announcement getSignleAnnouncement(int
	 * id) { for (Announcement a : announcements) { if (a.getId() == id) return a; }
	 * return null; }
	 * 
	 * // Save the Announcement with its new changes public void
	 * saveAnnouncement(Announcement announcement) {
	 * this.announcements.add(announcement); }
	 * 
	 * // update the Announcement public void updateAnnouncement(Announcement
	 * announcement) { for (Announcement a : announcements) { if (a.getId() ==
	 * announcement.getId()) { a.setState(announcement.getState()); } } }
	 * 
	 * // Remove an Announcement public void deleteAnnouncement(int id) {
	 * announcements.remove(id); }
	 */
}
