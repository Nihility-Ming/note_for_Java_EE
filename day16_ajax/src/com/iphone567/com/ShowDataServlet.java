package com.iphone567.com;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.MapHandler;

import com.iphone567.tally.tools.DBUtils;

public class ShowDataServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		response.setHeader("content-type", "text/html;charset=utf-8");
		String flname = request.getParameter("flname");
		if (flname == null && flname.trim() == "") {
			return;
		}

		QueryRunner qr = DBUtils.getQueryRunner();
		try {
			Map<String, Object> zhangwu = qr.query("select * from gjp_zhangwu where flname like ?", new MapHandler(),
					"%" + flname + "%");
			request.setAttribute("zhangwu", zhangwu);
			request.getRequestDispatcher("/table.jsp").forward(request, response);

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
