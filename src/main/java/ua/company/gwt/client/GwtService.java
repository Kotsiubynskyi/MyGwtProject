package ua.company.gwt.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("gwtService")
public interface GwtService extends RemoteService {

    String getMessage(String msg);

    public static class App {
        private static GwtServiceAsync ourInstance = GWT.create(GwtService.class);

        public static synchronized GwtServiceAsync getInstance() {
            return ourInstance;
        }
    }
}
