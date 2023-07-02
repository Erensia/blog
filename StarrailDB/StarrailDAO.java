package StarrailDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import util.DBManader;

public class StarrailDAO {
	private StarrailDAO() {

	}

	private static StarrailDAO instance = new StarrailDAO();

	public static StarrailDAO getInstance() {
		return instance;
	}

	public List<StarrailVO> selectAllProducts() {
		String sql = "select * from starrail order by hoshi desc";
		List<StarrailVO> list = new ArrayList<StarrailVO>();

		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			conn = DBManader.getConnection();
			pst = conn.prepareStatement(sql);
			rs = pst.executeQuery();
			while (rs.next()) {
				StarrailVO sVo = new StarrailVO();
				sVo.setName(rs.getString("name"));
				sVo.setElement(rs.getString("element"));
				sVo.setMichi(rs.getString("michi"));
				sVo.setHoshi(rs.getString("hoshi"));
				sVo.setWepwon(rs.getString("wepwon"));
				sVo.setLevels(rs.getInt("levels"));
				sVo.setPicture(rs.getString("picture"));
				sVo.setInfo(rs.getString("info"));
				sVo.setAscend(rs.getInt("ascend"));
				list.add(sVo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManader.close(conn, pst, rs);
		}
		return list;
	}

	public void insertCharacter(StarrailVO sVo) {
		String sql = "insert into starrail(name,element,michi,hoshi,wepwon,levels,picture,ascend) values(?,?,?,?,?,?,?,?)";
		Connection conn = null;
		PreparedStatement pst = null;
		try {
			conn = DBManader.getConnection();
			pst = conn.prepareStatement(sql);
			pst.setString(1, sVo.getName());
			pst.setString(2, sVo.getElement());
			pst.setString(3, sVo.getMichi());
			pst.setString(4, sVo.getHoshi());
			pst.setString(5, sVo.getWepwon());
			pst.setInt(6, sVo.getLevels());
			pst.setString(7, sVo.getPicture());
			pst.setInt(8, sVo.getAscend());
			pst.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManader.close(conn, pst);
		}
	}

	public StarrailVO selectStarrailByName(String name) {
		String sql = "select * from starrail where name=?";
		StarrailVO sVo = null;
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
					sVo = new StarrailVO();
					sVo.setName(rs.getString("name"));
					sVo.setElement(rs.getString("element"));
					sVo.setMichi(rs.getString("michi"));
					sVo.setHoshi(rs.getString("hoshi"));
					sVo.setWepwon(rs.getString("wepwon"));
					sVo.setLevels(rs.getInt("levels"));
					sVo.setPicture(rs.getString("picture"));
					sVo.setInfo(rs.getString("info"));
					sVo.setAscend(rs.getInt("ascend"));
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				DBManader.close(conn, pst, rs);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sVo;
	}
	
	public void updateCharacter(StarrailVO sVo) {
		String sql="update starrail set element=?, michi=?, hoshi=?, wepwon=?, levels=?, picture=?, ascend=? where name=?";
		Connection conn=null;
		PreparedStatement pst=null;
		try {
			conn=DBManader.getConnection();
			pst=conn.prepareStatement(sql);
			pst.setString(1, sVo.getElement());
			pst.setString(2, sVo.getMichi());
			pst.setString(3, sVo.getHoshi());
			pst.setString(4, sVo.getWepwon());
			pst.setInt(5, sVo.getLevels());
			pst.setString(6, sVo.getPicture());
			pst.setInt(7, sVo.getAscend());
			pst.setString(8, sVo.getName());
			pst.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBManader.close(conn, pst);
		}
	}
	
	public void deleteCharacter(String name) {
		String sql="delete starrail where name=?";
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
	
	public void updateCharacterInfo(StarrailVO sVo) {
		String sql="update starrail set element=?, michi=?, hoshi=?, wepwon=?, levels=?, info=? where name=?";
		Connection conn=null;
		PreparedStatement pst=null;
		try {
			conn=DBManader.getConnection();
			pst=conn.prepareStatement(sql);
			pst.setString(1, sVo.getElement());
			pst.setString(2, sVo.getMichi());
			pst.setString(3, sVo.getHoshi());
			pst.setString(4, sVo.getWepwon());
			pst.setInt(5, sVo.getLevels());
			pst.setString(6, sVo.getInfo());
			pst.setString(7, sVo.getName());
			pst.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBManader.close(conn, pst);
		}
	}
}
