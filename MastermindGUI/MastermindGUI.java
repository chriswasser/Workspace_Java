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
	private boolean isset1 = false;
	private boolean isset2 = false;
	private boolean isset3 = false;
	private boolean isset4 = false;
	private Color[] current = new Color[4];

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
	private boolean issetpin1 = false;
	private boolean issetpin2 = false;
	private boolean issetpin3 = false;
	private boolean issetpin4 = false;
	private JPanel[][] pins = new JPanel[9][4];

	// miscellaneous
	private JButton setSoluBtn;
	private JButton GuessBtn;
	private JLabel lblAllowedColours;
	private JLabel EndOfGameLbl;
	private JButton playAgainBtn;
	private JButton playCompBtn;

	// the random evaluation configurations
	public final int[][] eval = new int[][] { { 0, 1, 2, 3 }, // one
			{ 0, 1, 3, 2 }, { 0, 2, 1, 3 }, { 0, 2, 3, 1 }, { 0, 3, 1, 2 }, // five
			{ 0, 3, 2, 1 }, { 1, 0, 2, 3 }, { 1, 0, 3, 2 }, { 1, 2, 0, 3 }, { 1, 2, 3, 0 }, // ten
			{ 1, 3, 0, 2 }, { 1, 3, 2, 0 }, { 2, 0, 1, 3 }, { 2, 0, 3, 1 }, { 2, 1, 0, 3 }, // fifteen
			{ 2, 1, 3, 0 }, { 2, 3, 0, 1 }, { 2, 3, 1, 0 }, { 3, 0, 1, 2 }, { 3, 0, 2, 1 }, // twenty
			{ 3, 1, 0, 2 }, { 3, 1, 2, 0 }, { 3, 2, 0, 1 }, { 3, 2, 1, 0 }, // twenty-four
	};

	// configure the used colours
	private final Color[] colours = new Color[] { Color.WHITE, Color.YELLOW, Color.ORANGE, Color.RED, Color.GREEN,
			Color.BLUE, new Color(128, 0, 0), Color.BLACK };

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
					UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
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

		panels[0][0] = row1_1;
		panels[0][1] = row1_2;
		panels[0][2] = row1_3;
		panels[0][3] = row1_4;
		panels[1][0] = row2_1;
		panels[1][1] = row2_2;
		panels[1][2] = row2_3;
		panels[1][3] = row2_4;
		panels[2][0] = row3_1;
		panels[2][1] = row3_2;
		panels[2][2] = row3_3;
		panels[2][3] = row3_4;
		panels[3][0] = row4_1;
		panels[3][1] = row4_2;
		panels[3][2] = row4_3;
		panels[3][3] = row4_4;
		panels[4][0] = row5_1;
		panels[4][1] = row5_2;
		panels[4][2] = row5_3;
		panels[4][3] = row5_4;
		panels[5][0] = row6_1;
		panels[5][1] = row6_2;
		panels[5][2] = row6_3;
		panels[5][3] = row6_4;
		panels[6][0] = row7_1;
		panels[6][1] = row7_2;
		panels[6][2] = row7_3;
		panels[6][3] = row7_4;
		panels[7][0] = row8_1;
		panels[7][1] = row8_2;
		panels[7][2] = row8_3;
		panels[7][3] = row8_4;
		panels[8][0] = row9_1;
		panels[8][1] = row9_2;
		panels[8][2] = row9_3;
		panels[8][3] = row9_4;

		Input1 = new JButton("");
		Input1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (isset1) {
					Input1.setBackground(null);
					current[0] = null;
					isset1 = false;
				}
			}
		});
		Input1.setBounds(80, 570, 40, 40);
		contentPane.add(Input1);

		Input2 = new JButton("");
		Input2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (isset2) {
					Input2.setBackground(null);
					current[1] = null;
					isset2 = false;
				}
			}
		});
		Input2.setBounds(150, 570, 40, 40);
		contentPane.add(Input2);

		Input3 = new JButton("");
		Input3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (isset3) {
					Input3.setBackground(null);
					current[2] = null;
					isset3 = false;
				}
			}
		});
		Input3.setBounds(220, 570, 40, 40);
		contentPane.add(Input3);

		Input4 = new JButton("");
		Input4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (isset4) {
					Input4.setBackground(null);
					current[3] = null;
					isset4 = false;
				}
			}
		});
		Input4.setBounds(290, 570, 40, 40);
		contentPane.add(Input4);

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

		pins[0][0] = pin1_1;
		pins[0][1] = pin1_2;
		pins[0][2] = pin1_3;
		pins[0][3] = pin1_4;
		pins[1][0] = pin2_1;
		pins[1][1] = pin2_2;
		pins[1][2] = pin2_3;
		pins[1][3] = pin2_4;
		pins[2][0] = pin3_1;
		pins[2][1] = pin3_2;
		pins[2][2] = pin3_3;
		pins[2][3] = pin3_4;
		pins[3][0] = pin4_1;
		pins[3][1] = pin4_2;
		pins[3][2] = pin4_3;
		pins[3][3] = pin4_4;
		pins[4][0] = pin5_1;
		pins[4][1] = pin5_2;
		pins[4][2] = pin5_3;
		pins[4][3] = pin5_4;
		pins[5][0] = pin6_1;
		pins[5][1] = pin6_2;
		pins[5][2] = pin6_3;
		pins[5][3] = pin6_4;
		pins[6][0] = pin7_1;
		pins[6][1] = pin7_2;
		pins[6][2] = pin7_3;
		pins[6][3] = pin7_4;
		pins[7][0] = pin8_1;
		pins[7][1] = pin8_2;
		pins[7][2] = pin8_3;
		pins[7][3] = pin8_4;
		pins[8][0] = pin9_1;
		pins[8][1] = pin9_2;
		pins[8][2] = pin9_3;
		pins[8][3] = pin9_4;

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
				setStart();
			}
		});
		playAgainBtn.setBounds(270, 650, 180, 40);
		contentPane.add(playAgainBtn);
		playAgainBtn.setVisible(false);

		playCompBtn = new JButton("Play against Computer");
		playCompBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				for (int i = 0; i < 4; ++i) {
					current[i] = colours[(int) (Math.random() * 8)];
					for (int j = 0; j < i; ++j) {
						if (current[i] == current[j]) {
							i--;
							break;
						}
					}
				}
				playCompBtn.setVisible(false);
				start();
			}
		});
		playCompBtn.setBounds(270, 700, 180, 40);
		contentPane.add(playCompBtn);
	}

	private void setColour(Color c) {
		for (Color clr : current) {
			if (clr == c) {
				return;
			}
		}
		if (!isset1) {
			Input1.setBackground(c);
			current[0] = c;
			isset1 = true;
		} else if (!isset2) {
			Input2.setBackground(c);
			current[1] = c;
			isset2 = true;
		} else if (!isset3) {
			Input3.setBackground(c);
			current[2] = c;
			isset3 = true;
		} else if (!isset4) {
			Input4.setBackground(c);
			current[3] = c;
			isset4 = true;
		}
	}

	private void reset(JButton button) {
		button.setBackground(null);
	}

	private void resetAll() {
		reset(Input1);
		reset(Input2);
		reset(Input3);
		reset(Input4);
		isset1 = false;
		isset2 = false;
		isset3 = false;
		isset4 = false;
		current[0] = null;
		current[1] = null;
		current[2] = null;
		current[3] = null;
		issetpin1 = false;
		issetpin2 = false;
		issetpin3 = false;
		issetpin4 = false;
	}

	private void setStart() {
		Input1.setBackground(null);
		Input2.setBackground(null);
		Input3.setBackground(null);
		Input4.setBackground(null);
		isset1 = false;
		isset2 = false;
		isset3 = false;
		isset4 = false;
		Solution1.setBackground(null);
		Solution2.setBackground(null);
		Solution3.setBackground(null);
		Solution4.setBackground(null);
		for (int i = 0; i < 9; ++i) {
			for (int j = 0; j < 4; ++j) {
				pins[i][j].setBackground(null);
				panels[i][j].setBackground(null);
			}
		}
		issetpin1 = false;
		issetpin2 = false;
		issetpin3 = false;
		issetpin4 = false;
		EndOfGameLbl.setText("");
		EndOfGameLbl.setVisible(false);
		for (int i = 0; i < 4; ++i) {
			current[i] = null;
			solution[i] = null;
		}
		playAgainBtn.setVisible(false);
		GuessBtn.setVisible(false);
		setSoluBtn.setVisible(true);
		playCompBtn.setVisible(true);
		numGuesses = 1;
		row4_1.setVisible(true);
		row4_2.setVisible(true);
		row4_3.setVisible(true);
		row4_4.setVisible(true);
		pin4_1.setVisible(true);
		pin4_2.setVisible(true);
		pin4_3.setVisible(true);
		pin4_4.setVisible(true);
	}

	private void displayCurrent() {
		for (int i = 0; i < 4; ++i) {
			panels[numGuesses - 1][i].setBackground(current[i]);
		}
	}

	private void guess() {
		if (isValidInput()) {
			if (evaluateGuess()) {
				Solution1.setBackground(current[0]);
				Solution2.setBackground(current[1]);
				Solution3.setBackground(current[2]);
				Solution4.setBackground(current[3]);
				end();
				String s = String.format("Congratulations you win after %d guesses!", numGuesses);
				EndOfGameLbl.setText(s);
				playAgainBtn.setVisible(true);
			} else {
				displayCurrent();
				resetAll();
				numGuesses++;
				if (numGuesses == 10) {
					end();
					EndOfGameLbl.setText("You lost, please try again!");
				}
			}
		}
	}

	private void end() {
		row4_1.setVisible(false);
		row4_2.setVisible(false);
		row4_3.setVisible(false);
		row4_4.setVisible(false);
		pin4_1.setVisible(false);
		pin4_2.setVisible(false);
		pin4_3.setVisible(false);
		pin4_4.setVisible(false);
		EndOfGameLbl.setVisible(true);
	}

	private void start() {
		if (isValidInput()) {
			for (int i = 0; i < 4; ++i) {
				solution[i] = current[i];
			}
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
		if (areSame(current)) {
			return true;
		}
		int config = (int) (Math.random() * 24);
		for (int m = 0; m < current.length; ++m) {
			for (int n = 0; n < solution.length; ++n) {
				if (current[eval[config][m]] == solution[n]) {
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

	private boolean areSame(Color[] guess) {
		for (int i = 0; i < 4; ++i) {
			if (!(solution[i] == guess[i])) {
				return false;
			}
		}
		return true;
	}

	private void placePin(Color c) {
		if (!issetpin1) {
			pins[numGuesses - 1][0].setBackground(c);
			issetpin1 = true;
		} else if (!issetpin2) {
			pins[numGuesses - 1][1].setBackground(c);
			issetpin2 = true;
		} else if (!issetpin3) {
			pins[numGuesses - 1][2].setBackground(c);
			issetpin3 = true;
		} else if (!issetpin4) {
			pins[numGuesses - 1][3].setBackground(c);
			issetpin4 = true;
		}
	}

	private boolean isValidInput() {
		for (int i = 0; i < 4; ++i) {
			if (current[i] == null) {
				return false;
			}
		}
		return true;
	}

}
