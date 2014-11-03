package ua.company.gwt.server;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import ua.company.gwt.client.services.AsyncPanelLoadingService;

/**
 * @author EvgeniyKot on 03.11.2014.
 */
public class AsyncPanelLoadingServiceImpl extends RemoteServiceServlet implements AsyncPanelLoadingService {
    @Override
    public String getPanelName() {
        return "panelName2";
    }
}
