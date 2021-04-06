//Authors: Modester_Samwel
//github handles: Modester_Samwel


package GUI;

import javax.swing.JFrame;

public class ProductGUI {
	JFrame frame;
	public ProductGUI() {
		initComponent();
	}
	private void initComponent() {
		// TODO Auto-generated method stub
		
		frame = new JFrame("ProductGui");
		frame.setSize(300,300);
		frame.setVisible(true);
		
	}

	public static void main(String[] args) {
		new ProductGUI();
	}
}
