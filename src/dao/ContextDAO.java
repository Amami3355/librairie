package dao;

import jakarta.servlet.ServletContext;

public class ContextDAO {
	protected static String dbUrl;
	protected static String dbLogin;
	protected static String dbPassword;
	
	
	public static void init(ServletContext context) throws ClassNotFoundException {
		
		Class.forName(context.getInitParameter("JDBC_DRIVER"));
		dbUrl = context.getInitParameter("JDBC_URL");
		dbLogin = context.getInitParameter("JDBC_LOGIN");
		dbPassword = context.getInitParameter("JDBC_PASSWORD");
	}
}
