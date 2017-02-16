import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class EmployeeEditFrame extends JFrame {

	private JPanel contentPane;
	private JTextField id;
	private JTextField name;
	private JTextField dept;
	private JTextField salary;

	/**
	 * Create the frame.
	 */
	public EmployeeEditFrame(Employee employee) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 264, 298);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		panel.setBounds(0, 0, 248, 259);
		contentPane.add(panel);

		id = new JTextField();
		id.setText("");
		id.setColumns(10);
		id.setBounds(133, 31, 86, 20);
		id.setText(String.valueOf(employee.getIdemployee()));
		panel.add(id);

		JButton button = new JButton("idemployee");
		button.setBounds(10, 30, 86, 20);
		panel.add(button);

		name = new JTextField();
		name.setColumns(10);
		name.setBounds(133, 73, 86, 20);
		name.setText(employee.getName());
		panel.add(name);

		JButton button_1 = new JButton("Name");
		button_1.setBounds(10, 72, 89, 23);
		panel.add(button_1);

		dept = new JTextField();
		dept.setColumns(10);
		dept.setBounds(133, 118, 86, 20);
		dept.setText(employee.getDepartment());
		panel.add(dept);

		JButton button_2 = new JButton("Department");
		button_2.setBounds(10, 117, 89, 23);
		panel.add(button_2);

		salary = new JTextField();
		salary.setColumns(10);
		salary.setBounds(133, 167, 86, 20);
		salary.setText(String.valueOf(employee.getSalary()));
		panel.add(salary);

		JButton button_3 = new JButton("Salary");
		button_3.setBounds(10, 166, 89, 23);
		panel.add(button_3);

		JButton button_4 = new JButton("EDIT");
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Employee emp = new Employee();
				emp.setIdemployee(Integer.parseInt(id.getText()));
				emp.setName(name.getText());
				emp.setDepartment(dept.getText());
				emp.setSalary(Integer.parseInt(salary.getText()));
				if (EmployeeEntityManager.Add(emp) == 1) {
					JOptionPane.showMessageDialog(null, "EDITED:)");
					DefaultTableModel model = (DefaultTableModel) swing.table
							.getModel();
					model.addRow(new Object[] { emp.getIdemployee(),
							emp.getName(), emp.getDepartment(),
							emp.getSalary(), "x" });
					setVisible(false);
				} else {
					JOptionPane.showMessageDialog(null, "Can't Edited:(");
					setVisible(false);
				}
			}
		});
		button_4.setBounds(73, 214, 89, 23);
		panel.add(button_4);

	}
}
