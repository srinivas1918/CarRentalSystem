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
import com.pramati.crs.service.IBaseService;

import io.swagger.annotations.ApiOperation;

/**
 * 
 * @author srinivas nalla
 * 
 * Abstraction for common functions
 * 
 * @param <E> : Entity 
 * @param <I> : Data Type
 * @param <T>
 */
public abstract class AbstractDataConroller<E, I extends Serializable> implements IBaseController<E, I>{


	private IBaseService<E, I> baseService;
	
	public AbstractDataConroller(IBaseService<E, I> baseService) {
		this.baseService = baseService;
	}
	
	/**
	 * @see IBaseController#save(Object)
	 * 
	 * Save/update the Entity
	 * 
	 */
	@PostMapping("/")
	@ResponseStatus(code = HttpStatus.CREATED)
	@ApiOperation(notes = "save", value = "save or updates")
	@Override
	public void save(@RequestBody E e) {
		baseService.save(e);
	}

	/**
	 * @see IBaseController#list()
	 * 
	 */
	@GetMapping("/")
	@ResponseStatus(code = HttpStatus.OK)
	@ApiOperation(notes = "list", value = "returns the List")
	@Override
	public List<E> list() {
		return baseService.list();
	}

	/**
	 * @see IBaseController#getObject(Serializable)
	 */
	@GetMapping("/{id}")
	@ResponseStatus(code = HttpStatus.OK)
	@Override
	public E getObject(@PathVariable I id) {
		return baseService.get(id);
	}
	
	
}
