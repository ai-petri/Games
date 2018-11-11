import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.Shell;

public class MainClass
{

	public static void main(String[] args)
	{
		Display display = new Display();
		Shell shell = new Shell(display);
		
//--------------- Menu Bar-------------------------------------------------
		
		Menu menuBar = new Menu(shell, SWT.BAR);
		
		MenuItem[] BarItems = new MenuItem[4];
		Menu[] DropDownMenus = new Menu[BarItems.length];
		
		for(int i=0; i<BarItems.length; i++)
		{
			BarItems[i] = new MenuItem(menuBar, SWT.CASCADE);
			DropDownMenus[i] = new Menu(shell, SWT.DROP_DOWN);
			BarItems[i].setMenu(DropDownMenus[i]);
		}
		
		BarItems[0].setText("File");
		BarItems[1].setText("Edit");
		BarItems[2].setText("Game");
		BarItems[3].setText("Help");
		
		MenuItem[] fileMenuItems = new MenuItem[3];
		for (int i=0; i<fileMenuItems.length; i++)
		{
			fileMenuItems[i] = new MenuItem(DropDownMenus[0], SWT.PUSH);
		}
		
		  
		fileMenuItems[0].setText("New");
		fileMenuItems[0].addListener(SWT.Selection, new Listener() {
				
				@Override
				public void handleEvent(Event event) {
					
					
				}
			});
				
       
		fileMenuItems[1].setText("Exit");
		fileMenuItems[1].addListener(SWT.Selection, new Listener() {
			
			@Override
			public void handleEvent(Event event) {
				shell.getDisplay().dispose();
	            System.exit(0);
				
			}
		});
        
              
        shell.setMenuBar(menuBar);
	        
// ---------------------------------------------------------------------------	       
			

        
        
        
        
        
        
        
				
		
		shell.open();
		
		while (!shell.isDisposed())
		{
			if (!display.readAndDispatch())
			display.sleep();
		}
		display.dispose();
		
	}
	
}
