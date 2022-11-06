import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.Color;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.AbstractAction;
import javax.swing.Action;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


public class Triangulo extends JFrame {

	private JPanel contentPanel;
	private JTextField textBase;
	private JTextField textAltura;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Triangulo frame = new Triangulo();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Triangulo() {
				
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 500);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnOpciones = new JMenu("Opciones");
		menuBar.add(mnOpciones);
		
		JMenuItem mntmSalir = new JMenuItem("Salir");
		mntmSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		mnOpciones.add(mntmSalir);

		
		
		//Creacion de panel principal
		contentPanel = new JPanel();
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPanel);
		contentPanel.setLayout(null);
		
		JLabel lblTitulo = new JLabel("CALCULAR AREA DE TRIANGULO");
		lblTitulo.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 30));
		lblTitulo.setForeground(Color.GREEN);
		lblTitulo.setBounds(33, 33, 493, 50);
		contentPanel.add(lblTitulo);
		
		JLabel lblValidarAltura = new JLabel();
		lblValidarAltura.setForeground(Color.RED);
		lblValidarAltura.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.BOLD, 30));
		lblValidarAltura.setBounds(286, 212, 228, 30);
		contentPanel.add(lblValidarAltura);
		
		JLabel lblValidarBase = new JLabel();
		lblValidarBase.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.BOLD, 30));
		lblValidarBase.setForeground(Color.RED);
		lblValidarBase.setBounds(286, 122, 228, 42);
		contentPanel.add(lblValidarBase);
		
		JLabel lblResultado = new JLabel();
		lblResultado.setForeground(Color.WHITE);
		lblResultado.setFont(new Font("Tahoma", Font.ITALIC, 20));
		lblResultado.setBounds(70, 305, 432, 30);
		contentPanel.add(lblResultado);
		
		JButton btnArea = new JButton("Carcular area");
		btnArea.setEnabled(false);
		btnArea.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		
		btnArea.setBounds(145, 361, 170, 40);
		contentPanel.add(btnArea);
		
		JLabel lblTriangulo = new JLabel();
		lblTriangulo.setIcon(new ImageIcon("C:\\Users\\julia\\Downloads\\triangulo.png"));
		lblTriangulo.setBounds(561, 69, 400, 310);
		contentPanel.add(lblTriangulo);
		
		JLabel lblAltura = new JLabel("Altura");
		lblAltura.setForeground(Color.WHITE);
		lblAltura.setFont(new Font("Tahoma", Font.ITALIC, 40));
		lblAltura.setBounds(22, 193, 150, 60);
		contentPanel.add(lblAltura);
		
		JLabel lblBase = new JLabel("Base");
		lblBase.setToolTipText("");
		lblBase.setForeground(Color.WHITE);
		lblBase.setFont(new Font("Tahoma", Font.ITALIC, 40));
		lblBase.setBounds(22, 122, 150, 60);
		contentPanel.add(lblBase);
		
		textAltura = new JTextField();
		textAltura.addKeyListener(new KeyAdapter() {
			
			public void habilitarBoton() {
				if(!textBase.getText().isEmpty() && !textAltura.getText().isEmpty()) {
					btnArea.setEnabled(true);					
				}
				else {
					btnArea.setEnabled(false);
				}
				
			}
			public void keyReleased(KeyEvent e) {
				habilitarBoton();
				
			}
		});
		textAltura.setBounds(157, 203, 100, 50);
		contentPanel.add(textAltura);
		textAltura.setColumns(10);
		
		textBase = new JTextField();
		textBase.addKeyListener(new KeyAdapter() {
			
			public void habilitarBoton() {
				if(!textBase.getText().isEmpty() && !textAltura.getText().isEmpty()) {
					btnArea.setEnabled(true);					
				}
				else {
					btnArea.setEnabled(false);
				}
				
			}
			
			public void keyReleased(KeyEvent e) {
				habilitarBoton();
			}
		});
		textBase.setBounds(157, 122, 100, 50);
		contentPanel.add(textBase);
		textBase.setColumns(10);
		
		JLabel lblFondo = new JLabel();
		lblFondo.setForeground(Color.WHITE);
		lblFondo.setBackground(new Color(255, 255, 255));
		lblFondo.setIcon(new ImageIcon("C:\\Users\\julia\\Downloads\\fondo.jpg"));
		lblFondo.setBounds(0, 0, 1000, 500);
		contentPanel.add(lblFondo);
		
		btnArea.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				double base, altura, area;
						

				base = Double.parseDouble(textBase.getText());
				if (base<=0) {
					lblValidarBase.setText("Base incorrecta");
				}

				altura = Double.parseDouble(textAltura.getText());
				if (altura<=0) {
					lblValidarAltura.setText("Altura incorrecta");
				}

				area = (base * altura)/2;
		
				
				if (altura > 0 && base > 0) {
					btnArea.setEnabled(true);
					lblResultado.setText("El area del triangulo es " + area + " u²");
					lblValidarAltura.setText("");
					lblValidarBase.setText("");
				}				

				else if(altura > 0) {
					lblResultado.setText("Datos invalidos no se puede calcular area");
					lblValidarAltura.setText("");					
				}
				else if(base > 0) {					
					lblResultado.setText("Datos invalidos no se puede calcular area");
					lblValidarBase.setText("");
				}

									
			}

	
		});
		
	}
	

	
}
