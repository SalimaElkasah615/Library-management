import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.Font;
import javax.swing.table.DefaultTableModel;

import bdd.liu.projet2024.DBConnection;

import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.border.MatteBorder;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;

public class GUIBib {

	private JFrame frame;
	private JTextField nom;
	private JLabel lblIdauteur;
	private JTextField adresse;
	private JLabel lblNom;
	private JLabel lblAdresse;
	private JTextField regoin;
	private JLabel lblIsbn;
	private JLabel lblTitre;
	private JTextField titre;
	private JLabel lblNumero;
	private JTextField numero;
	private JComboBox<Object> comboBox_idAuteurTel;
	private JComboBox<?> comboBox_idBibliotheque;
	private JPanel panel;
	private JComboBox<?> comboBox_idAuteur;
	private JPanel panel_1;
	private JPanel panel_3;
	private JButton btnNewButton_4;
	
	
	DBConnection conn = null;
	PreparedStatement pst = null;
	ResultSet rs = null;
	

	DefaultTableModel model = new DefaultTableModel();
	private JLabel lblNewLabel_3;
	private JTable table;
	private JTextField ISBN;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUIBib window = new GUIBib();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GUIBib() {
		initialize();
		
		
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setForeground(SystemColor.menu);
		frame.getContentPane().setFont(new Font("Times New Roman", Font.BOLD, 14));
		frame.setBounds(0, 0,1400, 800);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		nom = new JTextField();
		nom.setFont(new Font("Tahoma", Font.BOLD, 14));
		nom.setColumns(10);
		nom.setBounds(142, 211, 133, 36);
		frame.getContentPane().add(nom);
		
		lblIdauteur = new JLabel("nom :");
		lblIdauteur.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblIdauteur.setBounds(35, 216, 97, 24);
		frame.getContentPane().add(lblIdauteur);
		
		adresse = new JTextField();
		adresse.setFont(new Font("Tahoma", Font.BOLD, 14));
		adresse.setColumns(10);
		adresse.setBounds(142, 258, 292, 36);
		frame.getContentPane().add(adresse);
		
		lblNom = new JLabel("adresse : ");
		lblNom.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNom.setBounds(35, 263, 97, 24);
		frame.getContentPane().add(lblNom);
		
		lblAdresse = new JLabel("region :");
		lblAdresse.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblAdresse.setBounds(35, 310, 97, 24);
		frame.getContentPane().add(lblAdresse);
		
		regoin = new JTextField();
		regoin.setFont(new Font("Tahoma", Font.BOLD, 14));
		regoin.setColumns(10);
		regoin.setBounds(142, 305, 292, 36);
		frame.getContentPane().add(regoin);
		
		lblIsbn = new JLabel("ISBN : ");
		lblIsbn.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblIsbn.setBounds(35, 407, 97, 24);
		frame.getContentPane().add(lblIsbn);
		
		lblTitre = new JLabel("titre :");
		lblTitre.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblTitre.setBounds(35, 454, 97, 24);
		frame.getContentPane().add(lblTitre);
		
		titre = new JTextField();
		titre.setFont(new Font("Tahoma", Font.BOLD, 14));
		titre.setColumns(10);
		titre.setBounds(142, 442, 292, 36);
		frame.getContentPane().add(titre);
		
		lblNumero = new JLabel("numero :");
		lblNumero.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNumero.setBounds(35, 568, 97, 24);
		frame.getContentPane().add(lblNumero);
		
		numero = new JTextField();
		numero.setFont(new Font("Tahoma", Font.BOLD, 14));
		numero.setColumns(10);
		numero.setBounds(142, 556, 133, 36);
		frame.getContentPane().add(numero);
		
		comboBox_idAuteurTel = new JComboBox<Object>();
		comboBox_idAuteurTel.setModel(new DefaultComboBoxModel(new String[] {"Choose please", "Mobile", "Fixe"}));
		comboBox_idAuteurTel.setFont(new Font("Tahoma", Font.BOLD, 14));
		comboBox_idAuteurTel.setBounds(285, 556, 149, 36);
		frame.getContentPane().add(comboBox_idAuteurTel);
		
		comboBox_idBibliotheque = new JComboBox();
		comboBox_idBibliotheque.setModel(new DefaultComboBoxModel(new String[] {"Choose please", "1-Bibliotheque Nationale, Nouakchott", "2-Bibliotheque Regionale, Nouadhibou", "3-Bibliotheque Municipale, Atar", "4-Bibliotheque Communautaire, Zouerate", "5-Bibliotheque Universitaire, Nouakchott", "6-Bibliotheque Scolaire, Kaedi", "7-Bibliotheque de Quartier, Rosso ", "8-Bibliotheque Mobile, Adrar", "9-Bibliotheque Culturelle, Nema", "10-Bibliotheque Mediatheque, Kiffa"}));
		
		comboBox_idBibliotheque.setFont(new Font("Times New Roman", Font.BOLD, 15));
		comboBox_idBibliotheque.setBounds(43, 74, 391, 61);
		frame.getContentPane().add(comboBox_idBibliotheque);
		
		
/////////////////////////UPDATE///////////////////////////////////
		JButton btnNewButton = new JButton("update");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int i=table.getSelectedRow();
			     model.setValueAt(comboBox_idBibliotheque.getSelectedItem(), i,0);
			     model.setValueAt(comboBox_idAuteur.getSelectedItem(), i,1);
				model.setValueAt(nom.getText(), i, 2);
				 model.setValueAt(adresse.getText(), i, 3);
                 model.setValueAt(regoin.getText(), i, 4);
                 model.setValueAt(ISBN.getText(), i, 5);
                 model.setValueAt(titre.getText(), i, 6);
                 model.setValueAt(numero.getText(), i, 7);
                 
                 model.setValueAt(comboBox_idAuteurTel.getSelectedItem(), i,8);
		
		
	            
	                
			}
		});
		
		
		btnNewButton.setFont(new Font("Times", Font.BOLD, 15));
		btnNewButton.setBounds(471, 253, 113, 46);
		frame.getContentPane().add(btnNewButton);
		
		////////////////////EXIT////////////////////////////////////
		JButton btnNewButton_1 = new JButton("Exit");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				frame =new JFrame("Exit");
						if (JOptionPane.showConfirmDialog(frame, "Confirm if you want to exit ", "GestionDeBibliotheque",
								JOptionPane.YES_NO_OPTION)==JOptionPane.YES_NO_OPTION) {
							System.exit(0);
						}
			}
		});
		btnNewButton_1.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnNewButton_1.setBounds(471, 456, 113, 46);
		frame.getContentPane().add(btnNewButton_1);
		
		/////////////////////ADD///////////////////////////////////////
		JButton btnNewButton_2 = new JButton("Add");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				if(comboBox_idBibliotheque.getSelectedItem().equals("")||	comboBox_idAuteur.getSelectedItem().equals("")
						||nom.getText().equals("")||adresse.getText().equals("")
						||regoin.getText().equals("")||ISBN.getText().equals("")
						||titre.getText().equals("")||numero.getText().equals("")
						||comboBox_idAuteurTel.getSelectedItem().equals(""))
				{
					JOptionPane.showMessageDialog(null, "please fill complete information" ,"GestionDeBibliotheque",
							JOptionPane.OK_OPTION);
				}
			
			DefaultTableModel model = (DefaultTableModel)	 table.getModel();
			model.addRow(new Object[]{
					
					
					comboBox_idBibliotheque.getSelectedItem(),
					comboBox_idAuteur.getSelectedItem(),
					nom.getText(),
					adresse.getText(),
					regoin.getText(),
					ISBN.getText(),
					titre.getText(),
					numero.getText(),
					comboBox_idAuteurTel.getSelectedItem(),
						
					
					
							
			});	
				
			if (table.getSelectedRow() == -1) {
				if (table.getRowCount()== 0) {
					
					JOptionPane.showMessageDialog(null, "GestionDeBibliotheque update Confirme" , "GestionDeBibliotheque",
					JOptionPane.OK_OPTION);
				}
			}
				
			}
		});
		
		
		btnNewButton_2.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnNewButton_2.setBounds(471, 185, 113, 46);
		frame.getContentPane().add(btnNewButton_2);
		
		///////////////////////delete////////////////////////////
		JButton btnNewButton_3 = new JButton("delete");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				DefaultTableModel model = (DefaultTableModel)	 table.getModel();
				
				if (table.getSelectedRow() == -1) {
					if (table.getRowCount()== 0) {
						
						JOptionPane.showMessageDialog(null, "NO data to delet" ,
								"GestionDeBibliotheque",JOptionPane.OK_OPTION);
					}else {
						
					JOptionPane.showMessageDialog(null, "Select a row to delet",
							"GestionDeBibliotheque",JOptionPane.OK_OPTION);
					}
					}else {
						model.removeRow(table.getSelectedRow());
					}
			}
		});
		
		
		
		
		btnNewButton_3.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnNewButton_3.setBounds(471, 321, 113, 46);
		frame.getContentPane().add(btnNewButton_3);
		
		panel = new JPanel();
		panel.setBorder(new MatteBorder(5, 5, 5, 5, (Color) new Color(191, 205, 219)));
		panel.setBounds(23, 51, 433, 104);
		frame.getContentPane().add(panel);
		
		comboBox_idAuteur = new JComboBox();
		comboBox_idAuteur.setModel(new DefaultComboBoxModel(new String[] {"Choose please", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"}));
		comboBox_idAuteur.setFont(new Font("Tahoma", Font.BOLD, 14));
		comboBox_idAuteur.setBounds(285, 211, 149, 36);
		frame.getContentPane().add(comboBox_idAuteur);
		
		panel_1 = new JPanel();
		panel_1.setBorder(new MatteBorder(5, 5, 5, 5, (Color) new Color(191, 205, 219)));
		panel_1.setBounds(23, 185, 433, 168);
		frame.getContentPane().add(panel_1);
		
		panel_3 = new JPanel();
		panel_3.setBorder(new MatteBorder(5, 5, 5, 5, (Color) SystemColor.inactiveCaption));
		panel_3.setBounds(23, 539, 433, 76);
		frame.getContentPane().add(panel_3);
		
		//////////////////////////RESET//////////////////////////////////////////////
		
		btnNewButton_4 = new JButton("Reset");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				comboBox_idBibliotheque.setSelectedItem("Make a Selection");
				comboBox_idAuteur.setSelectedItem("Make a Selection");
				nom.setText("");
				adresse.setText("");
				regoin.setText("");
				ISBN.setText("");
				titre.setText("");
				numero.setText("");
				comboBox_idAuteurTel.setSelectedItem("Make a Selection");
				
				
				
			
			}
		});
		btnNewButton_4.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnNewButton_4.setBounds(471, 396, 113, 46);
		frame.getContentPane().add(btnNewButton_4);
		
		JLabel lblNewLabel = new JLabel("Auteur");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(23, 166, 133, 14);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Bibliotheque");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1.setBounds(23, 28, 133, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Livre");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_2.setBounds(23, 364, 133, 14);
		frame.getContentPane().add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel("Telephone");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_3.setBounds(23, 514, 133, 14);
		frame.getContentPane().add(lblNewLabel_3);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(607, 51, 645, 564);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, SystemColor.inactiveCaption, SystemColor.inactiveCaption, SystemColor.inactiveCaption, SystemColor.inactiveCaption));
		table.setFont(new Font("Times New Roman", Font.BOLD, 11));
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				int i=table.getSelectedRow();
				comboBox_idBibliotheque.setToolTipText( model.getValueAt(i, 0).toString());
				comboBox_idAuteur.setToolTipText( model.getValueAt(i, 1).toString());
				nom.setToolTipText( model.getValueAt(i, 2).toString());
				adresse.setToolTipText( model.getValueAt(i,3).toString());
				regoin.setToolTipText( model.getValueAt(i, 4).toString());
				ISBN.setToolTipText( model.getValueAt(i, 5).toString());
				titre.setToolTipText( model.getValueAt(i, 6).toString());
				numero.setToolTipText( model.getValueAt(i, 7).toString());
				comboBox_idAuteurTel.setToolTipText( model.getValueAt(i, 8).toString());
				
				
			}
		});
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Bibliotheque", "idAuteur", "nom", " adresse", " region", "ISBN", "titre", "numero", "type"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(79);
		scrollPane.setViewportView(table);
		
		ISBN = new JTextField();
		ISBN.setFont(new Font("Tahoma", Font.BOLD, 12));
		ISBN.setBounds(142, 401, 292, 36);
		frame.getContentPane().add(ISBN);
		ISBN.setColumns(10);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new MatteBorder(5, 5, 5, 5, (Color) SystemColor.inactiveCaption));
		panel_2.setBounds(23, 388, 433, 120);
		frame.getContentPane().add(panel_2);
	}
}
