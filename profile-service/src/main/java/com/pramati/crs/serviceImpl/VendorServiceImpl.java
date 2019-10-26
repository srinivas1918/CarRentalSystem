package com.pramati.crs.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pramati.crs.entities.Vendor;
import com.pramati.crs.exceptions.VendorNotFoundException;
import com.pramati.crs.profiles.dto.VendorDTO;
import com.pramati.crs.repository.IVendorRepository;
import com.pramati.crs.service.IVendorService;

@Service
public class VendorServiceImpl implements IVendorService{

	@Autowired
	private IVendorRepository vendorRepository;
	
	@Override
	public void save(VendorDTO vendorDTO) {
		Vendor vendor = new Vendor();
		BeanUtils.copyProperties(vendorDTO, vendor);
		vendorRepository.save(vendor);
	}

	@Override
	public List<VendorDTO> list() {
		List<Vendor> vendors = vendorRepository.findAll();
		List<VendorDTO> vendorDTOs = new ArrayList<VendorDTO>();
		vendors.parallelStream().forEach(v -> {
			VendorDTO vendorDTO = new VendorDTO();
			BeanUtils.copyProperties(v, vendorDTO);
			vendorDTOs.add(vendorDTO);
		});
		
		return vendorDTOs;
	}

	@Override
	public VendorDTO get(Long id) {
		Optional<Vendor> vendor = vendorRepository.findById(id);
		if(vendor.isPresent()) {
			VendorDTO vendorDTO = new VendorDTO();
			BeanUtils.copyProperties(vendor.get(), vendorDTO);
			return vendorDTO;
		}
		throw new VendorNotFoundException("Vendor not found");
	}

}
