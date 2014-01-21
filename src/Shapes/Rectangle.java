package Shapes;

import org.lwjgl.util.vector.Vector2f;

public class Rectangle implements Shape {

	private Vector2f Position;
	private int Width, Height;

	public Vector2f getPosition() 				{		return Position;	}
	public void setPosition(Vector2f position) 	{		Position = position;}

	public Rectangle(Vector2f Pos, int width, int height) {
		this.setPosition(Pos);
		this.Width = width;
		this.Height = height;
	}

	public Rectangle(int x, int y, int width, int height) {
		this.setPosition(new Vector2f(x, y));
		this.Width = width;
		this.Height = height;
	}

	@Override
	public void resize(int Width, int Height) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean intersect(Shape a) {
	
		if(this.Position.x + this.getWidth() > a.getPosition().x &&
			this.Position.x < a.getPosition().x + a.getWidth() &&
			this.Position.y > a.getPosition().y &&	
			this.Position.y < a.getPosition().y + a.getHeight())
			
		{
			
			return true;
		}
		
		return false;
	}


	@Override
	public int getHeight() {
		// TODO Auto-generated method stub
		return Height;
	}

	@Override
	public int getWidth() {
		// TODO Auto-generated method stub
		return Width;
	}
	
	public String toString()
	{
		return Position.toString() + " - " + Height + " - " + Width;
	}

}
