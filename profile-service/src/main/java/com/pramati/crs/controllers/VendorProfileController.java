package com.pramati.crs.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pramati.crs.profiles.dto.VendorDTO;

@RestController
@RequestMapping("v1/vendors")
public class VendorProfileController extends AbstractDataConroller<VendorDTO, Long>{
}
