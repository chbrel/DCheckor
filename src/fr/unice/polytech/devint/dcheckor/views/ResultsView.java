package fr.unice.polytech.devint.dcheckor.views;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

import fr.unice.polytech.devint.dcheckor.controllers.CheckController;

public class ResultsView extends CheckView {

	private JLabel resultsContent;
	private String result;
	
	public ResultsView(CheckController cc) {
		super(cc);
		
		this.setLayout(new BorderLayout());
		
		JLabel title = new JLabel("Check Results");
		this.add(title, BorderLayout.NORTH);
		
		this.resultsContent = new JLabel("Results");
		
		JPanel panel = new JPanel();
		panel.add(this.resultsContent);
		JScrollPane s = new JScrollPane(panel);
		
		this.add(s, BorderLayout.CENTER);
		
		JPanel actions = new JPanel();
		actions.setLayout(new BorderLayout());
		this.add(actions, BorderLayout.SOUTH);
		
		JPanel buttons = new JPanel();
		buttons.setLayout(new BoxLayout(buttons, BoxLayout.X_AXIS));
		actions.add(buttons, BorderLayout.EAST);
		
/*		JButton cancelButton = new JButton("Cancel");
		cancelButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				cancel();
			}
			
		});
		buttons.add(cancelButton);
		
		JButton nextButton = new JButton("Next");
		nextButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				nextStep();
			}
			
		});
		buttons.add(nextButton);
*/
		
		JButton finishButton = new JButton("Quitter");
		finishButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				finishStep();
			}
			
		});
		buttons.add(finishButton);
		
	}
	
	public void setResult(String result) {
		this.result = result;
		this.resultsContent.setText(this.result);
	}

/*
	public void cancel() {
		int n = JOptionPane.showConfirmDialog(
			    this.getController(),
			    "Voulez-vous vraiment quitter l'installation ?",
			    "",
			    JOptionPane.YES_NO_OPTION);
			if(n == JOptionPane.YES_OPTION) {
				this.getController().cancel();
			}
	}

	public void nextStep() {
		this.getController().nextStep();
	}
*/
	public void finishStep() {
		this.getController().finishStep();
	}
	
}
