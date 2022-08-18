package dao;

import java.util.List;

import domain.Facility;

public interface FacilityDao {
	List<Facility> findAll() throws Exception;

	void insert(Facility facility) throws Exception;

	void updated(Facility facility) throws Exception;

	void delete(Facility facility) throws Exception;

}
