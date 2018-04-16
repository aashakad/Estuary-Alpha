import java.awt.event.ActionListener;
import java.awt.event.KeyListener;

public class Controller {
	private Model model;
	private View view;
	private ActionListener actionListener;
	private KeyListener keyListener;
	
	public Controller(){
		
		view = new View();
		model = new Model(view.getWidth(), view.getHeight(), view.getImageWidth(), view.getImageHeight());
	}
}
