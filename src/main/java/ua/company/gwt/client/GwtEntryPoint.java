package ua.company.gwt.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.dom.client.Style;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.*;
import com.sencha.gxt.widget.core.client.ContentPanel;
import com.sencha.gxt.widget.core.client.container.BorderLayoutContainer;
import ua.company.gwt.client.interfaces.DraggablePanel;

public class GwtEntryPoint implements EntryPoint {

    public void onModuleLoad() {
        Window.setTitle("Super Client 2.0");

        TabLayoutPanel p = new TabLayoutPanel(2, Style.Unit.EM);
        Label label = new Label("new Content <br /> sdfsd<br />sdf<br />sdf");
        p.add(new DraggablePanel(label), "Основная информация по абоненту");
        p.add(new HTML("that"), "Детализированая информация по абоненту");
        p.add(new SimplePanel(new Label("Simple Label")), "Информация по услугам");

        com.sencha.gxt.widget.core.client.Window window = new com.sencha.gxt.widget.core.client.Window();

        window.setMaximizable(true);

        window.setSize("500px", "500px");
        window.setDraggable(true);
        window.setAnimationDuration(100);
        window.getHeader().setText("I am window");
        window.setAllowTextSelection(false);
        window.setClosable(true);

        p.add(new SimplePanel(window), "Window");

        BorderLayoutContainer container = new BorderLayoutContainer();

        BorderLayoutContainer.BorderLayoutData layoutData = new BorderLayoutContainer.BorderLayoutData(450);
        layoutData.setCollapsible(true);
        layoutData.setMaxSize(500);
        layoutData.setSplit(true);
        ContentPanel contentPanel = new ContentPanel();

        contentPanel.getHeader().setText("Light Client 3.0");
        contentPanel.getHeader().setAllowTextSelection(false);
        contentPanel.setAnimationDuration(1000);
        p.addStyleName("margins");

        container.setWestWidget(contentPanel, layoutData);
        container.setCenterWidget(p);
        RootLayoutPanel.get().add(container);

    }
}
