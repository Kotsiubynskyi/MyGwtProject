package ua.company.gwt.client.services;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

/**
 * @author Eugene on 03.11.2014.
 */
@RemoteServiceRelativePath("panelService")
public interface AsyncPanelLoadingService extends RemoteService{

    String getPanelName();

    public static class App {
        private static AsyncPanelLoadingServiceAsync ourInstance = GWT.create(AsyncPanelLoadingService.class);

        public static synchronized AsyncPanelLoadingServiceAsync getInstance() {
            return ourInstance;
        }
    }

}
