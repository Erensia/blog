package Strarail_Upload_Servlet;

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

import StarrailDB.StarrailDAO;
import StarrailDB.StarrailVO;

@WebServlet("/starrailUpdate.do")
public class starrailUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public starrailUpdateServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String name=request.getParameter("name");
		
		StarrailDAO sDao=StarrailDAO.getInstance();
		StarrailVO sVo=sDao.selectStarrailByName(name);
		
		request.setAttribute("character", sVo);
		RequestDispatcher dis=request.getRequestDispatcher("starrail/starrailUpdate.jsp");
		dis.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		ServletContext context=getServletContext();
		String path=context.getRealPath("image");
		String encType="utf-8";
		int sizeLimit=20*1024*1024;
		
		MultipartRequest multi=new MultipartRequest(request, path, sizeLimit, encType,
				new DefaultFileRenamePolicy());
		
		String name=multi.getParameter("name");
		String element=multi.getParameter("element");
		String michi=multi.getParameter("michi");
		String hoshi=multi.getParameter("hoshi");
		String wepwon=multi.getParameter("wepwon");
		int levels=Integer.parseInt(multi.getParameter("levels"));
		String picture=multi.getFilesystemName("picture");
		if(picture==null) {
			picture=multi.getParameter("nomakeimg");
		}
		int ascend=Integer.parseInt(multi.getParameter("ascend"));
		
		StarrailVO sVo=new StarrailVO();
		sVo.setName(name);
		sVo.setElement(element);
		sVo.setMichi(michi);
		sVo.setHoshi(hoshi);
		sVo.setWepwon(wepwon);
		sVo.setLevels(levels);
		sVo.setPicture(picture);
		sVo.setAscend(ascend);
		
		StarrailDAO sDao=StarrailDAO.getInstance();
		sDao.updateCharacter(sVo);
		
		response.sendRedirect("starrailList.do");
	}

}
