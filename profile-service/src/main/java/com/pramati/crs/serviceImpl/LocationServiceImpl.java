package com.pramati.crs.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pramati.crs.entities.Location;
import com.pramati.crs.exceptions.LocationNotFoundException;
import com.pramati.crs.profiles.dto.LocationDTO;
import com.pramati.crs.repository.ILocationRepository;
import com.pramati.crs.service.ILocationService;

@Service
public class LocationServiceImpl implements ILocationService{

	@Autowired
	private ILocationRepository locationRepository;
	
	@Override
	public void save(LocationDTO locationDTO) {
		
		Location location = new Location();
		BeanUtils.copyProperties(locationDTO, location);
		locationRepository.save(location);
	}

	@Override
	public List<LocationDTO> list() {
		List<Location> locations = locationRepository.findAll();
		List<LocationDTO> locationDTOs = new ArrayList<LocationDTO>();
		locations.parallelStream().forEach(l -> {
			LocationDTO locationDTO = new LocationDTO();
			BeanUtils.copyProperties(l, locationDTO);
			locationDTOs.add(locationDTO);
		});
		return locationDTOs;
	}

	@Override
	public LocationDTO get(Integer id) {
		Optional<Location> location = locationRepository.findById(id);
		if(location.isPresent()) {
			LocationDTO locationDTO = new LocationDTO();
			BeanUtils.copyProperties(location, locationDTO);
			return locationDTO;
		}
		throw new LocationNotFoundException("Location Not Found");
		
	}

}
