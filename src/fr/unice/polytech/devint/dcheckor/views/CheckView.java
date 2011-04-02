package fr.unice.polytech.devint.dcheckor.views;

import javax.swing.JPanel;

import fr.unice.polytech.devint.dcheckor.controllers.CheckController;

public class CheckView extends JPanel {
	
	private CheckController cc;
	
	public CheckView(CheckController cc) {
		this.cc = cc;
	}
	
	public CheckController getController() {
		return this.cc;
	}
}
