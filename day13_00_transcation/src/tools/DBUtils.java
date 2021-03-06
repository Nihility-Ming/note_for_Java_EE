package tools;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

public class DBUtils {

	// 事务是基于连接的。不同用户用同一个事务，用单例设计有问题，解决办法Continue。。。
	private static Connection connection;

	static {
		try {
			Properties properties = getDBProperties();

			String driverClass = properties.getProperty("driverClass");
			String url = properties.getProperty("url");
			String user = properties.getProperty("user");
			String password = properties.getProperty("password");

			Class.forName(driverClass);
			connection = DriverManager.getConnection(url, user, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static Properties getDBProperties() {
		try {
			Properties properties = new Properties();
			InputStream inStream = DBUtils.class.getClassLoader().getResourceAsStream("database.properties");
			properties.load(inStream);
			return properties;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	public static Connection getConnection() {
		return connection;
	}

	public static void closeAll(Connection conn, Statement stm, ResultSet re) {
		try {
			if (conn != null)
				conn.close();
			if(!(stm instanceof PreparedStatement)) {
				if (stm != null && !stm.isClosed())
					stm.close();
			}
			if (re != null && !re.isClosed())
				re.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
