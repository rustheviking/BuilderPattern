package org.virusoft;

public class Main{

    public static void main(String[] args){
        NewsAgency newsAgency = new NewsAgency("No news");
        NewsChannel channelOne = new NewsChannel();
        newsAgency.addObserver(channelOne); // Add a new observer to the list
        newsAgency.setNews("Election have started!");
    }
}
