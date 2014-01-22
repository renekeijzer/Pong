import java.util.ArrayList;

import Screens.State;

public abstract class Game {
	
	static State state = State.INTRO;
	static boolean justStarted = false;
	public Game() {
		Initialize();
		LoadContent();
	}
	
	public abstract void Initialize();
	public abstract void LoadContent();
	
	public static class Components
	{
		private static ArrayList<GameComponent> RemoveComponents;
		
		public static ArrayList<GameComponent> getRemoveComponents() {
			if(RemoveComponents == null)
			{
				RemoveComponents = new ArrayList<GameComponent>();
			}
			return RemoveComponents;
		}
		
		private static ArrayList<GameComponent> Components;
		
		public static ArrayList<GameComponent> getComponents()		{return Components;}
		
		public static void add(GameComponent comp)
		{
			if(Components == null)
			{
				Components = new ArrayList<GameComponent>();
			}
			Components.add(comp);
		}
		
		public static void remove(GameComponent comp)
		{
			if(RemoveComponents == null)
			{
				RemoveComponents = new ArrayList<GameComponent>();
			}
			RemoveComponents.add(comp);
		}
		
	}
	
}
