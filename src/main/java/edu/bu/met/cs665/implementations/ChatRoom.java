/**
 * Name: Ratan Jagath Naik
 * Course: CS-665 Software Designs & Patterns
 * Date: 04/15/2024
 * File Name: ChatRoom.java
 * Description: Manages chat room functionalities like joining, leaving, sending messages,
 *              and broadcasting them to participants.
 */

package edu.bu.met.cs665.implementations;

import edu.bu.met.cs665.interfaces.MessageCallback;
import edu.bu.met.cs665.interfaces.MessageHandler;
import edu.bu.met.cs665.interfaces.Observable;
import java.util.HashMap;
import java.util.Map;

/**
 * Manages participants and their interaction within a chat room.
 * Acts as an Observable in the Observer pattern.
 */
public class ChatRoom implements Observable {
  private String name;  // Name of the chat room
  private Map<String, MessageCallback> participants;  // Participants in the chat room
  private MessageHandler messageHandler;  // Handler for message processing

  /**
   * Constructs a new ChatRoom with a given name.
   *
   * @param name the name of the chat room
   */
  public ChatRoom(String name) {
    this.name = name;
    this.participants = new HashMap<>();
    this.messageHandler = new DefaultMessageHandler(this);  // Delegation of message handling
  }

  /**
   * Adds a participant to the chat room.
   *
   * @param participant the participant to add
   */
  public void join(MessageCallback participant) {
    String username = ((ChatClient) participant).getUsername();
    if (!participants.containsKey(username)) {
      participants.put(username, participant);
      System.out.println(username + " has joined " + name);
    }
  }

  /**
   * Removes a participant from the chat room.
   *
   * @param username the username of the participant to remove
   */
  public void leave(String username) {
    if (participants.remove(username) != null) {
      System.out.println(username + " has left " + name);
    } else {
      System.out.println("Error: No such participant in " + name);
    }
  }

  /**
   * Sends a message to all participants after handling by the messageHandler.
   *
   * @param message the message to send
   */
  public void sendMessage(Message message) {
    if (participants.containsKey(message.getSender())) {
      messageHandler.handleMessage(message);
    } else {
      System.out.println("Error: Sender not registered in " + name);
    }
  }

  /**
   * Broadcasts a message to all participants.
   *
   * @param message the message to broadcast
   */
  protected void broadcastMessage(Message message) {
    participants.values().forEach(p -> p.onMessageReceived(message));
  }

  /**
   * Gets the current participants in the chat room.
   *
   * @return a map of usernames to their MessageCallback
   */
  public Map<String, MessageCallback> getParticipants() {
    return participants;
  }

  /**
   * Gets the name of the chat room.
   *
   * @return the name of the chat room
   */
  public String getName() {
    return name;
  }

  /**
   * Sets a new name for the chat room.
   *
   * @param name the new name to set for the chat room
   */
  public void setName(String name) {
    this.name = name;
  }
}