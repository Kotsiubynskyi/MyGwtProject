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
import com.sencha.gxt.widget.core.client.info.DefaultInfoConfig;
import com.sencha.gxt.widget.core.client.info.Info;
import com.sencha.gxt.widget.core.client.info.InfoConfig;

/**
 * @author EvgeniyKot on 13.11.2014
 */
public class WestBorderPanel implements IsWidget {
    TabPanel tabPanel;
    @UiField
    TextBox accountTextBox;
    ContentPanel contentPanel;


    @UiTemplate("templates/WestBorderPanel.ui.xml")
    interface WestBorderPanelUiBinder extends UiBinder<ContentPanel, WestBorderPanel> {
    }

    private static WestBorderPanelUiBinder westBorderPanelUiBinder = GWT.create(WestBorderPanelUiBinder.class);

    public WestBorderPanel() {
        contentPanel = westBorderPanelUiBinder.createAndBindUi(this);
    }

    public void setTabPanel(TabPanel tabPanel) {
        this.tabPanel = tabPanel;
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
        Widget w = tabPanel.findItem("Client [" + account + "]", true);
        if (w != null) {
            tabPanel.setActiveWidget(w);
            tabPanel.setTabIndex(tabPanel.getWidgetIndex(w));
            InfoConfig ic = new DefaultInfoConfig("Notification", "Tab with this client account is already opened");
            ic.setDisplay(4000);
            Info.display(ic);
            return;
        }

        Tab newTab = new Tab(account, tabPanel);
        Widget tabWidget = new ScrollPanel(newTab);
        TabItemConfig tabItemConfig = new TabItemConfig("Client [" + account + "]");
        if (!tabPanel.isEnabled()) tabPanel.enable();
        tabPanel.add(tabWidget, tabItemConfig);

        //move to last created tab
        tabPanel.setActiveWidget(tabPanel.getWidget(tabPanel.getWidgetCount() - 1));
        tabPanel.setTabIndex(tabPanel.getWidgetCount() - 1);
    }

    @Override
    public Widget asWidget() {
        return contentPanel;
    }

    public TextBox getAccountTextBox() {
        return accountTextBox;
    }
}
