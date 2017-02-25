import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Rectangle;

import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JSlider;
import java.awt.Label;
import java.awt.Cursor;

public class MastermindGUIV2 extends JFrame {

	private static final long serialVersionUID = 1L;

	private JPanel contentPane;

	private int maxGuesses = 20;

	// keeping track of scores
	private int currentPlayer = 1;
	private int[] playerScore = new int[2];

	// pin panel configuration
	private int xPin = 304;
	private int yPin = 5;
	private int widthPin = 10;
	private int heightPin = 40;

	// guess panel configuration
	private int xGuess = 4;
	private int yGuess = 5;
	private int widthGuess = 40;
	private int heightGuess = 40;

	// buttons for the current input which can be changed by the user
	private JButton Input1;
	private JButton Input2;
	private JButton Input3;
	private JButton Input4;
	private boolean isSetInput1 = false;
	private boolean isSetInput2 = false;
	private boolean isSetInput3 = false;
	private boolean isSetInput4 = false;
	private JButton[] current = new JButton[4];

	// solution decided by user or chance
	private JButton Solution1;
	private JButton Solution2;
	private JButton Solution3;
	private JButton Solution4;
	private Color[] solution = new Color[4];

	// the 8 allowed colours
	// used by user for inputting solution and next guess
	private JButton Colour1;
	private JButton Colour2;
	private JButton Colour3;
	private JButton Colour4;
	private JButton Colour5;
	private JButton Colour6;
	private JButton Colour7;
	private JButton Colour8;

	// miscellaneous
	private JButton setSoluBtn;
	private JButton GuessBtn;
	private JLabel lblAllowedColours;
	private JLabel EndOfGameLbl;
	private JButton playAgainBtn;
	private JButton playCompBtn;

	// the random evaluation configurations
	public final int[][] eval = new int[][] { // null
			{ 0, 1, 2, 3 }, { 0, 1, 3, 2 }, { 0, 2, 1, 3 }, { 0, 2, 3, 1 }, // four
			{ 0, 3, 1, 2 }, { 0, 3, 2, 1 }, { 1, 0, 2, 3 }, { 1, 0, 3, 2 }, // eight
			{ 1, 2, 0, 3 }, { 1, 2, 3, 0 }, { 1, 3, 0, 2 }, { 1, 3, 2, 0 }, // twelve
			{ 2, 0, 1, 3 }, { 2, 0, 3, 1 }, { 2, 1, 0, 3 }, { 2, 1, 3, 0 }, // sixteen
			{ 2, 3, 0, 1 }, { 2, 3, 1, 0 }, { 3, 0, 1, 2 }, { 3, 0, 2, 1 }, // twenty
			{ 3, 1, 0, 2 }, { 3, 1, 2, 0 }, { 3, 2, 0, 1 }, { 3, 2, 1, 0 } // twenty-four
	};

	// configure the used colours
	private final Color[] colours = new Color[] { // begin
			Color.WHITE, Color.YELLOW, Color.ORANGE, Color.RED, // four
			Color.GREEN, Color.BLUE, new Color(128, 0, 0), Color.BLACK // eight
	};

	// number of user guesses
	private int numGuesses = 1;
	private JScrollPane scrollPane;
	private JPanel scrollPanel;

	private JSlider sliderP1;
	private JSlider sliderP2;
	private JSlider[] sliders = new JSlider[2];
	private Label labelGuess;
	private Label labelScore;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MastermindGUIV2 frame = new MastermindGUIV2();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MastermindGUIV2() {
		setResizable(false);
		try {
			UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
		} catch (Exception e) {
			e.printStackTrace();
		}
		setTitle("Mastermind");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500, 50, 550, 800);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(124, 70, 420, 495);
		contentPane.add(scrollPane);

		scrollPanel = new JPanel();
		scrollPane.setViewportView(scrollPanel);
		scrollPanel.setSize(new Dimension(500, 487));
		scrollPanel.setPreferredSize(new Dimension(420, 487));
		scrollPanel.setLayout(null);

		Input1 = new JButton("");
		Input1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (isSetInput1) {
					current[0].setBackground(null);
					isSetInput1 = false;
				}
			}
		});
		Input1.setBounds(130, 570, 40, 40);
		contentPane.add(Input1);

		Input2 = new JButton("");
		Input2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (isSetInput2) {
					current[1].setBackground(null);
					isSetInput2 = false;
				}
			}
		});
		Input2.setBounds(200, 570, 40, 40);
		contentPane.add(Input2);

		Input3 = new JButton("");
		Input3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (isSetInput3) {
					current[2].setBackground(null);
					isSetInput3 = false;
				}
			}
		});
		Input3.setBounds(270, 570, 40, 40);
		contentPane.add(Input3);

		Input4 = new JButton("");
		Input4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (isSetInput4) {
					current[3].setBackground(null);
					isSetInput4 = false;
				}
			}
		});
		Input4.setBounds(340, 570, 40, 40);
		contentPane.add(Input4);

		current = new JButton[] { Input1, Input2, Input3, Input4 };

		Solution1 = new JButton("");
		Solution1.setBounds(130, 20, 40, 40);
		contentPane.add(Solution1);

		Solution2 = new JButton("");
		Solution2.setBounds(200, 20, 40, 40);
		contentPane.add(Solution2);

		Solution3 = new JButton("");
		Solution3.setBounds(270, 20, 40, 40);
		contentPane.add(Solution3);

		Solution4 = new JButton("");
		Solution4.setBounds(340, 20, 40, 40);
		contentPane.add(Solution4);

		Colour1 = new JButton("");
		Colour1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setColour(colours[0]);
			}
		});
		Colour1.setBounds(40, 650, 40, 40);
		contentPane.add(Colour1);
		Colour1.setBackground(colours[0]);

		Colour2 = new JButton("");
		Colour2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setColour(colours[1]);
			}
		});
		Colour2.setBounds(90, 650, 40, 40);
		contentPane.add(Colour2);
		Colour2.setBackground(colours[1]);

		Colour3 = new JButton("");
		Colour3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setColour(colours[2]);
			}
		});
		Colour3.setBounds(145, 650, 40, 40);
		contentPane.add(Colour3);
		Colour3.setBackground(new Color(255, 200, 0));

		Colour4 = new JButton("");
		Colour4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setColour(colours[3]);
			}
		});
		Colour4.setBounds(200, 650, 40, 40);
		contentPane.add(Colour4);
		Colour4.setBackground(colours[3]);

		Colour5 = new JButton("");
		Colour5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setColour(colours[4]);
			}
		});
		Colour5.setBounds(40, 700, 40, 40);
		contentPane.add(Colour5);
		Colour5.setBackground(colours[4]);

		Colour6 = new JButton("");
		Colour6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setColour(colours[5]);
			}
		});
		Colour6.setBounds(90, 700, 40, 40);
		contentPane.add(Colour6);
		Colour6.setBackground(colours[5]);

		Colour7 = new JButton("");
		Colour7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setColour(colours[6]);
			}
		});
		Colour7.setBounds(145, 700, 40, 40);
		contentPane.add(Colour7);
		Colour7.setBackground(colours[6]);

		Colour8 = new JButton("");
		Colour8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setColour(colours[7]);
			}
		});
		Colour8.setBounds(200, 700, 40, 40);
		contentPane.add(Colour8);
		Colour8.setBackground(colours[7]);

		setSoluBtn = new JButton("Set Solution");
		setSoluBtn.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		setSoluBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				start();
			}
		});
		setSoluBtn.setBounds(290, 650, 220, 40);
		contentPane.add(setSoluBtn);

		GuessBtn = new JButton("Enter Guess");
		GuessBtn.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		GuessBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				guess();
			}
		});
		GuessBtn.setBounds(290, 700, 220, 40);
		contentPane.add(GuessBtn);
		GuessBtn.setVisible(false);

		lblAllowedColours = new JLabel("Allowed Colours:");
		lblAllowedColours.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lblAllowedColours.setBounds(40, 615, 140, 30);
		contentPane.add(lblAllowedColours);

		EndOfGameLbl = new JLabel("");
		EndOfGameLbl.setHorizontalAlignment(SwingConstants.CENTER);
		EndOfGameLbl.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		EndOfGameLbl.setBounds(104, 200, 420, 125);
		contentPane.add(EndOfGameLbl);
		EndOfGameLbl.setVisible(false);

		playAgainBtn = new JButton("Play again");
		playAgainBtn.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		playAgainBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				restart();
			}
		});
		playAgainBtn.setBounds(290, 650, 220, 40);
		contentPane.add(playAgainBtn);
		playAgainBtn.setVisible(false);

		playCompBtn = new JButton("Play against Computer");
		playCompBtn.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		playCompBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				resetAll();
				chooseRandom();
				start();
			}
		});
		playCompBtn.setBounds(290, 700, 220, 40);
		contentPane.add(playCompBtn);

		sliderP1 = new JSlider();
		sliderP1.setValue(0);
		sliderP1.setMaximum(30);
		sliderP1.setBounds(10, 70, 50, 495);
		contentPane.add(sliderP1);
		sliderP1.setEnabled(false);
		sliderP1.setOrientation(SwingConstants.VERTICAL);

		sliderP2 = new JSlider();
		sliderP2.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		sliderP2.setPaintTicks(true);
		sliderP2.setPaintLabels(true);
		sliderP2.setMajorTickSpacing(5);
		sliderP2.setMinorTickSpacing(1);
		sliderP2.setValue(0);
		sliderP2.setMaximum(30);
		sliderP2.setOrientation(SwingConstants.VERTICAL);
		sliderP2.setEnabled(false);
		sliderP2.setBounds(60, 70, 50, 495);
		contentPane.add(sliderP2);

		sliders = new JSlider[] { sliderP1, sliderP2 };

		Label labelP1 = new Label("P1");
		labelP1.setAlignment(Label.CENTER);
		labelP1.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		labelP1.setBounds(22, 570, 24, 30);
		contentPane.add(labelP1);

		Label labelP2 = new Label("P2");
		labelP2.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		labelP2.setAlignment(Label.CENTER);
		labelP2.setBounds(62, 570, 24, 30);
		contentPane.add(labelP2);
		
		labelGuess = new Label("Current Guess");
		labelGuess.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		labelGuess.setBounds(406, 571, 138, 39);
		contentPane.add(labelGuess);
		
		labelScore = new Label("Score");
		labelScore.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		labelScore.setBounds(30, 35, 90, 30);
		contentPane.add(labelScore);
	}

	private void setColour(Color c) {
		for (JButton btn : current) {
			if (btn.getBackground() == c) {
				return;
			}
		}
		if (!isSetInput1) {
			current[0].setBackground(c);
			isSetInput1 = true;
		} else if (!isSetInput2) {
			current[1].setBackground(c);
			isSetInput2 = true;
		} else if (!isSetInput3) {
			current[2].setBackground(c);
			isSetInput3 = true;
		} else if (!isSetInput4) {
			current[3].setBackground(c);
			isSetInput4 = true;
		}
	}

	private void resetAll() {
		isSetInput1 = false;
		isSetInput2 = false;
		isSetInput3 = false;
		isSetInput4 = false;
		current[0].setBackground(null);
		current[1].setBackground(null);
		current[2].setBackground(null);
		current[3].setBackground(null);
	}

	private void restart() {
		resetAll();
		scrollPanel.setVisible(true);
		scrollPane.setVisible(true);
		scrollPanel.setSize(new Dimension(500, 450));
		scrollPanel.setPreferredSize(new Dimension(500, 450));
		scrollPanel.removeAll();
		xPin = 304;
		yPin = 5;
		widthPin = 10;
		heightPin = 40;

		xGuess = 4;
		yGuess = 5;
		widthGuess = 40;
		heightGuess = 40;

		Solution1.setBackground(null);
		Solution2.setBackground(null);
		Solution3.setBackground(null);
		Solution4.setBackground(null);
		for (int i = 0; i < 4; ++i) {
			solution[i] = null;
		}
		for (int i = 0; i < 9; ++i) {
			for (int j = 0; j < 4; ++j) {
			}
		}
		EndOfGameLbl.setText("");
		EndOfGameLbl.setVisible(false);
		playAgainBtn.setVisible(false);
		GuessBtn.setVisible(false);
		setSoluBtn.setVisible(true);
		playCompBtn.setVisible(true);
		numGuesses = 1;
	}

	private void guess() {
		if (isValidInput()) {
			if (evaluateGuess()) {
				Solution1.setBackground(current[0].getBackground());
				Solution2.setBackground(current[1].getBackground());
				Solution3.setBackground(current[2].getBackground());
				Solution4.setBackground(current[3].getBackground());
				end(String.format("Congratulations you win after %d guesses!", numGuesses));
			} else {
				if (yGuess + 40 >= scrollPanel.getHeight()) {
					scrollPanel.setSize(new Dimension(500, scrollPanel.getHeight() + 28));
					scrollPanel.setPreferredSize(new Dimension(500, scrollPanel.getHeight() + 28));
					scrollPanel.repaint();
					scrollPane.getViewport().scrollRectToVisible(new Rectangle(0, scrollPanel.getHeight() - 1, 1, 1));
				}
				for (int i = 0; i < 4; ++i) {
					JPanel guess = new JPanel();
					guess.setBounds(xGuess, yGuess, widthGuess, heightGuess);
					guess.setBackground(current[i].getBackground());
					scrollPanel.add(guess);
					xGuess += 70;
				}
				scrollPanel.repaint();
				scrollPane.getViewport().scrollRectToVisible(new Rectangle(0, scrollPanel.getHeight() - 1, 1, 1));
				xGuess = 4;
				yGuess += 55;
				resetAll();
				numGuesses++;
				if (numGuesses == maxGuesses) {
					end("You lost, please try again!");
				}
			}
		}
	}

	private void end(String s) {
		playerScore[currentPlayer] += numGuesses;
		if(playerScore[currentPlayer] > sliders[currentPlayer].getMaximum()) {
			for(JSlider slider : sliders) {
				slider.setMaximum(slider.getMaximum()+20);
			}
		}
		sliders[currentPlayer].setValue(playerScore[currentPlayer]);
		GuessBtn.setVisible(false);
		EndOfGameLbl.setVisible(true);
		scrollPanel.setVisible(false);
		scrollPane.setVisible(false);
		playAgainBtn.setVisible(true);
		EndOfGameLbl.setText(s);
	}

	private void start() {
		if (isValidInput()) {
			for (int i = 0; i < 4; ++i) {
				solution[i] = current[i].getBackground();
			}
			currentPlayer = (currentPlayer + 1) % 2;
			playCompBtn.setVisible(false);
			setSoluBtn.setVisible(false);
			GuessBtn.setVisible(true);
			Solution1.setBackground(Color.LIGHT_GRAY);
			Solution2.setBackground(Color.LIGHT_GRAY);
			Solution3.setBackground(Color.LIGHT_GRAY);
			Solution4.setBackground(Color.LIGHT_GRAY);
			resetAll();
		}
	}

	private boolean evaluateGuess() {
		if (isCorrect()) {
			return true;
		}
		int config = (int) (Math.random() * 24);
		for (int m = 0; m < current.length; ++m) {
			for (int n = 0; n < solution.length; ++n) {
				if (current[eval[config][m]].getBackground() == solution[n]) {
					if (eval[config][m] == n) {
						JPanel pin = new JPanel();
						pin.setBounds(xPin, yPin, widthPin, heightPin);
						pin.setBackground(Color.BLACK);
						scrollPanel.add(pin);
						xPin += 20;
					} else {
						JPanel pin = new JPanel();
						pin.setBounds(xPin, yPin, widthPin, heightPin);
						pin.setBackground(Color.WHITE);
						scrollPanel.add(pin);
						xPin += 20;
					}
				}
			}
		}
		xPin = 304;
		yPin += 55;
		return false;
	}

	private boolean isCorrect() {
		for (int i = 0; i < 4; ++i) {
			if (!(solution[i] == current[i].getBackground())) {
				return false;
			}
		}
		return true;
	}

	private boolean isValidInput() {
		for (int i = 0; i < 4; ++i) {
			if (current[i].getBackground().equals(new Color(238, 238, 238))) {
				return false;
			}
		}
		return true;
	}

	private void chooseRandom() {
		int[] num = new int[] { -1, -1, -1, -1 };
		for (int i = 0; i < 4; ++i) {
			num[i] = (int) (Math.random() * 8);
			for (int j = 0; j < i; ++j) {
				if (num[i] == num[j]) {
					--i;
					break;
				}
			}
		}
		for (int i : num) {
			setColour(colours[i]);
		}
	}
}
