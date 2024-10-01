package org.virusoft;

import java.util.ArrayList;
import java.util.List;


public class NewsAgency{
  private String news; // The data that changes
  private final List<Channel> channels = new ArrayList<>(); // List of observers

  // Class Constructor
  public NewsAgency(String news){
    this.news = news;
  }

  // Method to register an observer
  public void addObserver(Channel channel){
    this.channels.add(channel);     // Add a new observer to the list
  }

  // Method to update data and notify observers
  public void setNews(String news){
    this.news = news;
    notifyObservers(); // Notify all observers of the change
  }

  // Method to notify all registered observers
  public void notifyObservers(){
    for (Channel channel: this.channels){
      channel.update(this.news);    // Notify each observer with the new data
    }
  }

}
