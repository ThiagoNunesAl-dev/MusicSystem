import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaMeusGeneros {

	public JFrame frame;
	
	public void executar(TelaMeusGeneros generos) {
		try {
			frame.setLocationRelativeTo(null);
			generos.frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the application.
	 * @wbp.parser.entryPoint
	 */
	
	public void initialize(TelaMeusGeneros generos) {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel generosLabel = new JLabel("Meus Gêneros");
		generosLabel.setFont(new Font("Segoe UI", Font.BOLD, 15));
		generosLabel.setBounds(163, 11, 109, 21);
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
	}

}
