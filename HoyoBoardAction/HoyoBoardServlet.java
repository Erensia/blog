package HoyoBoardAction;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import HoyoBoardController.ActionFactory;

@WebServlet("/HoyoBoardServlet")
public class HoyoBoardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public HoyoBoardServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String command=request.getParameter("command");
		System.out.println("jsp에서 서블릿으로 전송한 command : "+command);
		
		ActionFactory af=ActionFactory.getInstance();
		Action action=af.getAction(command);
		
		if(action!=null) {
			action.execute(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		doGet(request, response);
	}

}
