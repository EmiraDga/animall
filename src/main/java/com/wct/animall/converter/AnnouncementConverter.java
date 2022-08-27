package com.wct.animall.converter;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wct.animall.dto.AnnouncementDto;
import com.wct.animall.dto.AnnouncementSaveDto;
import com.wct.animall.dto.AnnouncementUpdateDto;
import com.wct.animall.model.Announcement;

@Service
public class AnnouncementConverter {
	@Autowired
	private ModelMapper modelMapper;

	public AnnouncementDto convertToDto(Announcement announcement) {

		AnnouncementDto dto = modelMapper.map(announcement, AnnouncementDto.class);
		return dto;
	}

	public List<AnnouncementDto> entityToDto(List<Announcement> announcement) {
		return announcement.stream().map(x -> convertToDto(x)).collect(Collectors.toList());
	}

	public Announcement convertToEntity(AnnouncementDto dto) {
		Announcement announcement = modelMapper.map(dto, Announcement.class);
		return announcement;
	}

	// UpdateDto
	public Announcement convertToEntityUpdate(AnnouncementUpdateDto dto) {
		Announcement announcement = modelMapper.map(dto, Announcement.class);
		return announcement;
	}

	public AnnouncementDto convertToDtoUpdate(Announcement announcement) {

		AnnouncementDto dto = modelMapper.map(announcement, AnnouncementDto.class);
		return dto;
	}

	// save

	public Announcement convertToSaveEntity(AnnouncementSaveDto dto) {
		Announcement announcement = modelMapper.map(dto, Announcement.class);
		return announcement;
	}

	public AnnouncementSaveDto convertToSaveDto(Announcement announcement) {

		AnnouncementSaveDto dto = modelMapper.map(announcement, AnnouncementSaveDto.class);
		return dto;
	}

}
