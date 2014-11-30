package ua.company.gwt.server;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import ua.company.gwt.client.services.SuperClientService;
import ua.company.gwt.shared.dto.CallInfo;
import ua.company.gwt.shared.dto.CallType;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Eugene on 01.11.2014.
 */
public class SuperClientServiceImpl extends RemoteServiceServlet implements SuperClientService {

    @Override
    public List<CallInfo> getDocuments(Long account) {
        List<CallInfo> calls = new ArrayList<CallInfo>();
        for (int i = 0; i < 10; i++) {
            calls.add(new CallInfo("093988105" + i, 50000, 1, i % 2 == 0 ? CallType.IN : CallType.OUT, 141645960000L + i, 141645965000L + i));
        }
        try {
            Thread.sleep(800);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return calls;
    }
}