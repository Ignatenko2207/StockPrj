package privateOrder.servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sun.net.httpserver.spi.HttpServerProvider;

import privateOrder.DAO.GoodDAO;
import privateOrder.domain.Good;


@WebServlet("/goods")
public class GoodsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public GoodsServlet() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// get filters
		String filtr = "";
		boolean filtrIsEmpty = true;
		
	
		
		String groupOfGoods = (String) request.getParameter("groupOfGoods");
		if(groupOfGoods!=null & !groupOfGoods.isEmpty()){
			if(filtrIsEmpty){
				filtrIsEmpty = false;
				filtr += " WHERE goodgroup='"+groupOfGoods+"'";
			} else{
				filtr += " AND goodgroup='"+groupOfGoods+"'";
			}
		}
		
		String maker = (String) request.getParameter("maker");
		if(maker!=null & !maker.isEmpty()){
			if(filtrIsEmpty){
				filtrIsEmpty = false;
				filtr += " WHERE maker='"+maker+"'";
			} else{
				filtr += " AND maker='"+maker+"'";
			}
		}
		String colorCode = (String) request.getParameter("colorCode");
		if(colorCode!=null & !colorCode.isEmpty()){
			if(filtrIsEmpty){
				filtrIsEmpty = false;
				filtr += " WHERE code='"+colorCode+"'";
			} else{
				filtr += " AND code='"+colorCode+"'";
			}
		}
		String strSizeL = (String) request.getParameter("sizeL");
		if(strSizeL!=null & !strSizeL.isEmpty()){
			int sizeL = Integer.valueOf(strSizeL);
			if(filtrIsEmpty){
				filtrIsEmpty = false;
				filtr += " WHERE sizel>='"+sizeL+"'";
			} else{
				filtr += " AND sizel>='"+sizeL+"'";
			}
		}
		String strSizeH = (String) request.getParameter("strSizeH");
		if(strSizeH!=null & !strSizeH.isEmpty()){
			int sizeH = Integer.valueOf(strSizeH);
			if(filtrIsEmpty){
				filtrIsEmpty = false;
				filtr += " WHERE sizeh>='"+sizeH+"'";
			} else{
				filtr += " AND sizeh>='"+sizeH+"'";
			}
		}
		
		String strSizeW = (String) request.getParameter("strSizeW");
		if(strSizeW!=null & !strSizeW.isEmpty()){
			int sizeW = Integer.valueOf(strSizeW);
			if(filtrIsEmpty){
				filtrIsEmpty = false;
				filtr += " WHERE sizew>='"+sizeW+"'";
			} else{
				filtr += " AND sizew='"+sizeW+"'";
			}
		}
		
		String strLowPrice = (String) request.getParameter("strLowPrice");
		if(strLowPrice!=null & !strLowPrice.isEmpty()){
			int lowPrice = Integer.valueOf(strLowPrice);
			if(filtrIsEmpty){
				filtrIsEmpty = false;
				filtr += " WHERE price>='"+lowPrice+"'";
			} else{
				filtr += " AND price>='"+lowPrice+"'";
			}
		}
		
		String strHighPrice = (String) request.getParameter("strHighPrice");
		if(strHighPrice!=null & !strHighPrice.isEmpty()){
			int highPrice = Integer.valueOf(strHighPrice);
			if(filtrIsEmpty){
				filtrIsEmpty = false;
				filtr += " WHERE price<='"+highPrice+"'";
			} else{
				filtr += " AND price<='"+highPrice+"'";
			}
		}

		
		HttpSession session = request.getSession();
		session.setAttribute("filtr", filtr);
		RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
		dispatcher.forward(request, response);
		
		
		
	}

}
