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
	boolean move;
    boolean idle;
	
	public Controller(){
		//add more stuff
		p = new Player();
		view = new View();
		model = new Model(view.getWidth(), view.getHeight(), view.getImageWidth(), view.getImageHeight());
		move = false;
		idle = true;
	}
	
	public void start(){
		keyListener = new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {
			}
			@Override
			public void keyPressed(KeyEvent e) {
				int keyCode = e.getKeyCode();
					
				if (keyCode == KeyEvent.VK_LEFT){
					p.setFocusable(true);
					idle = false;
					move = true;
					p.changeMotion(move, idle);
					model.setDirect(Direction.WEST);
					model.updateLocationAndDirection();
				}
				else if (keyCode == KeyEvent.VK_RIGHT){
					p.setFocusable(true);
					idle = false;
					move = true;
					p.changeMotion(move, idle);
					model.setDirect(Direction.EAST);
					model.updateLocationAndDirection();
				}
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				int keyCode = e.getKeyCode();

				if (keyCode == KeyEvent.VK_LEFT){
					idle = true;
					move = false;
					p.changeMotion(move, idle);
				}
				else if (keyCode == KeyEvent.VK_RIGHT){
					idle = true;
					move = false;
					p.changeMotion(move, idle);
				}
			}
		};
		
		view.addKeyListener(keyListener);
		
		for(int i = 0; i < 100; i++)
		{
			view.update(model.getX(), model.getY(), model.getDirect());
		}
		
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
