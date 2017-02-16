import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class EmployeeInsertFrame extends JFrame {

	private JPanel contentPane;
	private JTextField id;
	private JTextField name;
	private JTextField dept;
	private JTextField salary;

	/**
	 * Create the frame.
	 */
	public EmployeeInsertFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 276, 297);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		id = new JTextField();
		id.setText("");
		id.setBounds(133, 31, 86, 20);
		contentPane.add(id);
		id.setColumns(10);

		JButton idemployee = new JButton("idemployee");
		idemployee.setBounds(10, 30, 86, 20);
		contentPane.add(idemployee);

		name = new JTextField();
		name.setBounds(133, 73, 86, 20);
		contentPane.add(name);
		name.setColumns(10);

		JButton Name = new JButton("Name");
		Name.setBounds(10, 72, 89, 23);
		contentPane.add(Name);

		dept = new JTextField();
		dept.setBounds(133, 118, 86, 20);
		contentPane.add(dept);
		dept.setColumns(10);

		JButton btnDepartment = new JButton("Department");
		btnDepartment.setBounds(10, 117, 89, 23);
		contentPane.add(btnDepartment);

		salary = new JTextField();
		salary.setBounds(133, 167, 86, 20);
		contentPane.add(salary);
		salary.setColumns(10);

		JButton btnSalary = new JButton("Salary");
		btnSalary.setBounds(10, 166, 89, 23);
		contentPane.add(btnSalary);

		JButton btnInsert = new JButton("Insert");
		btnInsert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Employee emp = new Employee();
					emp.setIdemployee(Integer.parseInt(id.getText()));
					emp.setName(name.getText());
					emp.setDepartment(dept.getText());
					emp.setSalary(Integer.parseInt(salary.getText()));
					if (EmployeeEntityManager.Add(emp) == 1) {
						JOptionPane.showMessageDialog(null, "Inserted:)");
						DefaultTableModel model = (DefaultTableModel) swing.table
								.getModel();
						model.addRow(new Object[] { emp.getIdemployee(),
								emp.getName(), emp.getDepartment(),
								emp.getSalary(), "x" });
						setVisible(false);
					}
				} catch (NumberFormatException e2) {
					JOptionPane.showMessageDialog(null,
							"Can't insert bad value for idEmployee "
									+ "and salary value");
				}
			}
		});
		btnInsert.setBounds(73, 214, 89, 23);
		contentPane.add(btnInsert);
	}
}
