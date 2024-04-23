/**
 * Name: Ratan Jagath Naik
 * Course: CS-665 Software Designs & Patterns
 * Date: 04/15/2024
 * File Name: MessageHandler.java
 * Description: Defines an interface for message handling strategies.
 */

package edu.bu.met.cs665.interfaces;

import edu.bu.met.cs665.implementations.Message;

/**
 * The MessageHandler interface declares a method for handling messages in a
 * generalized way. This interface allows for different message processing
 * strategies to be implemented by classes that fulfill this interface's contract.
 */
public interface MessageHandler {
  
  /**
   * Processes the given message according to a specific implementation.
   * This method is intended to be implemented to handle messages in various ways,
   * such as filtering, modifying, or routing the message based on certain criteria.
   *
   * @param message The message to handle.
   */
  void handleMessage(Message message);
}