package by.news.controllers;

import java.io.IOException;
import java.io.PrintWriter;

import by.news.beans.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ControllerLogging
 */
@WebServlet("/controllerLogging")
public class ControllerLogging extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor.
	 */
	public ControllerLogging() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		if (request.getParameter("button").equals("registration")) {
			User user = new User();
			user.setLogin(request.getParameter("login"));
			user.setPassword(request.getParameter("password"));

			if (user.getLogin().equals("") || user.getPassword().equals("")) {
				out.println("<p> заполните все поля! </p>");
			} else {
				out.println("<p> Пользователь " + user.getLogin() + " зарегестрирован! </p>");
			}

		} else {

			if (request.getParameter("login").equals("1111") && request.getParameter("password").equals("1111")) {
				out.println("<p> Авторизация прошла успешно! </p>");
			} else {
				out.println("<p> Проверьте логин или пороль! </p>");
			}

			out.close();
		}
	}

}