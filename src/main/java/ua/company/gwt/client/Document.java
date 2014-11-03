package ua.company.gwt.client;

import java.io.Serializable;
import java.util.Date;

/**
 * @author EvgeniyKot on 16.07.2014.
 */

public class Document implements Serializable {

    private String title;
    private String description;
    private Date date;
    private int numberOfPages;
    private String author;

    public Document() {
    }

    public Document(String title, String description, Date date, int numberOfPages, String author) {
        this.title = title;
        this.description = description;
        this.date = date;
        this.numberOfPages = numberOfPages;
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public void setNumberOfPages(int numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "Document{" +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", date=" + date +
                ", numberOfPages=" + numberOfPages +
                ", author='" + author + '\'' +
                '}';
    }
}
