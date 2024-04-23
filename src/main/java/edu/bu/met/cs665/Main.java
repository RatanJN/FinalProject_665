/**
 * Name: Ratan Jagath Naik
 * Course: CS-665 Software Designs & Patterns
 * Date: 04/15/2024
 * File Name: Main.java
 * Description: This Main class serves as the entry point for the chat application. It sets up
 *              the chat environment, including creating chat rooms and adding clients, and then
 *              sends a message to demonstrate the basic functionality of the chat system.
 */

package edu.bu.met.cs665;

import edu.bu.met.cs665.implementations.ChatClient;
import edu.bu.met.cs665.implementations.ChatManager;
import edu.bu.met.cs665.implementations.ChatRoom;
import edu.bu.met.cs665.implementations.Message;

/**
 * The Main class initializes and runs the chat application.
 */
public class Main {

  /**
   * Main method to demonstrate the functionality of the chat system.
   * This method sets up a chat manager, creates a chat room, adds clients, and sends a message.
   * It is used primarily for testing and demonstration purposes and complements the JUnit tests
   * that are required for each assignment and final project.
   */
  public static void main(String[] args) {
    ChatManager manager = ChatManager.getInstance();  // Singleton ChatManager
    manager.createChatRoom("General");                // Create a chat room named "General"

    ChatRoom generalRoom = manager.getChatRoom("General");  // Retrieve the "General" chat room
    ChatClient client1 = new ChatClient("client1");         // Create a chat client "client1"
    ChatClient client2 = new ChatClient("client2");         // Create a chat client "client2"

    generalRoom.join(client1);  // Add client1 to the chat room
    generalRoom.join(client2);  // Add client2 to the chat room

    // Send a message from client1 to all participants in the "General" chat room
    generalRoom.sendMessage(new Message("client1", "Hello everyone!"));
  }
}