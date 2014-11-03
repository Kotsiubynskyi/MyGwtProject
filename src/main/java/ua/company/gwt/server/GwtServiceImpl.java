package ua.company.gwt.server;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import ua.company.gwt.client.Document;
import ua.company.gwt.client.services.GwtService;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class GwtServiceImpl extends RemoteServiceServlet implements GwtService {
    public String getMessage(String msg) {
        return "Client said: \"" + msg + "\"<br>Server answered: \"Hi!\"";
    }

    @Override
    public List<Document> getDocuments() {
        List<Document> documents = new ArrayList<Document>();
        for (int i = 0; i < 10; i++) {
            documents.add(new Document("title", "description", new Date(), 5, "me"));
        }
        return documents;
    }

    @Override
    public void storeUserInSession() {
        HttpServletRequest request = this.getThreadLocalRequest();
        request.getSession(true).setAttribute("msisdn","684546");
    }

    @Override
    public String getUserFromSession() {
        HttpServletRequest request = this.getThreadLocalRequest();
        return (String) request.getSession().getAttribute("msisdn");
    }


}