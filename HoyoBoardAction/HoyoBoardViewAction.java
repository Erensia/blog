package HoyoBoardAction;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import HoyoBoardDB.HoyoBoardDAO;
import HoyoBoardDB.HoyoBoardVO;

public class HoyoBoardViewAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url="/hoyoboard/hoyoboardView.jsp";
		
		String num=request.getParameter("num");
		
		HoyoBoardDAO hDao=HoyoBoardDAO.getInstance();
		hDao.updateReadCount(num);
		
		HoyoBoardVO hVo=hDao.selectBoardByNum(num);
		request.setAttribute("board", hVo);
		
		RequestDispatcher dis=request.getRequestDispatcher(url);
		dis.forward(request, response);
		
	}

}
