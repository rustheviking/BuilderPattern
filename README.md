# ObserverPattern

## Overview

The Observer Pattern is useful when you want certain objects (observers) to be notified and updated automatically when another object (subject) changes. For your JavaFX school cafeteria POS project, this pattern can help keep different parts of the UI updated when the data (like orders, menu items, etc.) changes.

Let’s break it down simply:
## Basic Idea:

  - **Subject**: The object that holds the data and notifies observers when the data changes.
  - **Observer**: Objects that watch the subject. When the subject’s state changes, the observer is automatically updated.

## Steps to Implement the Observer Pattern in Java:

   1. Create an Observer Interface.
   2. Create a Subject Class.
   3. Update Observers when the Subject Changes.

## Here’s a simple example:
  1. Create an Observer Interface:

  This interface will be implemented by any object that needs to be updated when the subject changes.

    public interface Observer {
        void update(String data);  // This method will be called when data changes
    }
  2. Create a Subject Class:
  
  This class manages a list of observers and notifies them when its data changes.

    import java.util.ArrayList;
    import java.util.List;
    
    public class Subject {
        private List<Observer> observers = new ArrayList<>();  // List of observers
        private String data;  // The data that changes
    
        // Method to register an observer
        public void addObserver(Observer observer) {
            observers.add(observer);
        }
    
        // Method to update data and notify observers
        public void setData(String newData) {
            this.data = newData;
            notifyObservers();  // Notify all observers of the change
        }
    
        // Method to notify all registered observers
        private void notifyObservers() {
            for (Observer observer : observers) {
                observer.update(this.data);
            }
        }
    }

  3. Create an Observer Class (e.g., UI component in JavaFX):

  This class will update its display whenever the data in the subject changes.

    public class Display implements Observer {
      private String name;

    public Display(String name) {
        this.name = name;
    }

    @Override
    public void update(String data) {
        System.out.println(name + " updated with new data: " + data);
        // In your JavaFX project, this could update a UI label, table, etc.
      }
    }

  4. Using the Observer Pattern in Your Project:
  
  Let’s say you want different UI components (like a list of orders) to update when new orders come in.

    public class CafeteriaPOS {
        public static void main(String[] args) {
            Subject orderSystem = new Subject();  // The subject managing orders
    
            // Observers (UI components, for example)
            Display cashierDisplay = new Display("Cashier Display");
            Display kitchenDisplay = new Display("Kitchen Display");
    
            // Register observers
            orderSystem.addObserver(cashierDisplay);
            orderSystem.addObserver(kitchenDisplay);
    
            // New order comes in, update all displays
            orderSystem.setData("Order #123: 2 Sandwiches, 1 Coffee");
        }
    }
## How It Works:

  - You have a Subject that holds the current data (like a new order in the cafeteria).
  - When the data changes (e.g., a new order is placed), the Subject notifies all Observers (like the cashier display and kitchen display).
  - The Observers automatically update themselves with the new data, so the cashier and kitchen staff can see the order.

## How to Apply in JavaFX:

In your JavaFX project, the Observer classes could be controllers or UI elements, like tables or labels, that display order details. You can update them when the data changes (like a new order coming in).

For example, you can:

  - Create an OrderList subject that manages all the orders.
  - Register UI components (like an order list in the kitchen or cashier view) as observers.
  - When a new order is added, the UI components are automatically updated to reflect the changes.

This way, the Observer Pattern helps keep everything in sync without needing a lot of manual updating.
