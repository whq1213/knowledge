import java.sql.*;

public class sql {

	public static Connection getConnection() throws SQLException,
			java.lang.ClassNotFoundException {
		// ��һ��������MySQL��JDBC������
		Class.forName("com.mysql.jdbc.Driver");

		// ȡ�����ӵ�url,�ܷ���MySQL���ݿ���û���,���룻jsj�����ݿ���
		String url = "jdbc:mysql://localhost:3306/sqltest";
		String username = "root";
		String password = "1236";

		// �ڶ�����������MySQL���ݿ���������ʵ��
		Connection con = DriverManager.getConnection(url, username, password);
		return con;
	}

	public static void main(String args[]) {
		try {
			// ����������ȡ������ʵ��con����con����Statement������ʵ�� sql_statement
			Connection con = getConnection();
			Statement sql_statement = con.createStatement();

			// ����в�������
			String sql1 = "INSERT INTO tt (id,password) VALUES('admin','123456')";
			//ɾ
			String sql2 = "DELETE FROM tt WHERE id='ain' ";
			//sql_statement.executeUpdate(sql2);
			
			// ������
			String sql3 = "select * from tt";
			//��
			String sql4 = "select * from tt WHERE id='admin'";
			//��
			String sql5 = " UPDATE tt SET password='111111' WHERE id ='ainw'";
			sql_statement.executeUpdate(sql5);
			ResultSet result = sql_statement.executeQuery(sql4);

			
			
			
			
			// �Ի�õĲ�ѯ������д�����Result��Ķ�����в���
			while (result.next()) {

				String name = result.getString("id");
				String password = result.getString("password");
				// ȡ�����ݿ��е�����
				System.out.println(" " + name + " " + password);
			}

			// �ر����Ӻ�����
			sql_statement.close();
			con.close();

		} catch (java.lang.ClassNotFoundException e) {
			// ����JDBC����,��Ҫ�õ�����û���ҵ�
			System.err.print("ClassNotFoundException");
			// ��������
			System.err.println(e.getMessage());
		} catch (SQLException ex) {
			// ��ʾ���ݿ����Ӵ�����ѯ����
			System.err.println("SQLException: " + ex.getMessage());
		}
	}

}



// ִ����һ��sql���������һ����Ϊstudent�ı�
// sql_statement.executeUpdate("create table student (id int not null auto_increment, name varchar(20) not null default 'name', math int not null default 60, primary key (id) ); ");
