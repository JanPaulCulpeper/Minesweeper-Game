import java.awt.Color;
import java.awt.Component;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

import javax.swing.JFrame;




public class MyMouseAdapter extends MouseAdapter {
	private Random generator = new Random();
	public void mousePressed(MouseEvent e) {
		switch (e.getButton()) {
			case 1:		//Left mouse button
				Component c = e.getComponent();
				while (!(c instanceof JFrame)) {
					c = c.getParent();
					if (c == null) {
						return;
					}

				}
				JFrame myFrame = (JFrame) c;
				MyPanel myPanel = (MyPanel) myFrame.getContentPane().getComponent(0);
				Insets myInsets = myFrame.getInsets();
				int x1 = myInsets.left;
				int y1 = myInsets.top;
				e.translatePoint(-x1, -y1);
				int x = e.getX();
				int y = e.getY();
				myPanel.x = x;
				myPanel.y = y;
				myPanel.mouseDownGridX = myPanel.getGridX(x, y);
				myPanel.mouseDownGridY = myPanel.getGridY(x, y);
				myPanel.repaint();
				break;
		
			case 3:		//Right mouse button
				
				break;
			default:    //Some other button (2 = Middle mouse button, etc.)
				//Do nothing
				break;
		}
	}
	public void mouseReleased(MouseEvent e) {
		switch (e.getButton()) {
			case 1:		//Left mouse button
				Component c = e.getComponent();
				while (!(c instanceof JFrame)) {
					c = c.getParent();
					if (c == null) {
						return;
					}
				}
				JFrame myFrame = (JFrame)c;
				MyPanel myPanel = (MyPanel) myFrame.getContentPane().getComponent(0);  //Can also loop among components to find MyPanel
				Insets myInsets = myFrame.getInsets();
				int x1 = myInsets.left;
				int y1 = myInsets.top;
				e.translatePoint(-x1, -y1);
				int x = e.getX();
				int y = e.getY();
				myPanel.x = x;
				myPanel.y = y;
				int gridX = myPanel.getGridX(x, y);
				int gridY = myPanel.getGridY(x, y);
				
				if ((myPanel.mouseDownGridX == -1) || (myPanel.mouseDownGridY == -1)) {
					//Had pressed outside
					//Do nothing
				} else {
					if ((gridX == -1) || (gridY == -1)) {
						//Is releasing outside
						//Do nothing
					} else {
						if ((myPanel.mouseDownGridX != gridX) || (myPanel.mouseDownGridY != gridY)) {
							//Released the mouse button on a different cell where it was pressed
							//Do nothing
							} else {
							if ((gridX == -1) || (gridY == -1)) {
							
						} else {
							//Released the mouse button on the same cell where it was pressed
		
								if(myPanel.flagged[myPanel.mouseDownGridX][myPanel.mouseDownGridY] == false) {
									if(myPanel.mines[myPanel.mouseDownGridX][myPanel.mouseDownGridY] == 1) { // If you click on a mine everything is revealed
										for(int i=0; i < myPanel.getTotal_Columns(); i++) {
											for(int j=0; j < myPanel.getTotal_Rows(); j++) {
												if(myPanel.colorArray[i][j] == 1) //Paint mines cells black
													myPanel.colorArray[i][j] =Color.BLACK;
												myPanel.revealed[i][j] = true;
											}
										}
									
								}else {
									if(myPanel.revealed[myPanel.mouseDownGridX][myPanel.mouseDownGridY] == true) {
										
									}else {
										myPanel.clearZeros(gridX, gridY);
									}
								}
							}
						}
				}
				myPanel.repaint();
				break;
			}
			case 3:	{	//Right mouse button
			
				Component c1 = e.getComponent();
				while (!(c1 instanceof JFrame)) {
					c1 = c1.getParent();
					if (c1 == null) {
						return;
					}
				}
				JFrame myFrame1 = (JFrame)c1;
				MyPanel myPanel1 = (MyPanel) myFrame1.getContentPane().getComponent(0);  //Can also loop among components to find MyPanel
				Insets myInsets1 = myFrame1.getInsets();
				int x11 = myInsets1.left;
				int y11 = myInsets1.top;
				e.translatePoint(-x11, -y11);
				int x2 = e.getX();
				int y2 = e.getY();
				myPanel1.x = x2;
				myPanel1.y = y2;
				int gridX1 = myPanel1.getGridX(x2, y2);
				int gridY1 = myPanel1.getGridY(x2, y2);
				if ((myPanel1.mouseDownGridX == -1) || (myPanel1.mouseDownGridY == -1)) {
					//Had pressed outside
					//Do nothing
				} else {
					if ((gridX1 == -1) || (gridY1 == -1)) {
						//Is releasing outside
						//Do nothing
					} else {
						if ((myPanel1.mouseDownGridX != gridX1) || (myPanel1.mouseDownGridY != gridY1)) {
							//Released the mouse button on a different cell where it was pressed
						
							
							
							//Do nothing
							} else {
							if ((gridX1 == -1) || (gridY1 == -1)) {
							
						
							} else {
					Color newColor1 = null;
					switch (generator.nextInt(1)) {
						case 0:
							newColor1 = Color.RED;
							myPanel1.colorArray[myPanel1.mouseDownGridX][myPanel1.mouseDownGridY] = newColor1;
							myPanel1.repaint();
							
					}
							myPanel1.repaint();
							break;}
					
					
							}}}}
			default: 
				//Some other button (2 = Middle mouse button, etc.)
				//Do nothing
				break;
<<<<<<< HEAD
		}}}


		
=======
				
		}
		}
	}


>>>>>>> refs/heads/master
	
