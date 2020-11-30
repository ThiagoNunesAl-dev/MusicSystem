import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JTextField;
import javax.swing.JSeparator;
import javax.swing.JOptionPane;

public class TelaMeusGeneros {

	public JFrame frame;
	private JTextField novoGeneroTextField;
	
	public void executar(TelaMeusGeneros generos) {
		try {
			frame.setLocationRelativeTo(null);
			generos.frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static String listarGeneros () {
		ConnectionFactory factory = new ConnectionFactory();
		
		Connection c = factory.obterConexao();
		
		GeneroMusicaDAO generoDAO = new GeneroMusicaDAO(c);
		
		String generos = generoDAO.getLista().toString();

		return generos;
	}
	
	
	/**
	 * Create the application.
	 * @wbp.parser.entryPoint
	 */
	
	public void initialize(TelaMeusGeneros generos) throws Exception {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel generosLabel = new JLabel("G\u00EAneros");
		generosLabel.setFont(new Font("Segoe UI", Font.BOLD, 15));
		generosLabel.setBounds(185, 11, 65, 21);
		frame.getContentPane().add(generosLabel);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaMenuPrincipal menu = new TelaMenuPrincipal();
				menu.initialize(menu);
				menu.executar(menu);
				
				generos.frame.setVisible(false);
			}
		});
		btnVoltar.setBounds(10, 227, 89, 23);
		frame.getContentPane().add(btnVoltar);
		
		JButton inserirGeneroButton = new JButton("Adicionar");
		inserirGeneroButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String generoTxt = novoGeneroTextField.getText();
				
				GeneroMusica genero = new GeneroMusica();
				
				genero.setNome(generoTxt);
				
				ConnectionFactory factory = new ConnectionFactory();
				
				Connection c = factory.obterConexao();

				GeneroMusicaDAO generoDao = new GeneroMusicaDAO(c);
				generoDao.adiciona(genero);
			
				JOptionPane.showMessageDialog(null, "Gênero cadastrado com sucesso!");
			}
		});
		inserirGeneroButton.setBounds(164, 227, 96, 23);
		frame.getContentPane().add(inserirGeneroButton);
		
		JScrollPane disponiveisScrollPane = new JScrollPane();
		disponiveisScrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		disponiveisScrollPane.setToolTipText("");
		disponiveisScrollPane.setBounds(10, 66, 193, 46);
		frame.getContentPane().add(disponiveisScrollPane);
		JLabel disponiveis = new JLabel(listarGeneros());
		disponiveisScrollPane.setViewportView(disponiveis);
		
		JScrollPane generosScrollPane = new JScrollPane();
		generosScrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		generosScrollPane.setBounds(231, 66, 193, 46);
		frame.getContentPane().add(generosScrollPane);
		JLabel favoritos = new JLabel(listarGeneros());
		generosScrollPane.setViewportView(favoritos);
		
		JLabel disponiveisLabel = new JLabel("G\u00EAneros dispon\u00EDveis");
		disponiveisLabel.setFont(new Font("Segoe UI", Font.BOLD, 11));
		disponiveisLabel.setBounds(10, 43, 109, 14);
		frame.getContentPane().add(disponiveisLabel);
		
		JLabel meusGenerosLabel = new JLabel("Meus g\u00EAneros preferidos");
		meusGenerosLabel.setFont(new Font("Segoe UI", Font.BOLD, 11));
		meusGenerosLabel.setBounds(231, 43, 193, 14);
		frame.getContentPane().add(meusGenerosLabel);
		
		JLabel novoGeneroLabel = new JLabel("Gênero:");
		novoGeneroLabel.setFont(new Font("Segoe UI", Font.BOLD, 11));
		novoGeneroLabel.setBounds(98, 158, 46, 14);
		frame.getContentPane().add(novoGeneroLabel);
		
		novoGeneroTextField = new JTextField();
		novoGeneroTextField.setBounds(154, 156, 155, 20);
		frame.getContentPane().add(novoGeneroTextField);
		novoGeneroTextField.setColumns(10);
		
		JButton removerButton = new JButton("Remover");
		removerButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String generoTxt = novoGeneroTextField.getText();
				
				GeneroMusica genero = new GeneroMusica();
				
				genero.setNome(generoTxt);
				
				ConnectionFactory factory = new ConnectionFactory();
				
				Connection c = factory.obterConexao();

				GeneroMusicaDAO generoDao = new GeneroMusicaDAO(c);
				generoDao.remove(genero);
			
				JOptionPane.showMessageDialog(null, "Gênero removido com sucesso!");
			}
		});
		removerButton.setBounds(335, 227, 89, 23);
		frame.getContentPane().add(removerButton);
		
		JSeparator separador = new JSeparator();
		separador.setBounds(10, 135, 414, 12);
		frame.getContentPane().add(separador);
	}
}
