package aiwa.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.ServletContext;

import aiwa.entity.Category;
import aiwa.entity.Kanji;

public class KanjiModel {

	public Kanji findById(ServletContext context, int kanjiid) {

		try {
			Class.forName("org.sqlite.JDBC");

			Connection conn = DriverManager
					.getConnection("jdbc:sqlite:" + context.getRealPath("WEB-INF/teamproject.db"));

			String sql = "select * from kanji k inner join categories c on k.categoryid = c.categoryid where kanjiid = ? ";

			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, kanjiid);

			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				Kanji kanji = new Kanji();
				kanji.setKanjiid(rs.getInt("kanjiid"));
				kanji.setKanjiname(rs.getString("kanjiname"));
				kanji.setOnyomi(rs.getString("onyomi"));
				kanji.setKunyomi(rs.getString("kunyomi"));
				kanji.setImage(rs.getString("image"));
				kanji.setStrokecount(rs.getInt("strokecount"));
				kanji.setMeaning(rs.getString("meaning"));
				kanji.setExample(rs.getString("example"));

				Category category = new Category();
				category.setCategoryid(rs.getInt("categoryId"));
				category.setCategoryname(rs.getString("categoryName"));

				kanji.setCategory(category);
				conn.close();

				return kanji;
			}

			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	public ArrayList<Kanji> findByKeywordAndCategory(ServletContext context, String word, int categoryid) {
		ArrayList<Kanji> result = new ArrayList<>();

		try {

			Class.forName("org.sqlite.JDBC");

			Connection conn = DriverManager
					.getConnection("jdbc:sqlite:" + context.getRealPath("WEB-INF/teamproject.db"));

			String sql = "select "
					+ "* "
					+ "from "
					+ "kanji k "
					+ "inner join "
					+ "categories c "
					+ "on "
					+ "k.categoryid = c.categoryid "
					+ "where "
					+ "(kanjiname like ? or meaning like ? or onyomi like ? or kunyomi like ?)";

			if (categoryid > 0) {
				sql += "and c.categoryid = ? ";
			}

			sql += "order by kanjiid";

			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, "%" + word + "%");
			stmt.setString(2, "%" + word + "%");
			stmt.setString(3, "%" + word + "%");
			stmt.setString(4, "%" + word + "%");

			if (categoryid > 0) {
				stmt.setInt(5, categoryid);
			}

			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				Kanji kanji = new Kanji();
				kanji.setKanjiid(rs.getInt("kanjiid"));
				kanji.setKanjiname(rs.getString("kanjiname"));
				kanji.setOnyomi(rs.getString("onyomi"));
				kanji.setKunyomi(rs.getString("kunyomi"));
				kanji.setImage(rs.getString("image"));
				kanji.setStrokecount(rs.getInt("strokecount"));
				kanji.setMeaning(rs.getString("meaning"));
				kanji.setExample(rs.getString("example"));

				Category category = new Category();
				category.setCategoryid(rs.getInt("categoryId"));
				category.setCategoryname(rs.getString("categoryName"));

				kanji.setCategory(category);

				result.add(kanji);
			}

			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}

	public ArrayList<Kanji> findAll(ServletContext context) {
		ArrayList<Kanji> result = new ArrayList<>();

		try {

			Class.forName("org.sqlite.JDBC");

			Connection conn = DriverManager
					.getConnection("jdbc:sqlite:" + context.getRealPath("WEB-INF/teamproject.db"));

			String sql = "select * from kanji k inner join categories c on k.categoryid = c.categoryid order by kanjiid";

			PreparedStatement stmt = conn.prepareStatement(sql);

			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				Kanji kanji = new Kanji();
				kanji.setKanjiid(rs.getInt("kanjiid"));
				kanji.setKanjiname(rs.getString("kanjiname"));
				kanji.setOnyomi(rs.getString("onyomi"));
				kanji.setKunyomi(rs.getString("kunyomi"));
				kanji.setImage(rs.getString("image"));
				kanji.setStrokecount(rs.getInt("strokecount"));
				kanji.setMeaning(rs.getString("meaning"));
				kanji.setExample(rs.getString("example"));

				Category category = new Category();
				category.setCategoryid(rs.getInt("categoryId"));
				category.setCategoryname(rs.getString("categoryName"));

				kanji.setCategory(category);

				result.add(kanji);
			}

			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}
}
