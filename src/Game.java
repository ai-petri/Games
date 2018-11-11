import org.eclipse.swt.SWT;
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.widgets.Composite;


public class Game extends Composite
{

	
	Canvas canvas;
	GC gc;
	int cellWidth;
	int cellHeight;
	
	
	public Game(Composite parent) {
		super(parent, 0);
		this.setLayout(new GridLayout(2,true));
		canvas = new Canvas(this,SWT.BORDER);
		canvas.setBackground(new Color(null, 255,255,255));
		canvas.setLayoutData(new GridData(GridData.FILL_BOTH));
		
		gc = new GC(canvas);
				
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
			}
		});
		
		
		canvas.pack();
		
	}

	

}
