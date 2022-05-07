package formula;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Races extends JDialog {
	private JButton btnNewData;
	private JTextField textRaceName;
	private JTextField textDate;
	private JTextField textID;
	private JTextField textCountry;
	private JTable table;
	DefaultTableModel model;

	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Races dialog = new Races();
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	/* Create the dialog.
	 */
	public Races() {
		setBounds(100, 100, 1101, 483);
		getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 718, 347);
		getContentPane().add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int i=table.getSelectedRow();
				
				textID.setText(model.getValueAt(i, 0).toString());
				textCountry.setText(model.getValueAt(i, 1).toString());
				textRaceName.setText(model.getValueAt(i, 2).toString());
				textDate.setText(model.getValueAt(i, 3).toString());
				
			}
		});
		
		model = new DefaultTableModel();
		Object[] Column = { "Azonosító","Ország","Pályanév","Futam napja"};
		Object[] Row = new Object[4];
		model.setColumnIdentifiers(Column);
		table.setModel(model);
		scrollPane.setViewportView(table);
		
		btnNewData = new JButton("\u00DAj adat \nbeilleszt\u00E9se");
		btnNewData.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textDate.getText().equals("") || textID.getText().equals("") || textCountry.getText().equals("") || textRaceName.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Kérem minden mező kitöltését");
				}
				else {
					
					Row[0]=textID.getText();
					Row[1]=textCountry.getText();
					Row[2]=textRaceName.getText();
					Row[3]=textDate.getText();
					
					model.addRow(Row);
					
					
					textDate.setText("");
					textID.setText("");
					textCountry.setText("");
					textRaceName.setText("");
					
				}
			
			}
		});
		btnNewData.setBounds(738, 260, 150, 40);
		getContentPane().add(btnNewData);
		
		JButton btnBezar = new JButton("Bez\u00E1r\u00E1s");
		btnBezar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnBezar.setBounds(986, 410, 89, 23);
		getContentPane().add(btnBezar);
		
		JButton btnUpdate = new JButton("Adat m\u00F3dos\u00EDt\u00E1sa");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i=table.getSelectedRow();
				if(i>=0) {
				
				model.setValueAt(textID.getText(), i, 0);
				model.setValueAt(textCountry.getText(), i, 1);
				model.setValueAt(textRaceName.getText(), i, 2);
				model.setValueAt(textDate.getText(), i, 3);
				
				JOptionPane.showMessageDialog(null, "A módosítás sikeres!");
				}
				else
				{
					JOptionPane.showMessageDialog(null, "A módosításhoz válasszon ki egy sort!");
				}
			}
		});
		btnUpdate.setBounds(921, 261, 150, 40);
		getContentPane().add(btnUpdate);
		
		JButton btnDelete = new JButton("Adat t\u00F6rl\u00E9se");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i=table.getSelectedRow();
				if(i>=0) {
				model.removeRow(i);
				JOptionPane.showMessageDialog(null, "Sikeres Törlés");
				}
				else 
				{
					JOptionPane.showMessageDialog(null, "A törléshez válasszon ki egy sort");	
				}
					
				
			}
		});
		btnDelete.setBounds(738, 318, 150, 39);
		getContentPane().add(btnDelete);
		
		JButton btnClear = new JButton("Mezők törlése");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				textDate.setText("");
				textID.setText("");
				textCountry.setText("");
				textRaceName.setText("");
				
			}
		});
		btnClear.setBounds(921, 318, 150, 40);
		getContentPane().add(btnClear);
		
		JLabel lblNewLabel = new JLabel("Azonosító:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel.setBounds(738, 30, 138, 23);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNv = new JLabel("Ország:");
		lblNv.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNv.setBounds(738, 64, 138, 23);
		getContentPane().add(lblNv);
		
		JLabel lblCsapatnv = new JLabel("Pályanév:");
		lblCsapatnv.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblCsapatnv.setBounds(738, 98, 138, 23);
		getContentPane().add(lblCsapatnv);
		
		JLabel lblFutamokSzma = new JLabel("Futam napja:");
		lblFutamokSzma.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblFutamokSzma.setBounds(738, 130, 138, 23);
		getContentPane().add(lblFutamokSzma);
		
		textRaceName = new JTextField();
		textRaceName.setBounds(886, 100, 189, 20);
		getContentPane().add(textRaceName);
		textRaceName.setColumns(10);
		
		textDate = new JTextField();
		textDate.setColumns(10);
		textDate.setBounds(886, 132, 189, 20);
		getContentPane().add(textDate);
		
		textID = new JTextField();
		textID.setColumns(10);
		textID.setBounds(886, 32, 189, 20);
		getContentPane().add(textID);
		
		textCountry = new JTextField();
		textCountry.setColumns(10);
		textCountry.setBounds(886, 66, 189, 20);
		getContentPane().add(textCountry);
		
		
		
		

	}
}
