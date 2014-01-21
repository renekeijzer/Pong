package Accesoires;

import java.awt.Font;
import java.io.InputStream;

import org.newdawn.slick.Color;
import org.newdawn.slick.TrueTypeFont;
import org.newdawn.slick.util.ResourceLoader;


public class FontRenderer {

	private TrueTypeFont font;
	private boolean antiAlias = true;
	
	public FontRenderer(String ttf)
	{
		try {
		InputStream inputStream = ResourceLoader.getResourceAsStream(ttf);
		Font awtFont = Font.createFont(Font.TRUETYPE_FONT, inputStream);
		awtFont = awtFont.deriveFont(24f); // set font size

		font = new TrueTypeFont(awtFont, antiAlias);
		} catch (Exception e) {
		e.printStackTrace();
		}
	}
}
