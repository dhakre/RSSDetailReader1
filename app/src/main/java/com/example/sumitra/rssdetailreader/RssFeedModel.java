package com.example.sumitra.rssdetailreader;

import java.io.Serializable;

/**
 * Created by sumitra on 11/13/2017.
 */

public class RssFeedModel implements Serializable {

    public String title;
    public String link;
    public String description;


    public RssFeedModel(String title, String link, String description) {
        this.title = title;
        this.link = link;
        this.description = description;

    }
}
