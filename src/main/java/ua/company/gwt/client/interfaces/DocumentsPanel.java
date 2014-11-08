package ua.company.gwt.client.interfaces;

import com.google.gwt.user.client.ui.FlexTable;
import ua.company.gwt.client.services.GwtService;
import ua.company.gwt.shared.dto.Document;

import java.util.List;

/**
 * @author Eugene on 02.11.2014.
 */
public class DocumentsPanel extends MainPanel {

    @Override
    public void drawContent() {
        setTitle(CONSTANTS.docPaneTitle());
        GwtService.App.getInstance().getDocuments(new AbstractCallback<List<Document>>() {
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
                setPanelContent(dataTable);
            }
        });
    }
}
