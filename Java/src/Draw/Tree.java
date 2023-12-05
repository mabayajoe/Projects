package Draw;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.geom.AffineTransform;


class Tree extends LandscapeObject{
	//Attributes
	private final String levels;						//The number of levels (branch triangles) the tree will have.
	private final String trunkColor; 				// The Hex color of the trunk, including the preceding '#'. Set in the constructor.
	private final String branchColor; 			// The Hex color of the branches, including the preceding '#'. Set in the constructor.
	private int trunkWidth = 10;			//The trunk width in pixels.  Default of 10 for a scale of 1.  Modified by applyScale method().
	private int trunkHeight = 15;			//The trunk height in pixels.  Default of 15 for a scale of 1.  Modified by applyScale method().
	private int branchWidth = 30;			//The branch width in pixels.  Default of 30 for a scale of 1.  Modified by applyScale method().
	private int branchHeight = 30;			//The branch height in pixels.  Default of 30 for a scale of 1.  Modified by applyScale method().
	private final BasicStroke treeStroke = new BasicStroke(1);	//Stroke of 1 pixel use to outline each shape of the tree.

	
	/**
	 * Primary Constructor.
	 * Sets all class attributes.
	 * 
	 * @param	g2				The Graphics2D interface.
	 * @param	x				int.  The startX coordinate.  currentX is also set to x upon object creation.
	 * @param	y				int.  The startY coordinate.  currentX is also set to y upon object creation.
	 * @param	levels			int indicating how many levels (branch triangles) the tree will have.
	 * @param	scale			double.  Scale multiplier for the object.
	 * @param	s_trunkColor	A String representing the Hex code for the color used for the trunk of the tree.
	 * @param	s_branchColor	A String representing the Hex code for the color used for the branches of the tree.
	 *  
	 * @return	void
	 */
	public Tree(Graphics2D g2, int x, int y, double scale, int levels,  String s_trunkColor, String s_branchColor) {
		super(g2, x, y, scale);
		this.levels = String.valueOf(levels);
		this.trunkColor = "#" + s_trunkColor;
		this.branchColor = "#" + s_branchColor;
	}//end of Constructor Tree
	
	
	//Methods
	/**
	 * draw()
	 * Calls applyScale to apply the scale multiplier to all shape dimensions for the object.
	 * Calls drawTrunk to draw the trunk of the tree.
	 * Calls drawBranches to draw the branches of the tree.
	 *
	 */
	public void draw() {
		applyScale();
		drawTrunk();
		drawBranches();
	}//end of method draw()
	
	/**
	 * applyScale
	 * Applies the scale multiplier to all shape dimensions for the object.
	 * Called by draw()
	 *
	 */
	public void applyScale() {
		
		trunkWidth *= super.getScale();
		trunkHeight *= super.getScale();
		branchWidth *= super.getScale();
		branchHeight *= super.getScale();	
//		
	}//end of method applyScale()
	/**
	 * drawTrunk()
	 * Draws a rectangle for the trunk of the tree.
	 * Called by draw()
	 *
	 */
	private void drawTrunk() {
		g2.setColor(Color.decode(trunkColor));
		g2.fillRect(super.getStartX(), super.getStartY(), trunkWidth, trunkHeight);
		
		
		
		
	}//end of method drawTrunk()
	/**
	 * drawBranches()
	 * Draws 'level' number of triangles above the trunk overlapped by 'branchOverlap'.
	 * Called by draw()
	 *
	 */
	private void drawBranches() {
		AffineTransform origen_AT = g2.getTransform(); 
		Polygon tree = new Polygon(new int[]{0, branchWidth/2, branchWidth}, new int[]{branchHeight, 0, branchHeight}, 3);
		Polygon tree2 = new Polygon(new int[]{0, branchWidth/2, branchWidth}, new int[]{branchHeight, 0, branchHeight}, 3);

		for (int t = 0; t < levels; t++) {
			g2.translate(currentX-(trunkWidth), currentY-(trunkWidth + trunkHeight));

			g2.setColor(Color.decode(branchColor));
			g2.drawPolygon(tree);
			g2.fill(tree);

			g2.setColor(Color.black);
			g2.drawPolygon(tree2);


			currentY -= (15* super.getScale());
			g2.setTransform(origen_AT);

		}
	}//end of method drawBranches()

	public double getBranchOverlap() {
		//Indicates how much of each triangle is overlapped by the one above it.
		double branchOverlap = .45;
		return branchOverlap;
	}
}//end of class Tree
