package HoyoBoardAction;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import HoyoBoardDB.HoyoBoardDAO;
import HoyoBoardDB.HoyoBoardVO;

public class HoyoBoardCheckPassAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String url=null;
		
		String num=request.getParameter("num");
		String pass=request.getParameter("pass");
		
		HoyoBoardDAO hDao=HoyoBoardDAO.getInstance();
		HoyoBoardVO hVo=hDao.selectBoardByNum(num);
		
		if(hVo.getPass().equals(pass)) {
			url="/hoyoboard/hoyoCheckSuccess.jsp";
		}else {
			url="/hoyoboard/hoyoboardCheckPass.jsp";
			request.setAttribute("message", "비밀번호가 틀렸습니다");
		}
		
		RequestDispatcher dis=request.getRequestDispatcher(url);
		dis.forward(request, response);
	}

}
