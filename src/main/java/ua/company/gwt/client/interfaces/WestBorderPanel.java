package ua.company.gwt.client.interfaces;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.uibinder.client.UiTemplate;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.ScrollPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;
import com.sencha.gxt.widget.core.client.ContentPanel;
import com.sencha.gxt.widget.core.client.TabItemConfig;
import com.sencha.gxt.widget.core.client.TabPanel;
import com.sencha.gxt.widget.core.client.event.SelectEvent;
import com.sencha.gxt.widget.core.client.info.Info;

/**
 * @author EvgeniyKot on 13.11.2014
 */
public class WestBorderPanel implements IsWidget {
    private TabPanel tabPanel;
    @UiField
    TextBox accountTextBox;
    ContentPanel contentPanel;

    @UiTemplate("templates/WestPanel.ui.xml")
    interface WestPanelUiBinder extends UiBinder<ContentPanel, WestBorderPanel> {
    }

    private static WestPanelUiBinder westPanelUiBinder = GWT.create(WestPanelUiBinder.class);

    public WestBorderPanel(TabPanel tabPanel) {
        this.tabPanel = tabPanel;
        contentPanel = westPanelUiBinder.createAndBindUi(this);
    }

    @UiHandler("requestButton")
    void onSelect(SelectEvent event) {
        Long account = null;
        try {
            account = Long.valueOf(accountTextBox.getText());
        } catch (NumberFormatException e) {
            Info.display("Error", "Invalid number");
        }
        if (account != null) {
            createNewTab(account);
        }
    }

    private void createNewTab(Long account) {
        Tab newTab = new Tab(account, tabPanel);
        Widget tabWidget = new ScrollPanel(newTab);
        TabItemConfig tabItemConfig = new TabItemConfig("Client [" + account + "]");
        if (!tabPanel.isAttached() || tabPanel == null) {
            tabPanel = new TabPanel();
        }
        tabPanel.add(tabWidget, tabItemConfig);

        //move to last created tab
        tabPanel.setActiveWidget(tabPanel.getWidget(tabPanel.getWidgetCount() - 1));
        tabPanel.setTabIndex(tabPanel.getWidgetCount() - 1);
    }

    public TextBox getAccountTextBox() {
        return accountTextBox;
    }

    @Override
    public Widget asWidget() {
        return contentPanel;
    }
}