package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.bean.Filme;
import model.dao.FilmeDAO;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.JSpinner;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JFCadastroFilme extends JFrame {


	private JPanel contentPane;
	private JTextField txtTitulo;
	private JTextField txtSinopse;
	private JTextField txtCategoria;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFCadastroFilme frame = new JFCadastroFilme();
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
	public JFCadastroFilme() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 517, 370);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel JLtitulo = new JLabel(" Cadastrar Filme");
		JLtitulo.setBounds(151, 15, 212, 21);
		JLtitulo.setFont(new Font("Tahoma", Font.BOLD, 20));
		contentPane.add(JLtitulo);

		JLabel JLtitulofilme = new JLabel("T\u00EDtulo");
		JLtitulofilme.setBounds(5, 44, 46, 19);
		JLtitulofilme.setFont(new Font("Tahoma", Font.PLAIN, 15));
		contentPane.add(JLtitulofilme);

		txtTitulo = new JTextField();
		txtTitulo.setBounds(67, 45, 402, 20);
		contentPane.add(txtTitulo);
		txtTitulo.setColumns(10);

		JLabel JLsinopse = new JLabel("Sinopse");
		JLsinopse.setBounds(5, 86, 56, 19);
		JLsinopse.setFont(new Font("Tahoma", Font.PLAIN, 15));
		contentPane.add(JLsinopse);

		txtSinopse = new JTextField();
		txtSinopse.setBounds(69, 86, 350, 65);
		contentPane.add(txtSinopse);
		txtSinopse.setColumns(10);

		JLabel lblNewLabel = new JLabel("Categoria");
		lblNewLabel.setBounds(5, 158, 80, 19);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		contentPane.add(lblNewLabel);

		txtCategoria = new JTextField();
		txtCategoria.setBounds(91, 162, 318, 20);
		contentPane.add(txtCategoria);
		txtCategoria.setColumns(10);

		JSpinner spTempo = new JSpinner();
		spTempo.setBounds(25, 222, 46, 49);
		contentPane.add(spTempo);

		JLabel lblNewLabel_1 = new JLabel("Tempo");
		lblNewLabel_1.setBounds(15, 197, 47, 19);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Imagem");
		lblNewLabel_2.setBounds(110, 197, 56, 19);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		contentPane.add(lblNewLabel_2);

		JRadioButton rdbtn2d = new JRadioButton("2D");
		rdbtn2d.setBounds(110, 222, 43, 21);
		rdbtn2d.setFont(new Font("Tahoma", Font.PLAIN, 15));
		contentPane.add(rdbtn2d);

		JRadioButton rdbtn3d = new JRadioButton("3D");
		rdbtn3d.setBounds(110, 242, 43, 21);
		rdbtn3d.setFont(new Font("Tahoma", Font.PLAIN, 15));
		contentPane.add(rdbtn3d);

		ButtonGroup imagem = new ButtonGroup();
		imagem.add(rdbtn2d);
		imagem.add(rdbtn3d);

		JLabel lblNewLabel_3 = new JLabel("Audio");
		lblNewLabel_3.setBounds(221, 197, 35, 19);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		contentPane.add(lblNewLabel_3);

		JRadioButton rdbtnDublado = new JRadioButton("Dublado");
		rdbtnDublado.setBounds(221, 222, 77, 21);
		rdbtnDublado.setFont(new Font("Tahoma", Font.PLAIN, 15));
		contentPane.add(rdbtnDublado);

		JRadioButton rdbtnLegendado = new JRadioButton("Legendado");
		rdbtnLegendado.setBounds(221, 242, 97, 21);
		rdbtnLegendado.setFont(new Font("Tahoma", Font.PLAIN, 15));
		contentPane.add(rdbtnLegendado);

		ButtonGroup audio = new ButtonGroup();
		audio.add(rdbtnDublado);
		audio.add(rdbtnLegendado);

		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Filme f = new Filme();
				FilmeDAO dao = new FilmeDAO();
				f.setTitulo(txtTitulo.getText());
				f.setSinopse(txtSinopse.getText());
				f.setCategoria(txtCategoria.getText());
				f.setTempo(Integer.parseInt(spTempo.getValue().toString()));
				if (rdbtn2d.isSelected()) {
					f.setImagem3d(false);
				} else if (rdbtn3d.isSelected()) {
					f.setImagem3d(true);
				}
				if (rdbtnDublado.isSelected()) {
					f.setDublado(true);
				} else if (rdbtnLegendado.isSelected()) {
					f.setDublado(false);
				}
				dao.create(f);
				dispose();
				
			}
		});
		btnCadastrar.setBounds(122, 295, 97, 23);
		contentPane.add(btnCadastrar);

		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtTitulo.setText(null);
				txtSinopse.setText(null);
				txtCategoria.setText(null);
				spTempo.setValue(0);
				imagem.clearSelection();
				audio.clearSelection();				
			}
		});
		btnLimpar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnLimpar.setBounds(221, 295, 80, 23);
		contentPane.add(btnLimpar);

		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancelar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnCancelar.setBounds(303, 295, 97, 23);
		contentPane.add(btnCancelar);
	}
}