import static org.lwjgl.opengl.GL11.GL_QUADS;
import static org.lwjgl.opengl.GL11.GL_TEXTURE_2D;
import static org.lwjgl.opengl.GL11.glBegin;
import static org.lwjgl.opengl.GL11.glClearColor;
import static org.lwjgl.opengl.GL11.glEnable;
import static org.lwjgl.opengl.GL11.glEnd;
import static org.lwjgl.opengl.GL11.glVertex2f;

import java.util.Random;

import org.lwjgl.opengl.GL11;
import org.lwjgl.util.vector.Vector2f;
import org.newdawn.slick.Color;

import Accesoires.Sound;
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
		//colision
		rect = rectangle;
		
		//richting en snelheid
		Velocity = new Vector2f(0,0);
		double richting = GenerateRandomDirection();
		Velocity.x = (float) Math.cos(richting);
		Velocity.y = (float) Math.sin(richting);
		
		//snelheid
		double speed = (float) Math.random() * 4 + 1;
		Velocity.x += speed;
		Velocity.y += speed;
		
		//positie
		this.Position = rect.getPosition();
	}
	
	//Genereer een richting waarheen hij moet bewegen
	private double GenerateRandomDirection(){
		double richting = Math.random() * 2 * Math.PI;
		if (richting > (3/8 * Math.PI) && richting < (5/8 * Math.PI)){
			return GenerateRandomDirection();
		}else if(richting > (3/8 * Math.PI) + Math.PI && richting < (5/8 * Math.PI) + Math.PI){
			return GenerateRandomDirection();
		}
		return richting;
	}
	
	

	@Override
	public Vector2f getPosition() {
		return rect.getPosition();
	}
	
	//add all speed
	public void IncrementAllSpeed(float adding){
		if(this.Velocity.x < 0 && !(this.Velocity.x < minBallVelocity))
		{
			Velocity.x -=adding;
		}
		if(this.Velocity.y < 0 && !(this.Velocity.y < minBallVelocity))
		{
			Velocity.y -=adding;
		}
		if(this.Velocity.x > 0 && (this.Velocity.x < maxBallVelocity))
		{
			Velocity.x +=adding;
		}
		if(this.Velocity.y > 0 && (this.Velocity.x < maxBallVelocity))
		{
			Velocity.y +=adding;
		}
	}
	
	//verhoog alleen de snelheid op de x as
	public void IncrementXSpeed(float adding){
		if(this.Velocity.x > 0 && (this.Velocity.x < maxBallVelocity))
		{
			Velocity.x +=adding;
		}
		if(this.Velocity.y > 0 && (this.Velocity.x < maxBallVelocity))
		{
			Velocity.y +=adding;
		}
	}

	@Override
	public void Update() {
		IncrementAllSpeed(0.002f);
		
		//buiten map -> omkeren
		if(Position.y+rect.getHeight() >= WindowHeight)
		{
			if (Velocity.y > 0){
				Velocity.y = Velocity.y * -1;
				IncrementAllSpeed(0.005f);
			}
			this.setColor(Ball.getRandomColor());
			Sound.PlayBamf();
		}
		if(Position.y <= 0){
			if (Velocity.y < 0){
				Velocity.y = Velocity.y * -1;
				IncrementAllSpeed(0.005f);
			}
			this.setColor(Ball.getRandomColor());
			Sound.PlayBamf();
		}
		
		//snelheid binnen de perken houden
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
		
		//nieuwe positie
		this.Position.x += this.Velocity.x;
		this.Position.y += this.Velocity.y;
		rect.setPosition(Position);
	}

	@Override
	public void Draw() { //teken de ball
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
	public void Initialize() { //zie hier niet veel nut in
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
	
	public static Color getRandomColor(){ //genereer een random color, Rood, Groen, of Bluaw staat vast
		Random r = new Random();
		switch (getFastColorPart()){
		case (0): return new Color(getvastColorPartValue(), r.nextInt(255), r.nextInt(255));
		case (1): return new Color(r.nextInt(255),getvastColorPartValue(), r.nextInt(255));
		default:  return new Color(r.nextInt(255), r.nextInt(255), getvastColorPartValue());
		}
	}
	
	private static int vastColorPartValue = -1;
	public static byte getvastColorPartValue(){ //vast kleur waarde
		if (vastColorPartValue == -1){
			Random r = new Random();
			vastColorPartValue = r.nextInt(255);
		}
		return (byte)vastColorPartValue;
	}
	
	private static int vastColorPart = -1;
	public static int getFastColorPart(){ //vaste kleur type (Rood, Groen of Blauw)
		if (vastColorPart == -1){
			Random r = new Random();
			vastColorPart = r.nextInt(2);
		}
		return vastColorPart;
	}

}
