package umu.tds.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.BoxLayout;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import javax.swing.JTable;

public class VentanaPlaylistNueva {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTable table;
	private JTable table_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPlaylistNueva window = new VentanaPlaylistNueva();
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
	public VentanaPlaylistNueva() {
		initialize();
	}
	
	public JFrame getFrame() {
		return frame;
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 927, 458);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel_west = new JPanel();
		panel_west.setBackground(Color.LIGHT_GRAY);
		frame.getContentPane().add(panel_west, BorderLayout.WEST);
		panel_west.setLayout(new BoxLayout(panel_west, BoxLayout.Y_AXIS));
		
		JButton btnNewButton_1 = new JButton("Explorar");
		btnNewButton_1.setIcon(new ImageIcon(VentanaPlaylistNueva.class.getResource("/umu/tds/imagenes/lupa.png")));
		btnNewButton_1.setBorderPainted(false);
		btnNewButton_1.setBackground(Color.LIGHT_GRAY);
		panel_west.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Nueva lista");
		btnNewButton_2.setIcon(new ImageIcon(VentanaPlaylistNueva.class.getResource("/umu/tds/imagenes/mas-positivo-suma-simbolo-matematico.png")));
		btnNewButton_2.setBorderPainted(false);
		btnNewButton_2.setBackground(Color.LIGHT_GRAY);
		panel_west.add(btnNewButton_2);
		
		JButton btnRecientes = new JButton("Reciente");
		btnRecientes.setIcon(new ImageIcon(VentanaPlaylistNueva.class.getResource("/umu/tds/imagenes/reloj-de-pared.png")));
		btnRecientes.setBorderPainted(false);
		btnRecientes.setBackground(Color.LIGHT_GRAY);
		panel_west.add(btnRecientes);
		
		JButton btnMisL = new JButton("Mis listas");
		btnMisL.setIcon(new ImageIcon(VentanaPlaylistNueva.class.getResource("/umu/tds/imagenes/lista-de-reproduccion.png")));
		btnMisL.setBorderPainted(false);
		btnMisL.setBackground(Color.LIGHT_GRAY);
		panel_west.add(btnMisL);
		
		JPanel panel_center = new JPanel();
		frame.getContentPane().add(panel_center, BorderLayout.CENTER);
		panel_center.setLayout(new BorderLayout(0, 0));
		
		JPanel panel__north = new JPanel();
		panel_center.add(panel__north, BorderLayout.NORTH);
		GridBagLayout gbl_panel__north = new GridBagLayout();
		gbl_panel__north.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel__north.rowHeights = new int[]{1, 0, 0, 0, 0};
		gbl_panel__north.columnWeights = new double[]{1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl_panel__north.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel__north.setLayout(gbl_panel__north);
		
		textField = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.insets = new Insets(0, 0, 5, 5);
		gbc_textField.gridx = 3;
		gbc_textField.gridy = 1;
		panel__north.add(textField, gbc_textField);
		textField.setColumns(10);
		
		JButton ButCrear = new JButton("Crear");
		GridBagConstraints gbc_ButCrear = new GridBagConstraints();
		gbc_ButCrear.insets = new Insets(0, 0, 5, 5);
		gbc_ButCrear.gridx = 7;
		gbc_ButCrear.gridy = 1;
		panel__north.add(ButCrear, gbc_ButCrear);
		
		textField_1 = new JTextField();
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.insets = new Insets(0, 0, 5, 5);
		gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_1.gridx = 1;
		gbc_textField_1.gridy = 2;
		panel__north.add(textField_1, gbc_textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		GridBagConstraints gbc_textField_2 = new GridBagConstraints();
		gbc_textField_2.insets = new Insets(0, 0, 5, 5);
		gbc_textField_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_2.gridx = 3;
		gbc_textField_2.gridy = 2;
		panel__north.add(textField_2, gbc_textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		GridBagConstraints gbc_textField_3 = new GridBagConstraints();
		gbc_textField_3.insets = new Insets(0, 0, 5, 5);
		gbc_textField_3.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_3.gridx = 5;
		gbc_textField_3.gridy = 2;
		panel__north.add(textField_3, gbc_textField_3);
		textField_3.setColumns(10);
		
		JButton btnBuscar = new JButton("Buscar");
		GridBagConstraints gbc_btnBuscar = new GridBagConstraints();
		gbc_btnBuscar.insets = new Insets(0, 0, 5, 5);
		gbc_btnBuscar.gridx = 7;
		gbc_btnBuscar.gridy = 2;
		panel__north.add(btnBuscar, gbc_btnBuscar);
		
		JPanel panel__east = new JPanel();
		panel_center.add(panel__east, BorderLayout.EAST);
		
		table = new JTable();
		panel__east.add(table);
		
		JPanel panel__center = new JPanel();
		panel_center.add(panel__center, BorderLayout.CENTER);
		panel__center.setLayout(new BoxLayout(panel__center, BoxLayout.Y_AXIS));
		
		JButton btnNewButton_4 = new JButton(">>");
		panel__center.add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("<<");
		panel__center.add(btnNewButton_5);
		
		JPanel panel__west = new JPanel();
		panel_center.add(panel__west, BorderLayout.WEST);
		
		table_1 = new JTable();
		panel__west.add(table_1);
		
		JPanel panel_south = new JPanel();
		panel_center.add(panel_south, BorderLayout.SOUTH);
		
		JButton btnNewButton = new JButton("Aceptar");
		panel_south.add(btnNewButton);
		
		JButton btnNewButton_3 = new JButton("Cancelar");
		panel_south.add(btnNewButton_3);
		
		JPanel panel_north = new JPanel();
		panel_north.setBackground(Color.LIGHT_GRAY);
		frame.getContentPane().add(panel_north, BorderLayout.NORTH);
		GridBagLayout gbl_panel_north = new GridBagLayout();
		gbl_panel_north.columnWidths = new int[]{10, 10, 10, 0, 10, 0, 0, 10, 0};
		gbl_panel_north.rowHeights = new int[]{10, 0, 10, 0};
		gbl_panel_north.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_panel_north.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel_north.setLayout(gbl_panel_north);
		
		JLabel lblNewLabel_1 = new JLabel("Hola <dynamic>");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 20));
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblNewLabel_1.anchor = GridBagConstraints.NORTH;
		gbc_lblNewLabel_1.gridwidth = 3;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 1;
		gbc_lblNewLabel_1.gridy = 1;
		panel_north.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		JButton btnHaztePremium_1 = new JButton("Hazte Premium");
		btnHaztePremium_1.setBorderPainted(false);
		btnHaztePremium_1.setBackground(Color.YELLOW);
		GridBagConstraints gbc_btnHaztePremium_1 = new GridBagConstraints();
		gbc_btnHaztePremium_1.insets = new Insets(0, 0, 5, 5);
		gbc_btnHaztePremium_1.gridx = 5;
		gbc_btnHaztePremium_1.gridy = 1;
		panel_north.add(btnHaztePremium_1, gbc_btnHaztePremium_1);
		
		JButton btnSalir_1 = new JButton("Salir");
		btnSalir_1.setBorderPainted(false);
		btnSalir_1.setBackground(SystemColor.window);
		btnSalir_1.setActionCommand("Salir");
		GridBagConstraints gbc_btnSalir_1 = new GridBagConstraints();
		gbc_btnSalir_1.insets = new Insets(0, 0, 5, 5);
		gbc_btnSalir_1.gridx = 6;
		gbc_btnSalir_1.gridy = 1;
		panel_north.add(btnSalir_1, gbc_btnSalir_1);
	}

}
