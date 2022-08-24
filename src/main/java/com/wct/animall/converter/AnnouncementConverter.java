package com.wct.animall.converter;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wct.animall.dto.AnnouncemetDto;
import com.wct.animall.model.Announcement;

@Service
public class AnnouncementConverter {
	@Autowired
	private ModelMapper modelMapper;

	public AnnouncemetDto convertToDto(Announcement announcement) {

		AnnouncemetDto dto = modelMapper.map(announcement, AnnouncemetDto.class);
		return dto;
	}

	public List<AnnouncemetDto> entityToDto(List<Announcement> announcement) {
		return announcement.stream().map(x -> convertToDto(x)).collect(Collectors.toList());
	}

	public Announcement convertToEntity(AnnouncemetDto dto) {
		Announcement announcement = modelMapper.map(dto, Announcement.class);
		return announcement;
	}
}
