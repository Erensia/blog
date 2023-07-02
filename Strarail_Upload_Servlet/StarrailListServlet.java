package Strarail_Upload_Servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import StarrailDB.StarrailDAO;
import StarrailDB.StarrailVO;

@WebServlet("/starrailList.do")
public class StarrailListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public StarrailListServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		StarrailDAO sDao=StarrailDAO.getInstance();
		List<StarrailVO> list=sDao.selectAllProducts();
		request.setAttribute("character", list);
		RequestDispatcher dis=request.getRequestDispatcher("starrail/characterList.jsp");
		dis.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
