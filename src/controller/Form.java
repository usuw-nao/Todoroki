package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DaoFactory;
import domain.Account;

/**
 * Servlet implementation class Form
 */
@WebServlet("/Form")
public class Form extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/view/form.jsp")
				.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		//情報を受け取る
		String name = request.getParameter("name");
		Integer age = Integer.parseInt("age");
		String email = request.getParameter("email");
		Integer fno = Integer.parseInt("fno");

		//バリデーション

		//情報をDBに入れていく
		try {
			Account account = new Account();
			account.setName(name);
			account.setAge(age);
			account.setEmail(email);
			account.setFno(fno);
			
			IventDao iventDao = DaoFactory.createIventDao();
			iventDao.insert(ivent);
			
			
			
		
			// adultテーブルのiventの回数を一つ増やす
			Adult adult = (Adult) request.getSession().getAttribute("adult");
			DaoFactory.createAdultDao().update(adult.getId());
			

		} catch (Exception e) {
			throw new ServletException(e);
		}

	}

}
