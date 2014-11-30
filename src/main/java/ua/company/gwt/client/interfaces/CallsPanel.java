package ua.company.gwt.client.interfaces;

import com.google.gwt.core.client.GWT;
import com.sencha.gxt.data.shared.ListStore;
import com.sencha.gxt.widget.core.client.grid.ColumnConfig;
import com.sencha.gxt.widget.core.client.grid.ColumnModel;
import com.sencha.gxt.widget.core.client.grid.Grid;
import ua.company.gwt.client.SuperClient;
import ua.company.gwt.client.services.SuperClientService;
import ua.company.gwt.shared.dto.CallInfo;
import ua.company.gwt.shared.dto.CallInfoProperties;
import ua.company.gwt.shared.dto.CallType;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Eugene on 02.11.2014
 */
public class CallsPanel extends AbstractDataPanel<List<CallInfo>> {

    private static final CallInfoProperties callProp = GWT.create(CallInfoProperties.class);

    private final Long account;

    public CallsPanel(Long account) {
        List<CallInfo> calls = new ArrayList<CallInfo>();
        for (int i = 0; i < 10; i++) {
            calls.add(new CallInfo("093988105" + i, 50000, 1, i % 2 == 0 ? CallType.IN : CallType.OUT, 141645960000L + i, 141645965000L + i));
        }
        this.account = account;
        drawContent(calls);
    }

    @Override
    protected void requestData(DefaultAsyncCallback callback) {
        contentPanel.getHeader().setText(SuperClient.CONSTANTS.callsPanelTitle());
        SuperClientService.App.getInstance().getDocuments(account, callback);
    }

    @Override
    public void drawContent(List<CallInfo> data) {
        mainPanel.clear();

        ListStore<CallInfo> store = new ListStore<CallInfo>(callProp.startDate());
        store.addAll(data);

        final ColumnConfig<CallInfo, Long> startDateCol  = new ColumnConfig<CallInfo, Long>(callProp.startDateCol(), 110, "StartDate");
        final ColumnConfig<CallInfo, Long> endDateCol = new ColumnConfig<CallInfo, Long>(callProp.endDate(), 110, "EndDate");
        final ColumnConfig<CallInfo, Long> durationCol = new ColumnConfig<CallInfo, Long>(callProp.callDuration(), 78, "Duration");
        final ColumnConfig<CallInfo, Double> cost = new ColumnConfig<CallInfo, Double>(callProp.cost(), 55, "Cost");
        final ColumnConfig<CallInfo, CallType> callTypeCol = new ColumnConfig<CallInfo, CallType>(callProp.callType(), 78, "CallType");
        final ColumnConfig<CallInfo, String> destNumberCol = new ColumnConfig<CallInfo, String>(callProp.destNumber(), 145,"Destination Number");
        callTypeCol.setMenuDisabled(true);

        ColumnModel<CallInfo> columnModel = new ColumnModel<CallInfo>(new ArrayList<ColumnConfig<CallInfo, ?>>() {
            {
                add(callTypeCol);
                add(destNumberCol);
                add(startDateCol);
                add(endDateCol);
                add(durationCol);
                add(cost);
            }
        });

        Grid<CallInfo> cellTable = new Grid<CallInfo>(store, columnModel);
        mainPanel.setWidget(0, 0, cellTable);
        finish();
    }
}
