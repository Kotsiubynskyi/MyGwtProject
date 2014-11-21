package ua.company.gwt.client.interfaces;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiTemplate;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.ScrollPanel;
import com.sencha.gxt.widget.core.client.ContentPanel;
import com.sencha.gxt.widget.core.client.TabPanel;
import com.sencha.gxt.widget.core.client.button.ToolButton;
import com.sencha.gxt.widget.core.client.event.SelectEvent;
import com.sencha.gxt.widget.core.client.toolbar.FillToolItem;
import ua.company.gwt.client.SuperClient;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Eugene on 09.11.2014
 */
//Tab widget which contains all child panels with information about client
public class Tab extends Composite {
    private final TabPanel tabPanel;
    private List<Refreshable> tabWidgets = new ArrayList<Refreshable>();

    public Tab(Long account, TabPanel tabPanel) {
        super();
        this.tabPanel = tabPanel;
        callsPanel1 = new CallsPanel(account);
        callsPanel2 = new CallsPanel(account);
        tabWidgets.add(callsPanel1);
        tabWidgets.add(callsPanel2);

        initWidget(ourUiBinder.createAndBindUi(this));
        cntPanel.setBodyBorder(false);
        cntPanel.getBody().applyStyles("background-color: #BDD3EF");
        this.addTools();
    }

    private void addTools() {
        ToolButton refreshTool = new ToolButton(ToolButton.REFRESH);
        refreshTool.addSelectHandler(new SelectEvent.SelectHandler() {
            @Override
            public void onSelect(SelectEvent selectEvent) {
                for (Refreshable widget : tabWidgets) {
                    widget.refresh();
                }
            }
        });
        ToolButton closeTool = new ToolButton(ToolButton.CLOSE);
        closeTool.setTitle(SuperClient.CONSTANTS.closeTab());
        closeTool.addSelectHandler(new SelectEvent.SelectHandler() {
            @Override
            public void onSelect(SelectEvent selectEvent) {
                tabPanel.remove(tabPanel.getActiveWidget());
            }
        });
        cntPanel.addTool(refreshTool);
        cntPanel.addTool(new FillToolItem());
        cntPanel.addTool(closeTool);
    }

    private static TabUiBinder ourUiBinder = GWT.create(TabUiBinder.class);

    @UiTemplate("templates/Tab.ui.xml")
    interface TabUiBinder extends UiBinder<ScrollPanel, Tab> {
    }

    @UiField(provided = true)
    CallsPanel callsPanel2;
    @UiField(provided = true)
    CallsPanel callsPanel1;
    @UiField
    ContentPanel cntPanel;
}
