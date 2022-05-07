package formula;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;



import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JSeparator;
import javax.swing.JTree;
import java.awt.Choice;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JEditorPane;
import javax.swing.JPopupMenu;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;

public class Main_Menu extends JFrame {

	private JPanel contentPane;
	private ImageIcon Formula1;
	private JLabel myLabel;
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main_Menu frame = new Main_Menu();
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
	public Main_Menu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 420);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnData = new JButton("Adatkezel\u00E9s");
		btnData.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Data ne = new Data();
				ne.setVisible(true);
			}
		});
		btnData.setFont(new Font("Tahoma", Font.BOLD, 24));
		btnData.setBounds(81, 11, 500, 78);
		contentPane.add(btnData);
		
		JButton btnPDF = new JButton("PDF Ment\u00E9s");
		btnPDF.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnPDF.setBounds(28, 300, 140, 50);
		contentPane.add(btnPDF);
		
		JButton btnTomor = new JButton("T\u00F6m\u00F6r\u00EDt\u00E9s");
		btnTomor.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnTomor.setBounds(183, 300, 140, 50);
		contentPane.add(btnTomor);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\kovac\\eclipse-workspace\\JavaTech_Feleves_C00KSI\\Resource\\F1-new-old-logos.jpg"));
		lblNewLabel.setBounds(0, 0, 684, 381);
		contentPane.add(lblNewLabel);
	}
}
