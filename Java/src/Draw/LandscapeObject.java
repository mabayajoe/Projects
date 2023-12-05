package Draw;

import java.awt.Graphics2D;

public abstract class LandscapeObject {
	//Attributes
	protected int startX;			//Starting x coordinate for the object.  This doesn't change once the object has been created.
	private final int startY;			//Starting y coordinate for the object.  This doesn't change once the object has been created.
	protected int currentX;		//PROTECTED.  The current x coordinate for the object.  This will change as different shapes are added to the object.  Usually the starting point for the next shape drawn.
	protected int currentY;		//PROTECTED.  The current y coordinate for the object.  This will change as different shapes are added to the object.  Usually the starting point for the next shape drawn.
	private final double scale;		//Used in applyScale() method.  Multiplier for all shapes used in an object so that the entire object can be shrunk or grown with a single attribute to the constructor.
	protected Graphics2D g2;	//PROTECTED.  The Graphics2D interface
	
	/**
	 * Primary Constructor.
	 * Sets all class attributes.
	 * 
	 * @param	g2			The Graphics2D interface.
	 * @param	x			An int.  The startX coordinate.  currentX is also set to x upon object creation.
	 * @param	y			An int.  The startY coordinate.  currentX is also set to y upon object creation.
	 * @param	scale		A double.  Scale multiplier for the object.
	 */
	public LandscapeObject(Graphics2D g2, int x, int y, double scale) {
		this.g2 = g2;			
		this.startX = x;
		this.currentX = x;
		this.startY = y;
		this.currentY = y;
		this.scale = scale;
	}//end of Constructor LandscapeObject
	
	
	//Methods
	/**
	 * startX getter method
	 * 
	 * @return	An int with the starting x coordinate. 
	 */
	public int getStartX() {
		return startX;
	}//end of method getX()
	
	/**
	 * startY getter method
	 * 
	 * @return	An int with the starting y coordinate. 
	 */
	public int getStartY() {
		return startY;
	}//end of method getY()

	/**
	 * scale getter method
	 * 
	 * @return	A double with the scale multiplier. 
	 */
	public double getScale() {
		return scale;
	}//end of method getScale()

    /**
     * Must be implemented in all subclasses
     * Calls applyScale to apply the scale multiplier to all shape dimensions for the object.
     * Draws the object
     */
    private void draw() {

    }

    /**
	 * Must be implemented in all subclasses
	 * Applies the scale multiplier to all shape dimensions for the object.
	 * Called by draw()
	 *
	 */
	public abstract void applyScale();
	
}//end of class LandscapeObject
