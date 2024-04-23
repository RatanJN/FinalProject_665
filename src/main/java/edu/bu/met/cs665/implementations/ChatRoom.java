/**
 * Name: Ratan Jagath Naik
 * Course: CS-665 Software Designs & Patterns
 * Date: 04/15/2024
 * File Name: ChatRoom.java
 * Description: This class manages chat room functionalities like joining and sending messages.
 */

package edu.bu.met.cs665.implementations;

import edu.bu.met.cs665.interfaces.MessageCallback;
import java.util.HashMap;
import java.util.Map;

/**
 * The ChatRoom class manages the participants and the messages within a chat room.
 * It allows participants to join the room and send messages to all participants.
 */
public class ChatRoom {
  private String name;                             // Name of the chat room
  private Map<String, MessageCallback> participants; //Stores participants with quick access by name

  /**
   * Constructor to create a new ChatRoom with a given name.
   *
   * @param name the name of the chat room
   */
  public ChatRoom(String name) {
    this.name = name;
    this.participants = new HashMap<>();           // Initializes the map for storing participants
  }

  /**
   * Allows a participant to join the chat room. If the participant is not already in the room,
   * they are added.
   *
   * @param participant the participant who wishes to join the chat room
   */
  public void join(MessageCallback participant) {
    if (participant instanceof ChatClient) {
      String username = ((ChatClient) participant).getUsername();
      if (!participants.containsKey(username)) {   // Check if the username already exists
        participants.put(username, participant);   // Add new participant to the room
        System.out.println(username + " has joined " + name);
      }
    }
  }

  /**
   * Sends a message to all participants in the chat room if the sender is registered.
   *
   * @param message the message to be sent to the room
   */
  public void sendMessage(Message message) {
    if (participants.containsKey(message.getSender())) { //Check if sender is registered
      System.out.println("Message in " + name + " from " + message.getSender()
            + ": " + message.getContent());
      for (MessageCallback participant : participants.values()) {
        participant.onMessageReceived(message);     // Notify each participant of the new message
      }
    } else {
      System.out.println("Error: Sender not registered in " 
             + name + "."); // Error if sender not registered
    }
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

  /**
   * Returns a map of all participants in the chat room.
   *
   * @return a map of participant usernames to their corresponding MessageCallback objects
   */
  public Map<String, MessageCallback> getParticipants() {
    return participants;
  }
}
