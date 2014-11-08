package ua.company.gwt.client.interfaces;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;
import com.sencha.gxt.widget.core.client.FramedPanel;
import ua.company.gwt.client.resources.AppConstants;

public abstract class MainPanel extends InterfaceElement implements IsWidget {
    protected FramedPanel contentPanel;
    protected static final AppConstants CONSTANTS = GWT.create(AppConstants.class);

    public MainPanel() {
        contentPanel = new FramedPanel();
        contentPanel.getStyleName();
        contentPanel.getStylePrimaryName();
        setPanelContent(new Label(CONSTANTS.loading()));
        drawContent();
    }

    public abstract void drawContent();

    public Widget asWidget() {
        contentPanel.setAnimCollapse(false);
        contentPanel.setHeadingText(title);
        return contentPanel;
    }

    public void setPanelContent(Widget panelContent) {
        contentPanel.setWidget(panelContent);
    }

    protected abstract class AbstractCallback<T> implements AsyncCallback<T> {
        @Override
        public void onFailure(Throwable caught) {
            setPanelContent(new Label(CONSTANTS.failureOccurred()));
        }
    }

}