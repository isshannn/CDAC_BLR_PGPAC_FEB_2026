package com.FoodCart.Servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.FoodCart.dao.MenuDAO;
import com.FoodCart.pojo.FoodItem;

/**
 * Servlet implementation class MenusServlet
 */
@WebServlet("/MenuServlet")
public class MenuServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		MenuDAO menu = new MenuDAO();
		List<FoodItem> menu_obj = menu.getFoodItems();
		
		
		
		request.setAttribute("menu", menu_obj);
		
		RequestDispatcher Req_dispatch = request.getRequestDispatcher("menu.jsp");
		Req_dispatch.forward(request, response);
	}

}
