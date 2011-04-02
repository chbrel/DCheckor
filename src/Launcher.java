import fr.unice.polytech.devint.dcheckor.controllers.CheckController;
import fr.unice.polytech.devint.dcheckor.models.Checkor;


public class Launcher {

	public static void main(String[] args) {
		Checkor checkor = new Checkor();
		CheckController cc = new CheckController(checkor);
	}
}
