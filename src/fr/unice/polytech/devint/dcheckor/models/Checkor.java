package fr.unice.polytech.devint.dcheckor.models;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;

public class Checkor {

	private int cdyear;
	private String cdfolder;
	
	public String check() {
		
		ArrayList<String> generateErrors = new ArrayList<String>();
		
		String results = "<html>";
		
		//Test presence jre folder et subfolders
		results += "<h2>Vérification du dossier jre</h2><ul>";
		String jreFolderString = this.cdfolder + File.separator + "jre";
		File jreFolder = new File (jreFolderString); 

    	if (jreFolder.exists() && jreFolder.isDirectory()) {
    		results += "<li><span style=\"color:green\">Le répertoire jre existe.</span>";
    		
    		results += "<ul>";
    		//Test presence win jre folder
    		String winJreFolderString = jreFolderString + File.separator + "win";
    		File winJreFolder = new File (winJreFolderString); 

        	if (winJreFolder.exists() && winJreFolder.isDirectory()) {
        		results += "<li><span style=\"color:green\">Le sous-répertoire jre/win existe.</span></li>";
        	} else {
        		results += "<li><span style=\"color:red\">Le sous-répertoire jre/win n'existe pas.</span></li>";
        	}
        	
        	//Test presence linux jre folder
    		String linuxJreFolderString = jreFolderString + File.separator + "linux";
    		File linuxJreFolder = new File (linuxJreFolderString); 

        	if (linuxJreFolder.exists() && linuxJreFolder.isDirectory()) {
        		results += "<li><span style=\"color:green\">Le sous-répertoire jre/linux existe.</span></li>";
        	} else {
        		results += "<li><span style=\"color:red\">Le sous-répertoire jre/linux n'existe pas.</span></li>";
        	}
        	
        	//Test presence mac jre folder
    		String macJreFolderString = jreFolderString + File.separator + "mac";
    		File macJreFolder = new File (macJreFolderString); 

        	if (macJreFolder.exists() && macJreFolder.isDirectory()) {
        		results += "<li><span style=\"color:green\">Le sous-répertoire jre/mac existe.</span></li>";
        	} else {
        		results += "<li><span style=\"color:red\">Le sous-répertoire jre/mac n'existe pas.</span></li>";
        	}
        	
        	results += "</ul>";
    		
    		results += "</li>";
    	} else {
    		generateErrors.add("Le répertoire jre n'existe pas.");
    		results += "<li><span style=\"color:red\">Le répertoire jre n'existe pas.</span></li>";
    	}

    	results += "</ul>";
		
		//Test presence lib folder et subfolders
    	results += "<h2>Vérification du dossier lib</h2>\n<ul>\n";
		String libFolderString = this.cdfolder + File.separator + "lib";
		File libFolder = new File (libFolderString); 

    	if (libFolder.exists() && libFolder.isDirectory()) {
    		results += "<li><span style=\"color:green\">Le répertoire lib existe.</span>";
    		
    		results += "<ul>";
    		//Test presence win lib folder
    		String winLibFolderString = libFolderString + File.separator + "win";
    		File winLibFolder = new File (winLibFolderString); 

        	if (winLibFolder.exists() && winLibFolder.isDirectory()) {
        		results += "<li><span style=\"color:green\">Le sous-répertoire lib/win existe.</span></li>";
        	} else {
        		results += "<li><span style=\"color:red\">Le sous-répertoire lib/win n'existe pas.</span></li>";
        	}
        	
        	//Test presence linux lib folder
    		String linuxLibFolderString = libFolderString + File.separator + "linux";
    		File linuxLibFolder = new File (linuxLibFolderString); 

        	if (linuxLibFolder.exists() && linuxLibFolder.isDirectory()) {
        		results += "<li><span style=\"color:green\">Le sous-répertoire lib/linux existe.</span></li>";
        	} else {
        		results += "<li><span style=\"color:red\">Le sous-répertoire lib/linux n'existe pas.</span></li>";
        	}
        	
        	//Test presence mac lib folder
    		String macLibFolderString = libFolderString + File.separator + "mac";
    		File macLibFolder = new File (macLibFolderString); 

        	if (macLibFolder.exists() && macLibFolder.isDirectory()) {
        		results += "<li><span style=\"color:green\">Le sous-répertoire lib/mac existe.</span></li>";
        	} else {
        		results += "<li><span style=\"color:red\">Le sous-répertoire lib/mac n'existe pas.</span></li>";
        	}
        	
        	results += "</ul>";
    		
    		results += "</li>";
    	} else {
    		generateErrors.add("Le répertoire lib n'existe pas.");
    		results += "<li><span style=\"color:red\">Le répertoire lib n'existe pas.</span></li>";
    	}

    	results += "</ul>";
    	
    	//Test presence DListor folder
    	results += "<h2>Vérification du dossier DListor</h2>\n<ul>\n";
		String dlistorFolderString = this.cdfolder + File.separator + "DListor";
		File dlistorFolder = new File (dlistorFolderString); 

    	if (dlistorFolder.exists() && dlistorFolder.isDirectory()) {
    		results += "<li><span style=\"color:green\">Le répertoire DListor existe.</span></li>";
    	} else {
    		generateErrors.add("Le répertoire DListor n'existe pas.");
    		results += "<li><span style=\"color:red\">Le répertoire DListor n'existe pas.</span></li>";
    	}
    	
    	results += "</ul>";
    	
		//Test presence VocalyzeSIVOX folder
    	results += "<h2>Vérification du dossier VocalyzeSIVOX</h2>\n<ul>\n";
		String vocalyzeSIVOXFolderString = this.cdfolder + File.separator + "VocalyzeSIVOX";
		File vocalyzeSIVOXFolder = new File (vocalyzeSIVOXFolderString); 

    	if (vocalyzeSIVOXFolder.exists() && vocalyzeSIVOXFolder.isDirectory()) {
    		results += "<li><span style=\"color:green\">Le répertoire VocalyzeSIVOX existe.</span></li>";
    	} else {
    		generateErrors.add("Le répertoire VocalyzeSIVOX n'existe pas.");
    		results += "<li><span style=\"color:red\">Le répertoire VocalyzeSIVOX n'existe pas.</span></li>";
    	}
    	
    	results += "</ul>";
    	
		//Test presence LesLogiciels et test de structure de chaque projet
    	results += "<h2>Vérification du dossier LesLogiciels</h2>\n<ul>\n";
		String gamesFolderString = this.cdfolder + File.separator + "LesLogiciels";
		File gamesFolder = new File (gamesFolderString); 

    	if (gamesFolder.exists() && gamesFolder.isDirectory()) {
    		results += "<li><span style=\"color:green\">Le répertoire LesLogiciels existe.</span>";
    		
    		results += "<ul>";
    		
    		String[] gamesList = gamesFolder.list(); 

        	for (int i=0; i < gamesList.length; i++ ) {
        		String gameFolder = gamesFolder + File.separator + gamesList[i];
        		File game = new File(gameFolder); 
        		
        		if(game.exists() && game.isDirectory()) {
        			results += "<li><span><b>Vérification pour le projet dont le dossier est: " + gamesList[i] + "</b></span>";
        			results += "<ul>";
        			
        			//Vérification dossier bin et execution.bat/.sh
        			String gameBinFolder = gameFolder + File.separator + "bin";
        			File gameBin = new File(gameBinFolder); 
            		
            		if(gameBin.exists() && gameBin.isDirectory()) {
            			results += "<li><span style=\"color:green\">Le répertoire bin existe.</span>";
            			results += "<ul>";
            			
            			String gameBinExecBatFile = gameBinFolder + File.separator + "execution.bat";
            			File gameBinExecBat = new File(gameBinExecBatFile);
            			
            			if(gameBinExecBat.exists() && gameBinExecBat.isFile()) {
            				results += "<li><span style=\"color:green\">Le fichier bin/execution.bat existe.</span></li>";
            			} else {
            				generateErrors.add(gamesList[i] + ": Le fichier bin/execution.bat n'existe pas.");
            				results += "<li><span style=\"color:red\">Le fichier bin/execution.bat n'existe pas.</span></li>";
            			}
            			
            			String gameBinExecShFile = gameBinFolder + File.separator + "execution.sh";
            			File gameBinExecSh = new File(gameBinExecShFile);
            			
            			if(gameBinExecSh.exists() && gameBinExecSh.isFile()) {
            				results += "<li><span style=\"color:green\">Le fichier bin/execution.sh existe.</span></li>";
            			} else {
            				results += "<li><span style=\"color:orange\">Le fichier bin/execution.sh n'existe pas.</span></li>";
            			}
            			
            			results += "</ul>";
            			results += "</li>";
            		} else {
            			generateErrors.add(gamesList[i] + ": Le répertoire bin n'existe pas.");
            			results += "<li><span style=\"color:red\">Le répertoire bin n'existe pas.</span></li>";
            		}
            		
        			//Verification dossier src et compilation.bat/.sh
            		String gameSrcFolder = gameFolder + File.separator + "src";
        			File gameSrc = new File(gameSrcFolder); 
            		
            		if(gameSrc.exists() && gameSrc.isDirectory()) {
            			results += "<li><span style=\"color:green\">Le répertoire src existe.</span>";
            			results += "<ul>";
            			
            			String gameSrcCompilBatFile = gameSrcFolder + File.separator + "compilation.bat";
            			File gameSrcCompilBat = new File(gameSrcCompilBatFile);
            			
            			if(gameSrcCompilBat.exists() && gameSrcCompilBat.isFile()) {
            				results += "<li><span style=\"color:green\">Le fichier src/compilation.bat existe.</span></li>";
            			} else {
            				results += "<li><span style=\"color:red\">Le fichier src/compilation.bat n'existe pas.</span></li>";
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
            			results += "<li><span style=\"color:red\">Le répertoire src n'existe pas.</span></li>";
            		}
            		
        			//Verification dossier doc et infos.xml
            		String gameDocFolder = gameFolder + File.separator + "doc";
        			File gameDoc = new File(gameDocFolder); 
            		
            		if(gameDoc.exists() && gameDoc.isDirectory()) {
            			results += "<li><span style=\"color:green\">Le répertoire doc existe.</span>";
            			results += "<ul>";
            			
            			String gameDocInfosFile = gameDocFolder + File.separator + "infos.xml";
            			File gameDocInfos = new File(gameDocInfosFile);
            			
            			if(gameDocInfos.exists() && gameDocInfos.isFile()) {
            				results += "<li><span style=\"color:green\">Le fichier doc/infos.xml existe.</span></li>";
            				
            				String checkXml = this.checkInfosXmlFile(gameDocInfos);
            				
            				if(checkXml.contains("color:red")) {
            					generateErrors.add(gamesList[i] + ": Une/Des erreur(s) dans le infos.xml.");
            				}
            				results += "<ul>" + checkXml + "</ul>";
            				
            			} else {
            				generateErrors.add(gamesList[i] + ": Le fichier doc/infos.xml n'existe pas.");
            				results += "<li><span style=\"color:red\">Le fichier doc/infos.xml n'existe pas.</span></li>";
            			}
            			
            			results += "</ul>";
            			results += "</li>";
            		} else {
            			generateErrors.add(gamesList[i] + ": Le répertoire doc n'existe pas.");
            			results += "<li><span style=\"color:red\">Le répertoire doc n'existe pas.</span></li>";
            		}
            		
        			
        			results += "</ul>";
        			
        			results += "</li>";
        		} else {
        			generateErrors.add("Un fichier supplémentaire s'est glissé dans le répertoire LesLogciels: " + gameFolder);
        			results += "<li><span style=\"color:red\">Un fichier supplémentaire s'est glissé dans le répertoire LesLogciels: " + gameFolder + "</span></li>";
        		}
        	}
        	
        	results += "</ul>";
    		
    		results += "</li>";
    	} else {
    		generateErrors.add("Le répertoire LesLogiciels n'existe pas.");
    		results += "<li><span style=\"color:red;\">Le répertoire LesLogiciels n'existe pas.</span></li>";
    	}

    	results += "</ul>";
    	
    	if(generateErrors.isEmpty()) {
			results += "<span id=\"generateGood\" style=\"color:green\">La version zip du CD peut être générée!</span>";
		} else {
			results += "<ul><span  id=\"generateBad\" style=\"color:red;\">Impossible de générer la version zip du CD:</span>";
			for(String err : generateErrors) {
				results += "<li><span style=\"color:red;\">" + err + "</span></li>";
			}
			results += "</ul>";
		}
    	
		results += "</html>";
		
		
		
		return results;
	}
	
	public String checkInfosXmlFile(File infosFile) {
		boolean ok = true;
		String mistakes = "";
		SAXBuilder builder = new SAXBuilder();
        try {
            Element xmlRoot = builder.build(infosFile).getRootElement();

            String year = xmlRoot.getChildText("year");
            
            if(year == null) {
            	ok = false;
            	mistakes += "<li><span style=\"color:red\">Il ne contient pas d'informations sur l'année (noeud 'year').</span></li>";
            }

            Element gameCategories = xmlRoot.getChild("gamecategories");
            
            if(gameCategories == null) {
            	ok = false;
            	mistakes += "<li><span style=\"color:red\">Il ne contient pas d'informations sur les catégories de jeu (noeud 'gamecategories').</span></li>";
            }
            
            
            List categories = gameCategories.getChildren("gamecategory");
            if(categories == null || categories.size() == 0) {
            	ok = false;
            	mistakes += "<li><span style=\"color:red\">Aucune catégorie de jeu n'est décrit (noeud 'gamecategory' sous-noeud de 'gamecategories').</span></li>";
            }

            String shortDescription = xmlRoot.getChildText("shortdescription");
            
            if(shortDescription == null) {
            	ok = false;
            	mistakes += "<li><span style=\"color:red\">Il ne contient pas de résumé (noeud 'shortdescription').</span></li>";
            }
            
            String publicString = xmlRoot.getChildText("public");
            
            if(publicString == null) {
            	ok = false;
            	mistakes += "<li><span style=\"color:red\">Il ne contient pas d'informations sur le type de public visé par ce jeu (noeud 'public').</span></li>";
            }
            
            String gameStateString = xmlRoot.getChildText("gamestate");
            
            if(gameStateString == null) {
            	ok = false;
            	mistakes += "<li><span style=\"color:red\">Il ne contient pas d'informations sur l'état d'avancement de ce jeu (noeud 'gamestate').</span></li>";
            }

            String age = xmlRoot.getChildText("age");
            
            if(age == null) {
            	ok = false;
            	mistakes += "<li><span style=\"color:red\">Il ne contient pas d'informations sur l'age du public visé par ce jeu (noeud 'age').</span></li>";
            }
            
            String title = xmlRoot.getChildText("title");

            if(title == null) {
            	ok = false;
            	mistakes += "<li><span style=\"color:red\">Il ne contient pas de titre (noeud 'title').</span></li>";
            }
            
            Element authorsElem = xmlRoot.getChild("authors");
            
            if(authorsElem == null) {
            	ok = false;
            	mistakes += "<li><span style=\"color:red\">Il ne contient pas d'informations sur les auteurs du jeu (noeud 'authors').</span></li>";
            }

            List authors = authorsElem.getChildren("author");
            if(authors == null || authors.size() == 0) {
            	ok = false;
            	mistakes += "<li><span style=\"color:red\">Aucun auteur n'est enregistré pour ce jeu (noeud 'author' sous-noeud de 'authors').</span></li>";
            }
            
            Element notesElem = xmlRoot.getChild("notes");
            
            if(notesElem == null) {
            	ok = false;
            	mistakes += "<li><span style=\"color:red\">Il ne contient pas d'informations sur les notes du jeu (noeud 'notes').</span></li>";
            }

            List notes = notesElem.getChildren("note");
            if(notes == null || notes.size() == 0) {
            	ok = false;
            	mistakes += "<li><span style=\"color:#ED7F10\">Non Obligatoire: Aucune note n'est enregistré pour ce jeu (noeud 'note' sous-noeud de 'notes').</span></li>";
            }

            String gameplay = xmlRoot.getChildText("gameplay");
            
            if(gameplay == null) {
            	ok = false;
            	mistakes += "<li><span style=\"color:red\">Il ne contient pas d'informations sur les commandes du jeu (noeud 'gameplay').</span></li>";
            }

            String gamerules = xmlRoot.getChildText("gamerules");
            
            if(gamerules == null) {
            	ok = false;
            	mistakes += "<li><span style=\"color:red\">Il ne contient pas d'informations sur les règles du jeu (noeud 'gamerules').</span></li>";
            }
            
            if(ok) {
            	return "<li><span style=\"color:green\">Il ne manque aucune information sur ce jeu dans le fichier infos.xml.</span></li>";
            } else {
            	return mistakes;
            }

        } catch (JDOMException e) {
            return mistakes + "<li><span style=\"color:red\">Une erreur s'est produite pendant la lecture du fichier XML (pb de structure de fichier).</span></li>";
        } catch (IOException e) {
        	return mistakes + "<li><span style=\"color:red\">Une erreur s'est produite pendant la lecture du fichier XML (pb de lecture et non de structure du fichier).</span></li>";
        }
	}
	
	public void setCDYear(int year) {
		this.cdyear = year;
	}
	
	public void setCDFolder(String cdfolder) {
		this.cdfolder = cdfolder;
	}
	
	public String generateZipVersion() {
		String results = "<html>";
		
		String cdDestinationFolderString = this.cdfolder + "_ZipVersion";
		File cdDestinationFolderFile = new File(cdDestinationFolderString);
		cdDestinationFolderFile.mkdirs();
		results += "<span style=\"color:green\">Création du répertoire: " + cdDestinationFolderString + ".</span>";
		
		ArrayList<String> doNotCopy = new ArrayList<String>();
		
		//Zip lib folder et subfolders
		String libFolderString = this.cdfolder + File.separator + "lib";
		File libFolder = new File (libFolderString); 

		results += "<h2>Vérification du dossier lib</h2>";
    	if (libFolder.exists() && libFolder.isDirectory()) {
    		doNotCopy.add(libFolder.getAbsolutePath());
    		String libDestinationFolderString = cdDestinationFolderString + File.separator + "lib";
    		File libDestinationFolder = new File(libDestinationFolderString);
    		libDestinationFolder.mkdirs();
    		results += "<span style=\"color:green\">Création du répertoire: " + libDestinationFolderString + ".</span>";
    		
    		//Test presence win lib folder
    		String winLibFolderString = libFolderString + File.separator + "win";
    		File winLibFolder = new File (winLibFolderString); 

        	if (winLibFolder.exists() && winLibFolder.isDirectory()) {
        		String winLibDestinationFolderString = libDestinationFolderString + File.separator + "win.zip";
        		File winDestinationLibFile = new File (winLibDestinationFolderString); 
        		
        		
        		this.zipFolder(winLibFolder, winDestinationLibFile);
        		results += "<span style=\"color:green\">Création du fichier zip: " + winLibDestinationFolderString + ".</span>";
        	}
        	
        	//Test presence linux lib folder
    		String linuxLibFolderString = libFolderString + File.separator + "linux";
    		File linuxLibFolder = new File (linuxLibFolderString); 

        	if (linuxLibFolder.exists() && linuxLibFolder.isDirectory()) {
        		String linuxLibDestinationFolderString = libDestinationFolderString + File.separator + "linux.zip";
        		File linuxDestinationLibFile = new File (linuxLibDestinationFolderString); 
        		
        			
        		this.zipFolder(linuxLibFolder, linuxDestinationLibFile);
        		results += "<span style=\"color:green\">Création du fichier zip: " + linuxLibDestinationFolderString + ".</span>";
        	}
        	
        	//Test presence mac lib folder
    		String macLibFolderString = libFolderString + File.separator + "mac";
    		File macLibFolder = new File (macLibFolderString); 

        	if (macLibFolder.exists() && macLibFolder.isDirectory()) {
        		String macLibDestinationFolderString = libDestinationFolderString + File.separator + "mac.zip";
        		File macDestinationLibFile = new File (macLibDestinationFolderString); 
        		
        			
        		this.zipFolder(macLibFolder, macDestinationLibFile);
        		results += "<span style=\"color:green\">Création du fichier zip: " + macLibDestinationFolderString + ".</span>";
        	}

    	}

    	//Test presence DListor folder
		String dlistorFolderString = this.cdfolder + File.separator + "DListor";
		File dlistorFolder = new File (dlistorFolderString);
		
		results += "<h2>Vérification du dossier DListor</h2>";
    	if (dlistorFolder.exists() && dlistorFolder.isDirectory()) {
    		doNotCopy.add(dlistorFolder.getAbsolutePath());
    		String dListorDestinationFolderString = cdDestinationFolderString + File.separator + "DListor.zip";
    		File dListorDestinationFile = new File (dListorDestinationFolderString); 
    		
    			
    		this.zipFolder(dlistorFolder, dListorDestinationFile);
    		
    		results += "<span style=\"color:green\">Création du fichier zip: " + dListorDestinationFolderString + ".</span>";
    	}
    	
    	//Test presence DHelp folder
		String dhelpFolderString = this.cdfolder + File.separator + "DHelp";
		File dhelpFolder = new File (dhelpFolderString); 
		
		results += "<h2>Vérification du dossier DHelp</h2>";
    	if (dhelpFolder.exists() && dhelpFolder.isDirectory()) {
    		doNotCopy.add(dhelpFolder.getAbsolutePath());
    		String dHelpDestinationFolderString = cdDestinationFolderString + File.separator + "DHelp.zip";
    		File dHelpDestinationFile = new File (dHelpDestinationFolderString); 
    		
    			
    		this.zipFolder(dhelpFolder, dHelpDestinationFile);
    		
    		results += "<span style=\"color:green\">Création du fichier zip: " + dHelpDestinationFolderString + ".</span>";
    	}
    	
		//Test presence VocalyzeSIVOX folder
		String vocalyzeSIVOXFolderString = this.cdfolder + File.separator + "VocalyzeSIVOX";
		File vocalyzeSIVOXFolder = new File (vocalyzeSIVOXFolderString); 
		
		results += "<h2>Vérification du dossier VocalyzeSIVOX</h2>";
    	if (vocalyzeSIVOXFolder.exists() && vocalyzeSIVOXFolder.isDirectory()) {
    		doNotCopy.add(vocalyzeSIVOXFolder.getAbsolutePath());
    		String vocalyzeSIVOXDestinationFolderString = cdDestinationFolderString + File.separator + "VocalyzeSIVOX.zip";
    		File vocalyzeSIVOXDestinationFile = new File (vocalyzeSIVOXDestinationFolderString); 
    		
    			
    		this.zipFolder(vocalyzeSIVOXFolder, vocalyzeSIVOXDestinationFile);
    		
    		results += "<span style=\"color:green\">Création du fichier zip: " + vocalyzeSIVOXDestinationFolderString + ".</span>";
    	}
    	
		//Test presence LesLogiciels et test de structure de chaque projet
		String gamesFolderString = this.cdfolder + File.separator + "LesLogiciels";
		File gamesFolder = new File (gamesFolderString); 
		
		results += "<h2>Vérification du dossier LesLogiciels</h2>";
    	if (gamesFolder.exists() && gamesFolder.isDirectory()) {
    		doNotCopy.add(gamesFolder.getAbsolutePath());
    		String gamesDestinationFolderString = cdDestinationFolderString + File.separator + "LesLogiciels";
    		File gamesDestinationFolder = new File(gamesDestinationFolderString);
    		gamesDestinationFolder.mkdirs();
    		
    		results += "<span style=\"color:green\">Création du répertoire: " + gamesDestinationFolderString + ".</span>";
    		
    		
    		String[] gamesList = gamesFolder.list(); 

        	for (int i=0; i < gamesList.length; i++ ) {
        		String gameFolder = gamesFolder + File.separator + gamesList[i];
        		File game = new File(gameFolder); 
        		
        		results += "<h3>Traitement de: " + gamesList[i] + "</h3>";
        		if(game.exists() && game.isDirectory()) {
        			String gameDestinationFolderString = gamesDestinationFolderString + File.separator + gamesList[i];
            		File gameDestinationFolder = new File(gameDestinationFolderString);
            		gameDestinationFolder.mkdirs();
            		
            		
        			//Verification dossier doc et infos.xml
            		String gameDocFolder = gameFolder + File.separator + "doc";
        			File gameDoc = new File(gameDocFolder); 
            		
            		if(gameDoc.exists() && gameDoc.isDirectory()) {
            			String gameDocDestinationFolderString = gameDestinationFolderString + File.separator + "doc";
                		File gameDocDestinationFolder = new File(gameDocDestinationFolderString);
                		gameDocDestinationFolder.mkdirs();
            			
            			String gameDocInfosFile = gameDocFolder + File.separator + "infos.xml";
            			File gameDocInfos = new File(gameDocInfosFile);
            			
            			if(gameDocInfos.exists() && gameDocInfos.isFile()) {
            				String gameDocInfosDestinationFolderString = gameDocDestinationFolderString + File.separator + "infos.xml";
                    		File gameDocInfosDestinationFile = new File(gameDocInfosDestinationFolderString);
                    		
                    		try {
								FileUtils.copy(gameDocInfos, gameDocInfosDestinationFile);
								results += "<span style=\"color:green\">Copie du fichier infos.xml: " + gameDocInfosDestinationFolderString + ".</span>";
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
                    		
            			}
            		}
            		
            		String gameZipDestinationFolderString = gameDestinationFolderString + File.separator + game.getName() + ".zip";
            		File gameZipDestinationFile = new File (gameZipDestinationFolderString); 
            		
            		this.zipFolder(game, gameZipDestinationFile);
            		
            		results += "<span style=\"color:green\">Création du fichier zip: " + gameZipDestinationFolderString + ".</span>";
        		}
        	}
        	
    	}
    	
    	results += "<h2>Copie du reste du CD à l'identique</h2><ul>";
    	File cdFolderFile = new File(this.cdfolder);
    	for(File f : cdFolderFile.listFiles()) {
    		if(! doNotCopy.contains(f.getAbsolutePath())) {
    			File destFile = new File(cdDestinationFolderString + File.separator + f.getName());
    			
    			try {
					FileUtils.copy(f, destFile);
					results += "<li><span style=\"color:green\">Copie de: " + f.getName() + ".</span><li>";
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
    		}
    	}
    	
    	results += "</ul></html>";
		
		
		
		return results;
	}
	
	private void zipFolder(File folderToZip, File zipFile) {
		try{
    		ZipOutputStream zos = new ZipOutputStream(new FileOutputStream(zipFile));
    		
    		zipRecursively(folderToZip, ".", zos);
    		
    		//remember close it
    		zos.close();
 
		}catch(IOException ex){
	 	   ex.printStackTrace();
	 	}
	}
	
	private void zipRecursively(File folderToZip, String baseFolder, ZipOutputStream zos) {
		byte[] buffer = new byte[1024];
		try{
			for(File f : folderToZip.listFiles()) {
				if(f.isDirectory()) {
					zipRecursively(f, baseFolder + File.separator + f.getName(),zos);
				} else {
	        		ZipEntry ze= new ZipEntry(baseFolder + File.separator + f.getName());
	        		zos.putNextEntry(ze);
	        		FileInputStream in = new FileInputStream(f);
	     
	        		int len;
	        		while ((len = in.read(buffer)) > 0) {
	        			zos.write(buffer, 0, len);
	        		}
	     
	        		in.close();
	        		zos.closeEntry();
				}
			}
		}catch(IOException ex){
    	   ex.printStackTrace();
    	}
	}

}
