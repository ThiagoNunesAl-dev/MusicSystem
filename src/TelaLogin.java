import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;


import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.JSeparator;

public class TelaLogin {

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
					TelaLogin window = new TelaLogin();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/
	
	public void executar(TelaLogin login) {
		try {
			frame.setLocationRelativeTo(null);
			login.frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Create the application.
	 */
	/*public TelaLogin() {
		initialize();
	}*/

	/**
	 * Initialize the contents of the frame.
	 * @wbp.parser.entryPoint
	 */
	public void initialize(TelaLogin login) {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(100, 100, 500, 300);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel titleLabel = new JLabel("Login");
		titleLabel.setFont(new Font("Segoe UI", Font.BOLD, 15));
		titleLabel.setBounds(219, 11, 46, 21);
		frame.getContentPane().add(titleLabel);
		
		JLabel userLabel = new JLabel("Usu\u00E1rio:");
		userLabel.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		userLabel.setBounds(121, 75, 58, 14);
		frame.getContentPane().add(userLabel);
		
		userTextField = new JTextField();
		userTextField.setBounds(189, 73, 169, 20);
		frame.getContentPane().add(userTextField);
		userTextField.setColumns(10);
		
		JLabel senhaLabel = new JLabel("Senha:");
		senhaLabel.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		senhaLabel.setBounds(121, 128, 46, 14);
		frame.getContentPane().add(senhaLabel);
		
		senhaTextField = new JTextField();
		senhaTextField.setBounds(189, 122, 169, 20);
		frame.getContentPane().add(senhaTextField);
		senhaTextField.setColumns(10);
		
		JButton btnEntrar = new JButton("Entrar");
		btnEntrar.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		btnEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String senha = senhaTextField.getText();
				String usuario = userTextField.getText();
				
				String sql = "select * from usuario where NOME_USUARIO = ? and SENHA_USUARIO = ?";
				
				ConnectionFactory factory = new ConnectionFactory();
				
				try (Connection c = factory.obterConexao()) {
					PreparedStatement ps = c.prepareStatement(sql);
					ps.setString(1, usuario);
					ps.setString(2, senha);
					
					ResultSet rs = ps.executeQuery();
					
					if(rs.next()) {
						JOptionPane.showMessageDialog(null, "Login efetuado com sucesso!");
						TelaMenuPrincipal menu = new TelaMenuPrincipal();
						menu.initialize(menu);
						menu.executar(menu);
						frame.dispose();
					} else {
						JOptionPane.showMessageDialog(null, "Usuário ou senha não cadastrados!");
					}
				} catch(Exception ex) {
					JOptionPane.showMessageDialog(null, "Ocorreu um erro de conexão.");
				}
			}
		});
		btnEntrar.setBounds(200, 184, 89, 23);
		frame.getContentPane().add(btnEntrar);
		
		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				userTextField.setText(null);
				senhaTextField.setText(null);
			}
		});
		btnLimpar.setBounds(78, 184, 89, 23);
		frame.getContentPane().add(btnLimpar);
		
		JButton btnCadastrar = new JButton("Cadastre-se");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaCadastro cadastro = new TelaCadastro();
				cadastro.initialize(cadastro);
				cadastro.executar(cadastro);
				login.frame.setVisible(false);
			}
		});
		btnCadastrar.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		btnCadastrar.setBounds(319, 185, 106, 23);
		frame.getContentPane().add(btnCadastrar);
		
		JSeparator separador2 = new JSeparator();
		separador2.setBounds(78, 159, 347, 14);
		frame.getContentPane().add(separador2);
		
		JSeparator separador1 = new JSeparator();
		separador1.setBounds(78, 48, 347, 14);
		frame.getContentPane().add(separador1);
	}
}
