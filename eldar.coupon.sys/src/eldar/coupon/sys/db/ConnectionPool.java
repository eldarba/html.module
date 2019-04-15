package eldar.coupon.sys.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import eldar.coupon.sys.exceptions.CouponSystemException;

/**
 * @author Eldar this class represents a pool of connections to the database.
 */
public class ConnectionPool {

	private static ConnectionPool instance;
	public static final int MAX_CONNECTIONS = 10;
	private Set<Connection> set = new HashSet<>();
	private String driverName = "";
	private String url = "";

	private ConnectionPool() throws CouponSystemException {
		try {
			Class.forName(driverName);
			for (int i = 0; i < MAX_CONNECTIONS; i++) {
				set.add(DriverManager.getConnection(url));
			}
		} catch (ClassNotFoundException e) {
			throw new CouponSystemException("driver loading failed", e);
		} catch (SQLException e) {
			throw new CouponSystemException("creating connection failed", e);
		}
	}

	public static ConnectionPool getInstance() throws CouponSystemException {
		if(instance == null) {
			instance = new ConnectionPool();
		}
		return instance;
	}
	
	public synchronized Connection getConnection() {
		while(set.isEmpty()) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		Iterator<Connection> it = set.iterator();
		Connection con = it.next();
		it.remove();
		return con;
	}
	
	public synchronized void restoreConnection(Connection con) {
		set.add(con);
		notify();
	}
	
	public void closeAllConnections() throws CouponSystemException  {
		for (Connection c : set) {
			try {
				c.close();
			} catch (SQLException e) {
				throw new CouponSystemException("closeAllConnections failed", e);
			}
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	

}
