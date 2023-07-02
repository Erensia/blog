package Genshin_Upload_Servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import GenshinDB.GenshinDAO;
import GenshinDB.GenshinVO;

@WebServlet("/characterList.do")
public class CharacterListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public CharacterListServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		GenshinDAO gDao=GenshinDAO.getInstance();
		List<GenshinVO> characterList=gDao.selectAllProducts();
		request.setAttribute("characterList", characterList);
		RequestDispatcher dis=request.getRequestDispatcher("character/characterList.jsp");
		dis.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
