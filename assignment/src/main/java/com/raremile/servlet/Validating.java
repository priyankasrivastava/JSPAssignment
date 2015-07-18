package com.raremile.servlet;

import java.io.IOException;
import java.util.List;
import com.raremile.dal.UserDAL;
import com.raremile.entities.User;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class Validating extends HttpServlet {
	/**
	 * doPost method is used and it is calling the process method
	 */
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res)
			throws IOException, ServletException {
		process(req, res);
	}

	/**
	 * Process method is fetching the data from view and validating it
	 * 
	 * @param req
	 * @param res
	 * @throws ServletException
	 * @throws IOException
	 */
	public void process(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {

		UserDAL userdal = new UserDAL();

		String username = req.getParameter("user");
		String pass = req.getParameter("pass");
		List<User> list = userdal.getUserData(username);
		String email = null;
		String password = null;
		String role = null;
		long id = 0;
		for (User user : list) {
			email = user.getEmail();
			password = user.getPassword();
			id = user.getUserId();
			role = user.getUserRole();
		}
		if (username.equals(email)) {
			if (pass.equals(password)) {
				if (id == 1) {
					req.setAttribute("message", role);
					req.getRequestDispatcher("WEB-INF/first.jsp").forward(req,
							res);
				} else if (id == 2) {
					req.setAttribute("message", role);
					req.getRequestDispatcher("WEB-INF/second.jsp").forward(req,
							res);
				} else if (id == 3) {
					req.setAttribute("message", role);
					req.getRequestDispatcher("WEB-INF/third.jsp").forward(req,
							res);
				}
			} else {
				
				req.getRequestDispatcher("WEB-INF/error.jsp").forward(req, res);
			}

		} else {
			
			req.getRequestDispatcher("WEB-INF/error.jsp").forward(req, res);
		}

	}

}
