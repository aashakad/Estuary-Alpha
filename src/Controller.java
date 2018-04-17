import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.Timer;

public class Controller {
	private Model model;
	private View view;
	private ActionListener actionListener;
	private KeyListener keyListener;
	boolean movement;
	
	public Controller(){
		//add more stuff
		view = new View();
		model = new Model(view.getWidth(), view.getHeight(), view.getImageWidth(), view.getImageHeight());
		movement = false;
	}
	
	public void start(){
		keyListener = new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {}
			@Override
			public void keyPressed(KeyEvent e) {
				int keyCode = e.getKeyCode();
					
				if (keyCode == KeyEvent.VK_LEFT){
					movement = true;
					model.setDirect(Direction.WEST);
					view.update(model.getX(), model.getDirect());
				}
				if (keyCode == KeyEvent.VK_RIGHT){
					movement = true;
					model.setDirect(Direction.EAST);
					view.update(model.getX(), model.getDirect());
				}
			}
			@Override
			public void keyReleased(KeyEvent e) {
				int keyCode = e.getKeyCode();

				if (keyCode == KeyEvent.VK_LEFT){
					//stopMVT();
					//view update
				}
				if (keyCode == KeyEvent.VK_RIGHT){
					//stopMVT();
					//view update
				}
			}
		};
		 
		view.addKeyListener(keyListener);
		
		for(int i = 0; i < 5000; i++)
		{
			if (movement)
			{
				model.updateLocationAndDirection();
			}
		}
		//update the view
		view.update(model.getX(), model.getDirect());
		
		EventQueue.invokeLater(new Runnable(){
			public void run(){
			
				Timer t = new Timer(30, view.getdrawAction());
				t.start();
			}
		});
		
	}
 
	protected void stopMVT() {
		//may not need
	}
	public static void main(String[] args) {
		Controller c = new Controller();
		c.start();
	}
}
