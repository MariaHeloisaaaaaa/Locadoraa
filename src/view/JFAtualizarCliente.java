package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import model.bean.Cliente;
import model.dao.ClienteDAO;

public class JFAtualizarCliente extends JFrame {

	private JPanel contentPane;
	private JTextField txtNome;
	private JTextField txtEmail;
	
	private static int id;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFAtualizarCliente frame = new JFAtualizarCliente(id);
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
	public JFAtualizarCliente(int id) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(5, 5, 87, -1);
		contentPane.add(lblNewLabel);
		
		ClienteDAO cdao = new ClienteDAO();
		Cliente c = cdao.read(id);
		
		JLabel lblNewLabel_5 = new JLabel("ID do Cliente:");
		lblNewLabel_5.setBounds(15, 11, 83, 14);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblId = new JLabel("New label");
		lblId.setBounds(95, 11, 46, 14);
		contentPane.add(lblId);
		
		JLabel lblNewLabel_1 = new JLabel("Alterar Cadastro de Cliente");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1.setBounds(74, 17, 294, 30);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Nome Completo:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(24, 58, 115, 30);
		contentPane.add(lblNewLabel_2);
		
		txtNome = new JTextField();
		txtNome.setBounds(137, 63, 231, 24);
		contentPane.add(txtNome);
		txtNome.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Email:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_3.setBounds(91, 98, 38, 14);
		contentPane.add(lblNewLabel_3);
		
		txtEmail = new JTextField();
		txtEmail.setBounds(137, 98, 157, 17);
		contentPane.add(txtEmail);
		txtEmail.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Sexo:");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_4.setBounds(58, 136, 46, 14);
		contentPane.add(lblNewLabel_4);
		
		JRadioButton rdbtnFeminino = new JRadioButton("Feminino");
		rdbtnFeminino.setFont(new Font("Tahoma", Font.PLAIN, 15));
		rdbtnFeminino.setBounds(68, 151, 83, 23);
		contentPane.add(rdbtnFeminino);
		
		JRadioButton rdbtnMasculino = new JRadioButton("Masculino");
		rdbtnMasculino.setFont(new Font("Tahoma", Font.PLAIN, 15));
		rdbtnMasculino.setBounds(66, 177, 109, 23);
		contentPane.add(rdbtnMasculino);
		
		ButtonGroup sexo = new ButtonGroup();
		sexo.add(rdbtnFeminino);
		sexo.add(rdbtnMasculino);
		
		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnLimpar.setBounds(174, 227, 89, 23);
		contentPane.add(btnLimpar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnCancelar.setBounds(273, 227, 89, 23);
		contentPane.add(btnCancelar);

		lblId.setText(String.valueOf(c.getIdCliente()));
		txtNome.setText(c.getNome());
		txtEmail.setText(c.getEmail());
		if(rdbtnFeminino.isSelected()) {
			c.setSexo(false);
		}else if (rdbtnMasculino.isSelected()) {
			c.setSexo(true);
		}
		
		JButton btnAlterar = new JButton("Alterar");
		btnAlterar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Cliente c = new Cliente();
				ClienteDAO dao = new ClienteDAO();
				c.setNome(txtNome.getText());
				c.setEmail(txtEmail.getText());
				
				if(rdbtnFeminino.isSelected()) {
					c.setSexo(false);
				}else if (rdbtnMasculino.isSelected()) {
					c.setSexo(true);
				}
				
				dao.update(c);
			}
		});
		btnAlterar.setBounds(58, 227, 105, 23);
		contentPane.add(btnAlterar);

	   
	}
}