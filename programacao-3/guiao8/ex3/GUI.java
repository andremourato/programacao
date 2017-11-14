package aula8.ex3;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.List;
import org.jdesktop.layout.GroupLayout;

public class GUI extends JFrame{
	
	private JLabel imageHolder = new JLabel();
	private JLabel levelHolder = new JLabel("0€");
	
	//Question Holder
	private JTextArea question = new JTextArea();
	private JScrollPane jScrollPanel = new JScrollPane();
	
	//Buttons
	private JButton buttonDesistir;
	private JButton buttonConfirmar;
	//Help Buttons
	private JButton buttonPublico;
	private JButton buttonTelefone;
	private JButton button50;
	//Options Buttons
	private ButtonGroup buttonGroup = new ButtonGroup();
	private JRadioButton optionA;
	private JRadioButton optionB;
	private JRadioButton optionC;
	private JRadioButton optionD;
	
	//Questions
	private QuizList quizes = new QuizList(); //(KEY=LevelOfDifficulty,VALUE=ArrayOfQuizes)
	private Question nextQuestion;
	private int numQuestionsAnswered = 0;
	
	/*//Help
	private boolean has5050 = true;
	private boolean hasTelefone = true;
	private boolean hasPublico = true;*/
	
	private int prizes[] = {0, 25,    50,    125,    250,   500,
							   750,   1500,  2500,  5000,   10000,
							   16000, 32000, 64000, 125000, 250000};
	
	public GUI() {
		super("Quem Quer Ser Milionário");
		int width = 660;
		int height = 455;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new FlowLayout());
		setSize(width,height);
		
		//Reads the file with the information about the questions
		loadQuestionsFromFile();
		
		//Event Buttons
		buttonDesistir = new JButton("Desistir");
		buttonDesistir.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				givePrize();
			}
		});
		
		buttonConfirmar = new JButton("Confirmar");
		buttonConfirmar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(noButtonSelected()) return; //checks if an option has been chosen
				checkAnswer(selectedButtonText());
				loadNextQuestion();
			}
			
		});
		
		buttonPublico = new JButton("Ajuda Publico");
		buttonPublico.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				showHelpPublico();
			}
			
		});
		
		buttonTelefone = new JButton("Telefone");
		buttonTelefone.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				showHelpPhone();
			}
			
		});
		
		button50 = new JButton("50 - 50");
		button50.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				showHelp5050();
			}
			
		});
		
		//Option Buttons
		optionA = new JRadioButton("Option A");
		optionB = new JRadioButton("Option B");
		optionC = new JRadioButton("Option C");
		optionD = new JRadioButton("Option D");
		buttonGroup.add(optionA);
		buttonGroup.add(optionB);
		buttonGroup.add(optionC);
		buttonGroup.add(optionD);
		
		question = new JTextArea();
		question.setBackground(new Color(240, 240, 240));
	    question.setColumns(20);
	    question.setEditable(false);
	    question.setFont(new Font("Arial", 0, 25));
	    question.setLineWrap(true);
	    question.setRows(5);
	    question.setWrapStyleWord(true);
	    question.setBorder(BorderFactory.createLineBorder(new Color(240, 240, 240), 0));
	    jScrollPanel.setViewportView(question);
		
		//Overall layout
		drawLayout();
		
		//Start the game
		loadNextQuestion();
	}
	
	private boolean noButtonSelected() {
		Enumeration<AbstractButton> buttons = buttonGroup.getElements();
		while(buttons.hasMoreElements()) {
			if(buttons.nextElement().isSelected()) return false;
		}
		return true;
	}
	
	private void enableAllButtons() {
		Enumeration<AbstractButton> buttons = buttonGroup.getElements();
		while(buttons.hasMoreElements()) {
			buttons.nextElement().setEnabled(true);;
		}
	}
	
	private void resetButtonStatus() {
		buttonGroup.clearSelection();
	}
	
	private void checkAnswer(String selectedOption) {
		
		if(selectedOption.equals(nextQuestion.getOptions()[0])) {
			resetButtonStatus();
			numQuestionsAnswered++;
			quizes.remove(nextQuestion);
			loadNextQuestion();
		}
		else
			givePrize();
		
	}
	
	private String selectedButtonText() {
		if(optionA.isSelected()) return optionA.getText();
		else if(optionB.isSelected()) return optionB.getText();
		else if(optionC.isSelected()) return optionC.getText();
		else if(optionD.isSelected()) return optionD.getText();
		else return null;
	}
	
	private void givePrize() {
		JOptionPane.showMessageDialog(null,
				"Ganhou "+prizes[numQuestionsAnswered]+" euros");
		System.exit(0);
	}
	
	private void showHelpPublico() {
		int min = -1;
		int max = -1;
		if(quizes.getCurrentLevel()==0) {
			max = 90;
			min = 70;
		}else if(quizes.getCurrentLevel()==1) {
			max = 70;
			min = 50;
		}else if(quizes.getCurrentLevel()==2) {
			max = 50;
			min = 40;
		}
		//Shuffles the option order
		Enumeration<AbstractButton> elements = buttonGroup.getElements();
		List<String> options = new ArrayList<String>();
		while(elements.hasMoreElements()){
			options.add(elements.nextElement().getText());
		}
		Collections.shuffle(options);
		String info = "";
		//Gets the index of the solution in the shuffled list
		int solutionIndex = -1;
		for(int i = 0; i < 4; i++) {
			if(options.get(i).equals(nextQuestion.solution())) solutionIndex = i;
		}
		//Chooses a random value for the probability of the correct answer
		int probCorrect = min + (int)(Math.random() * (max - min + 1));
		max = 100-probCorrect;
		min = 0;
		//Chooses a random value for the remaining options
		//The sum of all teh probabilities must be 100%
		int numChosen = 0;
		for(int i = 0; i < 4; i++){
			if(i == solutionIndex) {
				info += options.get(i)+": "+probCorrect+"%\n";
				continue;
			}
			if(numChosen >= 2) {
				info += options.get(i)+": "+max+"%\n";
				continue;
			}
			int prob = min + (int)(Math.random() * (max - min + 1));
			info += options.get(i)+": "+prob+"%\n";
			max = max - prob;
			numChosen++;
		}
		JOptionPane.showMessageDialog(null,info,"Ajuda Publico", JOptionPane.INFORMATION_MESSAGE);
		buttonPublico.setEnabled(false);
	}
	
	private void showHelpPhone() {
		int min = -1;
		int max = -1;
		if(quizes.getCurrentLevel()==0) {
			max = 100;
			min = 80;
		}else if(quizes.getCurrentLevel()==1) {
			max = 80;
			min = 60;
		}else if(quizes.getCurrentLevel()==2) {
			max = 60;
			min = 40;
		}
		String info = "Dúvida entre:\n";
		int probCorrect = min + (int)(Math.random() * (max - min));
		int randIndex = 1 + (int)(Math.random()*3);
		info += nextQuestion.getOptions()[0]+": "+probCorrect+"%\n";
		info += nextQuestion.getOptions()[randIndex]+": "+(100-probCorrect)+"%";
		JOptionPane.showMessageDialog(null,info,"Ajuda Telefone", JOptionPane.INFORMATION_MESSAGE);
		buttonTelefone.setEnabled(false);
		
	}
	
	private void showHelp5050() {
		String solution = nextQuestion.getOptions()[0];
		Enumeration<AbstractButton> elements = buttonGroup.getElements();
		List<String> options = new ArrayList<String>();
		while(elements.hasMoreElements()){
			options.add(elements.nextElement().getText());
		}
		Collections.shuffle(options);
		int numDisabled = 0;
		for(String option : options) {
			if(numDisabled < 2) {
				if(optionA.getText().equals(option) && !optionA.getText().equals(solution)) {
					optionA.setEnabled(false);
					numDisabled++;
				}
				if(optionB.getText().equals(option) && !optionB.getText().equals(solution)) {
					optionB.setEnabled(false);
					numDisabled++;
				}
				if(optionC.getText().equals(option) && !optionC.getText().equals(solution)) {
					optionC.setEnabled(false);
					numDisabled++;
				}
				if(optionD.getText().equals(option) && !optionD.getText().equals(solution)) {
					optionD.setEnabled(false);
					numDisabled++;
				}
			}else break;
		}
		button50.setEnabled(false); //Disables the button since it can only be played once
		
	}
	
	private void loadNextQuestion() {
		if(quizes.numQuestions() == 0) givePrize(); //game is over if there are no more questions to be loaded
		enableAllButtons();
		ArrayList<Question> currentLevelQuizes = quizes.get(quizes.getCurrentLevel());
		nextQuestion = currentLevelQuizes.get((int)(Math.random()*currentLevelQuizes.size()));
		question.setText(nextQuestion.getQuestion());
		levelHolder.setText(prizes[numQuestionsAnswered]+"€");
		imageHolder.setIcon(new ImageIcon(nextQuestion.getImageName()));
		List<Integer> randomIndexes = new ArrayList<>();
		for(int i = 0; i < 4; i++) {
			randomIndexes.add(i);
		}
		Collections.shuffle(randomIndexes);
		String[] nextOptions = nextQuestion.getOptions();
		optionA.setText(nextOptions[randomIndexes.get(0)]);
		optionB.setText(nextOptions[randomIndexes.get(1)]);
		optionC.setText(nextOptions[randomIndexes.get(2)]);
		optionD.setText(nextOptions[randomIndexes.get(3)]);
	}
	
	private void loadQuestionsFromFile() {
		try {
			List<String> rawInfo = Files.readAllLines(Paths.get("questions.txt"),Charset.forName("ISO-8859-1"));
			for(String line : rawInfo) {
				String[] lineSplit = line.split("&&");
				Question q = new Question(
					lineSplit[0].split(":")[1],
					lineSplit[1],
					new String[] {
						lineSplit[2],
						lineSplit[3],
						lineSplit[4],
						lineSplit[5]
					},
					Integer.parseInt(lineSplit[6])
				);
				quizes.insert(q);
					
			}
		} catch (IOException e) {
			System.out.println("Questions file cannot be opened. Closing application...");
			System.exit(1);
		}
	}	
	
	private void drawLayout() {
		GroupLayout layout = new GroupLayout(getContentPane());
	    getContentPane().setLayout(layout);
	    layout.setHorizontalGroup(layout.createParallelGroup(1)
	      .add(layout.createSequentialGroup()
	        .addContainerGap()
	        .add(layout.createParallelGroup(1)
	          .add(layout.createSequentialGroup()
	            .add(imageHolder, -2, 297, -2)
	            .addPreferredGap(1)
	            .add(layout.createParallelGroup(1)
	              .add(jScrollPanel, -2, 274, -2)
	              .add(levelHolder, -1, 274, 32767)))
	          .add(layout.createSequentialGroup()
	            .add(layout.createParallelGroup(2)
	              .add(1, optionC, -1, 203, 32767)
	              .add(1, layout.createSequentialGroup()
	                .add(buttonPublico, -1, -1, 32767)
	                .addPreferredGap(0)
	                .add(buttonTelefone, -2, 100, -2))
	              .add(1, optionA, -1, 203, 32767))
	            .addPreferredGap(0)
	            .add(layout.createParallelGroup(1)
	              .add(button50, -2, 99, -2)
	              .add(optionB, -2, 218, -2)
	              .add(layout.createSequentialGroup()
	                .add(optionD, -2, 218, -2)
	                .addPreferredGap(0)
	                .add(buttonDesistir, -1, -1, 32767)
	                .addPreferredGap(0)
	                .add(buttonConfirmar)))))
	        .addContainerGap()));
	    

	    layout.setVerticalGroup(layout.createParallelGroup(1)
	    	      .add(layout.createSequentialGroup()
	    	        .add(layout.createParallelGroup(2, false)
	    	          .add(imageHolder, -2, 283, -2)
	    	          .add(1, layout.createSequentialGroup()
	    	            .add(levelHolder, -2, 26, -2)
	    	            .addPreferredGap(0, -1, 32767)
	    	            .add(jScrollPanel, -2, 190, -2)))
	    	        .addPreferredGap(1)
	    	        .add(layout.createParallelGroup(1)
	    	          .add(layout.createParallelGroup(3)
	    	            .add(buttonTelefone)
	    	            .add(button50))
	    	          .add(buttonPublico))
	    	        .add(11, 11, 11)
	    	        .add(layout.createParallelGroup(2)
	    	          .add(layout.createSequentialGroup()
	    	            .add(layout.createParallelGroup(1)
	    	              .add(optionA)
	    	              .add(optionB))
	    	            .add(16, 16, 16)
	    	            .add(layout.createParallelGroup(3)
	    	              .add(optionC)
	    	              .add(optionD)))
	    	          .add(layout.createParallelGroup(3)
	    	            .add(buttonConfirmar)
	    	            .add(buttonDesistir)))
	    	        .addContainerGap()));
		
		setVisible(true);
	}
	
}
