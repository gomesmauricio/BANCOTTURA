package VIEW;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import DAO.PessoaDAO;
import DAO.PessoaDAOimplement;
import ENTIDADES.Pessoa;
import EXCEPTIONS.ElementoNaoEncontradoException;
import EXCEPTIONS.RegistroCadastradoComSucessoException;
import EXCEPTIONS.RegistroExcluidoException;
import EXCEPTIONS.RegistroAlteradoException;
import UTIL.Clear;

public class CadastroCliente extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textNome;
	private JTextField textCPF;
	private JTextField textIdade;
	private JTextField textConta;
	private JTextField textEndereco;


	/**
	 * Create the dialog.
	 */
	public CadastroCliente() {

		setTitle("Bancottura Cadastro Cliente");
		setResizable(false);
		setBounds(100, 100, 525, 312);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		JLabel lblNewLabel = new JLabel("***Cadastro de Pessoa***");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(138, 11, 214, 14);
		contentPanel.add(lblNewLabel);

		textNome = new JTextField();
		textNome.setBounds(64, 51, 279, 20);
		contentPanel.add(textNome);
		textNome.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("Nome:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1.setBounds(20, 57, 46, 14);
		contentPanel.add(lblNewLabel_1);

		JLabel lblNewLabel_1_1 = new JLabel("CPF:");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1_1.setBounds(20, 106, 34, 14);
		contentPanel.add(lblNewLabel_1_1);

		textCPF = new JTextField();
		textCPF.setBounds(64, 100, 138, 20);
		contentPanel.add(textCPF);
		textCPF.setColumns(10);

		JLabel lblNewLabel_1_2 = new JLabel("Endere\u00E7o/ID:");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1_2.setBounds(319, 106, 86, 14);
		contentPanel.add(lblNewLabel_1_2);

		JLabel lblNewLabel_1_1_1 = new JLabel("Idade:");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1_1_1.setBounds(353, 57, 52, 14);
		contentPanel.add(lblNewLabel_1_1_1);

		textIdade = new JTextField();
		textIdade.setBounds(400, 51, 95, 20);
		contentPanel.add(textIdade);
		textIdade.setColumns(10);

		JLabel lblNewLabel_1_1_2 = new JLabel("Conta:");
		lblNewLabel_1_1_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1_1_2.setBounds(20, 155, 46, 14);
		contentPanel.add(lblNewLabel_1_1_2);

		JLabel lblNewLabel_1_1_2_1 = new JLabel("Genero:");
		lblNewLabel_1_1_2_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1_1_2_1.setBounds(366, 143, 56, 14);
		contentPanel.add(lblNewLabel_1_1_2_1);

		textConta = new JTextField();
		textConta.setBounds(64, 153, 138, 20);
		contentPanel.add(textConta);
		textConta.setColumns(10);

		textEndereco = new JTextField();
		textEndereco.setBounds(409, 104, 86, 20);
		contentPanel.add(textEndereco);
		textEndereco.setColumns(10);

		JRadioButton rbM = new JRadioButton("M");
		rbM.setFont(new Font("Tahoma", Font.BOLD, 12));
		rbM.setBounds(353, 164, 46, 23);
		contentPanel.add(rbM);

		JRadioButton rbF = new JRadioButton("F");
		rbF.setFont(new Font("Tahoma", Font.BOLD, 12));
		rbF.setBounds(404, 164, 46, 23);
		contentPanel.add(rbF);

		ButtonGroup bg = new ButtonGroup();
		bg.add(rbM);
		bg.add(rbF);

		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);

			JButton btBuscar = new JButton("Buscar");
			btBuscar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {

					String cpf = (JOptionPane.showInputDialog(null, "Informe o CPF", "Localizar",
							JOptionPane.INFORMATION_MESSAGE));

					try {
						Pessoa pessoa = new Pessoa();
						PessoaDAO pessoaDAO = new PessoaDAOimplement();
						pessoa = pessoaDAO.pesquisar(cpf);

						textNome.setText(pessoa.getNome());
						textCPF.setText(pessoa.getCpf());
						textIdade.setText(Integer.toString(pessoa.getIdade()));
						textEndereco.setText(Integer.toString(pessoa.getId_endereco()));
						textConta.setText(Integer.toString(pessoa.getNumero_conta()));

						if (pessoa.getGenero().equals("F")) {
							rbF.setSelected(true);
						} else {
							rbM.setSelected(true);
						}

					}

					catch (ElementoNaoEncontradoException e2) {
						JOptionPane.showMessageDialog(null, e2.getMessage(), "Alteração",
								JOptionPane.INFORMATION_MESSAGE);

					}

				}
			});

			JButton btExcluir = new JButton("Excluir");
			btExcluir.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					Pessoa pessoa = new Pessoa();

					try {

						JOptionPane.showConfirmDialog(null, "Deseja Realmente Excluir o Registro?", "Atenção",
								JOptionPane.WARNING_MESSAGE);

						PessoaDAO pessoaDAO = new PessoaDAOimplement();
						pessoaDAO.remover(textCPF.getText());

					} catch (RegistroExcluidoException ex) {

						JOptionPane.showMessageDialog(null, ex.getMessage(), "Exclusão",
								JOptionPane.INFORMATION_MESSAGE);
						Clear.limpar(contentPanel);

					}

				}
			});
			buttonPane.add(btExcluir);

			JButton btAlterar = new JButton("Alterar");
			btAlterar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {

					if (!textEndereco.getText().equals("")) {
						Pessoa pessoa = new Pessoa();

						pessoa.setNome(textNome.getText());
						pessoa.setIdade(Integer.parseInt(textIdade.getText() ));
						pessoa.setId_endereco(Integer.parseInt(textEndereco.getText()));
						pessoa.setNumero_conta(Integer.parseInt(textConta.getText()));
						pessoa.setCpf(textNome.getText());
						
						if(rbF.isSelected()) {
							pessoa.setGenero("F");
						}else {
							pessoa.setGenero("M");
						}
						
						PessoaDAO pessoaDAO = new PessoaDAOimplement();
						try {
							pessoaDAO.alterar(pessoa);
						} catch (Exception e1) {

							e1.printStackTrace();

							Clear.limpar(contentPanel);

						}

					} else {
						JOptionPane.showMessageDialog(null, "Necessario preencher todos os Campos!", "Atenção",
								JOptionPane.WARNING_MESSAGE);
					}
				}
			});
			buttonPane.add(btAlterar);
			buttonPane.add(btBuscar);

			JButton btSalvar = new JButton("Salvar");
			btSalvar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {

					if ((!textNome.getText().equals("")) && (!textIdade.getText().equals(""))
							&& (!textCPF.getText().equals("")) && (!textEndereco.getText().equals(""))
							&& (!textConta.getText().equals("")) && (rbF.isSelected() || rbM.isSelected())) {

						Pessoa pessoa = new Pessoa();
						PessoaDAO pessoaDAO = new PessoaDAOimplement();

						pessoa.setNome(textNome.getText());
						pessoa.setCpf(textCPF.getText());
						pessoa.setIdade(Integer.parseInt(textIdade.getText()));

						if (rbF.isSelected()) {
							pessoa.setGenero("F");
						} else {
							pessoa.setGenero("M");
						}

						pessoa.setId_endereco(Integer.parseInt(textEndereco.getText()));
						pessoa.setNumero_conta(Integer.parseInt(textConta.getText()));

						try {
							pessoaDAO.inserir(pessoa);

						} catch (RegistroCadastradoComSucessoException e1) {
							JOptionPane.showMessageDialog(null, e1.getMessage(), "Cadastro",
									JOptionPane.INFORMATION_MESSAGE);
							Clear.limpar(contentPanel);

						}
					} else {
						JOptionPane.showMessageDialog(null, "Necessário preencher todos os campos!", "ATENÇÃO",
								JOptionPane.INFORMATION_MESSAGE);
					}
				}

			});
			buttonPane.add(btSalvar);
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {

						Clear.limpar(contentPanel);
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}
