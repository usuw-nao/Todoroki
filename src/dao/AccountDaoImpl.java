package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Types;
import java.util.List;

import javax.sql.DataSource;

import domain.Account;

public class AccountDaoImpl implements AccountDao {
	private DataSource ds;

	public AccountDaoImpl(DataSource ds) {
		this.ds = ds;
	}

	@Override
	public List<Account> findAll() throws Exception {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	@Override
	public void insert(Account account) throws Exception {
		try (Connection con = ds.getConnection()) {
			String sql = "insert into account("
					+ " name,age,email,fno,reserve,reserve_id )"
					+ " values(?,?,?,?,?,?)";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, account.getName());
			stmt.setObject(2, account.getAge(), Types.INTEGER);
			stmt.setString(3, account.getEmail());
			stmt.setObject(4, account.getFno(), Types.INTEGER);
			stmt.setString(5, account.getReserve());
			stmt.setObject(6, account.getReserveId(), Types.INTEGER);
			stmt.executeUpdate();
		} catch (Exception e) {
			throw e;
		}

	}

}
