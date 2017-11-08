package aula8.ex1;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class GameWindow implements ActionListener{
	
	static JToggleButton[] buttons = new JToggleButton[9];
	private GameHandler jogo = new GameHandler();
	
	public GameWindow() {
		createGameWindow();
	}
	
	public void createGameWindow() {
		JFrame frame = new JFrame("Jogo do Galo");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(400,400);
		
		JPanel content = (JPanel)frame.getContentPane();
		content.setBackground(Color.WHITE);
		content.setLayout(new GridLayout(3,3));

		JPanel statContainer = new JPanel();
		statContainer.setBackground(Color.WHITE);
		statContainer.setLayout(new FlowLayout());
		
		//Creates the Buttons
		for(int i = 0; i < 9; i++) {
			buttons[i] = new JToggleButton();
			buttons[i].setFont(new Font("Arial", Font.BOLD, 50));
			buttons[i].addActionListener(this);
			content.add(buttons[i]);
		}
		frame.setContentPane(content);
		frame.setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent event) {
		JToggleButton button = (JToggleButton) event.getSource();
		button.setEnabled(false);
		if(button == buttons[0]) {
			jogo.efetuarJogada(1,1);
		}else if(button == buttons[1]) {
			jogo.efetuarJogada(2,1);
		}else if(button == buttons[2]) {
			jogo.efetuarJogada(3,1);
		}else if(button == buttons[3]) {
			jogo.efetuarJogada(1,2);
		}else if(button == buttons[4]) {
			jogo.efetuarJogada(2,2);
		}else if(button == buttons[5]) {
			jogo.efetuarJogada(3,2);
		}else if(button == buttons[6]) {
			jogo.efetuarJogada(1,3);
		}else if(button == buttons[7]) {
			jogo.efetuarJogada(2,3);
		}else if(button == buttons[8]) {
			jogo.efetuarJogada(3,3);
		}
		button.setText(jogo.ultimoJogador());
		if(jogo.terminado()) {
			if(jogo.ultimoJogadorGanhou())	
				JOptionPane.showMessageDialog(null,"O jogador "+jogo.ultimoJogador()+" ganhou!");
			else
				JOptionPane.showMessageDialog(null,"Empate!");
			System.exit(0);
		}
	}
	
}