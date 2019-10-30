package com.pramati.crs.service;

import java.util.List;

import com.pramati.crs.profiles.dto.CarDTO;

public interface ICarService extends IBaseService<CarDTO, Long>{
	List<CarDTO> getCarsList(Long vendorId);
}
