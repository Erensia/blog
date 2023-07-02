package HoyoBoardAction;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import HoyoBoardDB.HoyoBoardDAO;
import HoyoBoardDB.HoyoBoardVO;

public class HoyoboardUpdateAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HoyoBoardVO hVo=new HoyoBoardVO();
		
		hVo.setNum(Integer.parseInt(request.getParameter("num")));
		hVo.setName(request.getParameter("name"));
		hVo.setPass(request.getParameter("pass"));
		hVo.setEmail(request.getParameter("email"));
		hVo.setTitle(request.getParameter("title"));
		hVo.setContent(request.getParameter("content"));
		
		HoyoBoardDAO hDao=HoyoBoardDAO.getInstance();
		hDao.updateHoyoboard(hVo);
		
		new HoyoBoardListAction().execute(request, response);

	}

}
