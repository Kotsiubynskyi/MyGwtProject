package ua.company.gwt.client.interfaces;

import com.google.gwt.dom.client.Style;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.Widget;
import com.sencha.gxt.fx.client.Draggable;
import com.sencha.gxt.widget.core.client.FramedPanel;

public abstract class DraggablePanel extends InterfaceElement implements IsWidget {
    private SimplePanel container;
    protected FramedPanel contentPanel;
    protected Widget content;
    protected Draggable d;

    public DraggablePanel() {
        drawContent();
    }

    public abstract void drawContent();

    public Widget asWidget() {

        container = new SimplePanel();
        contentPanel = new FramedPanel();
        contentPanel.setWidth("500px");
        contentPanel.setAnimCollapse(false);
        contentPanel.setCollapsible(true);
        contentPanel.setHeadingText("Heading Text");
        contentPanel.getHeader().getElement().getStyle().setCursor(Style.Cursor.POINTER);
        contentPanel.getHeader().setAllowTextSelection(false);
        d = new Draggable(contentPanel, contentPanel.getHeader());
        container.setWidget(contentPanel);
        d.setUseProxy(false);
        return container;
    }

}