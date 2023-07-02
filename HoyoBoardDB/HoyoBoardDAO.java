package HoyoBoardDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import util.DBManader;

public class HoyoBoardDAO {
	// 싱글톤 패턴을 위한 private 생성자
	// private으로 외부에서의 객체 생성을 막아, 클래스 내부에서 스스로 객체를 생성하고 이를 전역적으로 사용가능케 한다.
	private HoyoBoardDAO() {

	}

	// 해당 클래스의 static 변수인 instance에 해당 클래스 객체를 할당하여 해당 객체를 재사용이 가능해 진다.
	private static HoyoBoardDAO instance = new HoyoBoardDAO();

	public static HoyoBoardDAO getInstance() {
		return instance;
	}

	// 게시판의 전체 db를 리스트 형식으로 가져오기
	public List<HoyoBoardVO> selectAllBoard() {
		String sql = "select * from hoyoboard order by num desc";

		List<HoyoBoardVO> list = new ArrayList<HoyoBoardVO>();

		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;

		try {
			conn = DBManader.getConnection();
			pst = conn.prepareStatement(sql);
			rs = pst.executeQuery();

			while (rs.next()) {
				HoyoBoardVO hVo = new HoyoBoardVO();

				hVo.setNum(rs.getInt("num"));
				hVo.setPass(rs.getString("pass"));
				hVo.setName(rs.getString("name"));
				hVo.setEmail(rs.getString("email"));
				hVo.setTitle(rs.getString("title"));
				hVo.setContent(rs.getString("content"));
				hVo.setReadcount(rs.getInt("readcount"));
				hVo.setWritedate(rs.getTimestamp("writedate"));

				list.add(hVo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManader.close(conn, pst, rs);
		}

		return list;
	}

	// 게시글을 등록하기 위한 insert문
	public void insertBoard(HoyoBoardVO hVo) {
		String sql = "insert into hoyoboard (" + "num,name,email,pass,title,content)"
				+ "values(hoyoboard_seq.nextval, ?,?,?,?,?)";
		
		Connection conn=null;
		PreparedStatement pst=null;
		
		try {
			conn=DBManader.getConnection();
			pst=conn.prepareStatement(sql);
			
			pst.setString(1, hVo.getName());
			pst.setString(2, hVo.getEmail());
			pst.setString(3, hVo.getPass());
			pst.setString(4, hVo.getTitle());
			pst.setString(5, hVo.getContent());
			
			pst.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DBManader.close(conn, pst);
		}
	}
	
	//조회수(readcount)증가를 위한 메소드-제목을 선택해 hoyoboard_view를 요청할때마다 1씩 증가해야함.
	public void updateReadCount(String num) {
		String sql = "update hoyoboard set readcount=readcount+1 where num=?";
		
		Connection conn=null;
		PreparedStatement pst=null;
		
		try {
			conn=DBManader.getConnection();
			pst=conn.prepareStatement(sql);
			pst.setString(1, num);
			pst.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManader.close(conn, pst);
		}
	}
	
	//게시글 리스트에서 제목을 선택하면 게시글 상세보기로 넘어가는데, 이때의 게시글 정보를 num데이터로 불러온다.
	public HoyoBoardVO selectBoardByNum(String num) {
		String sql="select*from hoyoboard where num=?";
		
		HoyoBoardVO hVo=null;
		Connection conn=null;
		PreparedStatement pst=null;
		ResultSet rs=null;
		
		try {
			conn=DBManader.getConnection();
			pst=conn.prepareStatement(sql);
			pst.setString(1, num);
			rs=pst.executeQuery();
			
			if(rs.next()) {
				hVo= new HoyoBoardVO();
				
				hVo.setNum(rs.getInt("num"));
				hVo.setPass(rs.getString("pass"));
				hVo.setName(rs.getString("name"));
				hVo.setEmail(rs.getString("email"));
				hVo.setTitle(rs.getString("title"));
				hVo.setContent(rs.getString("content"));
				hVo.setReadcount(rs.getInt("readcount"));
				hVo.setWritedate(rs.getTimestamp("writedate"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManader.close(conn, pst, rs);
		}
		
		return hVo;
	}
	
	//게시글 수정으로 들어가 수정 버튼을 누르면 수정된 데이터를 db에 입력하는 메소드
	public void updateHoyoboard(HoyoBoardVO hVo) {
		String sql="update hoyoboard set name=?, email=?, pass=?, title=?, content=? where num=?";
		Connection conn=null;
		PreparedStatement pst=null;
		
		try {
			conn=DBManader.getConnection();
			pst=conn.prepareStatement(sql);
			pst.setString(1, hVo.getName());
			pst.setString(2, hVo.getEmail());
			pst.setString(3, hVo.getPass());
			pst.setString(4, hVo.getTitle());
			pst.setString(5, hVo.getContent());
			pst.setInt(6, hVo.getNum());
			pst.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManader.close(conn, pst);
		}
	}
	
	//게시글 삭제 버튼을 누르면 view에 저장된 게시글 데이터가 삭제된다.
	public void deleteHoyoBoard(String num) {
		String sql="delete hoyoboard where num=?";
		Connection conn=null;
		PreparedStatement pst=null;
		try {
			conn=DBManader.getConnection();
			pst=conn.prepareStatement(sql);
			pst.setString(1, num);
			pst.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManader.close(conn, pst);
		}
	}
	
	//게시글 검색을 위한 메소드
	public ArrayList<HoyoBoardVO> searchHoyoBoard(String searchName, String searchValue){
		
		ArrayList<HoyoBoardVO> list=new ArrayList<HoyoBoardVO>();
		
		
		String sql="select num, title, name, writedate, readcount from hoyoboard";
		Connection conn=null;
		PreparedStatement pst=null;
		ResultSet rs=null;
		
		try {
			
			conn=DBManader.getConnection();
			
			if(searchName.equals("name")) {
				sql+=" where name like ?";
			}else {
				sql+=" where title like ?";
			}
			
			pst=conn.prepareStatement(sql);
			pst.setString(1, "%"+searchValue+"%");
			rs=pst.executeQuery();
			
			while(rs.next()) {
				HoyoBoardVO hVo=new HoyoBoardVO();
				
				hVo.setNum(rs.getInt("num"));
				hVo.setTitle(rs.getString("title"));
				hVo.setName(rs.getString("name"));
				hVo.setWritedate(rs.getTimestamp("writedate"));
				hVo.setReadcount(rs.getInt("readcount"));
				
				list.add(hVo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			DBManader.close(conn, pst, rs);
		}
		return list;
	}
}
