package fr.unice.polytech.devint.dcheckor.views;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import fr.unice.polytech.devint.dcheckor.controllers.CheckController;

public class ConfigView extends CheckView {
	
	private JTextField cdYearInfo;
	private JTextField gamesFolderInfo;

	
	public ConfigView(CheckController cc) {
		super(cc);
		
		this.setLayout(new BorderLayout());
		
		JLabel title = new JLabel("Configuration");
		this.add(title, BorderLayout.NORTH);
		
		JPanel configPanel = new JPanel();
		configPanel.setLayout(new BoxLayout(configPanel, BoxLayout.Y_AXIS));
		this.add(configPanel);
		
		JPanel cdYearPanel = new JPanel();
		cdYearPanel.setLayout(new BoxLayout(cdYearPanel, BoxLayout.Y_AXIS));
		configPanel.add(cdYearPanel);
		
		JLabel cdYearLabel =  new JLabel("Année du CD:");
		cdYearPanel.add(cdYearLabel);
		Calendar calendar =new GregorianCalendar();
		calendar.setTime(new Date());
		int annee =calendar.get(Calendar.YEAR);
		this.cdYearInfo = new JTextField(String.valueOf(annee));
		cdYearPanel.add(this.cdYearInfo);
		
		JPanel gamesFolderPanel = new JPanel();
		gamesFolderPanel.setLayout(new BoxLayout(gamesFolderPanel, BoxLayout.Y_AXIS));
		configPanel.add(gamesFolderPanel);
		
		JLabel gamesFolderLabel =  new JLabel("Dossier du contenu du CD:");
		gamesFolderPanel.add(gamesFolderLabel);
		this.gamesFolderInfo = new JTextField(System.getProperty("user.dir") + File.separator + "CDContenu" + File.separator);
		gamesFolderPanel.add(this.gamesFolderInfo); 
		
		JPanel actions = new JPanel();
		actions.setLayout(new BorderLayout());
		this.add(actions, BorderLayout.SOUTH);
		
		JPanel buttons = new JPanel();
		buttons.setLayout(new BoxLayout(buttons, BoxLayout.X_AXIS));
		actions.add(buttons, BorderLayout.EAST);
		
		JButton cancelButton = new JButton("Annuler");
		cancelButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				cancel();
			}
			
		});
		buttons.add(cancelButton);
		
		JButton nextButton = new JButton("Suivant");
		nextButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				nextStep();
			}
			
		});
		buttons.add(nextButton);
	}
	
	public void cancel() {
		int n = JOptionPane.showConfirmDialog(
		    this.getController(),
		    "Voulez-vous vraiment quitter l'installation?",
		    "",
		    JOptionPane.YES_NO_OPTION);
		if(n == JOptionPane.YES_OPTION) {
			this.getController().cancel();
		}
	}
	
	public void nextStep() {
		this.getController().setCDYear(Integer.parseInt(this.cdYearInfo.getText()));
		String gameFolder = this.gamesFolderInfo.getText();
		if(gameFolder.endsWith("/") || gameFolder.endsWith("\\")) {
			gameFolder = gameFolder.substring(0, gameFolder.length()-1);
		}
		this.getController().setCDFolder(gameFolder);
		
		this.getController().nextStep();
	}
}
