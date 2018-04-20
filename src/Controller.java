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
	private Player p;
	boolean move;
	
	public Controller(){
		//add more stuff
		p = new Player();
		view = new View();
		model = new Model(view.getWidth(), view.getHeight(), view.getImageWidth(), view.getImageHeight());
		move = false;
	}
	
	public void start(){
		keyListener = new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {
			}
			@Override
			public void keyPressed(KeyEvent e) {
				int keyCode = e.getKeyCode();
				move = true;
				if (keyCode == KeyEvent.VK_LEFT){
					//p.setFocusable(true);
					//idle = false;
					//p.changeMotion(move, idle);
					//view.p.setMove(move);
					model.setDirect(Direction.WEST);
					
				}
				else if (keyCode == KeyEvent.VK_RIGHT){
					//p.setFocusable(true);
					//idle = false;
					//p.changeMotion(move, idle);
					//view.p.setMove(move);
					model.setDirect(Direction.EAST);
				}
				//model.updateLocationAndDirection();
				//view.update(model.getX(), model.getY(), model.getDirect(), move);
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				move = false;
				view.update(model.getX(), model.getY(), model.getDirect(), move);
				
			}
		};
		
		view.addKeyListener(keyListener);
		for (int i = 0; i <5000; i++) {
			if (move)
				model.updateLocationAndDirection();
			view.update(model.getX(), model.getY(), model.getDirect(), move);
		}
		
		
		EventQueue.invokeLater(new Runnable(){
			public void run(){
			
				Timer t = new Timer(30, view.getdrawAction());
				t.start(); 
			}
		});
		move = false;
	}
 
	protected void stopMVT() {
		//may not need
	}
	public static void main(String[] args) {
		Controller c = new Controller();
		c.start();
	}
}
