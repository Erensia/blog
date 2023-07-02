package HoyoBoardAction;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HoyoBoardCheckPassFormAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url="/hoyoboard/hoyoboardCheckPass.jsp";
		
		RequestDispatcher dis=request.getRequestDispatcher(url);
		dis.forward(request, response);

	}

}
