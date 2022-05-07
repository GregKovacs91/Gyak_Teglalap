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
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStreamReader;

public class Check extends JDialog {
	private JButton btnNewData;
	private JTextField textWins;
	private JTextField textRaceNumber;
	private JTextField textName;
	private JTextField textTeamName;
	private JTextField textRaces;
	private JTextField textDebut;
	private JTable table;
	DefaultTableModel model;

	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Check dialog = new Check();
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
/*	File csv_file=new File("versenyzok.csv");
	DefaultTableModel csv_data=new DefaultTableModel();
	
	try {
		
		InputStreamReader inputStreamReader= new InputStreamReader(new FileInputStream(csv_file));
		CSVParser csvParser = CSVFormat.DEFAULT.parse(inputStreamReader);
		for(CSVRecord csvRecord:csvParser) {
			if(start==0) {
				start=0;
				csv_data.addColumn(csvRecord.get(0));
				csv_data.addColumn(csvRecord.get(1));
				csv_data.addColumn(csvRecord.get(2));
				csv_data.addColumn(csvRecord.get(3));
				csv_data.addColumn(csvRecord.get(4));
				csv_data.addColumn(csvRecord.get(5));
				csv_data.addColumn(csvRecord.get(6));
			}
			else
		}
		
	}catch (Exception e) {
		System.out.println("Hiba a fájl betöltésnél");
	}
	*/
	public Check() {
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
				textRaceNumber.setText(model.getValueAt(i, 0).toString());
				textName.setText(model.getValueAt(i, 1).toString());
				textTeamName.setText(model.getValueAt(i, 2).toString());
				textRaces.setText(model.getValueAt(i, 3).toString());
				textWins.setText(model.getValueAt(i, 4).toString());
				textDebut.setText(model.getValueAt(i, 5).toString());
			}
		});
		
		model = new DefaultTableModel();
		Object[] Column = { "Rajtszám","Név","Csapatnév","Versenyek száma","Győzelmek száma","Debütálás"};
		Object[] Row = new Object[6];
		model.setColumnIdentifiers(Column);
		table.setModel(model);
		scrollPane.setViewportView(table);
		

		
		btnNewData = new JButton("\u00DAj adat \nbeilleszt\u00E9se");
		btnNewData.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textRaceNumber.getText().equals("") || textName.getText().equals("") || textTeamName.getText().equals("") || textRaces.getText().equals("") || textWins.getText().equals("") || textDebut.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Kérem minden mező kitöltését");
				}
				else {
					Row[0]=textRaceNumber.getText();
					Row[1]=textName.getText();
					Row[2]=textTeamName.getText();
					Row[3]=textRaces.getText();
					Row[4]=textWins.getText();
					Row[5]=textDebut.getText();
					model.addRow(Row);
					
					textRaceNumber.setText("");
					textName.setText("");
					textTeamName.setText("");
					textRaces.setText("");
					textWins.setText("");
					textDebut.setText("");	
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
				model.setValueAt(textRaceNumber.getText(), i, 0);
				model.setValueAt(textName.getText(), i, 1);
				model.setValueAt(textTeamName.getText(), i, 2);
				model.setValueAt(textRaces.getText(), i, 3);
				model.setValueAt(textWins.getText(), i, 4);
				model.setValueAt(textDebut.getText(), i, 5);
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
				textRaceNumber.setText("");
				textName.setText("");
				textTeamName.setText("");
				textRaces.setText("");
				textWins.setText("");
				textDebut.setText("");	
			}
		});
		btnClear.setBounds(921, 318, 150, 40);
		getContentPane().add(btnClear);
		
		JLabel lblNewLabel = new JLabel("Rajtsz\u00E1m:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel.setBounds(738, 30, 138, 23);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNv = new JLabel("N\u00E9v:");
		lblNv.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNv.setBounds(738, 64, 138, 23);
		getContentPane().add(lblNv);
		
		JLabel lblCsapatnv = new JLabel("Csapatn\u00E9v:");
		lblCsapatnv.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblCsapatnv.setBounds(738, 98, 138, 23);
		getContentPane().add(lblCsapatnv);
		
		JLabel lblFutamokSzma = new JLabel("Futamok sz\u00E1ma:");
		lblFutamokSzma.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblFutamokSzma.setBounds(738, 130, 138, 23);
		getContentPane().add(lblFutamokSzma);
		
		JLabel lblGyzelmek = new JLabel("Gy\u0151zelmek sz\u00E1ma:");
		lblGyzelmek.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblGyzelmek.setBounds(738, 164, 138, 23);
		getContentPane().add(lblGyzelmek);
		
		JLabel lblDebtls = new JLabel("Deb\u00FCt\u00E1l\u00E1s:");
		lblDebtls.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblDebtls.setBounds(738, 198, 138, 23);
		getContentPane().add(lblDebtls);
		
		textWins = new JTextField();
		textWins.setBounds(886, 166, 189, 20);
		getContentPane().add(textWins);
		textWins.setColumns(10);
		
		textRaceNumber = new JTextField();
		textRaceNumber.setColumns(10);
		textRaceNumber.setBounds(886, 30, 189, 20);
		getContentPane().add(textRaceNumber);
		
		textName = new JTextField();
		textName.setColumns(10);
		textName.setBounds(886, 66, 189, 20);
		getContentPane().add(textName);
		
		textTeamName = new JTextField();
		textTeamName.setColumns(10);
		textTeamName.setBounds(886, 98, 189, 20);
		getContentPane().add(textTeamName);
		
		textRaces = new JTextField();
		textRaces.setColumns(10);
		textRaces.setBounds(886, 132, 189, 20);
		getContentPane().add(textRaces);
		
		textDebut = new JTextField();
		textDebut.setColumns(10);
		textDebut.setBounds(886, 200, 189, 20);
		getContentPane().add(textDebut);
		
		
		
		

	}
	
}
