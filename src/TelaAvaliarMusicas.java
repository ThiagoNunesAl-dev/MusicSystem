import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JTextField;
import javax.swing.JOptionPane;

public class TelaAvaliarMusicas {

	public JFrame frame;
	private JTextField musicaTextField;
	private JTextField notaTextField;

	public void executar (TelaAvaliarMusicas tela) {
		try {
			frame.setLocationRelativeTo(null);
			tela.frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static String listarMusicas () {
		ConnectionFactory factory = new ConnectionFactory();
		
		Connection c = factory.obterConexao();
		
		MusicaDAO musicaDAO = new MusicaDAO(c);
		
		String musicas = musicaDAO.getLista().toString();

		return musicas;
	}

	/**
	 * Initialize the contents of the frame.
	 * @wbp.parser.entryPoint
	 */
	public void initialize(TelaAvaliarMusicas avaliar) {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaMenuPrincipal menu = new TelaMenuPrincipal();
				menu.initialize(menu);
				menu.executar(menu);
				
				avaliar.frame.setVisible(false);
			}
		});
		btnVoltar.setBounds(10, 227, 89, 23);
		frame.getContentPane().add(btnVoltar);
		
		JLabel avaliarLabel = new JLabel("Avaliar m\u00FAsicas");
		avaliarLabel.setFont(new Font("Segoe UI", Font.BOLD, 15));
		avaliarLabel.setBounds(153, 11, 128, 23);
		frame.getContentPane().add(avaliarLabel);
		
		JScrollPane avaliarScrollPane = new JScrollPane();
		avaliarScrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		avaliarScrollPane.setBounds(10, 83, 208, 82);
		frame.getContentPane().add(avaliarScrollPane);
		JLabel musicas = new JLabel(listarMusicas());
		avaliarScrollPane.setViewportView(musicas);
		
		musicaTextField = new JTextField();
		musicaTextField.setBounds(271, 83, 153, 20);
		frame.getContentPane().add(musicaTextField);
		musicaTextField.setColumns(10);
		
		JLabel musicaLabel = new JLabel("M\u00FAsica:");
		musicaLabel.setFont(new Font("Segoe UI", Font.BOLD, 11));
		musicaLabel.setBounds(271, 62, 46, 14);
		frame.getContentPane().add(musicaLabel);
		
		notaTextField = new JTextField();
		notaTextField.setBounds(271, 145, 153, 20);
		frame.getContentPane().add(notaTextField);
		notaTextField.setColumns(10);
		
		JLabel notaLabel = new JLabel("Nota:");
		notaLabel.setFont(new Font("Segoe UI", Font.BOLD, 11));
		notaLabel.setBounds(271, 120, 46, 14);
		frame.getContentPane().add(notaLabel);
		
		JButton btnAdicionar = new JButton("Adicionar");
		btnAdicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String musicaTxt = musicaTextField.getText();
				float notaTxt = Float.parseFloat(notaTextField.getText());
				
				Musica musica = new Musica();
				
				musica.setNome(musicaTxt);
				musica.setNota(notaTxt);
				
				ConnectionFactory factory = new ConnectionFactory();
				
				Connection c = factory.obterConexao();

				MusicaDAO musicaDao = new MusicaDAO(c);
				musicaDao.adiciona(musica);
			
				JOptionPane.showMessageDialog(null, "Música cadastrada com sucesso!");
			}
		});
		btnAdicionar.setBounds(182, 227, 89, 23);
		frame.getContentPane().add(btnAdicionar);
		
		JButton btnRemover = new JButton("Remover");
		btnRemover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String musicaTxt = musicaTextField.getText();
				
				Musica musica = new Musica();
				
				musica.setNome(musicaTxt);
				
				ConnectionFactory factory = new ConnectionFactory();
				
				Connection c = factory.obterConexao();

				MusicaDAO musicaDao = new MusicaDAO(c);
				musicaDao.remove(musica);
			
				JOptionPane.showMessageDialog(null, "Música removida com sucesso!");
			}
		});
		btnRemover.setBounds(335, 227, 89, 23);
		frame.getContentPane().add(btnRemover);
		
		JLabel titleLabel = new JLabel("Todas as m\u00FAsicas:");
		titleLabel.setFont(new Font("Segoe UI", Font.BOLD, 11));
		titleLabel.setBounds(10, 58, 134, 23);
		frame.getContentPane().add(titleLabel);
	}

}
