package ua.company.gwt.client.interfaces;

import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import com.google.gwt.dom.client.Style;
import com.google.gwt.user.client.ui.*;
import com.sencha.gxt.widget.core.client.ContentPanel;
import com.sencha.gxt.widget.core.client.container.BorderLayoutContainer;

/**
 * @author EvgeniyKot on 03.11.2014.
 */
public class MainContainer implements IsWidget {

    private BorderLayoutContainer container;

    public MainContainer() {
        container = new BorderLayoutContainer();
        BorderLayoutContainer.BorderLayoutData layoutData = new BorderLayoutContainer.BorderLayoutData(450);
        layoutData.setCollapsible(true);
        layoutData.setMaxSize(500);
        layoutData.setSplit(true);

        ContentPanel contentPanel = new ContentPanel();
        contentPanel.getHeader().setText("Super Client 2.0");
        contentPanel.getHeader().setAllowTextSelection(false);

        container.setWestWidget(contentPanel, layoutData);
        container.setCenterWidget(createTabs());
    }

    public TabLayoutPanel createTabs() {
        TabLayoutPanel tabPanel = new TabLayoutPanel(2, Style.Unit.EM);
        tabPanel.add(new DocumentsPanel(), "First Tab");
        tabPanel.add(new HTML("that"), "Second Tab");
        tabPanel.add(new SimplePanel(new Label("Simple Label")), "Third Tab");
        tabPanel.addStyleName("margins");
        return tabPanel;
    }

    @Override
    public Widget asWidget() {
        return container;
    }
}
