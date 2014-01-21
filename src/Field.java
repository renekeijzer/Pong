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
//		tmpball = new Ball(
//				new Rectangle(
//						new Vector2f(400,200), 
//						20, 
//						20
//						)
//				);
//		Game.Components.add(tmpball);
//		BallList.add(tmpball);
		
		Game.Components.add(Player1);
		Game.Components.add(Player2);
		
	}
	@Override
	public void Update() {
		for(Ball ball : BallList){
			if(ball.intersects(Player1))
			{
				Vector2f tmpVel = ball.getVelocity();
				tmpVel.x = tmpVel.x * -1;
				ball.setVelocity(tmpVel);
				ball.setColor(Ball.getRandomColor());
				Sound.PlayBoop();
			}
			if(ball.intersects(Player2))
			{
				Vector2f tmpVel = ball.getVelocity();
				tmpVel.x = tmpVel.x * -1;
				ball.setVelocity(tmpVel);
				ball.setColor(Ball.getRandomColor());
				Sound.PlayBeep();
			}
			if(ball.getPosition().x > WindowWidth){
				Player2.incrementScore();
				RemoveBallList.add(ball);
				Game.Components.remove(ball);
			}else if(ball.getPosition().x < 0){
				Player1.incrementScore();
				RemoveBallList.add(ball);
				Game.Components.remove(ball);
			}
		}
		
		for (Ball ball : RemoveBallList){
			BallList.remove(ball);
		}
		RemoveBallList.clear();
		
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
		}else if(!(Keyboard.isKeyDown(Keyboard.KEY_B) && Keyboard.isKeyDown(Keyboard.KEY_A) && Keyboard.isKeyDown(Keyboard.KEY_L)) && !cancheat){
			cancheat = true;
		}
	}
}
