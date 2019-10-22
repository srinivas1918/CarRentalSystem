package com.pramati.crs.controller.interfaces;

import java.io.Serializable;
import java.util.List;

public interface IBaseController<E, I extends Serializable> {

	public void save(E e);
	
	public List<E> list();
	
	public E getObject(I i);
}
