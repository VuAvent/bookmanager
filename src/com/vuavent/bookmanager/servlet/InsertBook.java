package com.vuavent.bookmanager.servlet;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.vuavent.bookmanager.dao.BookDAO;
import com.vuavent.bookmanager.utils.FileUpdateUtil;

/**
 * Servlet implementation class InsertBook
 */
@WebServlet("/insertBook")
@MultipartConfig(
		fileSizeThreshold = 1024 * 1024 * 10,
		maxFileSize = 1024 * 1024 * 50,
		maxRequestSize = 1024 * 1024 * 100
		)

public class InsertBook extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertBook() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/insertBook.jsp");
	dispatcher.forward(request, response);
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		String name = (String) request.getParameter("name");
		String author = (String) request.getParameter("author");
		String publisher = (String) request.getParameter("publisher");
		String type = (String) request.getParameter("type");
		String language = (String) request.getParameter("language");
		String quantityStr = (String) request.getParameter("quantity");
		int quantity = Integer.parseInt(quantityStr);
		String image = (String) request.getParameter("image");
		
		BookDAO bookDAO = new BookDAO();
		bookDAO.insertBook(name, author,publisher, type, language, quantity, image );
		
		response.sendRedirect(request.getContextPath() + "/administration");

	}

}
