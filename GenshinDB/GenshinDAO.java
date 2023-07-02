package GenshinDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import util.DBManader;

public class GenshinDAO {
	private GenshinDAO() {

	}

	private static GenshinDAO instance = new GenshinDAO();

	public static GenshinDAO getInstance() {
		return instance;
	}

	public List<GenshinVO> selectAllProducts() {
		String sql = "select * from genshin order by hoshi desc";
		List<GenshinVO> list = new ArrayList<GenshinVO>();

		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			conn = DBManader.getConnection();
			pst = conn.prepareStatement(sql);
			rs = pst.executeQuery();
			while (rs.next()) {
				GenshinVO gVo = new GenshinVO();
				gVo.setName(rs.getString("name"));
				gVo.setElement(rs.getString("element"));
				gVo.setHoshi(rs.getString("hoshi"));
				gVo.setWepwon(rs.getString("wepwon"));
				gVo.setLevels(rs.getString("levels"));
				gVo.setPicture(rs.getString("picture"));
				gVo.setInfo(rs.getString("info"));
				gVo.setAscend(rs.getInt("ascend"));
				list.add(gVo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManader.close(conn, pst, rs);
		}
		return list;
	}

	public void insertCharacter(GenshinVO gVo) {
		String sql = "insert into genshin values(?,?,?,?,?,?,?,?)";
		Connection conn = null;
		PreparedStatement pst = null;
		try {
			conn = DBManader.getConnection();
			pst = conn.prepareStatement(sql);
			pst.setString(1, gVo.getName());
			pst.setString(2, gVo.getElement());
			pst.setString(3, gVo.getHoshi());
			pst.setString(4, gVo.getWepwon());
			pst.setString(5, gVo.getLevels());
			pst.setString(6, gVo.getPicture());
			pst.setString(7, gVo.getInfo());
			pst.setInt(8, gVo.getAscend());
			pst.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManader.close(conn, pst);
		}
	}

	public GenshinVO selectGenshinByName(String name) {
		String sql = "select *from genshin where name=?";
		GenshinVO gVo = null;
		try {
			Connection conn = null;
			PreparedStatement pst = null;
			ResultSet rs = null;
			try {
				conn = DBManader.getConnection();
				pst = conn.prepareStatement(sql);
				pst.setString(1, name);
				rs = pst.executeQuery();
				if (rs.next()) {
					gVo=new GenshinVO();
					gVo.setName(rs.getString("name"));
					gVo.setElement(rs.getString("element"));
					gVo.setHoshi(rs.getString("hoshi"));
					gVo.setWepwon(rs.getString("wepwon"));
					gVo.setLevels(rs.getString("levels"));
					gVo.setPicture(rs.getString("picture"));
					gVo.setInfo(rs.getString("info"));
					gVo.setAscend(rs.getInt("ascend"));
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				DBManader.close(conn, pst, rs);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return gVo;
	}
	
	public void updateCharacter(GenshinVO gVo) {
		String sql="update genshin set element=?, hoshi=?, wepwon=?, levels=?, picture=?, ascend=? where name=?";
		Connection conn=null;
		PreparedStatement pst=null;
		try {
			conn=DBManader.getConnection();
			pst=conn.prepareStatement(sql);
			pst.setString(1, gVo.getElement());
			pst.setString(2, gVo.getHoshi());
			pst.setString(3, gVo.getWepwon());
			pst.setString(4, gVo.getLevels());
			pst.setString(5, gVo.getPicture());
			pst.setInt(6, gVo.getAscend());
			pst.setString(7, gVo.getName());
			pst.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBManader.close(conn, pst);
		}
	}
	
	public void deleteCharacter(String name) {
		String sql="delete genshin where name=?";
		Connection conn=null;
		PreparedStatement pst=null;
		try {
			conn=DBManader.getConnection();
			pst=conn.prepareStatement(sql);
			pst.setString(1, name);
			pst.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBManader.close(conn, pst);
		}
	}
	
	public void updateCharacterInfo(GenshinVO gVo) {
		String sql="update genshin set element=?, hoshi=?, wepwon=?, levels=?, info=? where name=?";
		Connection conn=null;
		PreparedStatement pst=null;
		try {
			conn=DBManader.getConnection();
			pst=conn.prepareStatement(sql);
			pst.setString(1, gVo.getElement());
			pst.setString(2, gVo.getHoshi());
			pst.setString(3, gVo.getWepwon());
			pst.setString(4, gVo.getLevels());
			pst.setString(5, gVo.getInfo());
			pst.setString(6, gVo.getName());
			pst.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBManader.close(conn, pst);
		}
	}
}
