import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

public class TelaRecomendacoes {

	public JFrame frame;
	
	public void executar (TelaRecomendacoes tela) {
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
	public void initialize(TelaRecomendacoes tela) {
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
				
				tela.frame.setVisible(false);
			}
		});
		btnVoltar.setBounds(10, 227, 89, 23);
		frame.getContentPane().add(btnVoltar);
		
		JLabel recomendacoesLabel = new JLabel("Quero recomendações!");
		recomendacoesLabel.setFont(new Font("Segoe UI", Font.BOLD, 15));
		recomendacoesLabel.setBounds(131, 11, 171, 23);
		frame.getContentPane().add(recomendacoesLabel);
		
		JScrollPane recomendacoesScrollPane = new JScrollPane();
		recomendacoesScrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		recomendacoesScrollPane.setBounds(85, 85, 260, 79);
		frame.getContentPane().add(recomendacoesScrollPane);
		JLabel musicas = new JLabel(listarMusicas());
		recomendacoesScrollPane.setViewportView(musicas);
	}

}
