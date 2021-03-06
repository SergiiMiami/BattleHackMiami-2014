//-----------------------------------------------------------------------------
// File: DrawingPanelDeluxe.java
//
//
//
// Date: February 23, 2014
//-----------------------------------------------------------------------------

import java.awt.*;
import java.awt.geom.*;
import java.awt.geom.Point2D.Double;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import java.util.ArrayList;
import java.util.List;

import javax.swing.*;

//import DrawingPanel.Handlerclass;
//import DrawingPanel.MyCircle;
//import DrawingPanel.MyRectangle;
//import DrawingPanel.Triangle;

public class DrawingPanelDeluxe extends JPanel {
	private JPanel mousepanel;
	//private JLabel statusbar;
	private JButton triangleblue;
	private JButton triangleyellow;
	private JButton trianglered;
	private JButton squareblue;
	private JButton squarered;
	private JButton squareyellow;
	private JButton circleblue;
	private JButton circlered;
	private JButton circleyellow;
	private JButton diamondorange;
	private JButton diamondgreen;
	private JButton diamondpurple;
	private JButton paintBrush;
	//private List<MyRectangle> rectangles;
	//private List<MyCircle> circles;
	//private List<Triangle> triangles;
	//private List<MyDiamond> diamonds;
	private List<Shape> shapes;
	private Color color;
	public static int SWITCH;
	public final int SQUARE = 1;
	public final int CIRCLE = 2;
	public final int TRIANGLE = 3;
	public final int DIAMOND = 4;
	public int x1, y1;
	public int height, width;
	
	
	public DrawingPanelDeluxe(){
		//paintImage = new BufferedImage(1, 1, BufferedImage.TYPE_3BYTE_BGR);
		//rectangles = new ArrayList<MyRectangle>(25);
		//circles = new ArrayList<MyCircle>(200);
		//triangles = new ArrayList<Triangle>(25);
		//diamonds = new ArrayList<MyDiamond>(25);
		shapes = new ArrayList<Shape>(300);
		
		mousepanel = new JPanel();
		mousepanel.setBackground(Color.WHITE);
		add(mousepanel, BorderLayout.CENTER);
		mousepanel.setPreferredSize(new Dimension(1000, 1000));
		mousepanel.setOpaque(false);
		
		Handlerclass handler = new Handlerclass();
		mousepanel.addMouseListener(handler);
		mousepanel.addMouseMotionListener(handler);
		
		Icon triangleredIcon = new ImageIcon(getClass().getResource("triangle_red.png"));
		Icon triangleblueIcon = new ImageIcon(getClass().getResource("triangle_blue.png"));
		Icon triangleyellowIcon = new ImageIcon(getClass().getResource("triangle_yellow.png"));
		Icon squareyellowIcon = new ImageIcon(getClass().getResource("square_yellow.png"));
		Icon squareredIcon = new ImageIcon(getClass().getResource("square_red.png"));
		Icon squareblueIcon = new ImageIcon(getClass().getResource("square_blue.png"));
		Icon circleyellowIcon = new ImageIcon(getClass().getResource("circles_yellow.png"));
		Icon circleredIcon = new ImageIcon(getClass().getResource("circles_red.png"));
		Icon circleblueIcon = new ImageIcon(getClass().getResource("circles_blue.png"));
		
		Icon diamondorangeIcon = new ImageIcon(getClass().getResource("diamond_orange.png"));
		Icon diamondgreenIcon = new ImageIcon(getClass().getResource("diamond_green.png"));
		Icon diamondpurpleIcon = new ImageIcon(getClass().getResource("diamond_purple.png"));
		Icon paintbrushIcon = new ImageIcon(getClass().getResource("paintbrush.png"));
	
		trianglered = new JButton(triangleredIcon);
		squarered = new  JButton(squareredIcon);
		circlered = new JButton(circleredIcon);
		triangleblue = new JButton(triangleblueIcon);
		squareblue = new JButton(squareblueIcon);
		circleblue = new JButton(circleblueIcon);
		circleyellow = new JButton(circleyellowIcon);
		triangleyellow = new JButton(triangleyellowIcon);
		squareyellow = new JButton(squareyellowIcon);
		
		diamondorange = new JButton(diamondorangeIcon);
		diamondgreen = new JButton(diamondgreenIcon);
		diamondpurple = new JButton(diamondpurpleIcon);
		paintBrush = new JButton(paintbrushIcon);

		JPanel buttonPanel = new JPanel();
		//buttonPanel.setBackground(Color.WHITE);
		buttonPanel.setPreferredSize(new Dimension(900, 100));
		buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.X_AXIS));
		
		JPanel buttonPanel2 = new JPanel();
		//buttonPanel2.setBackground(Color.WHITE);
		buttonPanel2.setPreferredSize(new Dimension(1000, 100));
		buttonPanel2.setLayout(new BoxLayout(buttonPanel2, BoxLayout.X_AXIS));
		buttonPanel2.setOpaque(false);
		
		buttonPanel.add(trianglered);
		buttonPanel.add(triangleblue);
		buttonPanel.add(triangleyellow);
		buttonPanel.add(squarered);
		buttonPanel.add(squareblue);
		buttonPanel.add(squareyellow);
		buttonPanel2.add(circlered);
		buttonPanel2.add(circleblue);
		buttonPanel2.add(circleyellow);
		
		buttonPanel2.add(diamondorange);
		buttonPanel2.add(diamondgreen);
		buttonPanel2.add(diamondpurple);
		buttonPanel2.add(paintBrush);
		
	    mousepanel.add(buttonPanel, BorderLayout.NORTH);
		
		mousepanel.add(buttonPanel2, BorderLayout.NORTH);
		
		//statusbar = new JLabel("Nothing is happening");
		//mousepanel.add(statusbar, BorderLayout.SOUTH);

	    squarered.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				color = Color.RED;
				SWITCH = SQUARE;
			}
			
		});

		trianglered.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				color = Color.RED;
				SWITCH = TRIANGLE;
			}
			
		});
		
		circlered.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				color = Color.RED;
				SWITCH = CIRCLE;
			}
			
		});
		
		triangleblue.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				color = Color.BLUE;
				SWITCH = TRIANGLE;
			}
		});

		circleblue.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				color = Color.BLUE;
				SWITCH = CIRCLE;
			}
		});

		squareblue.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				color = Color.BLUE;
				SWITCH = SQUARE;
			}
		});
		
		circleyellow.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				color = Color.YELLOW;
				SWITCH = CIRCLE;
			}
		});

		squareyellow.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				color = Color.YELLOW;
				SWITCH = SQUARE;
			}
		});

		triangleyellow.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				color = Color.YELLOW;
				SWITCH = TRIANGLE;
			}
		});
				
	
		
		diamondorange.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				color = new Color(255, 140 , 0);
				SWITCH = DIAMOND;
			}
		});
		
		diamondpurple.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				color = new Color(128, 0, 128);
				SWITCH = DIAMOND;
			}
		});
		
		diamondgreen.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				color = Color.GREEN;
				SWITCH = DIAMOND;
			}
		});
		
		paintBrush.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				color = Color.BLACK;
				SWITCH = CIRCLE;
			}
		});
				
	}
	
	private class Handlerclass extends MouseAdapter{

		@Override
		
		public void mouseDragged(MouseEvent event) {
			// TODO Auto-generated method stub
			if(color == Color.BLACK){
				x1 = event.getX();
				y1 = event.getY();
				shapes.add(new MyCircle(x1, y1, 15, 15, color));
				repaint();
			}
			
		}

		@Override
		
		public void mouseMoved(MouseEvent event) {
			// TODO Auto-generated method stub
			
		}

		//@Override
		/*
		public void mouseClicked(MouseEvent event) {
			// TODO Auto-generated method stub
			x1 = event.getX();
			x2 = event.getX() + 20;
			y1 = event.getY();
			y2 = event.getY() + 20;
			repaint();
			statusbar.setText("Mouse has been clicked x-axis: " + event.getX() + "and Y:" + event.getY());
			
		}
		*/

		@Override
		public void mouseEntered(MouseEvent event) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent event) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mousePressed(MouseEvent event) {
			// TODO Auto-generated method stub
			x1 = event.getX();
			y1 = event.getY();
			//repaint();
			//statusbar.setText("Mouse has been pressed");
			
			
		}

		@Override
		public void mouseReleased(MouseEvent event) {
			// TODO Auto-generated method stub
			width = event.getX() - x1;
			height = event.getY() - y1;
			if(SWITCH == TRIANGLE)
				shapes.add(new Triangle(x1, y1, width, height, color));
			else if(SWITCH == SQUARE)
				shapes.add(new MyRectangle(x1, y1, width, height, color));
			else if(SWITCH == CIRCLE)
				shapes.add(new MyCircle(x1, y1, width, height, color));
			else if(SWITCH == DIAMOND)
				shapes.add(new MyDiamond(x1, y1, width, height, color));
			repaint();			
			//statusbar.setText("Mouse has been released with " + width + " " + height);		
		} 
		
		
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D)g;
		//g2.drawImage(paintImage, 0, 0, null);

		     for (Shape rect : shapes)
		          rect.paint(g2);
		     /*
		     for(MyCircle circle : circles)
		    	 circle.paint(g2);
		     
		     for(Triangle triangle : triangles)
		    	 triangle.paint(g2);
		     
		     for(MyDiamond diamond : diamonds)
		    	 diamond.paint(g2);

		*/
	}
	
	public class MyCircle extends Ellipse2D.Double implements Shape{
        private Color color;

        public MyCircle(int x, int y, int width, int height, Color color) {
            super(x, y, width, height);
            this.color = color;
        }

        public Color getColor() {
            return color;
        }

        public void paint(Graphics2D g2d) {

            g2d.setColor(getColor());
            g2d.fill(this);

        }
		
		
	}
	
	public class MyRectangle extends Rectangle implements Shape {

        private Color color;

        public MyRectangle(int x, int y, int width, int height, Color color) {
            super(x, y, width, height);
            this.color = color;
        }

        public Color getColor() {
            return color;
        }

        public void paint(Graphics2D g2d) {

            g2d.setColor(getColor());
            g2d.fill(this);

        }
    }
	
	public class MyDiamond implements Shape
	{
		private Color color;		
		Point2D top;
		Line2D[] sides = new Line2D[4];
		Polygon p;
		
		public MyDiamond(int x, int y, int width, int height, Color color)
		{
			top = new Point2D.Double(x, y);
			Point2D.Double midRight = new Point2D.Double(top.getX() + width/2, top.getY() + height/2);
			Point2D.Double midLeft = new Point2D.Double(top.getX() - width/2, top.getY() + height/2);
			Point2D.Double bottom = new Point2D.Double(top.getX(), top.getY() + height);
			
			Line2D.Double side1 = new Line2D.Double(midLeft, top);
			Line2D.Double side2 = new Line2D.Double(top, midRight);
			Line2D.Double side3 = new Line2D.Double(midLeft, bottom);
			Line2D.Double side4 = new Line2D.Double(bottom, midRight);
			
			sides[0] = side1;
			sides[1] = side2;
			sides[2] = side3;
			sides[3] = side4;
			
			this.color = color;
			
			int xs[] = {(int)top.getX(), (int)midRight.getX(), (int)bottom.getX(), (int)midLeft.getX()};
			int ys[] = {(int)top.getY(), (int)midRight.getY(), (int)bottom.getY(), (int)midLeft.getY()};
			
			p = new Polygon(xs, ys, 4);
		}
		
		public void paint(Graphics2D g2)
		{
			g2.setColor(color);

			for(int i = 0; i<sides.length; i++)
			{
				g2.draw(sides[i]);
			}

			g2.fill(p);	
		}
		
		public Color getColor()
		{
			return color;
		}
	}	
	
	public class Triangle implements Shape
	{
		
		Point2D top;
		Line2D[] sides = new Line2D[3];
		Color color;
		Polygon p;

		public Triangle(int x, int y, int width, int height, Color color)
		{
			top = new Point2D.Double(x, y);
			Point2D.Double bottomLeft = new Point2D.Double(top.getX()-width/2, top.getY()+height);
			Point2D.Double bottomRight = new Point2D.Double(top.getX()+width/2, top.getY()+height);

			Line2D.Double side1 = new Line2D.Double(top, bottomRight);
			Line2D.Double side2 = new Line2D.Double(bottomRight, bottomLeft);
			Line2D.Double side3 = new Line2D.Double(bottomLeft, top);

			sides[0] = side1;
			sides[1] = side2;
			sides[2] = side3;

			this.color = color;

			int xs[] = {(int)top.getX(), (int)bottomLeft.getX(), (int)bottomRight.getX()};
			int ys[] = {(int)top.getY(), (int)bottomLeft.getY(), (int)bottomRight.getY()};

			p = new Polygon(xs, ys, 3);
		}

		public void paint(Graphics2D g2)
		{
			g2.setColor(color);

			for(int i = 0; i<sides.length; i++)
			{
				g2.draw(sides[i]);
			}

			g2.fill(p);	
		}
		
		public Color getColor()
		{
			return color;
		}
	}
	
}
