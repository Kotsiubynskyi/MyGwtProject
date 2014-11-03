package ua.company.gwt.client.services;

import com.google.gwt.user.client.rpc.AsyncCallback;
import ua.company.gwt.client.Document;

import java.util.List;

/**
 * @author EvgeniyKot on 11.07.2014.
 */
public interface GwtServiceAsync {
    // Sample interface method of remote interface
    void getMessage(String msg, AsyncCallback<String> async);

    void getDocuments(AsyncCallback<List<Document>> async);

    void storeUserInSession(AsyncCallback<Void> async);

    void getUserFromSession(AsyncCallback<String> async);
}
