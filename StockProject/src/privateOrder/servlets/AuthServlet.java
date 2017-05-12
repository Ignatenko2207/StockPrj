package privateOrder.servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import privateOrder.DAO.AccountDAO;
import privateOrder.domain.Account;


@WebServlet("/authorisation")
public class AuthServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		String email = request.getParameter("login");
		String pass = request.getParameter("pass");
		
		Account account = new Account();
		
		try {
			Class.forName("org.postgresql.Driver");
			account = AccountDAO.getAccount(email, pass);
			
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		if(account.email.equals(email)){
			response.sendRedirect("jsp/usercabinet.jsp");
		} else{
			response.sendRedirect("jsp/wrongauth.jsp");
		}
		
		
		
	}

}
