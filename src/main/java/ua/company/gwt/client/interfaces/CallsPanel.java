package ua.company.gwt.client.interfaces;

import com.google.gwt.user.client.ui.FlexTable;
import ua.company.gwt.client.SuperClient;
import ua.company.gwt.client.services.SuperClientService;
import ua.company.gwt.shared.dto.CallInfo;

import java.util.List;

/**
 * @author Eugene on 02.11.2014
 */
public class CallsPanel extends AbstractDataPanel<List<CallInfo>> {

    private final Long account;

    public CallsPanel(Long account) {
        super();
        this.account = account;
    }

    @Override
    protected void requestData(DefaultAsyncCallback defaultAsyncCallback) {
        contentPanel.getHeader().setText(SuperClient.CONSTANTS.callsPanelTitle());
        SuperClientService.App.getInstance().getDocuments(account, defaultAsyncCallback);
    }

    @Override
    public void drawContent(List<CallInfo> data) {
        int i = 0;
        FlexTable dataTable = new FlexTable();
        for (CallInfo call : data) {
            dataTable.setText(i, 0, call.getCallType().toString());
            dataTable.setText(i, 1, call.getDestNumber());
            dataTable.setText(i, 2, String.valueOf(call.getStartDate()));
            dataTable.setText(i, 4, String.valueOf(call.getEndDate()));
            dataTable.setText(i++, 5, String.valueOf(call.getCost()));
        }
        mainPanel.setWidget(0, 0, dataTable);
        finish();
    }
}
