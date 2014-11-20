package ua.company.gwt.client.interfaces;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiTemplate;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.Label;
import com.sencha.gxt.widget.core.client.ContentPanel;
import com.sencha.gxt.widget.core.client.button.ToolButton;
import com.sencha.gxt.widget.core.client.event.SelectEvent;
import ua.company.gwt.client.SuperUser;

//Parent class for every panel which contains data
public abstract class AbstractDataPanel<T> extends Composite implements Refreshable {

    FlexTable mainPanel;
    @UiField
    ContentPanel contentPanel;
    @UiField
    Label loadingField;

    private static DataPanelUiBinder ourUiBinder = GWT.create(DataPanelUiBinder.class);

    @UiTemplate("templates/AbstractDataPanel.ui.xml")
    interface DataPanelUiBinder extends UiBinder<ContentPanel, AbstractDataPanel> {
    }

    public AbstractDataPanel() {
        mainPanel = new FlexTable();
        initWidget(ourUiBinder.createAndBindUi(this));
        loadingField.setText(SuperUser.CONSTANTS.loading());
        contentPanel.getHeader().addStyleName("pointer-cursor");
        contentPanel.getHeader().setAllowTextSelection(false);
        ToolButton refreshButton = new ToolButton(ToolButton.REFRESH);
        refreshButton.addSelectHandler(new SelectEvent.SelectHandler() {
            @Override
            public void onSelect(SelectEvent selectEvent) {
                refresh();
            }
        });
        contentPanel.addTool(refreshButton);
        requestData(new DefaultAsyncCallback());
    }

    protected abstract void requestData(DefaultAsyncCallback defaultAsyncCallback);

    public abstract void drawContent(T data);

    protected class DefaultAsyncCallback implements AsyncCallback<T> {
        @Override
        public void onFailure(Throwable caught) {
            contentPanel.setWidget(new Label(SuperUser.CONSTANTS.failureOccurred()));
        }

        @Override
        public void onSuccess(T data) {
            drawContent(data);
        }
    }

    //Have to be called every time when panel drawing is finished
    protected void finish() {
        contentPanel.clear();
        contentPanel.setWidget(mainPanel);
    }


    public void refresh() {
        mainPanel.clear(true);
        mainPanel.setWidget(0, 0, loadingField);
        requestData(new DefaultAsyncCallback());
    }
}
