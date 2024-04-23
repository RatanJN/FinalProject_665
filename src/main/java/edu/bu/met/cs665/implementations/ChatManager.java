/**
 * Name: Ratan Jagath Naik
 * Course: CS-665 Software Designs & Patterns
 * Date: 04/15/2024
 * File Name: ChatManager.java
 * Description: This class manages chat rooms and ensures single instance for ChatManager.
 */

package edu.bu.met.cs665.implementations;

import java.util.HashMap;
import java.util.Map;

/**
 * The ChatManager class implements the Singleton pattern to manage chat rooms.
 * This class is responsible for creating and managing chat rooms, ensuring that there
 * is a single, global point of access to the chat rooms.
 */
public class ChatManager {
  private static ChatManager instance;           // Static variable for singleton instance
  private Map<String, ChatRoom> chatRooms;       // Map to store chat room names and their instances

  /**
   * Private constructor to prevent instantiation outside this class.
   */
  private ChatManager() {
    chatRooms = new HashMap<>();                   // Initializes the map for storing chat rooms
  }

  /**
   * Provides access to the singleton instance of the ChatManager. If the instance doesn't exist,
   * it initializes it with thread-safe double-checked locking.
   *
   * @return The singleton instance of ChatManager.
   */
  public static ChatManager getInstance() {
    if (instance == null) {                        // First check (no locking)
      synchronized (ChatManager.class) {           // Synchronized block to ensure thread safety
        if (instance == null) {                    // Second check (inside lock)
          instance = new ChatManager();            // Create a new instance if it doesn't exist
        }
      }
    }
    return instance;
  }

  /**
   * Creates a new chat room if it does not already exist in the chatRooms map.
   *
   * @param name The name of the chat room to be created.
   */
  public void createChatRoom(String name) {
    if (!chatRooms.containsKey(name)) {            // Check if the chat room already exists
      ChatRoom room = new ChatRoom(name);          // Create new chat room
      chatRooms.put(name, room);                   // Put the new chat room in the map
    }
  }

  /**
   * Retrieves a chat room by its name.
   *
   * @param name The name of the chat room to retrieve.
   * @return The chat room associated with the given name.
   */
  public ChatRoom getChatRoom(String name) {
    return chatRooms.get(name);                    // Return the chat room if it exists
  }

  /**
   * Returns all chat rooms managed by this ChatManager.
   *
   * @return A map of chat room names to their respective ChatRoom instances.
   */
  public Map<String, ChatRoom> getChatRooms() {
    return chatRooms;                              // Return the map of all chat rooms
  }
}
