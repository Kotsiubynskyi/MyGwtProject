package ua.company.gwt.client.interfaces;

import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.SimplePanel;

public class FirstDataPanel extends SimplePanel {

    public FirstDataPanel() {
        super();
        setWidget(new Label("Simple Panel Label"));
    }
}
