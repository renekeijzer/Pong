import java.util.ArrayList;

import org.lwjgl.input.Keyboard;
import org.lwjgl.util.vector.Vector2f;

import Accesoires.Sound;
import Screens.State;
import Shapes.Rectangle;

public class Field extends GameComponent {

	private Player Player1, Player2;
	private Ball tmpball;
	private ArrayList<Ball> BallList;
	private ArrayList<Ball> RemoveBallList;
	private boolean cancheat;

	public Field() {
		cancheat = true;
		BallList = new ArrayList<Ball>();
		RemoveBallList = new ArrayList<Ball>();
		Player1 = new Player(new Rectangle(new Vector2f(20, 50), PlayerWidth,
				PlayerHeight), "wasd");
		Player2 = new Player(new Rectangle(new Vector2f(800, 50), PlayerWidth,
				PlayerHeight), "arrows");

		tmpball = new Ball(new Rectangle(new Vector2f(400, 200), 20, 20));
		Game.Components.add(tmpball);
		BallList.add(tmpball);

		Game.Components.add(Player1);
		Game.Components.add(Player2);

	}

	@Override
	public void Update() {
		
	switch(Game.state)
		{
			case INTRO:
				Player1.setPosition(new Vector2f(Player1.getPosition().x, BallList.get(0).getPosition().y - PlayerWidth/2));
				Player2.setPosition(new Vector2f(Player2.getPosition().x, BallList.get(0).getPosition().y - PlayerWidth/2));
				Player1.setManual(false);
				Player2.setManual(false);
				while (Keyboard.next()) {
				    if (Keyboard.getEventKeyState()) {
				    Game.state = State.GAME;
				    Game.justStarted = true;
				    	}
				    }
				
				break;
			case GAME:
				if(Game.justStarted)
				{
					Player1.setManual(true);
					Player2.setManual(true);
					Player1.setScore(0);
					Player2.setScore(0);
					Game.Components.remove(BallList.get(0));
					BallList.clear();
					
					tmpball = new Ball(new Rectangle(new Vector2f(400, 200), 20, 20));
					Game.Components.add(tmpball);
					BallList.add(tmpball);

					Game.justStarted = false;
				}
				
				break;
			default:
				System.exit(0);
	
		}
		
		
		for (Ball ball : BallList) {
			Vector2f tmpVel = ball.getVelocity();
			if (ball.intersects(Player1)) {
				ball.IncrementAllSpeed(0.006f);
				ball.IncrementXSpeed(0.004f);

				if ((ball.getPosition().y + ball.getHeight()) > (Player1
						.getPosition().y + Player1.getHeight())) {
					if (tmpVel.y < 0) {
						tmpVel.y = tmpVel.y * -1;
					}
					if (tmpVel.y < Player1.getYVelocity()) {
						tmpVel.y = (float) (Player1.getYVelocity() + 0.1f);
					}
				} else if (ball.getPosition().y < Player1.getPosition().y) {
					if (tmpVel.y > 0) {
						tmpVel.y = tmpVel.y * -1;
					}
					if (tmpVel.y > Player1.getYVelocity()) {
						tmpVel.y = (float) (Player1.getYVelocity() - 0.1f);
					}
				}
				if ((ball.getPosition().x + ball.getWidth()) > (Player1
						.getPosition().x + Player1.getWidth())) {
					if (tmpVel.x < 0) {
						tmpVel.x = tmpVel.x * -1;
					}
				}
				ball.setVelocity(tmpVel);
				ball.setColor(Ball.getRandomColor());
				Sound.PlayBoop();
			}
			if (ball.intersects(Player2)) {
				ball.IncrementAllSpeed(0.006f);
				ball.IncrementXSpeed(0.004f);
				if ((ball.getPosition().y + ball.getHeight()) > (Player2
						.getPosition().y + Player2.getHeight())) {
					if (tmpVel.y < 0) {
						tmpVel.y = tmpVel.y * -1;
					}
					if (tmpVel.y < Player2.getYVelocity()) {
						tmpVel.y = (float) (Player2.getYVelocity() + 0.1f);
					}
				} else if (ball.getPosition().y < Player2.getPosition().y) {
					if (tmpVel.y > 0) {
						tmpVel.y = tmpVel.y * -1;
					}
					if (tmpVel.y > Player2.getYVelocity()) {
						tmpVel.y = (float) (Player2.getYVelocity() - 0.1f);
					}
				}
				if (ball.getPosition().x < Player2.getPosition().x) {
					if (tmpVel.x > 0) {
						tmpVel.x = tmpVel.x * -1;
					}
				}
				ball.setVelocity(tmpVel);
				ball.setColor(Ball.getRandomColor());
				Sound.PlayBeep();
			}
			if (ball.getPosition().x > WindowWidth) {
				Player1.incrementScore();
				RemoveBallList.add(ball);
				Game.Components.remove(ball);

			} else if (ball.getPosition().x < 0) {
				Player2.incrementScore();
				RemoveBallList.add(ball);
				Game.Components.remove(ball);
			}
		}

		for (Ball ball : RemoveBallList) {
			BallList.remove(ball);
		}
		RemoveBallList.clear();

		if (BallList.size() == 0) {
			tmpball = new Ball(new Rectangle(new Vector2f(400, 200), 20, 20));
			Game.Components.add(tmpball);
			BallList.add(tmpball);
		}

		if (Keyboard.isKeyDown(Keyboard.KEY_B)
				&& Keyboard.isKeyDown(Keyboard.KEY_A)
				&& Keyboard.isKeyDown(Keyboard.KEY_L) && cancheat) {
			cancheat = false;

			for (int i = 0; i < 5; i++) {
				tmpball = new Ball(
						new Rectangle(new Vector2f(400, 200), 20, 20));
				Game.Components.add(tmpball);
				BallList.add(tmpball);
			}

		} else if (!(Keyboard.isKeyDown(Keyboard.KEY_B)
				&& Keyboard.isKeyDown(Keyboard.KEY_A) && Keyboard
					.isKeyDown(Keyboard.KEY_L)) && !cancheat) {
			Sound.PlayBalls();
			cancheat = true;
		}
	}
}
