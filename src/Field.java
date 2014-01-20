import java.util.ArrayList;

import org.lwjgl.util.vector.Vector2f;

import Shapes.Rectangle;


public class Field extends GameComponent{

	private Player Player1, Player2;
	private Ball ball;
	private ArrayList<Ball> BallList;
	
	public Field()
	{
		BallList = new ArrayList<Ball>();
		Player1 = new Player(new Rectangle(new Vector2f(20, 50), PlayerWidth, PlayerHeight), "wasd");
		Player2 = new Player(new Rectangle(new Vector2f(800, 50), PlayerWidth, PlayerHeight), "arrows");
		ball = new Ball(new Rectangle(new Vector2f(400,200), 20, 20));

		Game.Components.add(Player1);
		Game.Components.add(Player2);
		Game.Components.add(ball);
		
	}
	@Override
	public void Update() {

		if(Player1.intersects(ball))
		{
			Vector2f tmpVel = ball.getVelocity();
			tmpVel.x = tmpVel.x * -1;
			ball.setVelocity(tmpVel);
		}
		if(Player2.intersects(ball))
		{
			Vector2f tmpVel = ball.getVelocity();
			tmpVel.x = tmpVel.x * -1;
			ball.setVelocity(tmpVel);
		}
		
	}

}
