package ua.company.gwt.client.interfaces;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.Label;
import ua.company.gwt.client.Document;
import ua.company.gwt.client.services.GwtService;

import java.util.List;

/**
 * @author Eugene on 02.11.2014.
 */
public class DocumentsPanel extends DraggablePanel {
    @Override
    public void drawContent() {
        GwtService.App.getInstance().getDocuments(new AsyncCallback<List<Document>>() {
            @Override
            public void onFailure(Throwable throwable) {
                content = new Label("Failure occurred while getting documents");
            }

            @Override
            public void onSuccess(List<Document> documents) {
                FlexTable dataTable = new FlexTable();
                int row = 0;
                for (Document doc : documents) {
                    dataTable.setText(row, 0, doc.getTitle());
                    dataTable.setText(row, 1, doc.getDescription());
                    dataTable.setText(row, 2, String.valueOf(doc.getNumberOfPages()));
                    dataTable.setText(row, 3, doc.getDate().toString());
                    dataTable.setText(row++, 4, doc.getAuthor());
                }
                contentPanel.setWidget(dataTable);
            }
        });
    }
}
