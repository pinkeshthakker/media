package com.mediaocean.poc.dao;

import org.hibernate.criterion.Criterion;

import java.io.Serializable;
import java.util.List;

public interface AbstractDao<E, I extends Serializable> {

	/**
     * Base method to get a record by id from DB.
     * @param id
     * @return Object
     */
    E findById(I id);
    
    /**
     * This method will save or update any entity
     * @param e
     */
    void saveOrUpdate(E e);
    
    /**
     * This method will hard delete a record
     * @param e
     */
    void delete(E e);
    
    /**
     * This method will get a list of record by criteria
     * @param criterion
     * @return
     */
    List<E> findByCriteria(Criterion criterion);
	
    List<E> getUserList();
}
