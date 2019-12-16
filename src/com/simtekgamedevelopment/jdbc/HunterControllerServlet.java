package com.simtekgamedevelopment.jdbc;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

/**
 * Servlet implementation class HunterControllerServlet
 */
@WebServlet("/HunterControllerServlet")
public class HunterControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private HunterDbUtils dbUtil;
	@Resource(name = "jdbc/hunters")
	private DataSource dataSource;

	@Override
	public void init() throws ServletException {
		super.init();
		try {
			dbUtil = new HunterDbUtils(dataSource);
		} catch (Exception e) {
			e.getMessage();
		}
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    try {
			listHunters(request, response);
		} catch (Exception e) {
			throw new ServletException(e);
		}
	}

	private void listHunters(HttpServletRequest request, HttpServletResponse response) throws
		Exception {
		List<Hunter> hunters = dbUtil.getHunters();
		request.setAttribute("HUNTER_LIST", hunters);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/list-hunters.jsp");
		dispatcher.forward(request, response);
	}

}
