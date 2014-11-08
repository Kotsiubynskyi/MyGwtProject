package ua.company.gwt.server;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import ua.company.gwt.client.services.GwtService;
import ua.company.gwt.shared.dto.Document;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * @author Eugene on 01.11.2014.
 */
public class GwtServiceImpl extends RemoteServiceServlet implements GwtService {

    @Override
    public List<Document> getDocuments() {
        List<Document> documents = new ArrayList<Document>();
        for (int i = 0; i < 10; i++) {
            documents.add(new Document("DocTitle", "desc", new Date(), 7, "me"));
        }
        return documents;
    }
}