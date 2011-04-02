package fr.unice.polytech.devint.dcheckor.models;

import java.io.File;

public class Checkor {

	private int cdyear;
	private String cdfolder;
	
	public String check() {
		
		String results = "<html>";
		
		//Test presence jre folder et subfolders
		results += "<h2>V�rification du dossier jre</h2><ul>";
		String jreFolderString = this.cdfolder + File.separator + "jre";
		File jreFolder = new File (jreFolderString); 

    	if (jreFolder.exists() && jreFolder.isDirectory()) {
    		results += "<li><span style=\"color:green\">Le r�pertoire jre existe.</span>";
    		
    		results += "<ul>";
    		//Test presence win jre folder
    		String winJreFolderString = jreFolderString + File.separator + "win";
    		File winJreFolder = new File (winJreFolderString); 

        	if (winJreFolder.exists() && winJreFolder.isDirectory()) {
        		results += "<li><span style=\"color:green\">Le sous-r�pertoire jre/win existe.</span></li>";
        	} else {
        		results += "<li><span style=\"color:red\">Le sous-r�pertoire jre/win n'existe pas.</span></li>";
        	}
        	
        	//Test presence linux jre folder
    		String linuxJreFolderString = jreFolderString + File.separator + "linux";
    		File linuxJreFolder = new File (linuxJreFolderString); 

        	if (linuxJreFolder.exists() && linuxJreFolder.isDirectory()) {
        		results += "<li><span style=\"color:green\">Le sous-r�pertoire jre/linux existe.</span></li>";
        	} else {
        		results += "<li><span style=\"color:red\">Le sous-r�pertoire jre/linux n'existe pas.</span></li>";
        	}
        	
        	//Test presence mac jre folder
    		String macJreFolderString = jreFolderString + File.separator + "mac";
    		File macJreFolder = new File (macJreFolderString); 

        	if (macJreFolder.exists() && macJreFolder.isDirectory()) {
        		results += "<li><span style=\"color:green\">Le sous-r�pertoire jre/mac existe.</span></li>";
        	} else {
        		results += "<li><span style=\"color:red\">Le sous-r�pertoire jre/mac n'existe pas.</span></li>";
        	}
        	
        	results += "</ul>";
    		
    		results += "</li>";
    	} else {
    		results += "<li><span style=\"color:red\">Le r�pertoire jre n'existe pas.</span></li>";
    	}

    	results += "</ul>";
		
		//Test presence lib folder et subfolders
    	results += "<h2>V�rification du dossier lib</h2>\n<ul>\n";
		String libFolderString = this.cdfolder + File.separator + "lib";
		File libFolder = new File (libFolderString); 

    	if (libFolder.exists() && libFolder.isDirectory()) {
    		results += "<li><span style=\"color:green\">Le r�pertoire lib existe.</span>";
    		
    		results += "<ul>";
    		//Test presence win lib folder
    		String winLibFolderString = libFolderString + File.separator + "win";
    		File winLibFolder = new File (winLibFolderString); 

        	if (winLibFolder.exists() && winLibFolder.isDirectory()) {
        		results += "<li><span style=\"color:green\">Le sous-r�pertoire lib/win existe.</span></li>";
        	} else {
        		results += "<li><span style=\"color:red\">Le sous-r�pertoire lib/win n'existe pas.</span></li>";
        	}
        	
        	//Test presence linux lib folder
    		String linuxLibFolderString = libFolderString + File.separator + "linux";
    		File linuxLibFolder = new File (linuxLibFolderString); 

        	if (linuxLibFolder.exists() && linuxLibFolder.isDirectory()) {
        		results += "<li><span style=\"color:green\">Le sous-r�pertoire lib/linux existe.</span></li>";
        	} else {
        		results += "<li><span style=\"color:red\">Le sous-r�pertoire lib/linux n'existe pas.</span></li>";
        	}
        	
        	//Test presence mac lib folder
    		String macLibFolderString = libFolderString + File.separator + "mac";
    		File macLibFolder = new File (macLibFolderString); 

        	if (macLibFolder.exists() && macLibFolder.isDirectory()) {
        		results += "<li><span style=\"color:green\">Le sous-r�pertoire lib/mac existe.</span></li>";
        	} else {
        		results += "<li><span style=\"color:red\">Le sous-r�pertoire lib/mac n'existe pas.</span></li>";
        	}
        	
        	results += "</ul>";
    		
    		results += "</li>";
    	} else {
    		results += "<li><span style=\"color:red\">Le r�pertoire lib n'existe pas.</span></li>";
    	}

    	results += "</ul>";
    	
		//Test presence Listor folder
    	results += "<h2>V�rification du dossier Listor</h2>\n<ul>\n";
		String listorFolderString = this.cdfolder + File.separator + "Listor";
		File listorFolder = new File (listorFolderString); 

    	if (listorFolder.exists() && listorFolder.isDirectory()) {
    		results += "<li><span style=\"color:green\">Le r�pertoire Listor existe.</span></li>";
    	} else {
    		results += "<li><span style=\"color:red\">Le r�pertoire Listor n'existe pas.</span></li>";
    	}
    	
    	results += "</ul>";
    	
		//Test presence VocalyzeSIVOX folder
    	results += "<h2>V�rification du dossier VocalyzeSIVOX</h2>\n<ul>\n";
		String vocalyzeSIVOXFolderString = this.cdfolder + File.separator + "VocalyzeSIVOX";
		File vocalyzeSIVOXFolder = new File (vocalyzeSIVOXFolderString); 

    	if (vocalyzeSIVOXFolder.exists() && vocalyzeSIVOXFolder.isDirectory()) {
    		results += "<li><span style=\"color:green\">Le r�pertoire VocalyzeSIVOX existe.</span></li>";
    	} else {
    		results += "<li><span style=\"color:red\">Le r�pertoire VocalyzeSIVOX n'existe pas.</span></li>";
    	}
    	
    	results += "</ul>";
    	
		//Test presence LesLogiciels et test de structure de chaque projet
    	results += "<h2>V�rification du dossier LesLogiciels</h2>\n<ul>\n";
		String gamesFolderString = this.cdfolder + File.separator + "LesLogiciels";
		File gamesFolder = new File (gamesFolderString); 

    	if (gamesFolder.exists() && gamesFolder.isDirectory()) {
    		results += "<li><span style=\"color:green\">Le r�pertoire LesLogiciels existe.</span>";
    		
    		results += "<ul>";
    		
    		String[] gamesList = gamesFolder.list(); 

        	for (int i=0; i < gamesList.length; i++ ) {
        		String gameFolder = gamesFolder + File.separator + gamesList[i];
        		File game = new File(gameFolder); 
        		
        		if(game.exists() && game.isDirectory()) {
        			results += "<li><span><b>V�rification pour le projet dont le dossier est: " + gamesList[i] + "</b></span>";
        			results += "<ul>";
        			
        			//V�rification dossier bin et execution.bat/.sh
        			String gameBinFolder = gameFolder + File.separator + "bin";
        			File gameBin = new File(gameBinFolder); 
            		
            		if(gameBin.exists() && gameBin.isDirectory()) {
            			results += "<li><span style=\"color:green\">Le r�pertoire bin existe.</span>";
            			results += "<ul>";
            			
            			String gameBinExecBatFile = gameBinFolder + File.separator + "execution.bat";
            			File gameBinExecBat = new File(gameBinExecBatFile);
            			
            			if(gameBinExecBat.exists() && gameBinExecBat.isFile()) {
            				results += "<li><span style=\"color:green\">Le fichier bin/execution.bat existe.</span></li>";
            			} else {
            				results += "<li><span style=\"color:red\">Le fichier bin/execution.bat n'existe pas.</span></li>";
            			}
            			
            			String gameBinExecShFile = gameBinFolder + File.separator + "execution.sh";
            			File gameBinExecSh = new File(gameBinExecShFile);
            			
            			if(gameBinExecSh.exists() && gameBinExecSh.isFile()) {
            				results += "<li><span style=\"color:green\">Le fichier bin/execution.sh existe.</span></li>";
            			} else {
            				results += "<li><span style=\"color:red\">Le fichier bin/execution.sh n'existe pas.</span></li>";
            			}
            			
            			results += "</ul>";
            			results += "</li>";
            		} else {
            			results += "<li><span style=\"color:red\">Le r�pertoire bin n'existe pas.</span></li>";
            		}
            		
        			//Verification dossier src et compilation.bat/.sh
            		String gameSrcFolder = gameFolder + File.separator + "src";
        			File gameSrc = new File(gameSrcFolder); 
            		
            		if(gameSrc.exists() && gameSrc.isDirectory()) {
            			results += "<li><span style=\"color:green\">Le r�pertoire src existe.</span>";
            			results += "<ul>";
            			
            			String gameSrcCompilBatFile = gameSrcFolder + File.separator + "compilation.bat";
            			File gameSrcCompilBat = new File(gameSrcCompilBatFile);
            			
            			if(gameSrcCompilBat.exists() && gameSrcCompilBat.isFile()) {
            				results += "<li><span style=\"color:green\">Le fichier src/compilation.bat existe.</span></li>";
            			} else {
            				results += "<li><span style=\"color:red\">Le fichier src/execution.bat n'existe pas.</span></li>";
            			}
            			
            			String gameSrcCompilShFile = gameSrcFolder + File.separator + "compilation.sh";
            			File gameSrcCompilSh = new File(gameSrcCompilShFile);
            			
            			if(gameSrcCompilSh.exists() && gameSrcCompilSh.isFile()) {
            				results += "<li><span style=\"color:green\">Le fichier src/compilation.sh existe.</span></li>";
            			} else {
            				results += "<li><span style=\"color:red\">Le fichier src/compilation.sh n'existe pas.</span></li>";
            			}
            			
            			results += "</ul>";
            			results += "</li>";
            		} else {
            			results += "<li><span style=\"color:red\">Le r�pertoire src n'existe pas.</span></li>";
            		}
            		
        			//Verification dossier doc et infos.xml
            		String gameDocFolder = gameFolder + File.separator + "doc";
        			File gameDoc = new File(gameDocFolder); 
            		
            		if(gameDoc.exists() && gameDoc.isDirectory()) {
            			results += "<li><span style=\"color:green\">Le r�pertoire doc existe.</span>";
            			results += "<ul>";
            			
            			String gameDocInfosFile = gameDocFolder + File.separator + "infos.xml";
            			File gameDocInfos = new File(gameDocInfosFile);
            			
            			if(gameDocInfos.exists() && gameDocInfos.isFile()) {
            				results += "<li><span style=\"color:green\">Le fichier doc/infos.xml existe.</span></li>";
            			} else {
            				results += "<li><span style=\"color:red\">Le fichier doc/infos.xml n'existe pas.</span></li>";
            			}
            			
            			results += "</ul>";
            			results += "</li>";
            		} else {
            			results += "<li><span style=\"color:red\">Le r�pertoire src n'existe pas.</span></li>";
            		}
            		
        			
        			results += "</ul>";
        			
        			results += "</li>";
        		} else {
        			results += "<li><span style=\"color:red\">Un fichier suppl�mentaire s'est gliss� dans le r�pertoire LesLogciels: " + gameFolder + "</span></li>";
        		}
        	}
        	
        	results += "</ul>";
    		
    		results += "</li>";
    	} else {
    		results += "<li><span style=\"color:red;\">Le r�pertoire LesLogiciels n'existe pas.</span></li>";
    	}

    	results += "</ul>";
    	
		results += "</html>";
		
		return results;
	}
	
	public void setCDYear(int year) {
		this.cdyear = year;
	}
	
	public void setCDFolder(String cdfolder) {
		this.cdfolder = cdfolder;
	}
}
