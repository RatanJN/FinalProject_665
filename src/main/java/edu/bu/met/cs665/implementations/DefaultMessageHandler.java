/**
 * Name: Ratan Jagath Naik
 * Course: CS-665 Software Designs & Patterns
 * Date: 04/15/2024
 * File Name: DefaultMessageHandler.java
 * Description: Handles messages by delegating to a callback mechanism.
 */

package edu.bu.met.cs665.implementations;

import edu.bu.met.cs665.interfaces.MessageCallback;
import edu.bu.met.cs665.interfaces.MessageHandler;

/**
 * DefaultMessageHandler delegates the message handling to a callback.
 * It uses the strategy pattern for flexibility in message processing.
 */
public class DefaultMessageHandler implements MessageHandler {
  private MessageCallback callback;  // Callback to handle the message

  /**
   * Constructor initializes the handler with a specific callback.
   *
   * @param callback the callback to handle messages
   */
  public DefaultMessageHandler(MessageCallback callback) {
    this.callback = callback;
  }

  /**
   * Handles messages by delegating the responsibility to the callback.
   *
   * @param message the message to be handled
   */
  @Override
  public void handleMessage(Message message) {
    callback.onMessageReceived(message);
  }

  /**
   * Gets the current message handling callback.
   *
   * @return the current callback
   */
  public MessageCallback getCallback() {
    return callback;
  }

  /**
   * Sets a new callback for handling messages.
   *
   * @param callback the new callback to set
   */
  public void setCallback(MessageCallback callback) {
    this.callback = callback;
  }
}