import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Menu extends JPanel {
	
	// img = gets background image of the menu, no need to subimage
	
	boolean startGame = false;
	
	public Menu() {
		setFocusable(true);
		addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e) {
				// when certain player is clicked, chooses it
				startGame = true;
			} // mouselistener may or may not be needed if we have JButton?
		});
	} 
	
	public void paint (Graphics g) {
		super.paint(g);
		
		//g.drawImage(img, 0, 0, null);
	}
}
