package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import domain.Master;

public class MasterDaoImpl implements MasterDao {
	private DataSource ds;

	public MasterDaoImpl(DataSource ds) {
		this.ds = ds;
	}

	@Override
	public List<Master> findAll() throws Exception {
		List<Master> masterList = new ArrayList<>();

		try (Connection con = ds.getConnection()) {
			String sql = "select * from master order by id DESC";
			PreparedStatement pStmt = con.prepareStatement(sql);
			ResultSet rs = pStmt.executeQuery();
			while (rs.next()) {
				masterList.add(mapToMaster(rs));
			}

		} catch (SQLException e) {
			e.printStackTrace();

		}
		return masterList;
	}

	private Master mapToMaster(ResultSet rs) throws Exception {
		Master master = new Master();
		master.setId(rs.getInt("id"));
		master.setRdate(rs.getDate("rdate"));
		master.setR08(rs.getString("r08"));
		master.setR09(rs.getString("r09"));
		master.setR10(rs.getString("r10"));
		master.setR11(rs.getString("r11"));
		master.setR12(rs.getString("r12"));
		master.setR13(rs.getString("r13"));
		master.setR14(rs.getString("r14"));
		master.setR15(rs.getString("r15"));
		master.setR16(rs.getString("r16"));
		master.setR17(rs.getString("r17"));

		return master;

	}

	@Override
	public void insert(Master master) throws Exception {
		try {
			Connection con = ds.getConnection();
			String sql = "insert into master values(?,now(),?,"
					+ "?,?,?,?,?,?,?,?,? )";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setObject(1, master.getId(), Types.INTEGER);
			stmt.setString(2, master.getR08());
			stmt.setString(3, master.getR09());
			stmt.setString(4, master.getR10());
			stmt.setString(5, master.getR11());
			stmt.setString(6, master.getR12());
			stmt.setString(7, master.getR13());
			stmt.setString(8, master.getR14());
			stmt.setString(9, master.getR15());
			stmt.setString(10, master.getR16());
			stmt.setString(11, master.getR17());

			stmt.executeUpdate();

		} catch (Exception e) {
			throw e;
		}

	}

	@Override
	public void updated(Master master) throws Exception {
		try (Connection con = ds.getConnection()) {
			String sql = "UPDATE master "
					+ " SET rdate = ?"
					+ " WHERE id = ?";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setDate(1, master.getRdate());
			stmt.setObject(2, master.getId(), Types.INTEGER);
			stmt.executeUpdate();
		} catch (Exception e) {
			throw e;
		}

	}

	@Override
	public void delete(Master master) throws Exception {
		// TODO 自動生成されたメソッド・スタブ

	}

}
