/**
 * Name: Ratan Jagath Naik
 * Course: CS-665 Software Designs & Patterns
 * Date: 04/15/2024
 * File Name: Message.java
 * Description: Represents a message sent within the chat system.
 */

package edu.bu.met.cs665.implementations;

/**
 * The Message class encapsulates the details of a message, including its sender
 * and content. This class provides methods to access and modify these details.
 */
public class Message {
  private String sender;   // Username of the person who sends the message
  private String content;  // Text content of the message

  /**
   * Constructs a new Message instance.
   *
   * @param sender The username of the message sender
   * @param content The text content of the message
   */
  public Message(String sender, String content) {
    this.sender = sender;
    this.content = content;
  }

  /**
   * Retrieves the sender of the message.
   *
   * @return The username of the sender
   */
  public String getSender() {
    return sender;
  }

  /**
   * Sets a new sender for this message.
   *
   * @param sender The new username to assign as the sender
   */
  public void setSender(String sender) {
    this.sender = sender;
  }

  /**
   * Retrieves the content of the message.
   *
   * @return The text content of the message
   */
  public String getContent() {
    return content;
  }

  /**
   * Sets new content for this message.
   *
   * @param content The new text to be used as the content of the message
   */
  public void setContent(String content) {
    this.content = content;
  }
}