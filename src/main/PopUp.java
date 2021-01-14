package main;

import javax.swing.JPanel;
import javax.swing.Popup;
import javax.swing.PopupFactory;

public class PopUp {
	private JPanel popUpPanel,
					parentPanel;
    private Popup popUp;
    private MainPage parent;
    
    public PopUp(JPanel panel, MainPage main) {
    	popUpPanel = 
    	parentPanel = panel;
    	parent = main;
    }
    
    public void showPopUp() {
    	PopupFactory pf = PopupFactory.getSharedInstance();
        popUp = pf.getPopup(parentPanel, parent.getAddItemPanel(), parentPanel.getLocationOnScreen().x + (parentPanel.getWidth()/4), parentPanel.getLocationOnScreen().y + (parentPanel.getHeight()/4));
        popUp.show();
    }
    
    public void hidePopup() {
        popUp.hide();
        popUp = null;
    }
    
}
