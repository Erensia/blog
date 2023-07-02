package HoyoBoardAction;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import HoyoBoardDB.HoyoBoardDAO;
import HoyoBoardDB.HoyoBoardVO;

public class HoyoBoardListAction implements Action{
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url="/hoyoboard/hoyoboardList.jsp";
		
		HoyoBoardDAO hDao=HoyoBoardDAO.getInstance();
		List<HoyoBoardVO> list=hDao.selectAllBoard();
		request.setAttribute("boardlist", list);
		
		RequestDispatcher dis=request.getRequestDispatcher(url);
		dis.forward(request, response);
		
	}
}
