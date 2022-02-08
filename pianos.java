package piano_s;

import java.awt.EventQueue;
import javax.sound.midi.*;


import javax.sound.sampled.*;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class pianos {
	

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the application.
	 * @throws MidiUnavailableException 
	 */
	public pianos() throws MidiUnavailableException {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws MidiUnavailableException 
	 */
	private void initialize() throws MidiUnavailableException  {
		Synthesizer synth = MidiSystem.getSynthesizer();
		synth.open();
		final MidiChannel[] mc = synth.getChannels();
		Instrument[] instr = synth.getDefaultSoundbank().getInstruments();
		synth.loadInstrument(instr[90]);
		frame = new JFrame();
		frame.setBounds(100, 100, 1244, 733);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnC = new JButton("C");
		btnC.setBackground(Color.WHITE);
		btnC.setFont(new Font("Tahoma", Font.PLAIN, 26));
		btnC.setBounds(37, 280, 97, 287);
		frame.getContentPane().add(btnC);
		btnC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mc[5].noteOn(60,600);
			}
		});
		
		JButton btnD = new JButton("D");
		btnD.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mc[5].noteOn(62,600);
			}
		});
		btnD.setFont(new Font("Tahoma", Font.PLAIN, 26));
		btnD.setBackground(Color.WHITE);
		btnD.setBounds(144, 280, 97, 287);
		frame.getContentPane().add(btnD);
		
		JButton btnE = new JButton("E");
		btnE.setFont(new Font("Tahoma", Font.PLAIN, 26));
		btnE.setBackground(Color.WHITE);
		btnE.setBounds(251, 280, 97, 287);
		frame.getContentPane().add(btnE);
		btnE.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mc[5].noteOn(64,600);
			}
		});
		
		JButton btnF = new JButton("F");
		btnF.setFont(new Font("Tahoma", Font.PLAIN, 26));
		btnF.setBackground(Color.WHITE);
		btnF.setBounds(358, 280, 97, 287);
		frame.getContentPane().add(btnF);
		btnF.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mc[5].noteOn(65,600);
			}
		});
		
		JButton btnG = new JButton("G");
		btnG.setFont(new Font("Tahoma", Font.PLAIN, 26));
		btnG.setBackground(Color.WHITE);
		btnG.setBounds(465, 280, 97, 287);
		frame.getContentPane().add(btnG);
		btnG.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mc[5].noteOn(67, 600);
			}
		});
		
		JButton btnA = new JButton("A");
		btnA.setFont(new Font("Tahoma", Font.PLAIN, 26));
		btnA.setBackground(Color.WHITE);
		btnA.setBounds(572, 280, 97, 287);
		frame.getContentPane().add(btnA);
		btnA.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mc[5].noteOn(69, 600);
			}
		});
		
		JButton btnCsharp = new JButton("C#/D(flat)");
		btnCsharp.setForeground(Color.WHITE);
		btnCsharp.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnCsharp.setBackground(Color.BLACK);
		btnCsharp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mc[5].noteOn(61,600);
			}
		});
		btnCsharp.setBounds(79, 57, 116, 212);
		frame.getContentPane().add(btnCsharp);
		
		JButton btnDsharp = new JButton("D#/E(flat)");
		btnDsharp.setForeground(Color.WHITE);
		btnDsharp.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnDsharp.setBackground(Color.BLACK);
		btnDsharp.setBounds(205, 57, 116, 212);
		frame.getContentPane().add(btnDsharp);
		btnDsharp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mc[5].noteOn(63, 600);
			}
		});
		
		JButton btnFsharp = new JButton("F#/G(flat)");
		btnFsharp.setForeground(Color.WHITE);
		btnFsharp.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnFsharp.setBackground(Color.BLACK);
		btnFsharp.setBounds(382, 57, 116, 212);
		frame.getContentPane().add(btnFsharp);
		btnFsharp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mc[5].noteOn(66, 600);
			}
		});
		
		JButton btnGsharp = new JButton("G#/A(flat)");
		btnGsharp.setForeground(Color.WHITE);
		btnGsharp.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnGsharp.setBackground(Color.BLACK);
		btnGsharp.setBounds(508, 57, 116, 212);
		frame.getContentPane().add(btnGsharp);
		btnGsharp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mc[5].noteOn(68, 600);
			}
		});
		
		JButton btnB = new JButton("B");
		btnB.setFont(new Font("Tahoma", Font.PLAIN, 26));
		btnB.setBackground(Color.WHITE);
		btnB.setBounds(679, 280, 97, 287);
		frame.getContentPane().add(btnB);
		btnB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mc[5].noteOn(71, 600);
			}
		});
		
		JButton btnAsharp = new JButton("A#/B(flat)");
		btnAsharp.setForeground(Color.WHITE);
		btnAsharp.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnAsharp.setBackground(Color.BLACK);
		btnAsharp.setBounds(634, 57, 116, 212);
		frame.getContentPane().add(btnAsharp);
		btnAsharp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mc[5].noteOn(70, 600);
			}
		});
		
		JButton btnC_1 = new JButton("C");
		btnC_1.setFont(new Font("Tahoma", Font.PLAIN, 26));
		btnC_1.setBackground(Color.WHITE);
		btnC_1.setBounds(786, 280, 97, 287);
		frame.getContentPane().add(btnC_1);
		btnC_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mc[5].noteOn(72, 600);
			}
		});
		
		JButton btnD_1 = new JButton("D");
		btnD_1.setFont(new Font("Tahoma", Font.PLAIN, 26));
		btnD_1.setBackground(Color.WHITE);
		btnD_1.setBounds(893, 280, 97, 287);
		frame.getContentPane().add(btnD_1);
		btnD_1.addActionListener(new ActionListener () {
			public void actionPerformed(ActionEvent e) {
				mc[5].noteOn(74, 600);
			}
		});
		
		JButton btnCsharp_1 = new JButton("C#/D(flat)");
		btnCsharp_1.setForeground(Color.WHITE);
		btnCsharp_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnCsharp_1.setBackground(Color.BLACK);
		btnCsharp_1.setBounds(827, 57, 116, 212);
		frame.getContentPane().add(btnCsharp_1);
		btnCsharp_1.addActionListener(new ActionListener () {
			public void actionPerformed(ActionEvent e) {
				mc[5].noteOn(73, 600);
			}
		});
		
		
		
		
		frame.setVisible(true);
		
	}
}
