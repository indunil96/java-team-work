package aiwa.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import aiwa.entity.Kanji;
import aiwa.model.KanjiModel;

@WebServlet("/KanjiDetailController")
public class KanjiDetailController extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 1.PARAMETER
		String kanjiid = request.getParameter("kanjiid");

		// 2.MODEL
		KanjiModel km = new KanjiModel();
		Kanji kanji = km.findById(getServletContext(), Integer.parseInt(kanjiid));

		// 3.VIEW
		request.setAttribute("kanji", kanji);
		request.getRequestDispatcher("/kanjiDetailView.jsp").forward(request, response);
	}

}
