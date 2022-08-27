package dao;

import java.util.List;

import domain.Account;

public interface AccountDao {
	List<Account> findAll() throws Exception;

	//予約登録
	void insert(Account account) throws Exception;

}
