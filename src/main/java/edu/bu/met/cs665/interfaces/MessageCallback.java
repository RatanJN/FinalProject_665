/**
 * Name: Ratan Jagath Naik
 * Course: CS-665 Software Designs & Patterns
 * Date: 04/15/2024
 * File Name: MessageCallback.java
 * Description: Defines an interface for handling received messages.
 */

package edu.bu.met.cs665.interfaces;

import edu.bu.met.cs665.implementations.Message;

/**
 * The MessageCallback interface declares a method for receiving messages.
 * Implementations of this interface can define custom actions to take when a
 * message is received, such as displaying or logging the message.
 */
public interface MessageCallback {
  
  /**
   * Called when a message is received. Implementations should define what to do
   * with the received message, such as processing or displaying it.
   *
   * @param message The message that has been received.
   */
  void onMessageReceived(Message message);
}