import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

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
		recomendacoesLabel.setBounds(126, 11, 171, 23);
		frame.getContentPane().add(recomendacoesLabel);
	}

}
