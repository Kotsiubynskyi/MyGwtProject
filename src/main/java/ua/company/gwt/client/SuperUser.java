package ua.company.gwt.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.ui.RootLayoutPanel;
import com.sencha.gxt.widget.core.client.container.Viewport;
import ua.company.gwt.client.interfaces.MainContainer;

public class SuperUser implements EntryPoint {

    private String msisdn;

    public void onModuleLoad() {
        MainContainer container = new MainContainer();
        Viewport viewport = new Viewport();
        viewport.setBorders(true);
        viewport.setWidget(container);
        DOM.getElementById("loading").removeFromParent();
        RootLayoutPanel.get().add(viewport);

    }
}
