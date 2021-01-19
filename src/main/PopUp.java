package main;

import javax.swing.JPanel;
import javax.swing.Popup;
import javax.swing.PopupFactory;

public class PopUp {
	private JPanel parentPanel;
    private Popup popUp;
    
    public PopUp(JPanel panel) {
    	parentPanel = panel;
    }
    
    public void showPopUp(JPanel panel){
    	PopupFactory pf = PopupFactory.getSharedInstance();
        popUp = pf.getPopup(parentPanel, panel, (parentPanel.getLocationOnScreen().x) + (parentPanel.getWidth()/4), (parentPanel.getHeight()/4));
        popUp.show();
    }
    
    public void hidePopUp() {
        popUp.hide();
        popUp = null;
    }
    
}
