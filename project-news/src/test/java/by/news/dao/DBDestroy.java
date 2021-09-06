package by.news.dao;

import java.sql.Connection;
import java.sql.Statement;

import by.news.dao.connection_pool.ConnectionPool;

public class DBDestroy {
	private static final String SQL = "DROP TABLE project_news_test.news, project_news_test.news_category,"
			+ " project_news_test.news_status, project_news_test.user, project_news_test.user_role";

	public static void shutDown() throws Exception {

		ConnectionPool connectionPool = ConnectionPool.getInstance();

		Connection con = null;
		Statement stmt = null;

		try {
			con = connectionPool.takeConnection();
			stmt = con.createStatement();
			stmt.executeUpdate(SQL);

		} finally {
			connectionPool.closseConnection(con, stmt);
		}

		connectionPool.dispose();

	}

}
