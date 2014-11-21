package ua.company.gwt.client.services;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import ua.company.gwt.shared.dto.CallInfo;

import java.util.List;

@RemoteServiceRelativePath("gwtService")
public interface SuperClientService extends RemoteService {

    List<CallInfo> getDocuments(Long account);

    public static class App {
        private static SuperClientServiceAsync ourInstance = GWT.create(SuperClientService.class);

        public static synchronized SuperClientServiceAsync getInstance() {
            return ourInstance;
        }
    }
}
