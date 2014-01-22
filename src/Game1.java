import static org.lwjgl.opengl.GL11.*;

import org.lwjgl.opengl.Display;

import Screens.GameWindow;
import Screens.Window;


public class Game1 extends Game implements GlobalSettings{
	private Field field;
	public Player Player1, Player2;
	public Ball ball;
	public Game1()
	{
		do
		{
			//Clearing screen each gameloop
			glClear(GL_COLOR_BUFFER_BIT);
			//Elke GameComponent updaten en drawen
			for(GameComponent Component : Components.getComponents())
			{
				
				Component.Update();
				Component.Draw();
			}
			field.Update();
			//Alle GameComponents weg gooien die weg gegooid moeten worden
			for(GameComponent Component : Components.getRemoveComponents()){
				Components.getComponents().remove(Component);
			}
			//Clearing The removed components
			Components.getRemoveComponents().clear();
			//Updating the display
			Display.update();
		}
		while(!Display.isCloseRequested());
	}
	
	
	public void Initialize() {
		//Initialiseren van alle openGL Setting, en initialiseren van een nieuwe window
		@SuppressWarnings("unused")
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
		//Nieuwe content loaden
		field = new Field();
	}

}
