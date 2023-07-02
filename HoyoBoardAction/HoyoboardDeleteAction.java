package HoyoBoardAction;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import HoyoBoardDB.HoyoBoardDAO;

public class HoyoboardDeleteAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String num=request.getParameter("num");
		
		HoyoBoardDAO hDao=HoyoBoardDAO.getInstance();
		hDao.deleteHoyoBoard(num);
		
		new HoyoBoardListAction().execute(request, response);

	}

}
