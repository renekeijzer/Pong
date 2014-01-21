import static org.lwjgl.opengl.GL11.GL_QUADS;
import static org.lwjgl.opengl.GL11.GL_TEXTURE_2D;
import static org.lwjgl.opengl.GL11.glBegin;
import static org.lwjgl.opengl.GL11.glClearColor;
import static org.lwjgl.opengl.GL11.glColor3f;
import static org.lwjgl.opengl.GL11.glEnable;
import static org.lwjgl.opengl.GL11.glEnd;
import static org.lwjgl.opengl.GL11.glVertex2f;

import java.util.Random;

import org.lwjgl.opengl.GL11;
import org.lwjgl.util.vector.Vector2f;
import org.newdawn.slick.Color;

import Shapes.Rectangle;


public class Ball extends MovableGameComponent{
	

	private Vector2f Position, Velocity;
	private Color myColor;
	
	public void setPostition(Vector2f Position)		{	this.Position = Position;		}
	public void setVelocity(Vector2f Velocity)		{	this.Velocity = Velocity;		}
	public void setVerticalVelocity(float i) 		{	this.Velocity.y = i;		}
	public void setHorizontalVelocity(float i) 		{	this.Velocity.x = i;		}
	public void setColor(Color c)					{	this.myColor = c; 			}
	
	public Vector2f getVelocity()					{	return this.Velocity;		}
	
	public Ball(Rectangle rectangle)
	{	
		myColor = getRandomColor();
		rect = rectangle;
		Velocity = new Vector2f(0,0);
		this.Position = rect.getPosition();
		if(1+(int)(Math.random()*2) == 1)
		{
			this.Velocity.x += (1 + (float)(Math.random()*10)-5);
			this.Velocity.y += (1 + (float)(Math.random()*10)-5);
		}
			else
		{	
				this.Velocity.x -= (1 + (float)(Math.random()*10)-5);
				this.Velocity.y -= (1 + (float)(Math.random()*10)-5);
		}
	}
	
	

	@Override
	public Vector2f getPosition() {
		return rect.getPosition();
	}

	@Override
	public void Update() {
		if(this.Velocity.x < 0 && !(this.Velocity.x < minBallVelocity))
		{
			Velocity.x -=0.001f;
		}
		if(this.Velocity.y < 0 && !(this.Velocity.y < minBallVelocity))
		{
			Velocity.y -=0.001f;
		}
		if(this.Velocity.x > 0 && (this.Velocity.x < maxBallVelocity))
		{
			Velocity.x +=0.001f;
		}
		if(this.Velocity.y > 0 && (this.Velocity.x < maxBallVelocity))
		{
			Velocity.y +=0.001f;
		}
		
		if(Position.y+rect.getHeight() >= WindowHeight)
		{
			Velocity.y = Velocity.y * -1;
			this.setColor(Ball.getRandomColor());
		}
		if(Position.y <= 0){
			Velocity.y = Velocity.y * -1;
			this.setColor(Ball.getRandomColor());
		}
		if(Velocity.x > maxBallVelocity)
		{
			Velocity.x = maxBallVelocity;
		}
		if(Velocity.x < minBallVelocity)
		{
			Velocity.x = minBallVelocity;
		}
		if(Velocity.y > maxBallVelocity)
		{
			Velocity.y = maxBallVelocity;
		}
		if(Velocity.y < minBallVelocity)
		{
			Velocity.y = minBallVelocity;
		}
		
		
		this.Position.x += this.Velocity.x;
		this.Position.y += this.Velocity.y;
		rect.setPosition(Position);
	}

	@Override
	public void Draw() {
		Color.white.bind();
		glBegin(GL_QUADS);
			GL11.glColor3ub((byte)myColor.getRed(), (byte)myColor.getGreen(), (byte)myColor.getBlue());
			glVertex2f(Position.x, Position.y);
			glVertex2f(Position.x, Position.y + rect.getHeight());
			glVertex2f(Position.x + rect.getWidth(), Position.y + rect.getHeight());
			glVertex2f(Position.x + rect.getWidth(), Position.y);
		glEnd();
	}

	@Override
	public void Initialize() {
		glEnable(GL_TEXTURE_2D);
		glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
	}

	@Override
	public int getHeight() {
		return rect.getHeight();
	}

	@Override
	public int getWidth() {
		return rect.getWidth();
	}
	
	public static Color getRandomColor(){
		Random r = new Random();
		return new Color(r.nextInt(255), r.nextInt(255), r.nextInt(255));
	}

}
