package ua.company.gwt.client.interfaces.keyhandler;

import com.google.gwt.user.client.Event;
import com.sencha.gxt.core.client.Style;
import com.sencha.gxt.widget.core.client.TabPanel;
import com.sencha.gxt.widget.core.client.container.BorderLayoutContainer;

/**
 * @author EvgeniyKot on 15.11.2014.
 */
public class KeyHandler {

    public static final int RIGHT_ARROW_KEY = 39;
    public static final int LEFT_ARROW_KEY = 37;
    public static final int W_KEY = 87;
    private static boolean initialized;

    private KeyHandler() {
    }

    public static void init(BorderLayoutContainer container) {
        if (!initialized) {
            TabPanel tabPanel = (TabPanel) container.getCenterWidget();
            initCloseTabKeyHandler(tabPanel);
            initTabPanelClickHandler(tabPanel);
            initWestPanelClickHandler(container);
            initialized = true;
        }
    }

    //Shift + W - close current tab
    private static void initCloseTabKeyHandler(final TabPanel tabPanel) {
        Event.addNativePreviewHandler(new Event.NativePreviewHandler() {
            @Override
            public void onPreviewNativeEvent(Event.NativePreviewEvent event) {
                if (event.getNativeEvent().getShiftKey()) {
                    if (event.getNativeEvent().getKeyCode() == W_KEY && event.getTypeInt() == Event.ONKEYUP)
                        //Next check of condition is important - do not delete
                        if (event.getNativeEvent().getShiftKey()) {
                            int tabIndex = tabPanel.getTabIndex();
                            if (tabIndex > 0) {
                                tabPanel.setTabIndex(tabIndex - 1);
                            }
                            tabPanel.remove(tabIndex);
                        }
                }
            }
        });
    }

    //Shift + (RIGHT_ARROW | LEFT_ARROW) - navigate between tabs
    private static void initTabPanelClickHandler(final TabPanel tabPanel) {
        Event.addNativePreviewHandler(new Event.NativePreviewHandler() {
            @Override
            public void onPreviewNativeEvent(Event.NativePreviewEvent event) {
                if (event.getNativeEvent().getShiftKey()) {
                    int selectedTab = tabPanel.getTabIndex();
                    if (event.getNativeEvent().getKeyCode() == RIGHT_ARROW_KEY && event.getTypeInt() == Event.ONKEYDOWN) {
                        if (selectedTab < tabPanel.getWidgetCount() - 1) {
                            tabPanel.setActiveWidget(tabPanel.getWidget(++selectedTab));
                            tabPanel.getActiveWidget().getElement().focus();
                        }
                    }
                    if (event.getNativeEvent().getKeyCode() == LEFT_ARROW_KEY && event.getTypeInt() == Event.ONKEYDOWN) {
                        if (selectedTab > 0) {
                            tabPanel.setActiveWidget(tabPanel.getWidget(--selectedTab));
                            tabPanel.getActiveWidget().getElement().focus();
                        }
                    }
                    tabPanel.setTabIndex(selectedTab);
                }
            }
        });
    }

    //Ctrl + (RIGHT_ARROW | LEFT_ARROW) - show/hide west west border panel
    private static void initWestPanelClickHandler(final BorderLayoutContainer container) {
        Event.addNativePreviewHandler(new Event.NativePreviewHandler() {
            @Override
            public void onPreviewNativeEvent(Event.NativePreviewEvent event) {
                if (event.getNativeEvent().getCtrlKey()) {
                    if (event.getNativeEvent().getKeyCode() == RIGHT_ARROW_KEY && event.getTypeInt() == Event.ONKEYDOWN) {
                        container.expand(Style.LayoutRegion.WEST);
                        container.getWestWidget().getElement().focus();
                    }
                    if (event.getNativeEvent().getKeyCode() == LEFT_ARROW_KEY && event.getTypeInt() == Event.ONKEYDOWN) {
                        container.collapse(Style.LayoutRegion.WEST);
                        container.getWestWidget();
                    }
                }
            }
        });
    }
}
