import java.sql.*;

public class DBConnection {
	Connection con;
	Statement stmt;
	
	public Connection getCon() {
		return con;
	}
	public void setCon(Connection con) {
		this.con = con;
	}
	public Statement getStmt() {
		return stmt;
	}
	public void setStmt(Statement stmt) {
		this.stmt = stmt;
	}
	
	public DBConnection() {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			try {
				String url = "jdbc:sqlserver://DESKTOP-BOSLAKJ\\SQLEXPRESS:1433;databaseName=QuanLy;integratedSecurity=true;";
				this.con = DriverManager.getConnection(url);
				this.stmt = con.createStatement();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public void main(String [] args) {
		try {
			DBConnection condb = new DBConnection();
			ResultSet rs = condb.getStmt().executeQuery("select * from SinhVien inner join DeTai on SinhVien.MaSV=DeTai.MaSV");
			
			//them du lieu vao csdl cho cac bang
			while (rs.next()) {
				System.out.println(rs.getString(1));
				System.out.println(rs.getString(2));
				System.out.println(rs.getString(3));
				System.out.println(rs.getString(4));
				System.out.println(rs.getString(5));
				System.out.println(rs.getString(6));
				System.out.println(rs.getString(7));
				System.out.println(rs.getString(8));
				System.out.println(rs.getString(9));
				System.out.println(rs.getString(10));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
