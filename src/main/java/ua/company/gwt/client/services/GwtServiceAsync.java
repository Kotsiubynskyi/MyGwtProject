package ua.company.gwt.client.services;

import com.google.gwt.user.client.rpc.AsyncCallback;
import ua.company.gwt.shared.dto.Document;

import java.util.List;

/**
 * @author Eugene on 11.07.2014.
 */
public interface GwtServiceAsync {
    void getDocuments(AsyncCallback<List<Document>> async);
}
