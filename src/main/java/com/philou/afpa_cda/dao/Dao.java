package com.philou.afpa_cda.dao;

import java.util.List;

public interface Dao<T> {
	
	List<T> liste();
	boolean insert(T obj);
	T find(Long id);
	boolean update(T obj);
	void delete(Long id);
        long count();

}