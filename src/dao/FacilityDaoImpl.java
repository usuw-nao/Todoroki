package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import domain.Facility;

public class FacilityDaoImpl implements FacilityDao {
	private DataSource ds;

	public FacilityDaoImpl(DataSource ds) {
		this.ds = ds;
	}

	@Override
	public List<Facility> findAll() throws Exception {
		List<Facility> FacilityList = new ArrayList<>();

		try (Connection con = ds.getConnection()) {
			String sql = "select * from facility order by id DESC";
			PreparedStatement pStmt = con.prepareStatement(sql);
			ResultSet rs = pStmt.executeQuery();
			while (rs.next()) {
				FacilityList.add(mapToFacility(rs));
			}

		} catch (SQLException e) {
			e.printStackTrace();

		}
		return FacilityList;
	}

	private Facility mapToFacility(ResultSet rs) throws Exception {
		Facility facility = new Facility();
		facility.setId(rs.getInt("id"));
		facility.setName(rs.getString("name"));

		return facility;

	}

	@Override
	public void insert(Facility facility) throws Exception {
		try {
			Connection con = ds.getConnection();
			String sql = "insert into facility values(?,?)";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setObject(1, facility.getId(), Types.INTEGER);
			stmt.setString(2, facility.getName());

			stmt.executeUpdate();

		} catch (Exception e) {
			throw e;
		}

	}

	@Override
	public void updated(Facility facility) throws Exception {
		try (Connection con = ds.getConnection()) {
			String sql = "UPDATE facility "
					+ " SET name = ?"
					+ " WHERE id = ?";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, facility.getName());
			stmt.setObject(2, facility.getId(), Types.INTEGER);
			stmt.executeUpdate();
		} catch (Exception e) {
			throw e;
		}

	}

	@Override
	public void delete(Facility facility) throws Exception {
		// TODO 自動生成されたメソッド・スタブ
	}
}
