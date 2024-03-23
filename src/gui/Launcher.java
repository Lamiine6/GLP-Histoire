package gui;

import java.awt.Font;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.JPanel;

import config.SimulationConfiguration;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;



public class Launcher extends JFrame {
	
	private static final long serialVersionUID = 1L;
	
	private JButton startButton = new JButton("Lancer la simulation");
	
	private JButton configButton = new JButton(" Changer les paramètres ");
	
	private JButton changerVitesse = new JButton("Vitesse x2");
	
	private JButton revenirMenu = new JButton("Revenir au menu");
	
	private static Font font = new Font(Font.MONOSPACED, Font.BOLD, 20);
	
	private JPanel buttonPanel = new JPanel();
	
	private JPanel paramPanel = new JPanel();
	
	public Launcher(String title) {
		super(title);
		init();
	}
	private void init() {
		Container contentPane = getContentPane();
		contentPane.setLayout(new FlowLayout(FlowLayout.CENTER)); 
		
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        paramPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        
        changerVitesse.setFont(font);
        changerVitesse.addActionListener(new changerVitesse());
        revenirMenu.setFont(font);
        revenirMenu.addActionListener(new revenirMenu());
        paramPanel.add(revenirMenu);
        paramPanel.add(changerVitesse);
        startButton.setFont(font);
        configButton.setFont(font);
        startButton.addActionListener(new LancerLaPartie());
        configButton.addActionListener(new Parametre());
        buttonPanel.add(startButton);
        buttonPanel.add(configButton);
        contentPane.add(paramPanel);
        paramPanel.setVisible(false);
        contentPane.add(buttonPanel);
        buttonPanel.setVisible(true);
        setPreferredSize(new Dimension(700, 150));
        setResizable(false);
        pack();
        this.setVisible(true);
	}
	private class LancerLaPartie implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			MainGUI simulationMainGUI = new MainGUI("Simulation de l'Histoire");
			Thread simulationThread = new Thread(simulationMainGUI);
			simulationThread.start();
			setVisible(false);
		}
	}
	private class Parametre implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			buttonPanel.setVisible(false);
			paramPanel.setVisible(true);
		}
	}
	private class changerVitesse implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			if (changerVitesse.getText().equals("Vitesse x2")){
				SimulationConfiguration.SIMULATION_SPEED/=2;
				changerVitesse.setText("Vitesse x1");
			}
			else {
				SimulationConfiguration.SIMULATION_SPEED*=2;
				changerVitesse.setText("Vitesse x2");
			}
			
		}
	}
	private class revenirMenu implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			paramPanel.setVisible(false);
			buttonPanel.setVisible(true);
		}
	}
}

	
	
	
	