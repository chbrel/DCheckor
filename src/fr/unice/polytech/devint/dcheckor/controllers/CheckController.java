package fr.unice.polytech.devint.dcheckor.controllers;

import java.awt.Dimension;
import java.io.File;
import java.util.ArrayList;

import javax.swing.JFrame;

import fr.unice.polytech.devint.dcheckor.models.Checkor;
import fr.unice.polytech.devint.dcheckor.views.ConfigView;
import fr.unice.polytech.devint.dcheckor.views.ResultsView;
import fr.unice.polytech.devint.dcheckor.views.WelcomeView;
import fr.unice.polytech.devint.dcheckor.models.FileUtils;

public class CheckController extends JFrame {

	private Checkor checkor;
	
	private WelcomeView wv;
	private ConfigView cv;
	private ResultsView rv;
	
	private int cdyear;
	private String cdfolder;
	
	
	public CheckController(Checkor checkor) {
		super("View Manager");
		this.checkor = checkor;
		
		
		this.wv = new WelcomeView(this);
		this.cv = new ConfigView(this);
		this.rv = new ResultsView(this);
		
		this.init();
	}
	
	public void init() {
		this.setTitle("DCheckor!");
		this.setContentPane(this.wv);
		
		Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
		
		this.setMinimumSize(new Dimension(1024,768));
		this.setPreferredSize(new Dimension(1024,768));
		this.setMaximumSize(screenSize);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.pack();
		

		this.setLocation((screenSize.width-this.getWidth())/2,(screenSize.height-this.getHeight())/2);
		
		this.setVisible(true);
	}
	
	public void nextStep() {
		if(this.getContentPane().equals(this.wv)) {
			this.setTitle("DCheckor Configuration");
			this.setContentPane(this.cv);
			this.pack();
		} else {
			if(this.getContentPane().equals(this.cv)) {
				checkProcess();
				
				this.setTitle("Results Pane");
				this.setContentPane(this.rv);
				this.pack();
			}
		}
	}
	
	public void setCDYear(int year) {
		this.cdyear = year;
	}
	
	public void setCDFolder(String cdfolder) {
		this.cdfolder = cdfolder;
	}
	
	private void checkProcess() {
		this.checkor.setCDYear(this.cdyear);
		this.checkor.setCDFolder(this.cdfolder);
		
		File cdFolderFile = new File(this.cdfolder);
		if(!cdFolderFile.exists()) {
			this.rv.setResult("<html><h1 style=\"color:red;\">Le dossier donné en entrée n'existe pas!!!</h1></html>");
		} else {
		
			File resourcesFile = new File(this.cdfolder + File.separator + "resources" + File.separator);
			if(!resourcesFile.exists()) {
				resourcesFile.mkdirs();
			}
			
			FileUtils.write(this.cdfolder + File.separator + "resources" + File.separator + "year.txt" , String.valueOf(this.cdyear), false);
			
			this.rv.setResult(this.checkor.check());
		}
	}
	
	public void cancel() {
		this.dispose();
	}
	
	public void finishStep() {
		this.dispose();
	}

}
