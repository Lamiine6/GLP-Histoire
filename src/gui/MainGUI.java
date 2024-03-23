package gui;

import java.awt.BorderLayout;



import chrono.*;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

import config.SimulationConfiguration;
import engine.map.Map;
import engine.process.SimulationBuilder;
import engine.simulation.Evenement;
import engine.simulation.EvenementGuerre;
import engine.simulation.GestionnaireEvenement;
import engine.data.ListeEvenement;
public class MainGUI extends JFrame implements Runnable {

	private Map map;
	
	private int time;
	
	private int time2 = 0;

	private final static Dimension preferredSize = new Dimension(SimulationConfiguration.WINDOW_WIDTH, SimulationConfiguration.WINDOW_HEIGHT);

	private static Font font = new Font("Palatino", Font.BOLD, 20);

	private static final long serialVersionUID = 1L;

	private Chronometer chronometer = new Chronometer();

	private JButton startButton = new JButton(" Commencer la simulation ");
	private JButton clearButton = new JButton(" Arrêter la simulation ");

	private JLabel minuteLabel = new JLabel("Durée de la simulation: ");
	private JLabel secondLabel = new JLabel(":");

	private JLabel timeValue = new JLabel("");
	private JLabel minuteValue = new JLabel("");
	private JLabel secondValue = new JLabel("");

	private JPanel control = new JPanel();
	private JTextArea info = new JTextArea();
	
	private SimulationDisplay dashboard;
	
	private Boolean stop = true;
	
	private MainGUI instance = this;
	
	private ListeEvenement le = new ListeEvenement();
	
	private EvenementGuerre guerreencours;
	
	private GestionnaireEvenement ge = new GestionnaireEvenement();

	public MainGUI(String title) {
		super(title);
		init();
	}

	private void init() {
		
        info.setEditable(false);
        
		Container contentPane = getContentPane();
		contentPane.setLayout(new BorderLayout());

		map = SimulationBuilder.buildMap();
		dashboard = new SimulationDisplay(map);
		dashboard.setPreferredSize(new Dimension(preferredSize));
		contentPane.add(BorderLayout.CENTER, dashboard);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		pack();
		setVisible(true);
		setPreferredSize(preferredSize);
		setResizable(false);
		this.time = 1490;
		updateValues(time);

		control.setLayout(new FlowLayout(FlowLayout.CENTER));
		info.setLayout(new FlowLayout(FlowLayout.LEFT));
		
		info.setFont(font);
		info.append("Liste des événements : ");
		info.setPreferredSize(new Dimension(150, 200));
		contentPane.add(BorderLayout.SOUTH, info);
		timeValue.setFont(new Font("Georgia", Font.BOLD, 22));
		control.add(BorderLayout.EAST, timeValue);
		minuteLabel.setFont(font);
		control.add(minuteLabel);
		minuteValue.setFont(font);
		control.add(minuteValue);

		secondLabel.setFont(font);
		control.add(secondLabel);
		secondValue.setFont(font);
		control.add(secondValue);

		startButton.setFont(font);
		startButton.addActionListener(new StartStopAction());
		control.add(startButton);

		clearButton.setFont(font);
		clearButton.addActionListener(new ClearAction());
		control.add(clearButton);
		contentPane.add(BorderLayout.NORTH, control);
	}
	private void updateValues(int time) {
		if (le.contientEvenement(time, secondValue)) {
			ajouterInfo(le.getListeEvenement().get(time).toString());
		}
		timeValue.setText("Année : "+String.valueOf(time)+"   ");

		CyclicCounter minute = chronometer.getMinute();
		minuteValue.setText(minute.toString());

		CyclicCounter second = chronometer.getSecond();
		secondValue.setText(second.toString());
		dashboard.repaint();
	}

	@Override
	public void run() {
		while (!stop && time<1790) {
			try {
				Thread.sleep(SimulationConfiguration.SIMULATION_SPEED);
			} catch (InterruptedException e) {
				System.out.println(e.getMessage());
			}
			if (!stop) {
				time2++;
				if ((time2)%30==0) {
					time2=0;
					chronometer.increment();
					updateValues(time);
					if ((Integer.valueOf(secondValue.getText())-1)%2==0) {
						this.time++;
					}
				}
				if(guerreencours!=null) {
					if ((time==(guerreencours.getDate().getYear()+guerreencours.getDuree())) && (time2==1) && (Integer.valueOf(secondValue.getText())-1)%2==0){
						ajouterInfo("Le gagnant de la guerre est "+ge.traiterEvenementsGuerre(time, guerreencours));
					}
				}
				if (le.contientEvenement(time, secondValue)) {
					dashboard.repaint(le.getListeEvenement().get(time).getAnimation());
						Evenement evenement = le.getListeEvenement().get(time);
						if (evenement instanceof EvenementGuerre) {
							guerreencours = (EvenementGuerre) evenement;
						}
				}
				else {
					dashboard.repaint();
				}
			}
		}
	}
	public int getTime() {
		return this.time;
	}
	
	public void ajouterInfo(String infotext) {
        info.append(infotext + "\n");
        String[] lignes = info.getText().split("\n");
        if (lignes.length > 3) {
            StringBuilder nouveauTexte = new StringBuilder();
            for (int i = lignes.length - 3; i < lignes.length; i++) {
                nouveauTexte.append(lignes[i]).append("\n");
            }
            info.setText(nouveauTexte.toString());
        }
    }
	
	private class StartStopAction implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			if (!stop) {
				stop = true;
				startButton.setText(" Reprendre la simulation ");
			} else {
				stop = false;
				startButton.setText(" Mettre en pause la simulation ");
				Thread chronoThread = new Thread(instance);
				chronoThread.start();
			}
		}
	}

	private class ClearAction implements ActionListener {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			stop = true;
			time = 1490;
			startButton.setText(" Commencer la simulation ");
			chronometer.init();
			updateValues(time);
		}

	}
}