/**
 * Name: Ratan Jagath Naik
 * Course: CS-665 Software Designs & Patterns
 * Date: 04/15/2024
 * File Name: Observable.java
 * Description: Defines an interface for the Observable in Observer pattern.
 */

package edu.bu.met.cs665.interfaces;

import edu.bu.met.cs665.implementations.Message;

/**
 * The Observable interface for implementing the Observer pattern.
 * This interface provides methods for managing observers and notifying them
 * of changes or messages.
 */
public interface Observable {
  /**
     * Adds an observer to the chat environment.
     *
     * @param participant the observer to be added, typically a ChatClient
     */
  void join(MessageCallback participant);

  /**
     * Removes an observer from the chat environment based on their username.
     *
     * @param username the username of the observer to remove
     */
  void leave(String username);

  /**
     * Notifies all observers about a new message.
     *
     * @param message the message that triggers notifications to all observers
     */
  void sendMessage(Message message);
}
