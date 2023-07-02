package Strarail_Upload_Servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import StarrailDB.StarrailDAO;
import StarrailDB.StarrailVO;

@WebServlet("/starrailDelete.do")
public class StarrailDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public StarrailDeleteServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name = request.getParameter("name");

		StarrailDAO sDao = StarrailDAO.getInstance();
		StarrailVO sVo = sDao.selectStarrailByName(name);

		request.setAttribute("character", sVo);
		RequestDispatcher dis = request.getRequestDispatcher("starrail/starrailDelete.jsp");
		dis.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");

		String name = request.getParameter("name");
		StarrailDAO sDao = StarrailDAO.getInstance();
		sDao.deleteCharacter(name);

		response.sendRedirect("starrailList.do");
	}

}
