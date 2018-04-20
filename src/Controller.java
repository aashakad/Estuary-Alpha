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
	boolean move;
	
	public Controller(){
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
					model.setDirect(Direction.WEST);
				}
				else if (keyCode == KeyEvent.VK_RIGHT){
					model.setDirect(Direction.EAST);
				}
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				move = false;
				view.update(model.getX(), model.getY(), model.getDirect(), move);
			}
		};
		
		view.addKeyListener(keyListener);
		EventQueue.invokeLater(new Runnable(){
			public void run(){
				Timer t = new Timer(30, new ActionListener(){

					@Override
					public void actionPerformed(ActionEvent arg0) {
						if (move)
							model.updateLocationAndDirection();
						view.update(model.getX(), model.getY(), model.getDirect(), move);
					}
					
				});
				t.start(); 
			}
		});
	}
	public static void main(String[] args) {
		Controller c = new Controller();
		c.start();
	}
}
