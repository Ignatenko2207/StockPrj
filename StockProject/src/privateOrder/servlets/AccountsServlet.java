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


@WebServlet("/accounts")
public class AccountsServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		String action = request.getParameter("action");
		
		if(action.equals("createAcc")){
			String email = request.getParameter("email");
			String pass = request.getParameter("pass");
			String login = request.getParameter("login");
			String phone = request.getParameter("phone");
			String address = request.getParameter("address");
		
			Account account = new Account();
			
			try {
				Class.forName("org.postgresql.Driver");
				account = AccountDAO.getAccount(email, pass);
				
			} catch (SQLException | ClassNotFoundException e) {
				e.printStackTrace();
			}
			if(account.email.equals(email)){
				response.sendRedirect("/StockProject/index.jsp");
			} else{
				try {
					Class.forName("org.postgresql.Driver");
					AccountDAO.createAccount(login, pass, phone, address, email);
				} catch (SQLException | ClassNotFoundException e) {
					e.printStackTrace();
				}
				response.sendRedirect("jsp/usercabinet.jsp");
			}
		}
		
		
		
		
//		String email = request.getParameter("login");
//		String pass = request.getParameter("pass");
//		
//		Account account = new Account();
//		
//		try {
//			Class.forName("org.postgresql.Driver");
//			account = AccountDAO.getAccount(email, pass);
//			
//		} catch (SQLException | ClassNotFoundException e) {
//			e.printStackTrace();
//		}
//		if(account.email.equals(email)){
//			response.sendRedirect("jsp/usercabinet.jsp");
//		} else{
//			response.sendRedirect("jsp/wrongauth.jsp");
//		}
//		
		
		
	}

}
