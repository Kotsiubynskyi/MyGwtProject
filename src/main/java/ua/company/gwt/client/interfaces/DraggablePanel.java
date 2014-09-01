package ua.company.gwt.client.interfaces;

import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.Widget;
import com.sencha.gxt.fx.client.Draggable;
import com.sencha.gxt.widget.core.client.FramedPanel;

public class DraggablePanel implements IsWidget {
    private SimplePanel container;
    FramedPanel contentPanel;
    Widget content;
    Draggable d;

    public DraggablePanel(Widget content) {
        this.content = content;
    }

    public Widget asWidget() {
        container = new SimplePanel();
        contentPanel = new FramedPanel();

        contentPanel.setAnimCollapse(true);
        contentPanel.setCollapsible(true);
        contentPanel.setAnimationDuration(100);
        contentPanel.setHeadingText("Heading Text");
        contentPanel.add(content);
        d = new Draggable(contentPanel, contentPanel.getHeader());
        container.setWidget(contentPanel);
        d.setUseProxy(false);
        return container;
    }

}