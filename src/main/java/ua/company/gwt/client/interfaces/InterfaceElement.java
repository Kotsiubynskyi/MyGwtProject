package ua.company.gwt.client.interfaces;

import com.google.gwt.user.client.ui.IsWidget;

/**
 * @author EvgeniyKot on 03.11.2014.
 */
public abstract class InterfaceElement implements IsWidget{

    protected String title;
    protected int width = 400;
    protected int height = 250;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}
