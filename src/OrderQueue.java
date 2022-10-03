// Java Program to Implement Queue using Array and Generics
 
import java.io.*;
import java.util.*;
 

class OrderQueue<T> {
    int front = -1, rear = -1;
    // Creating an object of ArrayList class of T type
    ArrayList<T> A = new ArrayList<>();
 
    T front()
    {
       
        if (front == -1)
            return null;
 
        return A.get(front);
    }

    T rear()
    {
        // If it is not pointing to any element in queue
        if (rear == -1)
            return null;
        return A.get(rear);
    }

    void enqueue(T X)
    {
        // If queue is empty
        if (this.empty()) {
            front = 0;
            rear = 0;
            A.add(X);
        }
 
        // If queue is not empty
        else {
            rear++;
            if (A.size() > rear) {
 
                // Mov rear pointer to next
                A.set(rear, X);
            }
            else
 
                // Add element to the queue
                A.add(X);
        }
    }
    // Method 4
    // Deletes elements from the rear from queue
    void dequeue()
    {
        // if queue doesn't have any elements
        if (this.empty())
 
            // Display message when queue is already empty
            System.out.println("Queue is already empty");
 
        // If queue has only one element
        else if (front == rear) {
 
            // Both are pointing to same element
            front = rear = -1;
        }
 
        // If queue has more than one element
        else {
 
            // Increment the rear
            front++;
        }
    }
 
    // Method 5
    // Checks whether the queue is empty
    boolean empty()
    {
        // Both are initialized to same value
        // as assigned at declaration means no queue made
        if (front == -1 && rear == -1)
            return true;
        return false;
    }
    // Method 6
    // Print the queue
 
    // @Override
    public String toString()
    {
        if (this.empty())
            return "";
 
        String Ans = "";
 
        for (int i = front; i < rear; i++) {
            Ans += String.valueOf(A.get(i)) + "->";
        }
 
        Ans += String.valueOf(A.get(rear));
 
        return Ans;
    }
}