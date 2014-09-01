package ua.company.gwt.client;

import com.google.gwt.user.client.rpc.AsyncCallback;

/**
 * @author EvgeniyKot on 11.07.2014.
 */
public interface GwtServiceAsync {
    // Sample interface method of remote interface
    void getMessage(String msg, AsyncCallback<String> async);
}
