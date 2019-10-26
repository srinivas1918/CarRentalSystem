package com.pramati.crs.serviceImpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pramati.crs.entities.City;
import com.pramati.crs.exceptions.CityNoFoundException;
import com.pramati.crs.profiles.dto.CityDTO;
import com.pramati.crs.repository.ICityRepository;
import com.pramati.crs.service.ICityService;

@Service
public class CityServiceImpl implements ICityService {

	
	@Autowired
	private ICityRepository cityRepository;
	
	@Override
	public void save(CityDTO cityDto) {
		City city = new City();
		city.setCityName(cityDto.getCityName());
		city.setCreatedOn(new Date());
		cityRepository.save(city);
	}

	@Override
	public List<CityDTO> list() {
		List<City> cities = cityRepository.findAll();
		List<CityDTO> cityDTOs = new ArrayList<CityDTO>();
		cities.parallelStream().forEach(c -> {
			CityDTO cityDTO = new CityDTO();
			BeanUtils.copyProperties(c, cityDTO);
			cityDTOs.add(cityDTO);
		});
		
		return cityDTOs;
	}

	@Override
	public CityDTO get(Integer id) {
		Optional<City> city = cityRepository.findById(id);
		if(city.isPresent()) {
			CityDTO cityDTO = new CityDTO();
			BeanUtils.copyProperties(city.get(), cityDTO);
			return cityDTO;
		}
		
		throw new CityNoFoundException("No City found");
	}

}
