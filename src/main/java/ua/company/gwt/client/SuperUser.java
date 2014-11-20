package ua.company.gwt.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.shared.GWT;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.ui.RootLayoutPanel;
import com.sencha.gxt.widget.core.client.container.Viewport;
import ua.company.gwt.client.interfaces.MainContainer;
import ua.company.gwt.client.resources.AppConstants;

public class SuperUser implements EntryPoint {

    public static AppConstants CONSTANTS = GWT.create(AppConstants.class);

    public void onModuleLoad() {
        MainContainer container = new MainContainer();
        Viewport viewport = new Viewport();
        viewport.setWidget(container);
        DOM.getElementById("loading").removeFromParent();
        RootLayoutPanel.get().add(viewport);

//      Set focus to text box for account input in west container panel after module loading
        container.getWestBorderPanel().getAccountTextBox().getElement().focus();
    }
}
