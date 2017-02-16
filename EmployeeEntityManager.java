import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class EmployeeEntityManager {
	final static String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	final static String DB_URL = "jdbc:mysql://localhost/employee";
	final static String USER = "root";
	final static String PASS = "";
	static java.sql.Connection conn = null;
	static java.sql.Statement stmt = null;
	static {

		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);

		} catch (SQLException se) {

			se.printStackTrace();
		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	public static void close() {
		try {
			if (stmt != null)
				stmt.close();
		} catch (SQLException se2) {
		}
		try {
			if (conn != null)
				conn.close();
		} catch (SQLException se) {
			se.printStackTrace();
		}
	}

	public static ArrayList<Employee> Show() {
		ArrayList<Employee> list = new ArrayList<Employee>();

		try {
			stmt = conn.createStatement();
			String sql = "SELECT * FROM employee.employ;";
			ResultSet rl1 = stmt.executeQuery(sql);
			while (rl1.next()) {

				Employee emp1 = new Employee();
				emp1.setIdemployee(rl1.getInt(1));
				emp1.setName(rl1.getString(2));

				emp1.setDepartment(rl1.getString(3));
				emp1.setSalary(rl1.getInt(4));
				list.add(emp1);

			}
		} catch (Exception e) {
			System.out.println("show exception!");
		}

		return list;
	}

	public static int Delete(int id) {
		int i = 0;
		try {
			stmt = conn.createStatement();
			String sql = "DELETE FROM `employee`.`employ` WHERE `idemploye`='"
					+ id + "';";
			i = stmt.executeUpdate(sql);
		} catch (SQLException e) {
			System.out.println("delete exception");
		}

		return i;
	}

	public static int Add(Employee emp1) {
		int i = 0;
		try {

			stmt = conn.createStatement();
			String sql;
			if (emp1.getDepartment().isEmpty() || emp1.getName().isEmpty()
					|| emp1.getIdemployee() == 0 || emp1.getSalary() == -1) {
				i = -1;
				throw new Exception();
			} else {
				sql = "INSERT INTO `employee`.`employ` (`idemploye`, `name`, `department`, `salary`)"
						+ " VALUES ('"
						+ emp1.getIdemployee()
						+ "','"
						+ emp1.getName()
						+ "','"
						+ emp1.getDepartment()
						+ "','"
						+ emp1.getSalary() + "');";

				i = stmt.executeUpdate(sql);
			}
		} catch (SQLException se) {

			JOptionPane.showMessageDialog(null,"you can not insert with duplicate key!");
		} catch (Exception e) {

			JOptionPane.showMessageDialog(null,"Can't insert null value");
		}

		return i;

	}
}
