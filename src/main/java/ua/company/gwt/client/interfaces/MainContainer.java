package ua.company.gwt.client.interfaces;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiTemplate;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Widget;
import com.sencha.gxt.widget.core.client.TabPanel;
import com.sencha.gxt.widget.core.client.container.BorderLayoutContainer;
import ua.company.gwt.client.interfaces.keyhandler.KeyHandler;

/**
 * @author Eugene on 03.11.2014
 */
public class MainContainer implements IsWidget {

    @UiField(provided = true)
    WestBorderPanel westBorderPanel;
    @UiField
    TabPanel tabPanel;
    private BorderLayoutContainer container;
    private static MainContainerUiBinder ourUiBinder = GWT.create(MainContainerUiBinder.class);

    @UiTemplate("templates/MainContainer.ui.xml")
    interface MainContainerUiBinder extends UiBinder<BorderLayoutContainer, MainContainer> {
    }

    public MainContainer() {
        westBorderPanel = new WestBorderPanel();
        container = ourUiBinder.createAndBindUi(this);
        westBorderPanel.setTabPanel(tabPanel);
        tabPanel.getContainer().addStyleName("background");
        KeyHandler.init(container);
    }

    @Override
    public Widget asWidget() {
        return container;
    }

    public WestBorderPanel getWestBorderPanel() {
        return westBorderPanel;
    }
}