package ua.company.gwt.client.interfaces;

import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import com.google.gwt.dom.client.Style;
import com.google.gwt.user.client.ui.*;
import com.sencha.gxt.widget.core.client.ContentPanel;
import com.sencha.gxt.widget.core.client.container.BorderLayoutContainer;
import ua.company.gwt.client.resources.AppConstants;

/**
 * @author Eugene on 03.11.2014.
 */
public class MainContainer implements IsWidget {

    private AppConstants CONSTANTS = GWT.create(AppConstants.class);

    private BorderLayoutContainer container;

    public MainContainer() {
        container = new BorderLayoutContainer();
        BorderLayoutContainer.BorderLayoutData layoutData = new BorderLayoutContainer.BorderLayoutData(200);
        layoutData.setCollapsible(true);
        layoutData.setMaxSize(500);
        layoutData.setSplit(true);

        ContentPanel contentPanel = new ContentPanel();
        contentPanel.getHeader().setText(CONSTANTS.appTitle());
        contentPanel.setAllowTextSelection(false);

        container.setWestWidget(contentPanel, layoutData);
        container.setCenterWidget(createTabs());
    }

    public TabLayoutPanel createTabs() {
        TabLayoutPanel tabPanel = new TabLayoutPanel(2, Style.Unit.EM);
        final FlexTable htmlTable = new FlexTable();
        GWT.runAsync(new RunAsyncCallback() {
            @Override
            public void onFailure(Throwable reason) {

            }

            @Override
            public void onSuccess() {
                htmlTable.setWidget(0, 0, new DocumentsPanel());
            }
        });
        tabPanel.add(new ScrollPanel(htmlTable), "First Tab");
        tabPanel.add(new HTML("I am <i>html</i>"), "Second Tab");
        return tabPanel;
    }

    @Override
    public Widget asWidget() {
        return container;
    }
}