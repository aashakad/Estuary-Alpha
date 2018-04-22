import java.awt.EventQueue;
import java.awt.Rectangle;
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
	boolean mow;
	boolean mowerEquip;
	
	public Controller(){
		p = new Player();
		view = new View();
		model = new Model(view.getWidth(), view.getHeight(), view.getImageWidth(), view.getImageHeight());
		move = false;
		// mow is set to true for grass cutting test purposes, by default it should be set to false
		mow = false;
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
					model.setDirect(Direction.WEST);
					move = true;
				}
				else if (keyCode == KeyEvent.VK_RIGHT){
					model.setDirect(Direction.EAST);
					move = true;
				}
				else if (keyCode == KeyEvent.VK_SPACE) {
					System.out.println("Spacebar is pressed");
					if (view.p.closeToMower()) {
						System.out.println("updated move");
						mow = true;
						move = false;
					}
				}
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				move = false;
				view.update(model.getX(), model.getY(), model.getDirect(), move, mow);
			}
		};
		
		/*
		public void checkCollisions() {
		
			Rectangle grass = g.getBounds();
			Rectangle player = p.getBounds();

	            if (grass.intersects(player) && mow == true) {
	                grass.setVisible(false);
	        }
	    }
	    */
		
		view.addKeyListener(keyListener);
		for (int i = 0; i < 5000; i++) {
			if (move)
				model.updateLocationAndDirection();
			view.update(model.getX(), model.getY(), model.getDirect(), move, mow);
		}
		
		
		EventQueue.invokeLater(new Runnable(){
			public void run(){
				
				Timer t = new Timer(120, view.getdrawAction());
				t.start(); 
			}
		});
		move = false;
	}
	
	public static void main(String[] args) {
		Controller c = new Controller();
		c.start();
	}
}