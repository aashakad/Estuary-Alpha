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
				move = false;
				if (keyCode == KeyEvent.VK_LEFT){
					p.setFocusable(true);
					p.setMove(move);
					model.setDirect(Direction.WEST);
					move = true;
				}
				else if (keyCode == KeyEvent.VK_RIGHT){
					p.setFocusable(true);
					p.setMove(move);
					model.setDirect(Direction.EAST);
					move = true;
					
				}
				model.updateLocationAndDirection();
				view.update(model.getX(), model.getY(), model.getDirect(), move);
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				int keyCode = e.getKeyCode();

				if (keyCode == KeyEvent.VK_LEFT){
					idle = true;
					move = false;
					p.setMove(move);
				}
				else if (keyCode == KeyEvent.VK_RIGHT){
					idle = true;
					move = false;
					p.setMove(move);
				}
			}
		};
		
		view.addKeyListener(keyListener);
		
//		for(int i = 0; i < 100; i++)
//		{
//			view.update(model.getX(), model.getY(), model.getDirect(), move);
//		}
		
		EventQueue.invokeLater(new Runnable(){
			public void run(){
				view.update(model.getX(), model.getY(), model.getDirect(), move);
				Timer t = new Timer(60, view.getdrawAction());
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
