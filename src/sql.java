import java.sql.*;

public class sql {

	public static Connection getConnection() throws SQLException,
			java.lang.ClassNotFoundException {
		// 第一步：加载MySQL的JDBC的驱动
		Class.forName("com.mysql.jdbc.Driver");

		// 取得连接的url,能访问MySQL数据库的用户名,密码；jsj：数据库名
		String url = "jdbc:mysql://localhost:3306/sqltest";
		String username = "root";
		String password = "1236";

		// 第二步：创建与MySQL数据库的连接类的实例
		Connection con = DriverManager.getConnection(url, username, password);
		return con;
	}

	public static void main(String args[]) {
		try {
			// 第三步：获取连接类实例con，用con创建Statement对象类实例 sql_statement
			Connection con = getConnection();
			Statement sql_statement = con.createStatement();

			// 向表中插入数据
			String sql1 = "INSERT INTO tt (id,password) VALUES('admin','123456')";
			//删
			String sql2 = "DELETE FROM tt WHERE id='ain' ";
			//sql_statement.executeUpdate(sql2);
			
			// 查所有
			String sql3 = "select * from tt";
			//查
			String sql4 = "select * from tt WHERE id='admin'";
			//改
			String sql5 = " UPDATE tt SET password='111111' WHERE id ='ainw'";
			sql_statement.executeUpdate(sql5);
			ResultSet result = sql_statement.executeQuery(sql4);

			
			
			
			
			// 对获得的查询结果进行处理，对Result类的对象进行操作
			while (result.next()) {

				String name = result.getString("id");
				String password = result.getString("password");
				// 取得数据库中的数据
				System.out.println(" " + name + " " + password);
			}

			// 关闭连接和声明
			sql_statement.close();
			con.close();

		} catch (java.lang.ClassNotFoundException e) {
			// 加载JDBC错误,所要用的驱动没有找到
			System.err.print("ClassNotFoundException");
			// 其他错误
			System.err.println(e.getMessage());
		} catch (SQLException ex) {
			// 显示数据库连接错误或查询错误
			System.err.println("SQLException: " + ex.getMessage());
		}
	}

}



// 执行了一个sql语句生成了一个名为student的表
// sql_statement.executeUpdate("create table student (id int not null auto_increment, name varchar(20) not null default 'name', math int not null default 60, primary key (id) ); ");
