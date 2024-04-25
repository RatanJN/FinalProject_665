/**
 * Name: Ratan Jagath Naik
 * Course: CS-665 Software Designs & Patterns
 * Date: 04/15/2024
 * File Name: DefaultMessageHandler.java
 * Description: Processes messages by implementing content moderation and then 
 *              delegates broadcasting to a ChatRoom, exemplifying the Delegation 
 *              and Strategy patterns.
 */

package edu.bu.met.cs665.implementations;

import edu.bu.met.cs665.interfaces.MessageHandler;

/**
 * This handler pre-processes messages including content checks before broadcasting
 * via the ChatRoom, implementing both Delegation and Strategy patterns.
 */
public class DefaultMessageHandler implements MessageHandler {
  private ChatRoom chatRoom;  // Reference to ChatRoom for message broadcasting

  /**
   * Constructs a message handler with a reference to the ChatRoom for broadcasting.
   *
   * @param chatRoom the chat room that will broadcast messages
   */
  public DefaultMessageHandler(ChatRoom chatRoom) {
    this.chatRoom = chatRoom;
  }

  /**
   * Handles message processing including content moderation before broadcasting.
   *
   * @param message the message to be processed and broadcasted
   */
  @Override
  public void handleMessage(Message message) {
    System.out.println("Handling message: " + message.getContent());
    if (isContentAcceptable(message.getContent())) {
      chatRoom.broadcastMessage(message);
    } else {
      System.out.println("Content blocked due to inappropriate language.");
    }
  }

  /**
   * Checks if the message content is acceptable, filtering out prohibited words.
   *
   * @param content the content of the message to check
   * @return true if content is acceptable, false otherwise
   */
  private boolean isContentAcceptable(String content) {
    String[] prohibitedWords = {"badword1", "badword2", "badword3"};
    for (String word : prohibitedWords) {
      if (content.toLowerCase().contains(word)) {
        return false;
      }
    }
    return true;
  }
}