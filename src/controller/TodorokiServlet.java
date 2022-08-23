package controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DaoFactory;
import dao.MasterDao;
import domain.Master;

/**
 * Servlet implementation class TodorokiServlet
 */
@WebServlet("/Todoroki")
public class TodorokiServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			MasterDao masterDao = DaoFactory.createMasterDao();
			List<Master> masterList = masterDao.findAll();
			request.setAttribute("masterList", masterList);

			//指定された日付けのイベント時間帯も表示
			String rdate = request.getParameter("rdate");
			if (rdate != null) {
				List<Master> planList = new ArrayList<>();
				SimpleDateFormat sdf = new SimpleDateFormat("y-MM-dd");
				for (Master master : masterList) {
					if (sdf.format(master.getRdate()).equals(rdate)) {
						planList.add(master);
					}
				}
				request.setAttribute("planList", planList);
				if (planList.size() == 0) {
					request.setAttribute("planMessage", "予定はありません");
				}

			}
			request.getRequestDispatcher("/WEB-INF/view/Todoroki.jsp")
					.forward(request, response);
		} catch (Exception e) {
			throw new ServletException(e);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
