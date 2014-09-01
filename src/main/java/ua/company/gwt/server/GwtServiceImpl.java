package ua.company.gwt.server;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import ua.company.gwt.client.GwtService;

public class GwtServiceImpl extends RemoteServiceServlet implements GwtService {
    public String getMessage(String msg) {
        return "Client said: \"" + msg + "\"<br>Server answered: \"Hi!\"";
    }
}