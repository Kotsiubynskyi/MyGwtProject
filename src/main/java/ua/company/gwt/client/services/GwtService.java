package ua.company.gwt.client.services;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import ua.company.gwt.client.Document;

import java.util.List;

@RemoteServiceRelativePath("gwtService")
public interface GwtService extends RemoteService {

    String getMessage(String msg);

    List<Document> getDocuments();

    void storeUserInSession();

    String getUserFromSession();

    public static class App {
        private static GwtServiceAsync ourInstance = GWT.create(GwtService.class);

        public static synchronized GwtServiceAsync getInstance() {
            return ourInstance;
        }
    }
}
