package bdd.liu.projet2024;



import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.SQLException;

public class DBConnection {
	

		private static DBConnection instance;
		private Connection connection;
		private String url = "jdbc:mysql://localhost:3306/";
		private String bdd=" DbBibliotheque";
		private String username = "root";
		private String password = "";
		//library
		public DBConnection() throws SQLException {
			//
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				this.connection = DriverManager.getConnection(url+bdd,
						username, password);
				System.out.println("Connection a la base de donnee "+bdd);
				System.out.println();
			} catch (ClassNotFoundException e) {
				System.out.println("Erreur du Driver : " + e.getMessage());
			} catch (SQLException e) {
				System.out.println("Erreur SQL : " + e.getMessage());
			}
		}
		public Connection getConnection() {
			return connection;
		}
		public static DBConnection getInstance() throws SQLException {
			if (instance == null) {
				instance = new DBConnection();
			} else if (instance.getConnection().isClosed()) {
				instance = new DBConnection();
			}
			return instance;
		}
		
		public static void main(String[] args) throws SQLException {
			DBConnection.getInstance().getConnection();
			
			
			}
		public static void cleanDB() {
			// TODO Auto-generated method stub
			
		}
		
		
		
			
		
		}

