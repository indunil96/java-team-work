package aiwa.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import aiwa.entity.Category;
import aiwa.entity.Kanji;
import aiwa.model.CategoryModel;
import aiwa.model.KanjiModel;

@WebServlet("/KanjiListController")
public class KanjiListController extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 1.PARAMETER
		String word = request.getParameter("keyword");
		if (word == null) {
			word = "";
		}

		String categoryid = request.getParameter("categoryid");
		if (categoryid == null) {
			categoryid = "0";
		}

		// 2.MODEL
		KanjiModel km = new KanjiModel();
		ArrayList<Kanji> kanjis = km.findByKeywordAndCategory(getServletContext(), word, Integer.parseInt(categoryid));

		CategoryModel cm = new CategoryModel();
		ArrayList<Category> categories = cm.findAll(getServletContext());

		// 3.VIEW
		request.setAttribute("kanjis", kanjis);
		request.setAttribute("word", word);
		request.setAttribute("categoryid", Integer.parseInt(categoryid));
		request.setAttribute("categories", categories);
		request.getRequestDispatcher("/kanjiListView.jsp").forward(request, response);
	}

}
