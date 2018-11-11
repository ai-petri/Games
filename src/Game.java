import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseListener;
import org.eclipse.swt.events.MouseMoveListener;
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.widgets.Composite;


public class Game extends Composite
{

	
	Canvas canvas;
	GC gc;
	int cellWidth = 0;
	int cellHeight = 0;
	
	int X = 0;
	int Y = 0;
	
	boolean isDown = false;
	
	
	public Game(Composite parent) {
		super(parent, 0);
		this.setLayout(new GridLayout(2,true));
		canvas = new Canvas(this,SWT.BORDER);
		canvas.setBackground(new Color(null, 255,255,255));
		canvas.setLayoutData(new GridData(GridData.FILL_BOTH));
		
		gc = new GC(canvas);
		
		Image image = new Image(parent.getDisplay(), Game.class.getResourceAsStream("image.png"));
				
		canvas.addPaintListener(new PaintListener() {
			
			@Override
			public void paintControl(PaintEvent e) {
				
				
				
				
				for (int i = 0; i<8; i++)
					for (int j = 0; j<8; j++)
					{
						cellWidth = (canvas.getClientArea().width)/8;
						cellHeight = (canvas.getClientArea().height)/8;
						gc.setBackground(new Color(null,255,255,255));
						if((i+j)%2 == 0) gc.setBackground(new Color(null,150,50,0));
							
						gc.fillRectangle(i*cellWidth, j*cellHeight, cellWidth, cellHeight);
						
					}
				
				//gc.drawImage(image, X*cellWidth, Y*cellHeight);
			}
		});
		
		canvas.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseUp(MouseEvent e) {
				isDown = false;
				gc.drawImage(image, X*cellWidth, Y*cellHeight);
				
			}
			
			@Override
			public void mouseDown(MouseEvent e) {
				isDown = true;
				canvas.redraw();
				
				
			}
			
			@Override
			public void mouseDoubleClick(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		canvas.addMouseMoveListener(new MouseMoveListener() {
			
			@Override
			public void mouseMove(MouseEvent e) {

				X = e.x/cellWidth;
				Y = e.y/cellHeight;
				
				if (isDown)
				{
					//gc.drawImage(image.)
				}
				
			}
		});
		
		
		
		
		canvas.pack();
		
	}

	

}
