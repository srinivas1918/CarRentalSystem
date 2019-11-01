package com.pramati.crs.service;

import java.io.Serializable;
import java.util.List;

public interface IBaseService<E, I extends Serializable > {

	public void save(E e);
	
	public List<E> list();
	
	public E get(I i);
}
