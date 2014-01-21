import java.util.ArrayList;

import org.lwjgl.util.vector.Vector2f;

import Shapes.Rectangle;


public class Field extends GameComponent{

	private Player Player1, Player2;
	private Ball tmpball;
	private ArrayList<Ball> BallList;
	
	public Field()
	{
		BallList = new ArrayList<Ball>();
		Player1 = new Player(new Rectangle(new Vector2f(20, 50), PlayerWidth, PlayerHeight), "wasd");
		Player2 = new Player(new Rectangle(new Vector2f(800, 50), PlayerWidth, PlayerHeight), "arrows");
		
		for(int i = 0; i < 15; i++)
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
			
		}
		if(ball.intersects(Player2))
		{
			Vector2f tmpVel = ball.getVelocity();
			tmpVel.x = tmpVel.x * -1;
			ball.setVelocity(tmpVel);
		}
		}
	}

}
