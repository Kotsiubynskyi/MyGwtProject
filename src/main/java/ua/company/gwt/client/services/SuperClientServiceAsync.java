package ua.company.gwt.client.services;

import com.google.gwt.user.client.rpc.AsyncCallback;
import ua.company.gwt.shared.dto.CallInfo;

import java.util.List;

/**
 * @author Eugene on 11.07.2014.
 */
public interface SuperClientServiceAsync {
    void getDocuments(Long account, AsyncCallback<List<CallInfo>> async);
}
