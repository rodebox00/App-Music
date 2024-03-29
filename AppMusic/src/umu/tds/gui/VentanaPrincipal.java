package umu.tds.gui;

import java.awt.BorderLayout;

import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import com.itextpdf.text.DocumentException;

import umu.tds.controlador.Controlador;

import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.BoxLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.File;
import java.io.FileNotFoundException;

import javax.swing.JOptionPane;
import pulsador.Luz;

public class VentanaPrincipal implements PropertyChangeListener{

	private JFrame frmVentanaPrincipal;
	private Luz luz;
	
	public VentanaPrincipal() {
		initialize();
	}
	public void propertyChange(PropertyChangeEvent evento) {
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.showOpenDialog(frmVentanaPrincipal);	
		File currentFile = fileChooser.getSelectedFile();
		if(currentFile==null) {
			JOptionPane.showMessageDialog(luz, "No se ha seleccionado ningun fichero", "Aviso", JOptionPane.INFORMATION_MESSAGE, null);
		}else if(!currentFile.exists()) {
			JOptionPane.showMessageDialog(luz, "No existe el fichero seleccionado", "Error", JOptionPane.ERROR_MESSAGE, null);
		}
		else {
			String extension = currentFile.getName().substring(currentFile.getName().lastIndexOf('.') + 1);
			if (extension.equals("xml"))
				Controlador.getUnicaInstancia().cargarCanciones(currentFile.getPath());
			else
				JOptionPane.showMessageDialog(luz, "El fichero seleccionado debe tener extension '.xml' o '.mp3'", "Error", JOptionPane.ERROR_MESSAGE, null);
		}
	}
	
	public JFrame getFrame() {
		return frmVentanaPrincipal;
	}
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPrincipal frame = new VentanaPrincipal();
					frame.frmVentanaPrincipal.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public void mostrarVentana() {
		frmVentanaPrincipal.setLocationRelativeTo(null);
		frmVentanaPrincipal.setVisible(true);
	}
	
	public void initialize() {
		frmVentanaPrincipal = new JFrame();
		frmVentanaPrincipal.setMinimumSize(new Dimension(690, 370));
		frmVentanaPrincipal.setTitle("AppMusic");
		frmVentanaPrincipal.setBounds(100, 100, 690, 370);
		frmVentanaPrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel contentPane = (JPanel) frmVentanaPrincipal.getContentPane();
		frmVentanaPrincipal.getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		frmVentanaPrincipal.getContentPane().add(panel, BorderLayout.NORTH);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{10, 10, 10, 0, 50, 155, 50, 155, 44, 0};
		gbl_panel.rowHeights = new int[]{10, 0, 10, 0};
		gbl_panel.columnWeights = new double[]{0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JLabel lblNewLabel = new JLabel("Hola "+ Controlador.getUnicaInstancia().getLoginUsuario());
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblNewLabel.gridwidth = 3;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.anchor = GridBagConstraints.NORTH;
		gbc_lblNewLabel.gridx = 1;
		gbc_lblNewLabel.gridy = 1;
		panel.add(lblNewLabel, gbc_lblNewLabel);
		
				JButton btnPdfPremium = new JButton();
				boolean isPremium = Controlador.getUnicaInstancia().isUsuarioPremium();
				if(isPremium)	btnPdfPremium.setText("Generar pdf");
				else btnPdfPremium.setText("Hazte premium");
				
				btnPdfPremium.setBackground(Color.YELLOW);
				btnPdfPremium.setForeground(Color.BLACK);
				GridBagConstraints gbc_btnHaztePremium = new GridBagConstraints();
				gbc_btnHaztePremium.fill = GridBagConstraints.HORIZONTAL;
				gbc_btnHaztePremium.insets = new Insets(0, 0, 5, 5);
				gbc_btnHaztePremium.gridx = 5;
				gbc_btnHaztePremium.gridy = 1;
				panel.add(btnPdfPremium, gbc_btnHaztePremium);	
				
				JButton btnSalir = new JButton("Salir");
				GridBagConstraints gbc_btnSalir = new GridBagConstraints();
				gbc_btnSalir.fill = GridBagConstraints.HORIZONTAL;
				gbc_btnSalir.insets = new Insets(0, 0, 5, 5);
				gbc_btnSalir.gridx = 7;
				gbc_btnSalir.gridy = 1;
				panel.add(btnSalir, gbc_btnSalir);
				btnSalir.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						VentanaLogin reg = new VentanaLogin();
						reg.getFrame().setVisible(true);
						frmVentanaPrincipal.setVisible(false);
					}
				});
				
				btnPdfPremium.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						//Si es usario premium generamos el pdf sino nos desplazamos a la ventana convertirse en premium
						if (isPremium) {	
							JFileChooser chooser = new JFileChooser();
							chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
							chooser.showOpenDialog(frmVentanaPrincipal);
							File directory = chooser.getSelectedFile();
							if(directory!=null) {
								if(!directory.exists()) {
									JOptionPane.showMessageDialog(btnPdfPremium, "El directorio seleccionado no existe", "Error", JOptionPane.ERROR_MESSAGE, null);
								}
								else {
									try {
										Controlador.getUnicaInstancia().generaPDF(directory.getAbsolutePath());
									} catch (FileNotFoundException fe) {
										System.out.println(fe.getMessage());
									} catch (DocumentException d) {
										System.out.println(d.getMessage());
									}
								}
							}else {
								JOptionPane.showMessageDialog(btnPdfPremium, "No se ha seleccionado ningun directorio", "Aviso", JOptionPane.INFORMATION_MESSAGE, null);
							}
						} else {
							VentanaPremium reg = new VentanaPremium();
							reg.getFrame().setVisible(true);
							frmVentanaPrincipal.setVisible(false);
						}
					}
				});
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.LIGHT_GRAY);
		frmVentanaPrincipal.getContentPane().add(panel_1, BorderLayout.WEST);
		panel_1.setLayout(new BoxLayout(panel_1, BoxLayout.Y_AXIS));
		
		JButton btnExplorar = new JButton("Explorar");
		btnExplorar.setBorderPainted(false);
		btnExplorar.setBackground(Color.LIGHT_GRAY);
		btnExplorar.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/umu/tds/imagenes/lupa.png")));
		panel_1.add(btnExplorar);
		btnExplorar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaExplorar reg = new VentanaExplorar();
				reg.getFrame().setVisible(true);
				frmVentanaPrincipal.setVisible(false);
			}
		});
		
		JButton btnLista = new JButton("Nueva lista");
		btnLista.setBorderPainted(false);
		btnLista.setBackground(Color.LIGHT_GRAY);
		btnLista.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/umu/tds/imagenes/mas-positivo-suma-simbolo-matematico.png")));
		panel_1.add(btnLista);
		btnLista.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int reply = JOptionPane.showConfirmDialog(null, "Desea Crear una nueva Playlist", "Crear Playlist", JOptionPane.YES_NO_OPTION);
				if (reply == JOptionPane.YES_OPTION) {
					VentanaCrearPlaylist reg = new VentanaCrearPlaylist();
					reg.getFrame().setVisible(true);
					frmVentanaPrincipal.setVisible(false);
				}
			}
		});
		
		JButton btnRecientes = new JButton("Reciente");
		btnRecientes.setBorderPainted(false);
		btnRecientes.setBackground(Color.LIGHT_GRAY);
		btnRecientes.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/umu/tds/imagenes/reloj-de-pared.png")));
		panel_1.add(btnRecientes);
		btnRecientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaRecientes reg = new VentanaRecientes();
				reg.getFrame().setVisible(true);
				frmVentanaPrincipal.setVisible(false);
			}
		});
		
		JButton btnMisL = new JButton("Mis listas");
		btnMisL.setBorderPainted(false);
		btnMisL.setBackground(Color.LIGHT_GRAY);
		btnMisL.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/umu/tds/imagenes/lista-de-reproduccion.png")));
		panel_1.add(btnMisL);
		btnMisL.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaMisListas reg = new VentanaMisListas();
				reg.getFrame().setVisible(true);
				frmVentanaPrincipal.setVisible(false);
			}
		});
		
		luz = new Luz();
		panel_1.add(luz);
		
		JPanel panel_2 = new JPanel();
		frmVentanaPrincipal.getContentPane().add(panel_2, BorderLayout.CENTER);
		panel_2.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_3 = new JPanel();
		panel_2.add(panel_3, BorderLayout.NORTH);
		
		JLabel lblBienvenidoaAAppmusic = new JLabel("Bienvenido/a a AppMusic");
		panel_3.add(lblBienvenidoaAAppmusic);
		lblBienvenidoaAAppmusic.setVerticalAlignment(SwingConstants.TOP);
		lblBienvenidoaAAppmusic.setVerticalTextPosition(SwingConstants.TOP);
		lblBienvenidoaAAppmusic.setHorizontalAlignment(SwingConstants.CENTER);
		lblBienvenidoaAAppmusic.setFont(new Font("DejaVu Math TeX Gyre", Font.BOLD, 25));
		
		JPanel panel_4 = new JPanel();
		panel_4.setPreferredSize(new Dimension(10, 200));
		panel_2.add(panel_4, BorderLayout.CENTER);
		
		JLabel label = new JLabel("");
		label.setPreferredSize(new Dimension(225, 200));
		panel_4.add(label);
		label.setHorizontalAlignment(SwingConstants.RIGHT);
		label.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/umu/tds/imagenes/logo.jpeg")));
		contentPane.setBorder(new EmptyBorder(10, 10, 10, 10));
		luz.addEncendidoListener(this);
		
		
	}
	

}