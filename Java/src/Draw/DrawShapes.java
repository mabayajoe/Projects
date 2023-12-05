package Draw;

import java.awt.EventQueue;
import java.io.Serial;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class DrawShapes extends JPanel {
	//Attributes
	@Serial
    private static final long serialVersionUID = 6311020027600344213L;
	
	/**
	 * Main method to run the DrawShapes program.
	 * This method sets up a JFrame, creates a DrawPanel to go inside the JFrame, and turns everything visible.
	 * No arguments expected
	 * No return
	 */
	public static void main(String[] args) {
        //Program runs inside an EventQueue
//end of public void run()
        EventQueue.invokeLater(() -> {
            JFrame frame = new JFrame();			//Create a new JFrame object called frame
            frame.setTitle("Draw12a Shapes");			//Set the attributes of the frame object
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setResizable(false);
            frame.setLocationByPlatform(true);
            frame.setContentPane(new DrawPanel());	//Create a new DrawPanel object and sets the content pane of the frame to it
            frame.pack();							//Pack the frame around the DrawPanel so the frame is an exact fit around the DrawPanel object
            frame.setVisible(true);					//Set the frame and everything inside it to visible
        }); //end of EventQueue.invokeLater
	}//end of method main()

}//end of class DrawShapes
