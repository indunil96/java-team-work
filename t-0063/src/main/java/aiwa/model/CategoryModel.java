package aiwa.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.ServletContext;

import aiwa.entity.Category;

public class CategoryModel {
	public ArrayList<Category> findAll(ServletContext context) {
		ArrayList<Category> result = new ArrayList<>();

		try {
			Class.forName("org.sqlite.JDBC");

			Connection conn = DriverManager
					.getConnection("jdbc:sqlite:" + context.getRealPath("WEB-INF/teamproject.db"));
			String sql = "select * from categories order by categoryid";

			PreparedStatement stmt = conn.prepareStatement(sql);

			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				Category category = new Category();
				category.setCategoryid(rs.getInt("categoryid"));
				category.setCategoryname(rs.getString("categoryname"));
				result.add(category);
			}
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}
