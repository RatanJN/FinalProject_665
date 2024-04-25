/**
 * Name: Ratan Jagath Naik
 * Course: CS-665 Software Designs & Patterns
 * Date: 04/15/2024
 * File Name: Message.java
 * Description: Represents a message sent within the chat system.
 */

package edu.bu.met.cs665.implementations;

import edu.bu.met.cs665.types.MessageType;

/**
 * The Message class encapsulates the details of a message, including its sender
 * and content. This class provides methods to access and modify these details.
 */
public class Message {
  private String sender;   // Username of the person who sends the message
  private String content;  // Text content of the message
  private MessageType type; // Using MessageType enum

  /**
   * Constructs a new Message instance.
   *
   * @param sender The username of the message sender
   * @param content The text content of the message
   */
  public Message(String sender, String content, MessageType type) {
    this.sender = sender;
    this.content = content;
    this.type = type;
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
  
  /**
   * Retrieves the type of the message.
   *
   * @return The type of the message as defined by the MessageType enum
   */
  public MessageType getType() {
    return type;
  }

  /**
   * Sets a new type for this message.
   *
   * @param type The new MessageType enum value to set for the message
   */
  public void setType(MessageType type) {
    this.type = type;
  }
}