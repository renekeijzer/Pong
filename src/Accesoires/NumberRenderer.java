package Accesoires;

import static org.lwjgl.opengl.GL11.GL_QUADS;
import static org.lwjgl.opengl.GL11.glBegin;
import static org.lwjgl.opengl.GL11.glVertex2f;

import org.lwjgl.opengl.GL11;
import org.lwjgl.util.vector.Vector2f;
import org.newdawn.slick.Color;

public class NumberRenderer {
	
	public NumberRenderer()
	{
		
	}
	
	public void Draw(Vector2f Pos, String number, int amp )
	{
		char[] Arr = number.toCharArray();
		Color.white.bind();
		glBegin(GL_QUADS);
		GL11.glColor3f(1,1,1);
		//Rendering cijferreeks
		for(char num : Arr)
		{
			switch(Character.getNumericValue(num))
			{
			case 1:
				glVertex2f(Pos.x+(3*amp), Pos.y+(0*amp));
				glVertex2f(Pos.x+(3*amp), Pos.y+((6*amp)));
				glVertex2f(Pos.x+((4*amp)), Pos.y+(6*amp)) ;
				glVertex2f(Pos.x+((4*amp)), Pos.y+(0*amp));
				
				glVertex2f(Pos.x+(2.5f * amp), Pos.y+(5 * amp));
				glVertex2f(Pos.x+(2.5f * amp), Pos.y+(6 * amp));
				glVertex2f(Pos.x+(4.5f * amp), Pos.y+(6 * amp));
				glVertex2f(Pos.x+(4.5f * amp), Pos.y+(5 * amp));
				
				glVertex2f(Pos.x+(3 * amp), Pos.y+(0 * amp));
				glVertex2f(Pos.x+(2 * amp), Pos.y+(1 * amp));
				glVertex2f(Pos.x+(3 * amp), Pos.y+(1 * amp));
				glVertex2f(Pos.x+(3 * amp), Pos.y+(2 * amp));
				break;
			case 2:
				
				glVertex2f(Pos.x+(1*amp), Pos.y+(0*amp));
				glVertex2f(Pos.x+(1*amp), Pos.y+(1*amp));
				glVertex2f(Pos.x+((5*amp)), Pos.y+(1*amp)) ;
				glVertex2f(Pos.x+((5*amp)), Pos.y+(0*amp));
				
				glVertex2f(Pos.x+(5 * amp), Pos.y+(0 * amp));
				glVertex2f(Pos.x+(5 * amp), Pos.y+(3 * amp));
				glVertex2f(Pos.x+(4 * amp), Pos.y+(3 * amp));
				glVertex2f(Pos.x+(4 * amp), Pos.y+(0 * amp));
				
				glVertex2f(Pos.x+(5 * amp), Pos.y+(2.5f * amp));
				glVertex2f(Pos.x+(5 * amp), Pos.y+(3.5f * amp));
				glVertex2f(Pos.x+(1 * amp), Pos.y+(3.5f * amp));
				glVertex2f(Pos.x+(1 * amp), Pos.y+(2.5f * amp));
				
				glVertex2f(Pos.x+(1 * amp), Pos.y+(3 * amp));
				glVertex2f(Pos.x+(1 * amp), Pos.y+(6 * amp));
				glVertex2f(Pos.x+(2 * amp), Pos.y+(6 * amp));
				glVertex2f(Pos.x+(2 * amp), Pos.y+(3 * amp));
				
				glVertex2f(Pos.x+(1 * amp), Pos.y+(5 * amp));
				glVertex2f(Pos.x+(1 * amp), Pos.y+(6 * amp));
				glVertex2f(Pos.x+(5 * amp), Pos.y+(6 * amp));
				glVertex2f(Pos.x+(5 * amp), Pos.y+(5 * amp));
				break;				
			case 3:
				glVertex2f(Pos.x+(1*amp), Pos.y+(0*amp));
				glVertex2f(Pos.x+(1*amp), Pos.y+(1*amp));
				glVertex2f(Pos.x+((5*amp)), Pos.y+(1*amp)) ;
				glVertex2f(Pos.x+((5*amp)), Pos.y+(0*amp));				
				
				glVertex2f(Pos.x+(5 * amp), Pos.y+(0 * amp));
				glVertex2f(Pos.x+(5 * amp), Pos.y+(3 * amp));
				glVertex2f(Pos.x+(4 * amp), Pos.y+(3 * amp));
				glVertex2f(Pos.x+(4 * amp), Pos.y+(0 * amp));
				
				glVertex2f(Pos.x+(5 * amp), Pos.y+(2.5f * amp));
				glVertex2f(Pos.x+(5 * amp), Pos.y+(3.5f * amp));
				glVertex2f(Pos.x+(1 * amp), Pos.y+(3.5f * amp));
				glVertex2f(Pos.x+(1 * amp), Pos.y+(2.5f * amp));
			

				glVertex2f(Pos.x+(5 * amp), Pos.y+(2.5f * amp));
				glVertex2f(Pos.x+(5 * amp), Pos.y+(6 * amp));
				glVertex2f(Pos.x+(4 * amp), Pos.y+(6 * amp)) ;
				glVertex2f(Pos.x+(4 * amp), Pos.y+(2.5f * amp));
				
				glVertex2f(Pos.x+(1 * amp), Pos.y+(5 * amp));
				glVertex2f(Pos.x+(1 * amp), Pos.y+(6 * amp));
				glVertex2f(Pos.x+(5 * amp), Pos.y+(6 * amp));
				glVertex2f(Pos.x+(5 * amp), Pos.y+(5 * amp));
				break;
				
			case 4:
				
				glVertex2f(Pos.x+(1*amp), Pos.y+(0*amp));
				glVertex2f(Pos.x+(1*amp), Pos.y+(3.5f*amp));
				glVertex2f(Pos.x+(2*amp), Pos.y+(3.5f*amp)) ;
				glVertex2f(Pos.x+(2*amp), Pos.y+(0*amp));				
				
				glVertex2f(Pos.x+(5 * amp), Pos.y+(0 * amp));
				glVertex2f(Pos.x+(5 * amp), Pos.y+(3 * amp));
				glVertex2f(Pos.x+(4 * amp), Pos.y+(3 * amp));
				glVertex2f(Pos.x+(4 * amp), Pos.y+(0 * amp));
				
				glVertex2f(Pos.x+(5 * amp), Pos.y+(2.5f * amp));
				glVertex2f(Pos.x+(5 * amp), Pos.y+(3.5f * amp));
				glVertex2f(Pos.x+(1 * amp), Pos.y+(3.5f * amp));
				glVertex2f(Pos.x+(1 * amp), Pos.y+(2.5f * amp));

				glVertex2f(Pos.x+(5 * amp), Pos.y+(2.5f * amp));
				glVertex2f(Pos.x+(5 * amp), Pos.y+(6 * amp));
				glVertex2f(Pos.x+(4 * amp), Pos.y+(6 * amp)) ;
				glVertex2f(Pos.x+(4 * amp), Pos.y+(2.5f * amp));
				break;
				
			case 5:
				glVertex2f(Pos.x+(1*amp), Pos.y+(0*amp));
				glVertex2f(Pos.x+(1*amp), Pos.y+(1*amp));
				glVertex2f(Pos.x+((5*amp)), Pos.y+(1*amp)) ;
				glVertex2f(Pos.x+((5*amp)), Pos.y+(0*amp));
				
				glVertex2f(Pos.x+(1*amp), Pos.y+(0*amp));
				glVertex2f(Pos.x+(1*amp), Pos.y+(3.5f*amp));
				glVertex2f(Pos.x+(2*amp), Pos.y+(3.5f*amp)) ;
				glVertex2f(Pos.x+(2*amp), Pos.y+(0*amp));				
		
				
				glVertex2f(Pos.x+(5 * amp), Pos.y+(2.5f * amp));
				glVertex2f(Pos.x+(5 * amp), Pos.y+(3.5f * amp));
				glVertex2f(Pos.x+(1 * amp), Pos.y+(3.5f * amp));
				glVertex2f(Pos.x+(1 * amp), Pos.y+(2.5f * amp));
		

				glVertex2f(Pos.x+(5 * amp), Pos.y+(2.5f * amp));
				glVertex2f(Pos.x+(5 * amp), Pos.y+(6 * amp));
				glVertex2f(Pos.x+(4 * amp), Pos.y+(6 * amp)) ;
				glVertex2f(Pos.x+(4 * amp), Pos.y+(2.5f * amp));
				
				glVertex2f(Pos.x+(1 * amp), Pos.y+(5 * amp));
				glVertex2f(Pos.x+(1 * amp), Pos.y+(6 * amp));
				glVertex2f(Pos.x+(5 * amp), Pos.y+(6 * amp));
				glVertex2f(Pos.x+(5 * amp), Pos.y+(5 * amp));
				break;
			case 6:
				glVertex2f(Pos.x+(1*amp), Pos.y+(0*amp));
				glVertex2f(Pos.x+(1*amp), Pos.y+(1*amp));
				glVertex2f(Pos.x+((5*amp)), Pos.y+(1*amp)) ;
				glVertex2f(Pos.x+((5*amp)), Pos.y+(0*amp));
				
				glVertex2f(Pos.x+(1*amp), Pos.y+(0*amp));
				glVertex2f(Pos.x+(1*amp), Pos.y+(3.5f*amp));
				glVertex2f(Pos.x+(2*amp), Pos.y+(3.5f*amp)) ;
				glVertex2f(Pos.x+(2*amp), Pos.y+(0*amp));				
			
				glVertex2f(Pos.x+(5 * amp), Pos.y+(2.5f * amp));
				glVertex2f(Pos.x+(5 * amp), Pos.y+(3.5f * amp));
				glVertex2f(Pos.x+(1 * amp), Pos.y+(3.5f * amp));
				glVertex2f(Pos.x+(1 * amp), Pos.y+(2.5f * amp));
				
				glVertex2f(Pos.x+(1 * amp), Pos.y+(3 * amp));
				glVertex2f(Pos.x+(1 * amp), Pos.y+(6 * amp));
				glVertex2f(Pos.x+(2 * amp), Pos.y+(6 * amp));
				glVertex2f(Pos.x+(2 * amp), Pos.y+(3 * amp));

				glVertex2f(Pos.x+(5 * amp), Pos.y+(2.5f * amp));
				glVertex2f(Pos.x+(5 * amp), Pos.y+(6 * amp));
				glVertex2f(Pos.x+(4 * amp), Pos.y+(6 * amp)) ;
				glVertex2f(Pos.x+(4 * amp), Pos.y+(2.5f * amp));
				
				glVertex2f(Pos.x+(1 * amp), Pos.y+(5 * amp));
				glVertex2f(Pos.x+(1 * amp), Pos.y+(6 * amp));
				glVertex2f(Pos.x+(5 * amp), Pos.y+(6 * amp));
				glVertex2f(Pos.x+(5 * amp), Pos.y+(5 * amp));
				break;
			case 7:
				glVertex2f(Pos.x+(1*amp), Pos.y+(0*amp));
				glVertex2f(Pos.x+(1*amp), Pos.y+(1*amp));
				glVertex2f(Pos.x+((5*amp)), Pos.y+(1*amp));
				glVertex2f(Pos.x+((5*amp)), Pos.y+(0*amp));
				
				glVertex2f(Pos.x+((5*amp)), Pos.y+(0*amp));
				glVertex2f(Pos.x+((1*amp)), Pos.y+(6*amp));
				glVertex2f(Pos.x+((2*amp)), Pos.y+(6*amp));
				glVertex2f(Pos.x+((5*amp)), Pos.y+(1*amp));
				break;
			case 8:
				glVertex2f(Pos.x+(1*amp), Pos.y+(0*amp));
				glVertex2f(Pos.x+(1*amp), Pos.y+(1*amp));
				glVertex2f(Pos.x+((5*amp)), Pos.y+(1*amp)) ;
				glVertex2f(Pos.x+((5*amp)), Pos.y+(0*amp));
				
				glVertex2f(Pos.x+(1*amp), Pos.y+(0*amp));
				glVertex2f(Pos.x+(1*amp), Pos.y+(3.5f*amp));
				glVertex2f(Pos.x+(2*amp), Pos.y+(3.5f*amp)) ;
				glVertex2f(Pos.x+(2*amp), Pos.y+(0*amp));				
				
				glVertex2f(Pos.x+(5 * amp), Pos.y+(0 * amp));
				glVertex2f(Pos.x+(5 * amp), Pos.y+(3 * amp));
				glVertex2f(Pos.x+(4 * amp), Pos.y+(3 * amp));
				glVertex2f(Pos.x+(4 * amp), Pos.y+(0 * amp));
				
				glVertex2f(Pos.x+(5 * amp), Pos.y+(2.5f * amp));
				glVertex2f(Pos.x+(5 * amp), Pos.y+(3.5f * amp));
				glVertex2f(Pos.x+(1 * amp), Pos.y+(3.5f * amp));
				glVertex2f(Pos.x+(1 * amp), Pos.y+(2.5f * amp));
				
				glVertex2f(Pos.x+(1 * amp), Pos.y+(3 * amp));
				glVertex2f(Pos.x+(1 * amp), Pos.y+(6 * amp));
				glVertex2f(Pos.x+(2 * amp), Pos.y+(6 * amp));
				glVertex2f(Pos.x+(2 * amp), Pos.y+(3 * amp));

				glVertex2f(Pos.x+(5 * amp), Pos.y+(2.5f * amp));
				glVertex2f(Pos.x+(5 * amp), Pos.y+(6 * amp));
				glVertex2f(Pos.x+(4 * amp), Pos.y+(6 * amp)) ;
				glVertex2f(Pos.x+(4 * amp), Pos.y+(2.5f * amp));
				
				glVertex2f(Pos.x+(1 * amp), Pos.y+(5 * amp));
				glVertex2f(Pos.x+(1 * amp), Pos.y+(6 * amp));
				glVertex2f(Pos.x+(5 * amp), Pos.y+(6 * amp));
				glVertex2f(Pos.x+(5 * amp), Pos.y+(5 * amp));
				break;
			case 9:
				glVertex2f(Pos.x+(1*amp), Pos.y+(0*amp));
				glVertex2f(Pos.x+(1*amp), Pos.y+(1*amp));
				glVertex2f(Pos.x+((5*amp)), Pos.y+(1*amp)) ;
				glVertex2f(Pos.x+((5*amp)), Pos.y+(0*amp));
				
				glVertex2f(Pos.x+(1*amp), Pos.y+(0*amp));
				glVertex2f(Pos.x+(1*amp), Pos.y+(3.5f*amp));
				glVertex2f(Pos.x+(2*amp), Pos.y+(3.5f*amp)) ;
				glVertex2f(Pos.x+(2*amp), Pos.y+(0*amp));				
				
				glVertex2f(Pos.x+(5 * amp), Pos.y+(0 * amp));
				glVertex2f(Pos.x+(5 * amp), Pos.y+(3 * amp));
				glVertex2f(Pos.x+(4 * amp), Pos.y+(3 * amp));
				glVertex2f(Pos.x+(4 * amp), Pos.y+(0 * amp));
				
				glVertex2f(Pos.x+(5 * amp), Pos.y+(2.5f * amp));
				glVertex2f(Pos.x+(5 * amp), Pos.y+(3.5f * amp));
				glVertex2f(Pos.x+(1 * amp), Pos.y+(3.5f * amp));
				glVertex2f(Pos.x+(1 * amp), Pos.y+(2.5f * amp));
			

				glVertex2f(Pos.x+(5 * amp), Pos.y+(2.5f * amp));
				glVertex2f(Pos.x+(5 * amp), Pos.y+(6 * amp));
				glVertex2f(Pos.x+(4 * amp), Pos.y+(6 * amp)) ;
				glVertex2f(Pos.x+(4 * amp), Pos.y+(2.5f * amp));
				
				glVertex2f(Pos.x+(1 * amp), Pos.y+(5 * amp));
				glVertex2f(Pos.x+(1 * amp), Pos.y+(6 * amp));
				glVertex2f(Pos.x+(5 * amp), Pos.y+(6 * amp));
				glVertex2f(Pos.x+(5 * amp), Pos.y+(5 * amp));
				break;
			case 0:
				glVertex2f(Pos.x+(1*amp), Pos.y+(0*amp));
				glVertex2f(Pos.x+(1*amp), Pos.y+(1*amp));
				glVertex2f(Pos.x+((5*amp)), Pos.y+(1*amp)) ;
				glVertex2f(Pos.x+((5*amp)), Pos.y+(0*amp));
				
				glVertex2f(Pos.x+(1*amp), Pos.y+(0*amp));
				glVertex2f(Pos.x+(1*amp), Pos.y+(3.5f*amp));
				glVertex2f(Pos.x+(2*amp), Pos.y+(3.5f*amp)) ;
				glVertex2f(Pos.x+(2*amp), Pos.y+(0*amp));				
				
				glVertex2f(Pos.x+(5 * amp), Pos.y+(0 * amp));
				glVertex2f(Pos.x+(5 * amp), Pos.y+(3 * amp));
				glVertex2f(Pos.x+(4 * amp), Pos.y+(3 * amp));
				glVertex2f(Pos.x+(4 * amp), Pos.y+(0 * amp));

				
				glVertex2f(Pos.x+(1 * amp), Pos.y+(3 * amp));
				glVertex2f(Pos.x+(1 * amp), Pos.y+(6 * amp));
				glVertex2f(Pos.x+(2 * amp), Pos.y+(6 * amp));
				glVertex2f(Pos.x+(2 * amp), Pos.y+(3 * amp));

				glVertex2f(Pos.x+(5 * amp), Pos.y+(2.5f * amp));
				glVertex2f(Pos.x+(5 * amp), Pos.y+(6 * amp));
				glVertex2f(Pos.x+(4 * amp), Pos.y+(6 * amp)) ;
				glVertex2f(Pos.x+(4 * amp), Pos.y+(2.5f * amp));
				
				glVertex2f(Pos.x+(1 * amp), Pos.y+(5 * amp));
				glVertex2f(Pos.x+(1 * amp), Pos.y+(6 * amp));
				glVertex2f(Pos.x+(5 * amp), Pos.y+(6 * amp));
				glVertex2f(Pos.x+(5 * amp), Pos.y+(5 * amp));
				break;
			
			}
			Pos.x += 6*amp + 5;
		}
	}

}
