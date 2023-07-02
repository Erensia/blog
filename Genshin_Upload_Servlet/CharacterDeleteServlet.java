package Genshin_Upload_Servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import GenshinDB.GenshinDAO;
import GenshinDB.GenshinVO;

@WebServlet("/characterDelete.do")
public class CharacterDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public CharacterDeleteServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name=request.getParameter("name");
		
		GenshinDAO gDao=GenshinDAO.getInstance();
		GenshinVO gVo=gDao.selectGenshinByName(name);
		
		request.setAttribute("character", gVo);
		RequestDispatcher dis=request.getRequestDispatcher("character/characterDelete.jsp");
		dis.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String name=request.getParameter("name");
		GenshinDAO gDao=GenshinDAO.getInstance();
		gDao.deleteCharacter(name);
		
		response.sendRedirect("characterList.do");
	}

}
