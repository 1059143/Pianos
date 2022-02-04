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
	private void initialize() throws MidiUnavailableException {
		Synthesizer synth = MidiSystem.getSynthesizer();
		synth.open();
		final MidiChannel[] mc = synth.getChannels();
		Instrument[] instr = synth.getDefaultSoundbank().getInstruments();
		synth.loadInstrument(instr[90]);
		frame = new JFrame();
		frame.setBounds(100, 100, 969, 671);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("C");
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 26));
		btnNewButton.setBounds(37, 280, 97, 287);
		frame.getContentPane().add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
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
		
		JButton btnNewButton_1 = new JButton("C#/D(flat)");
		btnNewButton_1.setForeground(Color.WHITE);
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnNewButton_1.setBackground(Color.BLACK);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mc[5].noteOn(61,600);
			}
		});
		btnNewButton_1.setBounds(79, 57, 116, 212);
		frame.getContentPane().add(btnNewButton_1);
		
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
		btnFsharp.setBounds(400, 57, 116, 212);
		frame.getContentPane().add(btnFsharp);
		btnFsharp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mc[5].noteOn(66, 600);
			}
		});
		frame.setVisible(true);
		
	}
}
