import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaMenuPrincipal {

	private JFrame frame;

	public void executar(TelaMenuPrincipal menu) {
		try {
			frame.setLocationRelativeTo(null);
			menu.frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Initialize the contents of the frame.
	 * @wbp.parser.entryPoint
	 */
	public void initialize(TelaMenuPrincipal menu) {
		frame = new JFrame();
		frame.setBounds(100, 100, 500, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel espotifaiLabel = new JLabel("Espotifai");
		espotifaiLabel.setFont(new Font("Segoe UI", Font.BOLD, 15));
		espotifaiLabel.setBounds(209, 11, 66, 21);
		frame.getContentPane().add(espotifaiLabel);
		
		JButton btnGeneros = new JButton("Meus gêneros");
		btnGeneros.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaMeusGeneros generos = new TelaMeusGeneros();
				try {
					generos.initialize(generos);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				generos.executar(generos);
				
				menu.frame.setVisible(false);
			}
		});
		btnGeneros.setBounds(151, 76, 182, 23);
		frame.getContentPane().add(btnGeneros);
		
		JButton btnAvaliar = new JButton("Avaliar músicas");
		btnAvaliar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaAvaliarMusicas tela = new TelaAvaliarMusicas();
				tela.initialize(tela);
				tela.executar(tela);
				
				menu.frame.setVisible(false);
			}
		});
		btnAvaliar.setBounds(151, 126, 182, 23);
		frame.getContentPane().add(btnAvaliar);
		
		JButton btnRecomendacoes = new JButton("Quero recomendações");
		btnRecomendacoes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaRecomendacoes tela = new TelaRecomendacoes();
				tela.initialize(tela);
				tela.executar(tela);
				
				menu.frame.setVisible(false);
			}
		});
		btnRecomendacoes.setBounds(151, 178, 182, 23);
		frame.getContentPane().add(btnRecomendacoes);
		
		JButton btnLogout = new JButton("Logout");
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaLogin login = new TelaLogin();
				login.initialize(login);
				login.executar(login);
				
				menu.frame.setVisible(false);
			}
		});
		btnLogout.setBounds(10, 227, 89, 23);
		frame.getContentPane().add(btnLogout);
	}

}
