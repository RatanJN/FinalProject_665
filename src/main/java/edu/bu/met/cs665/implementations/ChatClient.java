/**
 * Name: Ratan Jagath Naik
 * Course: CS-665 Software Designs & Patterns
 * Date: 04/15/2024
 * File Name: ChatClient.java
 * Description: Represents a chat client that can receive messages.
 */

package edu.bu.met.cs665.implementations;

import edu.bu.met.cs665.interfaces.MessageCallback;

/**
 * The ChatClient class implements the MessageCallback interface to receive
 * messages. This class is responsible for handling the actions of a single user
 * within the chat system.
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
   * Receives messages and prints them to the console, formatted to show the
   * sender and content of the message.
   *
   * @param message the message that has been received
   */
  @Override
  public void onMessageReceived(Message message) {
    System.out.println("[" + username + "] New message from "
        + message.getSender() + ": " + message.getContent());
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