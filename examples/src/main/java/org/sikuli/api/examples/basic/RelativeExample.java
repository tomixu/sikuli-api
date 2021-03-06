package org.sikuli.api.examples.basic;

import java.net.URL;

import org.sikuli.api.DesktopScreenRegion;
import org.sikuli.api.ImageTarget;
import org.sikuli.api.Relative;
import org.sikuli.api.ScreenRegion;
import org.sikuli.api.Target;
import org.sikuli.api.examples.images.Images;
import org.sikuli.api.examples.utils.ScreenSimulator;
import org.sikuli.api.robot.Keyboard;
import org.sikuli.api.robot.Mouse;
import org.sikuli.api.robot.desktop.DesktopKeyboard;
import org.sikuli.api.robot.desktop.DesktopMouse;
import org.sikuli.api.visual.Canvas;
import org.sikuli.api.visual.DesktopCanvas;

public class RelativeExample {
	static Mouse mouse = new DesktopMouse();
	static Keyboard keyboard = new DesktopKeyboard();
	static Canvas canvas = new DesktopCanvas();
	
	static ScreenSimulator simulator = new ScreenSimulator(){
		public void run(){
			showImage(Images.GoogleSearchPage);
			wait(20);
			close();
		}
	};

	public static void main(String[] args) {
		simulator.start();		
		ScreenRegion s = new DesktopScreenRegion();			
		URL imageURL = Images.GoogleSearchButton;                
		Target imageTarget = new ImageTarget(imageURL);
		ScreenRegion r = s.find(imageTarget);		
		
		ScreenRegion rightArea = Relative.to(r).right(100).getScreenRegion();
		ScreenRegion leftArea = Relative.to(r).left(100).getScreenRegion();
		ScreenRegion aboveArea = Relative.to(r).above(100).getScreenRegion();
		ScreenRegion belowArea = Relative.to(r).below(100).getScreenRegion();
		
		canvas.add().box().around(rightArea);
		canvas.add().label("right").inside(rightArea);
				
		canvas.add().box().around(leftArea);
		canvas.add().label("left").inside(leftArea);

		canvas.add().box().around(aboveArea);
		canvas.add().label("above").inside(aboveArea);
		
		canvas.add().box().around(belowArea);
		canvas.add().label("below").inside(belowArea);

		canvas.display(3);

		mouse.click(Relative.to(r).center().getScreenLocation());
		mouse.click(Relative.to(r).topLeft().getScreenLocation());
		mouse.click(Relative.to(r).topRight().getScreenLocation());
		mouse.click(Relative.to(r).bottomRight().getScreenLocation());
		mouse.click(Relative.to(r).bottomLeft().getScreenLocation());
	

	}
}
