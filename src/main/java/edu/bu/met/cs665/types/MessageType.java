/**
 * Name: Ratan Jagath Naik
 * Course: CS-665 Software Designs & Patterns
 * Date: 04/15/2024
 * File Name: MessageType.java
 * Description: Defines the types of messages that can be handled in the chat system.
 */

package edu.bu.met.cs665.types;

/**
 * The MessageType enum specifies different categories of messages
 * that can be sent and received in the chat application. Each type
 * represents a specific kind of message handling scenario.
 */
public enum MessageType {
  /**
   * DIRECT messages are intended for specific users, facilitating
   * private communication between individuals.
   */
  DIRECT, // For direct messages between users

  /**
   * BROADCAST messages are sent to all users within a chat room,
   * useful for sharing information with every participant.
   */
  BROADCAST, // For messages sent to all users in a chat room

  /**
   * SYSTEM messages are used for notifications from the chat system itself,
   * such as alerts or administrative messages.
   */
  SYSTEM, // For system notifications

  /**
   * DEFAULT messages are used for any message types not specifically categorized,
   * serving as a fallback communication type.
   */
  DEFAULT // For any other types of messages
}