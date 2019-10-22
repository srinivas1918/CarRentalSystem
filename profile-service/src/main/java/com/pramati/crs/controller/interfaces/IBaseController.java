package com.pramati.crs.controller.interfaces;

import java.io.Serializable;
import java.util.List;
/**
 * @author srinivas nalla
 * @version 1.0.0
 * 
 * This interface servers the basic operations like saving entity, fetching all entities
 * and gets the Object. 
 */
public interface IBaseController<E, I extends Serializable> {

	/**
	 * 
	 * @param e: Entity to be persisted/updated
	 */
	public void save(E e);
	
	/**
	 * gets the all objects of type Entity
	 * 
	 * @return the list of all Entities
	 */
	public List<E> list();
	
	/**
	 * gets the object based the param
	 * 
	 * @param i: id of the entity to be fetched
	 * @return
	 */
	public E getObject(I i);
}
