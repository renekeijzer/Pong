import java.util.ArrayList;

import org.lwjgl.input.Keyboard;
import org.lwjgl.util.vector.Vector2f;

import Accesoires.Sound;
import Shapes.Rectangle;


public class Field extends GameComponent{

	private Player Player1, Player2;
	private Ball tmpball;
	private ArrayList<Ball> BallList;
	private ArrayList<Ball> RemoveBallList;
	private boolean cancheat;
	
	public Field()
	{
		cancheat = true;
		BallList = new ArrayList<Ball>();
		RemoveBallList = new ArrayList<Ball>();
		Player1 = new Player(new Rectangle(new Vector2f(20, 50), PlayerWidth, PlayerHeight), "wasd");
		Player2 = new Player(new Rectangle(new Vector2f(800, 50), PlayerWidth, PlayerHeight), "arrows");
		
		tmpball = new Ball(
				new Rectangle(
						new Vector2f(400,200), 
						20, 
						20
						)
				);
		Game.Components.add(tmpball);
		BallList.add(tmpball);
		
		Game.Components.add(Player1);
		Game.Components.add(Player2);
		
	}
	@Override
	public void Update() {
		for(Ball ball : BallList){
			Vector2f tmpVel = ball.getVelocity();
			if(ball.intersects(Player1))
			{
			
//				if ((ball.getPosition().y + ball.getHeight() > Player1.getPosition().y) && ((Player1.getPosition().y + Player1.getHeight()) > ball.getPosition().y)){
//					tmpVel.y = tmpVel.y * -1;		
//				}else{
//					tmpVel.x = tmpVel.x * -1;
//				}
				tmpVel.x = tmpVel.x * -1;
				ball.setVelocity(tmpVel);
				ball.setColor(Ball.getRandomColor());
				Sound.PlayBoop();
			}
			if(ball.intersects(Player2))
			{
	
				
				tmpVel.x = tmpVel.x * -1;
				ball.setVelocity(tmpVel);
				ball.setColor(Ball.getRandomColor());
				Sound.PlayBeep();
			}
			if(ball.getPosition().x > WindowWidth){
				Player1.incrementScore();
				RemoveBallList.add(ball);
				Game.Components.remove(ball);
				
			}else if(ball.getPosition().x < 0){
				Player2.incrementScore();
				RemoveBallList.add(ball);
				Game.Components.remove(ball);
			}
		}
		
		for (Ball ball : RemoveBallList){
			BallList.remove(ball);
		}
		RemoveBallList.clear();
		
		
		
		if(BallList.size() == 0)
		{
			tmpball = new Ball(
					new Rectangle(
							new Vector2f(400,200), 
							20, 
							20
							)
					);
			Game.Components.add(tmpball);
			BallList.add(tmpball);
		}
		
		if (Keyboard.isKeyDown(Keyboard.KEY_B) && Keyboard.isKeyDown(Keyboard.KEY_A) && Keyboard.isKeyDown(Keyboard.KEY_L) && cancheat){
			cancheat = false;
			
			for(int i = 0; i < 5; i++)
			{

				tmpball = new Ball(
						new Rectangle(
								new Vector2f(400,200), 
								20, 
								20
								)
						);
				Game.Components.add(tmpball);
				BallList.add(tmpball);
				
			}
			
		}
		else if(!(Keyboard.isKeyDown(Keyboard.KEY_B) 
				&& Keyboard.isKeyDown(Keyboard.KEY_A) 
				&& Keyboard.isKeyDown(Keyboard.KEY_L)) 
				&& !cancheat)
		{Sound.PlayBalls();
			cancheat = true;
		}
	}
}
