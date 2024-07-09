package controle;

import java.awt.Color;
import javax.swing.border.AbstractBorder;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Insets;


public class RoundedBorder extends AbstractBorder {
	
	private Color borderColor;
	private int radius;
	
	public RoundedBorder(Color borderColor, int radius) {
		this.borderColor = borderColor;
		this.radius = radius;
	}


@Override
public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
	super.paintBorder(c, g, x, y, width, height);
	g.setColor(borderColor);
	g.drawRoundRect(x, y, width - 1, height - 1, radius, radius);
}

@Override
public Insets getBorderInsets(Component c) {
	return new Insets(radius, radius, radius, radius);
}

@Override
public Insets getBorderInsets(Component c, Insets insets) {
	insets.left = insets.top = insets.right = insets.bottom = radius;
	return insets;
}

}