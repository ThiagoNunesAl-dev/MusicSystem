import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;

public class TelaAvaliarMusicas {

	public JFrame frame;

	public void executar (TelaAvaliarMusicas tela) {
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
	}

}
