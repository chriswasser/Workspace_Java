import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JSlider;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import javax.swing.border.EtchedBorder;
import java.awt.Font;

public class Farbregler extends JFrame {

	private JPanel contentPane;
	private JPanel farbFeld;
	private JSlider rotSlider;
	private JSlider gruenSlider;
	private JSlider blauSlider;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Farbregler frame = new Farbregler();
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
	public Farbregler() {
		setTitle("Farbregler");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 550, 330);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		farbFeld = new JPanel();
		farbFeld.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		farbFeld.setBounds(50, 20, 450, 120);
		contentPane.add(farbFeld);
		
		JLabel rotLabel = new JLabel("Rot");
		rotLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		rotLabel.setBounds(10, 155, 50, 20);
		contentPane.add(rotLabel);
		
		JLabel gruenLabel = new JLabel("Gr\u00FCn");
		gruenLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		gruenLabel.setBounds(8, 205, 50, 20);
		contentPane.add(gruenLabel);
		
		JLabel blauLabel = new JLabel("Blau");
		blauLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		blauLabel.setBounds(10, 255, 50, 20);
		contentPane.add(blauLabel);
		
		rotSlider = new JSlider();
		rotSlider.setPaintTicks(true);
		rotSlider.setPaintLabels(true);
		rotSlider.setMinorTickSpacing(4);
		rotSlider.setMajorTickSpacing(20);
		rotSlider.setMaximum(255);
		rotSlider.setValue(240);
		rotSlider.setBounds(50, 155, 450, 40);
		contentPane.add(rotSlider);
		
		gruenSlider = new JSlider();
		gruenSlider.setMajorTickSpacing(20);
		gruenSlider.setMinorTickSpacing(4);
		gruenSlider.setPaintLabels(true);
		gruenSlider.setPaintTicks(true);
		gruenSlider.setMaximum(255);
		gruenSlider.setValue(240);
		gruenSlider.setBounds(50, 205, 450, 40);
		contentPane.add(gruenSlider);
		
		blauSlider = new JSlider();
		blauSlider.setMajorTickSpacing(20);
		blauSlider.setMinorTickSpacing(4);
		blauSlider.setPaintLabels(true);
		blauSlider.setPaintTicks(true);
		blauSlider.setSnapToTicks(true);
		blauSlider.setMaximum(255);
		blauSlider.setValue(240);
		blauSlider.setBounds(50, 255, 450, 40);
		contentPane.add(blauSlider);
	
		rotSlider.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				updateFarbe();
			}
		});

		gruenSlider.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				updateFarbe();
			}
		});

		blauSlider.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				updateFarbe();
			}
		});

	}
	
	private void updateFarbe() {
		farbFeld.setBackground(new Color(rotSlider.getValue(), gruenSlider.getValue(), blauSlider.getValue()));
	}
}
