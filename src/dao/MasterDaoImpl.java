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
			String sql = "select * from master ";
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
		master.setName(rs.getString("name"));
		master.setRdate(rs.getDate("rdate"));
		master.setR08(rs.getInt("r08"));
		master.setR09(rs.getInt("r09"));
		master.setR10(rs.getInt("r10"));
		master.setR11(rs.getInt("r11"));
		master.setR12(rs.getInt("r12"));
		master.setR13(rs.getInt("r13"));
		master.setR14(rs.getInt("r14"));
		master.setR15(rs.getInt("r15"));
		master.setR16(rs.getInt("r16"));
		master.setR17(rs.getInt("r17"));

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
			stmt.setObject(2, master.getR08(), Types.INTEGER);
			stmt.setObject(3, master.getR09(), Types.INTEGER);
			stmt.setObject(4, master.getR10(), Types.INTEGER);
			stmt.setObject(5, master.getR11(), Types.INTEGER);
			stmt.setObject(6, master.getR12(), Types.INTEGER);
			stmt.setObject(7, master.getR13(), Types.INTEGER);
			stmt.setObject(8, master.getR14(), Types.INTEGER);
			stmt.setObject(9, master.getR15(), Types.INTEGER);
			stmt.setObject(10, master.getR16(), Types.INTEGER);
			stmt.setObject(11, master.getR17(), Types.INTEGER);

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
