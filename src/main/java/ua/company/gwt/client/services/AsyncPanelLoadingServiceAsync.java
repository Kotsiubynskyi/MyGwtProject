package ua.company.gwt.client.services;

import com.google.gwt.user.client.rpc.AsyncCallback;

/**
 * @author Eugene on 03.11.2014.
 */
public interface AsyncPanelLoadingServiceAsync {

    void getPanelName(AsyncCallback<String> panelName);

}
