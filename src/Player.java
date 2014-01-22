import static org.lwjgl.opengl.GL11.GL_BLEND;
import static org.lwjgl.opengl.GL11.GL_QUADS;
import static org.lwjgl.opengl.GL11.GL_TEXTURE_2D;
import static org.lwjgl.opengl.GL11.glBegin;
import static org.lwjgl.opengl.GL11.glClearColor;
import static org.lwjgl.opengl.GL11.glColor3f;
import static org.lwjgl.opengl.GL11.glDisable;
import static org.lwjgl.opengl.GL11.glEnable;
import static org.lwjgl.opengl.GL11.glEnd;
import static org.lwjgl.opengl.GL11.glVertex2f;

import org.lwjgl.input.Keyboard;
import org.lwjgl.util.vector.Vector2f;
import org.newdawn.slick.Color;

import Accesoires.NumberRenderer;
import Shapes.Rectangle;


public class Player extends MovableGameComponent{

	private String playerIdentity;
	private Vector2f Position;
	private float Velocity = 0;
	private int score;
	private NumberRenderer nr;
	private boolean Manual;
	
	public void setPosition(Vector2f pos)	{	this.Position = pos;		}
	public Vector2f getPosition() 			{	return rect.getPosition();	}
	public int getHeight() 					{	return rect.getHeight();	}
	public int getWidth() 					{	return rect.getWidth();		}
	public int getScore()					{	return score;				}
	public float getYVelocity()				{	return this.Velocity;		}
	public void setScore(int i)				{	this.score = i;				}
	public void setManual(boolean bool)		{	this.Manual = bool;			}
	
	public Player(Rectangle rectangle, String id)
	{
		this.Manual = false;
		nr = new NumberRenderer();
		score = 0;
		rect = rectangle;
		this.Position = rect.getPosition();
		this.playerIdentity = id;
	}
	
	
	@Override
	public void Initialize() {
		glEnable(GL_TEXTURE_2D);
		glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
	}

	@Override
	public void Update() {
		
		if(Manual){
			//Player controls
		if(playerIdentity == "wasd")
		{
			
			if(Keyboard.isKeyDown(Keyboard.KEY_W))
			{
				if (Velocity > minPlayerVelocity) {
					Velocity -= 0.5f;
				}
			}
			else if(Keyboard.isKeyDown(Keyboard.KEY_S)){
				if (Velocity < maxPlayerVelocity) {
					Velocity += 0.5f;
				}
			}
			else{
				Velocity = 0;
			}
		}
		else if(playerIdentity == "arrows"){
			if(Keyboard.isKeyDown(Keyboard.KEY_UP)){
				if (Velocity > minPlayerVelocity) {
					Velocity -= 0.5f;
				}
			}
			else if(Keyboard.isKeyDown(Keyboard.KEY_DOWN))
			{
				if (Velocity < maxPlayerVelocity) {
					Velocity += 0.5f;
				}
			}else
			{
				Velocity = 0;
			}
		}
		if(Position.y+rect.getHeight() > WindowHeight)
		{
			Position.y = WindowHeight - rect.getHeight();
			Velocity = 0;
		}
		if(Position.y < 0)
		{
			Position.y = 0;
			Velocity = 0;
		}
		}
		
		this.Position.y += Velocity;
		rect.setPosition(Position);
		
	}

	@Override
	public void Draw() {
		//Drawing players
		Color.white.bind();
		glDisable(GL_BLEND);
		glBegin(GL_QUADS);
			glColor3f(0.5f, 0.5f, 1);
			glVertex2f(Position.x, Position.y);
			glVertex2f(Position.x, Position.y + rect.getHeight());
			glVertex2f(Position.x + rect.getWidth(), Position.y + rect.getHeight());
			glVertex2f(Position.x + rect.getWidth(), Position.y);
			if (playerIdentity == "arrows"){
			//	Drawing score
			nr.Draw(new Vector2f(650, 50), Integer.toString(score), 15);
			}else if(playerIdentity == "wasd"){
				nr.Draw(new Vector2f(100, 50), Integer.toString(score), 15);
			}
		
			glEnd();
	}
	public void incrementScore(){
		score++;
	}



}
