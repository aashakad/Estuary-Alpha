import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.Timer;

public class Controller {
	private Model model;
	private View view;
	private Player p;
	private ActionListener actionListener;
	private KeyListener keyListener;
	boolean movement;
    boolean idle;
	
	public Controller(){
		//add more stuff
		p = new Player();
		view = new View();
		model = new Model(view.getWidth(), view.getHeight(), view.getImageWidth(), view.getImageHeight());
		movement = false;
		idle = true;
	}
	
	public void start(){
		keyListener = new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {}
			@Override
			public void keyPressed(KeyEvent e) {
				int keyCode = e.getKeyCode();
					
				if (keyCode == KeyEvent.VK_LEFT){
					p.setFocusable(true);

					idle = false;
					movement = true;
					model.setDirect(Direction.WEST);
					view.update(model.getX(), model.getDirect());
					p.updatePlayer(model.getX(), model.getY(), model.getDirect()); 
				}
				if (keyCode == KeyEvent.VK_RIGHT){
					p.setFocusable(true);

					idle = false;
					movement = true;
					model.setDirect(Direction.EAST);
					view.update(model.getX(), model.getDirect());
					p.updatePlayer(model.getX(), model.getY(), model.getDirect()); 
				}
			}
			@Override
			public void keyReleased(KeyEvent e) {
				int keyCode = e.getKeyCode();

				if (keyCode == KeyEvent.VK_LEFT){
					idle = true;
					//stopMVT();
					//view update
				}
				if (keyCode == KeyEvent.VK_RIGHT){
					idle = true;
					//stopMVT();
					//view update
				}
			}
		};
		 
		view.addKeyListener(keyListener);
		
		for(int i = 0; i < 5000; i++)
		{
			if (movement == true)
			{
				model.updateLocationAndDirection();
			}
		}
		//update the view
		view.update(model.getX(), model.getDirect());
		p.updatePlayer(model.getX(), model.getY(), model.getDirect()); 
		
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
