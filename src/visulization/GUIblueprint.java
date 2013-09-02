/***
 * Written by lina on 2013/08/30
 */

package visulization;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.*;
import javax.swing.*;
import java.io.*;

import javax.imageio.*;

public class GUIblueprint extends JFrame {
	public static void run() {
		// create the main frame
		GUIblueprint frame = new GUIblueprint();
		// set the frame to be visible
		frame.setVisible(true);
	}

	/**
	 * Constructor, put all frame settings into it
	 */
	public GUIblueprint() {
		// set title
		setTitle("Gene Regulatory Network");
		// set frame size
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension screenSize = kit.getScreenSize();
		int screenWidth = screenSize.width;
		int screenHeight = screenSize.height;
		Dimension size = new Dimension(screenWidth / 2, screenHeight / 2);
		setSize(size);
		// set menu bar
		JMenuBar menubar = new JMenuBar();
		JMenu filemenu = new JMenu("File");
		JMenu configmenu = new JMenu("Configure");
		configmenu.add(new JSeparator());

		JMenuItem fileItem1 = new JMenuItem("Export");
		filemenu.add(fileItem1);

		filemenu.add(new AbstractAction("Exit") {
			public void actionPerformed(ActionEvent event) {
				System.exit(0);
			}
		});
		menubar.add(filemenu);
		menubar.add(configmenu);
		setJMenuBar(menubar);

		// set the 
		
		GridBagLayout layout = new GridBagLayout();
		setLayout(layout);

		ActionListener listener = new NodeShapeAction();

		// construct components

		JLabel nodeShapeLabel = new JLabel("Node shape: ");

		NodeShape = new JComboBox(new String[] { "ellipse", "box", "circle",
				"record", "plaintext" });

		NodeShape.addActionListener(listener);

		add(nodeShapeLabel,new GBC(0, 0, 1, 1).setAnchor(GBC.EAST).setInsets(5));
		add(NodeShape,new GBC(1, 0, 1, 1).setWeight(100, 0).setAnchor(GBC.WEST).setInsets(5));
		

		// draw GRN graph picture
		add(new GRNGraphPanel(),new GBC(2, 0, 4, 4).setFill(GBC.BOTH).setWeight(100, 100));
		
		// set default close operation
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}


class GRNGraphPanel extends JPanel {
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		// get image
		try {
			BufferedImage image = ImageIO.read(new File("graph1.jpg"));
			// get panel width and height
			int panelWidth = getWidth();
			int panelHeight = getHeight();
			// draw the image
			g.drawImage(image, panelWidth/2, 0, panelWidth / 2, panelHeight, null);
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}
}

	private JComboBox NodeShape;

/**
 * An action listener that changes the shape of the node.
 */
private class NodeShapeAction implements ActionListener {
	public void actionPerformed(ActionEvent event) {

        String nodeShape = (String) NodeShape.getSelectedItem();
        generateNewDotFile(nodeShape);		
			
	}


	public void generateNewDotFile(String nodeshape){
		Process p = null;
		try {
			p = Runtime.getRuntime().exec("ls");
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			p.waitFor();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		BufferedReader b = new BufferedReader(new InputStreamReader(p.getInputStream()));
		String line = "";
		try {
			while( (line = b.readLine()) != null){
				System.out.println(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

}