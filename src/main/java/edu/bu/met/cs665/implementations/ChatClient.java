/**
 * Name: Ratan Jagath Naik
 * Course: CS-665 Software Designs & Patterns
 * Date: 04/15/2024
 * File Name: ChatClient.java
 * Description: Represents a chat client that can receive messages and handle them
 * based on their type, enhancing user interaction within the chat system.
 */

package edu.bu.met.cs665.implementations;

import edu.bu.met.cs665.interfaces.MessageCallback;

/**
 * The ChatClient class implements the MessageCallback interface to handle
 * received messages. It processes messages differently based on their type,
 * enhancing user interaction within the chat system.
 */
public class ChatClient implements MessageCallback {
  private String username;  // Username of the chat client

  /**
   * Constructor to create a new chat client with a specific username.
   *
   * @param username the username of the client
   */
  public ChatClient(String username) {
    this.username = username;
  }

  /**
   * Receives messages and processes them based on their type.
   * It differentiates between DIRECT, BROADCAST, SYSTEM, and DEFAULT messages.
   *
   * @param message the message that has been received
   */
  @Override
  public void onMessageReceived(Message message) {
    switch (message.getType()) {
      case DIRECT:
        handleDirectMessage(message);
        break;
      case BROADCAST:
        handleBroadcastMessage(message);
        break;
      case SYSTEM:
        handleSystemMessage(message);
        break;
      default:
        handleDefaultMessage(message);
    }
  }

  /**
   * Handles direct messages intended for the client.
   * Displays a personalized message indicating a direct communication.
   *
   * @param message the direct message received
   */
  private void handleDirectMessage(Message message) {
    System.out.println("[" + username + "] Direct message from " + message.getSender() 
         + ": " + message.getContent());
  }

  /**
   * Handles broadcast messages sent to all clients in a chat room.
   * Displays a message indicating it is a broadcast from a particular sender.
   *
   * @param message the broadcast message received
   */
  private void handleBroadcastMessage(Message message) {
    System.out.println("[" + username + "] Broadcast message from " 
        + message.getSender() + ": " + message.getContent());
  }

  /**
   * Handles system messages, which could include notifications or alerts.
   * Displays a message indicating it is a system-generated notification.
   *
   * @param message the system message received
   */
  private void handleSystemMessage(Message message) {
    System.out.println("[" + username + "] System notification: " + message.getContent());
  }

  /**
   * Handles default messages, or any message types not specifically categorized.
   * Provides a generic response indicating the receipt of the message.
   *
   * @param message the message received
   */
  private void handleDefaultMessage(Message message) {
    System.out.println("[" + username + "] Message: " + message.getContent());
  }

  /**
   * Gets the username of this chat client.
   *
   * @return the username of the client
   */
  public String getUsername() {
    return username;
  }

  /**
   * Sets the username of this chat client.
   *
   * @param username the new username to be set
   */
  public void setUsername(String username) {
    this.username = username;
  }
}