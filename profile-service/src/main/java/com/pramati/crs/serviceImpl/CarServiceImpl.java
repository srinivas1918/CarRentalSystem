package com.pramati.crs.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pramati.crs.entities.Car;
import com.pramati.crs.exceptions.CarNotFoundException;
import com.pramati.crs.profiles.dto.CarDTO;
import com.pramati.crs.repository.ICarRepository;
import com.pramati.crs.service.ICarService;

@Service
public class CarServiceImpl implements ICarService{

	@Autowired
	private ICarRepository carRepository;
	
	@Override
	public void save(CarDTO carDTO) {
		Car car = new Car();
		BeanUtils.copyProperties(carDTO, car);
		carRepository.save(car);
	}

	@Override
	public List<CarDTO> list() {
		List<Car> cars = carRepository.findAll();
		return convertCarToDTO(cars);
	}

	@Override
	public CarDTO get(Long id) {
		Optional<Car> car = carRepository.findById(id);
		if(car.isPresent()) {
			CarDTO carDTO = new CarDTO();
			BeanUtils.copyProperties(car.get(), carDTO);
			return carDTO;
		}
		throw new CarNotFoundException("Car not found");
	}

	@Override
	public List<CarDTO> getCarsList(Long vendorId) {
		List<Car> cars = carRepository.findByVendorId(vendorId);
		
		return convertCarToDTO(cars);
	}
	
	private List<CarDTO> convertCarToDTO(List<Car> source){
		List<CarDTO> carDTOs = new ArrayList<CarDTO>();
		source.parallelStream().forEach(c -> {
			CarDTO carDTO = new CarDTO();
			BeanUtils.copyProperties(c, carDTO);
			carDTOs.add(carDTO);
		});
		
		return carDTOs;
	}

}
