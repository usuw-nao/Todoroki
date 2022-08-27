package dao;

import java.util.List;

import domain.Master;

public interface MasterDao {
	List<Master> findAll() throws Exception;

	void insert(Master master) throws Exception;

	void update(Integer id) throws Exception;

	void delete(Master master) throws Exception;

}
