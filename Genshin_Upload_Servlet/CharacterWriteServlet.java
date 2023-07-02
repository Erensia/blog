package Genshin_Upload_Servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import GenshinDB.GenshinDAO;
import GenshinDB.GenshinVO;

@WebServlet("/characterWrite.do")
public class CharacterWriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public CharacterWriteServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dis=request.getRequestDispatcher("character/characterWrite.jsp");
		dis.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		ServletContext context=getServletContext();
		String path=context.getRealPath("image");
		String encType="utf-8";
		int sizeLimit=20*1024*1024;
		
		MultipartRequest multi=new MultipartRequest(request, path, sizeLimit,
				encType, new DefaultFileRenamePolicy());
		
		String name=multi.getParameter("name");
		String element=multi.getParameter("element");
		String hoshi=multi.getParameter("hoshi");
		String wepwon=multi.getParameter("wepwon");
		String levels=multi.getParameter("levels");
		String picture=multi.getFilesystemName("picture");
		int ascend=Integer.parseInt(multi.getParameter("ascend"));
		
		GenshinVO gVo=new GenshinVO();
		gVo.setName(name);
		gVo.setElement(element);
		gVo.setHoshi(hoshi);
		gVo.setWepwon(wepwon);
		gVo.setLevels(levels);
		gVo.setPicture(picture);
		gVo.setAscend(ascend);
		
		GenshinDAO gDao=GenshinDAO.getInstance();
		gDao.insertCharacter(gVo);
		
		response.sendRedirect("characterList.do");
	}

}
