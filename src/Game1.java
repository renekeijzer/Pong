import static org.lwjgl.opengl.GL11.*;

import org.lwjgl.opengl.Display;
import org.lwjgl.util.vector.Vector2f;

import Screens.GameWindow;
import Screens.Window;
import Shapes.Rectangle;


public class Game1 extends Game implements GlobalSettings{
	private Field field;
	public Player Player1, Player2;
	public Ball ball;
	public Game1()
	{
		do
		{
			glClear(GL_COLOR_BUFFER_BIT);
			
			for(GameComponent Component : Components.getComponents())
			{
				
				Component.Update();
				Component.Draw();
			}
			for(GameComponent Component : Components.getRemoveComponents()){
				Components.getComponents().remove(Component);
			}
			Components.getRemoveComponents().clear();
			field.Update();
			Display.update();
		}
		while(!Display.isCloseRequested());
	}
	
	
	public void Initialize() {
		Window window = new GameWindow(WindowWidth, WindowHeight);
		
		glEnable(GL_BLEND);
		glBlendFunc(GL_SRC_ALPHA, GL_ONE_MINUS_SRC_ALPHA);
		glClearColor(1.0f, 1.0f, 1.0f, 0.0f);
		glViewport(0,0, Window.getWidth(), Window.getHeight());
		glMatrixMode(GL_MODELVIEW);
		glMatrixMode(GL_PROJECTION);
		glLoadIdentity();
		glOrtho(0, Window.getWidth(), Window.getHeight(), 0, 1, -1);
		glMatrixMode(GL_MODELVIEW);		
		
	}

	@Override
	public void LoadContent() {
		field = new Field();
		
	}

}
