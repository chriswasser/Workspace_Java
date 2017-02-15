import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

public class MastermindGUI extends JFrame {

	private static final long serialVersionUID = 1L;

	private JPanel contentPane;

	// panels for the past guesses
	private JPanel row1_1;
	private JPanel row1_2;
	private JPanel row1_3;
	private JPanel row1_4;
	private JPanel row2_1;
	private JPanel row2_2;
	private JPanel row2_3;
	private JPanel row2_4;
	private JPanel row3_1;
	private JPanel row3_2;
	private JPanel row3_3;
	private JPanel row3_4;
	private JPanel row4_1;
	private JPanel row4_2;
	private JPanel row4_3;
	private JPanel row4_4;
	private JPanel row5_1;
	private JPanel row5_2;
	private JPanel row5_3;
	private JPanel row5_4;
	private JPanel row6_1;
	private JPanel row6_2;
	private JPanel row6_3;
	private JPanel row6_4;
	private JPanel row7_1;
	private JPanel row7_2;
	private JPanel row7_3;
	private JPanel row7_4;
	private JPanel row8_1;
	private JPanel row9_1;
	private JPanel row8_2;
	private JPanel row9_2;
	private JPanel row8_3;
	private JPanel row8_4;
	private JPanel row9_3;
	private JPanel row9_4;
	private JPanel[][] panels = new JPanel[9][4];

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

	// panels for the black and white feedback pins
	private JPanel pin1_1;
	private JPanel pin1_2;
	private JPanel pin1_3;
	private JPanel pin1_4;
	private JPanel pin2_1;
	private JPanel pin2_2;
	private JPanel pin2_3;
	private JPanel pin2_4;
	private JPanel pin3_1;
	private JPanel pin3_2;
	private JPanel pin3_3;
	private JPanel pin3_4;
	private JPanel pin4_1;
	private JPanel pin4_2;
	private JPanel pin4_3;
	private JPanel pin4_4;
	private JPanel pin5_1;
	private JPanel pin5_2;
	private JPanel pin5_3;
	private JPanel pin5_4;
	private JPanel pin6_1;
	private JPanel pin6_2;
	private JPanel pin6_3;
	private JPanel pin6_4;
	private JPanel pin7_1;
	private JPanel pin7_2;
	private JPanel pin7_3;
	private JPanel pin7_4;
	private JPanel pin8_1;
	private JPanel pin8_2;
	private JPanel pin8_3;
	private JPanel pin8_4;
	private JPanel pin9_1;
	private JPanel pin9_2;
	private JPanel pin9_3;
	private JPanel pin9_4;
	private boolean isSetPin1 = false;
	private boolean isSetPin2 = false;
	private boolean isSetPin3 = false;
	private boolean isSetPin4 = false;
	private JPanel[][] pins = new JPanel[9][4];

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
	int numGuesses = 1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MastermindGUI frame = new MastermindGUI();
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
	public MastermindGUI() {
		try {
			UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
		} catch (Exception e) {
			e.printStackTrace();
		}
		setTitle("Mastermind");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500, 50, 500, 800);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		row1_1 = new JPanel();
		row1_1.setBounds(80, 75, 40, 40);
		contentPane.add(row1_1);

		row1_2 = new JPanel();
		row1_2.setBounds(150, 75, 40, 40);
		contentPane.add(row1_2);

		row1_3 = new JPanel();
		row1_3.setBounds(220, 75, 40, 40);
		contentPane.add(row1_3);

		row1_4 = new JPanel();
		row1_4.setBounds(290, 75, 40, 40);
		contentPane.add(row1_4);

		row2_1 = new JPanel();
		row2_1.setBounds(80, 130, 40, 40);
		contentPane.add(row2_1);

		row2_2 = new JPanel();
		row2_2.setBounds(150, 130, 40, 40);
		contentPane.add(row2_2);

		row2_3 = new JPanel();
		row2_3.setBounds(220, 130, 40, 40);
		contentPane.add(row2_3);

		row2_4 = new JPanel();
		row2_4.setBounds(290, 130, 40, 40);
		contentPane.add(row2_4);

		row3_1 = new JPanel();
		row3_1.setBounds(80, 185, 40, 40);
		contentPane.add(row3_1);

		row3_2 = new JPanel();
		row3_2.setBounds(150, 185, 40, 40);
		contentPane.add(row3_2);

		row3_3 = new JPanel();
		row3_3.setBounds(220, 185, 40, 40);
		contentPane.add(row3_3);

		row3_4 = new JPanel();
		row3_4.setBounds(290, 185, 40, 40);
		contentPane.add(row3_4);

		row4_1 = new JPanel();
		row4_1.setBounds(80, 240, 40, 40);
		contentPane.add(row4_1);

		row4_2 = new JPanel();
		row4_2.setBounds(150, 240, 40, 40);
		contentPane.add(row4_2);

		row4_3 = new JPanel();
		row4_3.setBounds(220, 240, 40, 40);
		contentPane.add(row4_3);

		row4_4 = new JPanel();
		row4_4.setBounds(290, 240, 40, 40);
		contentPane.add(row4_4);

		row5_1 = new JPanel();
		row5_1.setBounds(80, 295, 40, 40);
		contentPane.add(row5_1);

		row5_2 = new JPanel();
		row5_2.setBounds(150, 295, 40, 40);
		contentPane.add(row5_2);

		row5_3 = new JPanel();
		row5_3.setBounds(220, 295, 40, 40);
		contentPane.add(row5_3);

		row5_4 = new JPanel();
		row5_4.setBounds(290, 295, 40, 40);
		contentPane.add(row5_4);

		row6_1 = new JPanel();
		row6_1.setBounds(80, 350, 40, 40);
		contentPane.add(row6_1);

		row6_2 = new JPanel();
		row6_2.setBounds(150, 350, 40, 40);
		contentPane.add(row6_2);

		row6_3 = new JPanel();
		row6_3.setBounds(220, 350, 40, 40);
		contentPane.add(row6_3);

		row6_4 = new JPanel();
		row6_4.setBounds(290, 350, 40, 40);
		contentPane.add(row6_4);

		row7_1 = new JPanel();
		row7_1.setBounds(80, 405, 40, 40);
		contentPane.add(row7_1);

		row7_2 = new JPanel();
		row7_2.setBounds(150, 405, 40, 40);
		contentPane.add(row7_2);

		row7_3 = new JPanel();
		row7_3.setBounds(220, 405, 40, 40);
		contentPane.add(row7_3);

		row7_4 = new JPanel();
		row7_4.setBounds(290, 405, 40, 40);
		contentPane.add(row7_4);

		row8_1 = new JPanel();
		row8_1.setBounds(80, 460, 40, 40);
		contentPane.add(row8_1);

		row8_2 = new JPanel();
		row8_2.setBounds(150, 460, 40, 40);
		contentPane.add(row8_2);

		row8_3 = new JPanel();
		row8_3.setBounds(220, 460, 40, 40);
		contentPane.add(row8_3);

		row8_4 = new JPanel();
		row8_4.setBounds(290, 460, 40, 40);
		contentPane.add(row8_4);

		row9_1 = new JPanel();
		row9_1.setBounds(80, 515, 40, 40);
		contentPane.add(row9_1);

		row9_2 = new JPanel();
		row9_2.setBounds(150, 515, 40, 40);
		contentPane.add(row9_2);

		row9_3 = new JPanel();
		row9_3.setBounds(220, 515, 40, 40);
		contentPane.add(row9_3);

		row9_4 = new JPanel();
		row9_4.setBounds(290, 515, 40, 40);
		contentPane.add(row9_4);

		panels = new JPanel[][] { // begin
				{ row1_1, row1_2, row1_3, row1_4 }, // first line
				{ row2_1, row2_2, row2_3, row2_4 }, // second line
				{ row3_1, row3_2, row3_3, row3_4 }, // third line
				{ row4_1, row4_2, row4_3, row4_4 }, // fourth line
				{ row5_1, row5_2, row5_3, row5_4 }, // fifth line
				{ row6_1, row6_2, row6_3, row6_4 }, // sixth line
				{ row7_1, row7_2, row7_3, row7_4 }, // seventh line
				{ row8_1, row8_2, row8_3, row8_4 }, // eighth line
				{ row9_1, row9_2, row9_3, row9_4 } // ninth line
		};

		Input1 = new JButton("");
		Input1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (isSetInput1) {
					current[0].setBackground(null);
					isSetInput1 = false;
				}
			}
		});
		Input1.setBounds(80, 570, 40, 40);
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
		Input2.setBounds(150, 570, 40, 40);
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
		Input3.setBounds(220, 570, 40, 40);
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
		Input4.setBounds(290, 570, 40, 40);
		contentPane.add(Input4);

		current = new JButton[] { Input1, Input2, Input3, Input4 };

		Solution1 = new JButton("");
		Solution1.setBounds(80, 20, 40, 40);
		contentPane.add(Solution1);

		Solution2 = new JButton("");
		Solution2.setBounds(150, 20, 40, 40);
		contentPane.add(Solution2);

		Solution3 = new JButton("");
		Solution3.setBounds(220, 20, 40, 40);
		contentPane.add(Solution3);

		Solution4 = new JButton("");
		Solution4.setBounds(290, 20, 40, 40);
		contentPane.add(Solution4);

		Colour1 = new JButton("");
		Colour1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setColour(colours[0]);
			}
		});
		Colour1.setBounds(25, 650, 40, 40);
		contentPane.add(Colour1);
		Colour1.setBackground(colours[0]);

		Colour2 = new JButton("");
		Colour2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setColour(colours[1]);
			}
		});
		Colour2.setBounds(75, 650, 40, 40);
		contentPane.add(Colour2);
		Colour2.setBackground(colours[1]);

		Colour3 = new JButton("");
		Colour3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setColour(colours[2]);
			}
		});
		Colour3.setBounds(130, 650, 40, 40);
		contentPane.add(Colour3);
		Colour3.setBackground(new Color(255, 200, 0));

		Colour4 = new JButton("");
		Colour4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setColour(colours[3]);
			}
		});
		Colour4.setBounds(185, 650, 40, 40);
		contentPane.add(Colour4);
		Colour4.setBackground(colours[3]);

		Colour5 = new JButton("");
		Colour5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setColour(colours[4]);
			}
		});
		Colour5.setBounds(25, 700, 40, 40);
		contentPane.add(Colour5);
		Colour5.setBackground(colours[4]);

		Colour6 = new JButton("");
		Colour6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setColour(colours[5]);
			}
		});
		Colour6.setBounds(75, 700, 40, 40);
		contentPane.add(Colour6);
		Colour6.setBackground(colours[5]);

		Colour7 = new JButton("");
		Colour7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setColour(colours[6]);
			}
		});
		Colour7.setBounds(130, 700, 40, 40);
		contentPane.add(Colour7);
		Colour7.setBackground(colours[6]);

		Colour8 = new JButton("");
		Colour8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setColour(colours[7]);
			}
		});
		Colour8.setBounds(185, 700, 40, 40);
		contentPane.add(Colour8);
		Colour8.setBackground(colours[7]);

		pin1_1 = new JPanel();
		pin1_1.setBounds(380, 75, 10, 40);
		contentPane.add(pin1_1);

		pin1_2 = new JPanel();
		pin1_2.setBounds(400, 75, 10, 40);
		contentPane.add(pin1_2);

		pin1_3 = new JPanel();
		pin1_3.setBounds(420, 75, 10, 40);
		contentPane.add(pin1_3);

		pin1_4 = new JPanel();
		pin1_4.setBounds(440, 75, 10, 40);
		contentPane.add(pin1_4);

		pin2_1 = new JPanel();
		pin2_1.setBounds(380, 130, 10, 40);
		contentPane.add(pin2_1);

		pin2_2 = new JPanel();
		pin2_2.setBounds(400, 130, 10, 40);
		contentPane.add(pin2_2);

		pin2_3 = new JPanel();
		pin2_3.setBounds(420, 130, 10, 40);
		contentPane.add(pin2_3);

		pin2_4 = new JPanel();
		pin2_4.setBounds(440, 130, 10, 40);
		contentPane.add(pin2_4);

		pin3_1 = new JPanel();
		pin3_1.setBounds(380, 185, 10, 40);
		contentPane.add(pin3_1);

		pin3_2 = new JPanel();
		pin3_2.setBounds(400, 185, 10, 40);
		contentPane.add(pin3_2);

		pin3_3 = new JPanel();
		pin3_3.setBounds(420, 185, 10, 40);
		contentPane.add(pin3_3);

		pin3_4 = new JPanel();
		pin3_4.setBounds(440, 185, 10, 40);
		contentPane.add(pin3_4);

		pin4_1 = new JPanel();
		pin4_1.setBounds(380, 240, 10, 40);
		contentPane.add(pin4_1);

		pin4_2 = new JPanel();
		pin4_2.setBounds(400, 240, 10, 40);
		contentPane.add(pin4_2);

		pin4_3 = new JPanel();
		pin4_3.setBounds(420, 240, 10, 40);
		contentPane.add(pin4_3);

		pin4_4 = new JPanel();
		pin4_4.setBounds(440, 240, 10, 40);
		contentPane.add(pin4_4);

		pin5_1 = new JPanel();
		pin5_1.setBounds(380, 295, 10, 40);
		contentPane.add(pin5_1);

		pin5_2 = new JPanel();
		pin5_2.setBounds(400, 295, 10, 40);
		contentPane.add(pin5_2);

		pin5_3 = new JPanel();
		pin5_3.setBounds(420, 295, 10, 40);
		contentPane.add(pin5_3);

		pin5_4 = new JPanel();
		pin5_4.setBounds(440, 295, 10, 40);
		contentPane.add(pin5_4);

		pin6_1 = new JPanel();
		pin6_1.setBounds(380, 350, 10, 40);
		contentPane.add(pin6_1);

		pin6_2 = new JPanel();
		pin6_2.setBounds(400, 350, 10, 40);
		contentPane.add(pin6_2);

		pin6_3 = new JPanel();
		pin6_3.setBounds(420, 350, 10, 40);
		contentPane.add(pin6_3);

		pin6_4 = new JPanel();
		pin6_4.setBounds(440, 350, 10, 40);
		contentPane.add(pin6_4);

		pin7_1 = new JPanel();
		pin7_1.setBounds(380, 405, 10, 40);
		contentPane.add(pin7_1);

		pin7_2 = new JPanel();
		pin7_2.setBounds(400, 405, 10, 40);
		contentPane.add(pin7_2);

		pin7_3 = new JPanel();
		pin7_3.setBounds(420, 405, 10, 40);
		contentPane.add(pin7_3);

		pin7_4 = new JPanel();
		pin7_4.setBounds(440, 405, 10, 40);
		contentPane.add(pin7_4);

		pin8_1 = new JPanel();
		pin8_1.setBounds(380, 460, 10, 40);
		contentPane.add(pin8_1);

		pin8_2 = new JPanel();
		pin8_2.setBounds(400, 460, 10, 40);
		contentPane.add(pin8_2);

		pin8_3 = new JPanel();
		pin8_3.setBounds(420, 460, 10, 40);
		contentPane.add(pin8_3);

		pin8_4 = new JPanel();
		pin8_4.setBounds(440, 460, 10, 40);
		contentPane.add(pin8_4);

		pin9_1 = new JPanel();
		pin9_1.setBounds(380, 515, 10, 40);
		contentPane.add(pin9_1);

		pin9_2 = new JPanel();
		pin9_2.setBounds(400, 515, 10, 40);
		contentPane.add(pin9_2);

		pin9_3 = new JPanel();
		pin9_3.setBounds(420, 515, 10, 40);
		contentPane.add(pin9_3);

		pin9_4 = new JPanel();
		pin9_4.setBounds(440, 515, 10, 40);
		contentPane.add(pin9_4);

		pins = new JPanel[][] { // begin
				{ pin1_1, pin1_2, pin1_3, pin1_4 }, // first line
				{ pin2_1, pin2_2, pin2_3, pin2_4 }, // second line
				{ pin3_1, pin3_2, pin3_3, pin3_4 }, // third line
				{ pin4_1, pin4_2, pin4_3, pin4_4 }, // fourth line
				{ pin5_1, pin5_2, pin5_3, pin5_4 }, // fifth line
				{ pin6_1, pin6_2, pin6_3, pin6_4 }, // sixth line
				{ pin7_1, pin7_2, pin7_3, pin7_4 }, // seventh line
				{ pin8_1, pin8_2, pin8_3, pin8_4 }, // eighth line
				{ pin9_1, pin9_2, pin9_3, pin9_4 } // ninth line
		};

		setSoluBtn = new JButton("Set Solution");
		setSoluBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				start();
			}
		});
		setSoluBtn.setBounds(270, 650, 180, 40);
		contentPane.add(setSoluBtn);

		GuessBtn = new JButton("Enter Guess");
		GuessBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				guess();
			}
		});
		GuessBtn.setBounds(270, 700, 180, 40);
		contentPane.add(GuessBtn);
		GuessBtn.setVisible(false);

		lblAllowedColours = new JLabel("Allowed Colours:");
		lblAllowedColours.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblAllowedColours.setBounds(25, 615, 140, 30);
		contentPane.add(lblAllowedColours);

		EndOfGameLbl = new JLabel("");
		EndOfGameLbl.setHorizontalAlignment(SwingConstants.CENTER);
		EndOfGameLbl.setFont(new Font("Tahoma", Font.PLAIN, 20));
		EndOfGameLbl.setBounds(10, 200, 464, 125);
		contentPane.add(EndOfGameLbl);
		EndOfGameLbl.setVisible(false);

		playAgainBtn = new JButton("Play again");
		playAgainBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				restart();
			}
		});
		playAgainBtn.setBounds(270, 650, 180, 40);
		contentPane.add(playAgainBtn);
		playAgainBtn.setVisible(false);

		playCompBtn = new JButton("Play against Computer");
		playCompBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				resetAll();
				chooseRandom();
				start();
			}
		});
		playCompBtn.setBounds(270, 700, 180, 40);
		contentPane.add(playCompBtn);
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
		isSetPin1 = false;
		isSetPin2 = false;
		isSetPin3 = false;
		isSetPin4 = false;
	}

	private void restart() {
		resetAll();
		Solution1.setBackground(null);
		Solution2.setBackground(null);
		Solution3.setBackground(null);
		Solution4.setBackground(null);
		for (int i = 0; i < 4; ++i) {
			solution[i] = null;
		}
		for (int i = 0; i < 9; ++i) {
			for (int j = 0; j < 4; ++j) {
				pins[i][j].setBackground(null);
				pins[i][j].setVisible(true);
				panels[i][j].setBackground(null);
				panels[i][j].setVisible(true);
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
				for (int i = 0; i < 4; ++i) {
					panels[numGuesses - 1][i].setBackground(current[i].getBackground());
				}
				resetAll();
				numGuesses++;
				if (numGuesses == 10) {
					end("You lost, please try again!");
				}
			}
		}
	}

	private void end(String s) {
		row4_1.setVisible(false);
		row4_2.setVisible(false);
		row4_3.setVisible(false);
		row4_4.setVisible(false);
		pin4_1.setVisible(false);
		pin4_2.setVisible(false);
		pin4_3.setVisible(false);
		pin4_4.setVisible(false);
		GuessBtn.setVisible(false);
		EndOfGameLbl.setVisible(true);
		playAgainBtn.setVisible(true);
		EndOfGameLbl.setText(s);
	}

	private void start() {
		if (isValidInput()) {
			for (int i = 0; i < 4; ++i) {
				solution[i] = current[i].getBackground();
			}
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
						placePin(colours[7]);
					} else {
						placePin(colours[0]);
					}
				}
			}
		}
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

	private void placePin(Color c) {
		if (!isSetPin1) {
			pins[numGuesses - 1][0].setBackground(c);
			isSetPin1 = true;
		} else if (!isSetPin2) {
			pins[numGuesses - 1][1].setBackground(c);
			isSetPin2 = true;
		} else if (!isSetPin3) {
			pins[numGuesses - 1][2].setBackground(c);
			isSetPin3 = true;
		} else if (!isSetPin4) {
			pins[numGuesses - 1][3].setBackground(c);
			isSetPin4 = true;
		}
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
		int[] num = new int[] {-1, -1, -1, -1};
		for (int i = 0; i < 4; ++i) {
			num[i] = (int) (Math.random() * 8);
			for(int j = 0; j < i; ++j) {
				if(num[i] == num[j]) {
					--i;
					break;
				}
			}
		}
		for(int i : num) {
			setColour(colours[i]);
		}
	}

}
