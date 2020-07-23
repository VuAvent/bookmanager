package com.vuavent.bookmanager.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.vuavent.bookmanager.bo.Book;
import com.vuavent.bookmanager.dao.BookDAO;

/**
 * Servlet implementation class UpdateBook
 */
@WebServlet("/updateBook")
public class UpdateBook extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateBook() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String idStr = (String) request.getParameter("id");
		int id = Integer.parseInt(idStr);
		
		BookDAO bookDAO = new BookDAO();
		Book bookFind = bookDAO.findById(id);		
		request.setAttribute("bookFind", bookFind);
		
		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/updateBook.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		String idStr = (String) request.getParameter("id");
		int id = Integer.parseInt(idStr);
		String name = (String) request.getParameter("name");
		String author = (String) request.getParameter("author");
		String publisher = (String) request.getParameter("publisher");
		String type = (String) request.getParameter("type");
		String language = (String) request.getParameter("language");
		String quantityStr = (String) request.getParameter("quantity");
		int quantity = Integer.parseInt(quantityStr);
		String image = (String) request.getParameter("image");
		
		BookDAO bookDAO = new BookDAO();
		bookDAO.updateBook(id,name, author,publisher, type, language, quantity, image );
		
		response.sendRedirect(request.getContextPath() + "/administration");
	}

}
