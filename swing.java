import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class swing extends JFrame {

	private JPanel contentPane;
	public static JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					swing frame = new swing();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public swing() {
		final ArrayList<Employee> list = EmployeeEntityManager.Show();

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 315, 245);
		contentPane.add(scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);

		Object[][] data = new Object[list.size()][5];

		for (int i = 0; i < list.size(); i++) {

			data[i][0] = list.get(i).getIdemployee();
			data[i][1] = list.get(i).getName();
			data[i][2] = list.get(i).getDepartment();
			data[i][3] = list.get(i).getSalary();
			data[i][4] = "X";
		}
		String[] cname = { "ID", "Name", "Department", "salary", "delete" };

		final TableModel mymodel = new DefaultTableModel(data, cname);

		table.setModel(mymodel);

		JButton btnAdd = new JButton("ADD");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				EmployeeInsertFrame frame = new EmployeeInsertFrame();
				frame.setVisible(true);
			}
		});
		btnAdd.setBounds(335, 81, 89, 23);
		contentPane.add(btnAdd);

		JButton btnNewButton = new JButton("EDIT");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Employee emp = new Employee();
				emp = list.get(table.getSelectedRow());
				int i = EmployeeEntityManager.Delete(list.get(
						table.getSelectedRow()).getIdemployee());
				DefaultTableModel model = (DefaultTableModel) swing.table
						.getModel();
				model.removeRow(table.getSelectedRow());

				System.out.println(i);
				EmployeeEditFrame frame = new EmployeeEditFrame(emp);
				frame.setVisible(true);
			}
		});
		btnNewButton.setBounds(335, 132, 89, 23);
		contentPane.add(btnNewButton);

		JButton btnDelete = new JButton("DELETE");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					if (table.getSelectedRow() != -1) {
						int result = JOptionPane.showConfirmDialog(null,
								"Are you sure want to delete this employee?");
						if (result == JOptionPane.YES_NO_OPTION) {
							int i = EmployeeEntityManager.Delete(list.get(
									table.getSelectedRow()).getIdemployee());
							if (table.getSelectedRow() != -1) {
								((DefaultTableModel) mymodel).removeRow(table
										.getSelectedRow());
							}
							if (i == 1) {
								JOptionPane
										.showMessageDialog(null, "deleted:)");

							}
						} else {
							JOptionPane
									.showMessageDialog(null, "not deleted:(");
						}

					}

					else {
						JOptionPane.showMessageDialog(null,
								"please select a raw");
					}
				} catch (Exception e1) {
					e1.printStackTrace();
				}

			}

		});
		btnDelete.setBounds(335, 184, 89, 23);
		contentPane.add(btnDelete);

		table.addMouseListener(new MouseAdapter() {
			// @Override
			// public void mouseClicked(MouseEvent e) {
			// if (table.getSelectedColumn() == 4) {
			// try {
			// int result = JOptionPane.showConfirmDialog(null,
			// "Are you sure want to delete this employee?");
			// if (result == JOptionPane.YES_NO_OPTION) {
			// int i = EmployeeEntityManager.Delete(list.get(
			// table.getSelectedRow()).getIdemployee());
			// if (table.getSelectedRow() != -1) {
			// ((DefaultTableModel) mymodel).removeRow(table
			// .getSelectedRow());
			// }
			// if (i == 1) {
			// JOptionPane
			// .showMessageDialog(null, "deleted:)");
			//
			// }
			// } else {
			// JOptionPane
			// .showMessageDialog(null, "not deleted:(");
			// }
			//
			// } catch (Exception e2) {
			// System.out.println("please select a row");
			// }
			//
			// }
			//
			// }
		});

	}

	protected void finalize() {
		EmployeeEntityManager.close();

	}
}
