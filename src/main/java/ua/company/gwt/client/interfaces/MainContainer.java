package ua.company.gwt.client.interfaces;

import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Widget;
import com.sencha.gxt.widget.core.client.TabPanel;
import com.sencha.gxt.widget.core.client.container.BorderLayoutContainer;
import com.sencha.gxt.widget.core.client.container.BorderLayoutContainer.BorderLayoutData;
import ua.company.gwt.client.interfaces.keyhandler.KeyHandler;

/**
 * @author Eugene on 03.11.2014
 */
public class MainContainer implements IsWidget {
    private BorderLayoutData layoutData;
    private BorderLayoutContainer container;
    private WestBorderPanel westBorderPanel;
    private TabPanel tabPanel;

    public MainContainer() {
        container = new BorderLayoutContainer();
        layoutData = new BorderLayoutData(300);
        layoutData.setCollapsible(true);
        layoutData.setMaxSize(300);
        layoutData.setMinSize(300);
        layoutData.setSplit(true);

        tabPanel = new TabPanel();
        tabPanel.setAutoSelect(true);
        tabPanel.setTabScroll(true);
        tabPanel.setCloseContextMenu(true);
        tabPanel.getContainer().addStyleName("background");

        westBorderPanel = new WestBorderPanel(tabPanel);
        westBorderPanel.accountTextBox.getElement().focus();
        container.setWestWidget(westBorderPanel, layoutData);
        container.setCenterWidget(tabPanel);

        KeyHandler.init(container);
    }

    public WestBorderPanel getWestBorderPanel() {
        return westBorderPanel;
    }

    @Override
    public Widget asWidget() {
        return container;
    }
}