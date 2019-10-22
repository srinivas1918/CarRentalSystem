package com.pramati.crs.controllers;

import java.io.Serializable;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.pramati.crs.controller.interfaces.IBaseController;

import io.swagger.annotations.ApiOperation;


public abstract class AbstractDataConroller<E, I extends Serializable> implements IBaseController<E, I>{

	@PostMapping("/")
	@ResponseStatus(code = HttpStatus.CREATED)
	@ApiOperation(notes = "save", value = "save or updates")
	@Override
	public void save(@RequestBody E e) {
		// TODO 		
	}

	@GetMapping("/")
	@ResponseStatus(code = HttpStatus.OK)
	@ApiOperation(notes = "list", value = "returns the List")
	@Override
	public List<E> list() {
		// TODO 
		return null;
	}

	@GetMapping("/{id}")
	@ResponseStatus(code = HttpStatus.OK)
	@Override
	public E getObject(@PathVariable I id) {
		// TODO 
		return null;
	}


}
