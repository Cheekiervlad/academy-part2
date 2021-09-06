package by.news.dao;

import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.Statement;
import java.util.List;
import java.util.stream.Collectors;

import by.news.dao.connection_pool.ConnectionPool;

public class DBInit {

	public static void startUp() throws Exception {
		URL url1 = NewsDaoImplTest.class.getClassLoader().getResource("news_project.sql");
		URL url2 = NewsDaoImplTest.class.getClassLoader().getResource("news_data.sql");

		List<String> str1 = Files.readAllLines(Paths.get(url1.toURI()));
		List<String> str2 = Files.readAllLines(Paths.get(url2.toURI()));

		String sql1 = str1.stream().collect(Collectors.joining());
		String sql2 = str2.stream().collect(Collectors.joining());

		ConnectionPool connectionPool = ConnectionPool.getInstance();
		connectionPool.initPoolData();

		Connection con = null;
		Statement stmt = null;

		try {
			con = connectionPool.takeConnection();
			stmt = con.createStatement();
			stmt.executeUpdate(sql1);
			stmt.executeUpdate(sql2);

		} finally {
			connectionPool.closseConnection(con, stmt);
		}
	}
}
