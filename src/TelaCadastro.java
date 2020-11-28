import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JSeparator;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.awt.event.ActionEvent;

public class TelaCadastro {

	public JFrame frame;
	private JTextField userTextField;
	private JTextField senhaTextField;
	
	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastro window = new TelaCadastro();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/
	
	public void executar(TelaCadastro tela) {
		try {
			frame.setLocationRelativeTo(null);
			tela.frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Create the application.
	 */
	/*public TelaCadastro() {
		initialize();
	}*/

	/**
	 * Initialize the contents of the frame.
	 * @wbp.parser.entryPoint
	 */
	public void initialize(TelaCadastro cadastro) {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(100, 100, 500, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel cadastroLabel = new JLabel("Cadastro");
		cadastroLabel.setBounds(213, 11, 69, 21);
		cadastroLabel.setFont(new Font("Segoe UI", Font.BOLD, 15));
		frame.getContentPane().add(cadastroLabel);
		
		JLabel userNewLabel = new JLabel("Escolha um nome de usu\u00E1rio:");
		userNewLabel.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		userNewLabel.setBounds(24, 76, 165, 14);
		frame.getContentPane().add(userNewLabel);
		
		JLabel senhaLabel = new JLabel("Escolha uma senha:");
		senhaLabel.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		senhaLabel.setBounds(78, 133, 111, 14);
		frame.getContentPane().add(senhaLabel);
		
		userTextField = new JTextField();
		userTextField.setBounds(224, 74, 180, 20);
		frame.getContentPane().add(userTextField);
		userTextField.setColumns(10);
		
		senhaTextField = new JTextField();
		senhaTextField.setBounds(224, 131, 180, 20);
		frame.getContentPane().add(senhaTextField);
		senhaTextField.setColumns(10);
		
		JSeparator separador1 = new JSeparator();
		separador1.setBounds(24, 48, 443, 2);
		frame.getContentPane().add(separador1);
		
		JSeparator separador2 = new JSeparator();
		separador2.setBounds(24, 184, 443, 2);
		frame.getContentPane().add(separador2);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String usuarioTxt = userTextField.getText();
				String senhaTxt = senhaTextField.getText();
				
				Usuario usuario = new Usuario();
				
				usuario.setNome(usuarioTxt);
				usuario.setSenha(senhaTxt);
				
				ConnectionFactory factory = new ConnectionFactory();
				
				Connection c = factory.obterConexao();

				UsuarioDAO usuarioDao = new UsuarioDAO(c);
				usuarioDao.adiciona(usuario);
			
				JOptionPane.showMessageDialog(null, "Usuário cadastrado com sucesso!");
				
				TelaLogin login = new TelaLogin();
				login.initialize(login);
				login.executar(login);
				
				cadastro.frame.setVisible(false);
		}});
		btnCadastrar.setBounds(199, 197, 111, 23);
		frame.getContentPane().add(btnCadastrar);
		
		JButton btnNewButton = new JButton("Limpar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				userTextField.setText(null);
				senhaTextField.setText(null);
			}
		});
		btnNewButton.setBounds(34, 197, 89, 23);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaLogin login = new TelaLogin();
				login.initialize(login);
				login.executar(login);
				
				cadastro.frame.setVisible(false);
			}
		});
		btnVoltar.setBounds(378, 197, 89, 23);
		frame.getContentPane().add(btnVoltar);
	}
}
