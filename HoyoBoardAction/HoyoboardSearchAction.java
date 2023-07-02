package HoyoBoardAction;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import HoyoBoardDB.HoyoBoardDAO;
import HoyoBoardDB.HoyoBoardVO;

public class HoyoboardSearchAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url="/hoyoboard/hoyoboardList.jsp";
		
		String searchName=request.getParameter("searchName");
		String searchValue=request.getParameter("searchValue");
		
		HoyoBoardDAO hDao=HoyoBoardDAO.getInstance();
		ArrayList<HoyoBoardVO>list=hDao.searchHoyoBoard(searchName, searchValue);
		
		System.out.println(list);
		
		request.setAttribute("boardlist", list);
		RequestDispatcher dis=request.getRequestDispatcher(url);
		dis.forward(request, response);

	}

}
