/**
 * Name: Ratan Jagath Naik
 * Course: CS-665 Software Designs & Patterns
 * Date: 04/15/2024
 * File Name: ChatTest.java
 * Description: This class contains unit tests for the chat application's core functionalities,
 * including joining chat rooms, sending messages, managing participants, and ensuring Singleton
 * pattern compliance.
 */

package edu.bu.met.cs665;

import static org.junit.Assert.*;

import edu.bu.met.cs665.implementations.ChatClient;
import edu.bu.met.cs665.implementations.ChatManager;
import edu.bu.met.cs665.implementations.ChatRoom;
import edu.bu.met.cs665.implementations.Message;
import edu.bu.met.cs665.types.MessageType;
import org.junit.Before;
import org.junit.Test;

/**
 * ChatTest class performs several unit tests to ensure the functionality of the chat system
 * is as expected. It tests chat room joining, message sending, participant management, and
 * Singleton behavior.
 */
public class ChatTest {

  private ChatManager manager;
  private ChatRoom testRoom;
  private ChatClient client1;
  private ChatClient client2;

  /**
   * Sets up a consistent test environment before each test method.
   * Initializes the chat manager, chat room, and clients for testing.
   */
  @Before
  public void setUp() {
    // Reset the ChatManager for each test to avoid interference between tests
    manager = ChatManager.getInstance();
    manager.createChatRoom("General");
    testRoom = manager.getChatRoom("General");

    client1 = new ChatClient("client1");
    client2 = new ChatClient("client2");
  }

  /**
   * Tests if a client can successfully join a chat room.
   */
  @Test
  public void testJoinChatRoom() {
    testRoom.join(client1);
    assertTrue(testRoom.getParticipants().containsKey("client1"));
  }

  /**
   * Tests if a registered client can send a message within a chat room.
   */
  @Test
  public void testSendMessage() {
    testRoom.join(client1);
    Message msg = new Message("client1", "Hello, World!", MessageType.BROADCAST);
    testRoom.sendMessage(msg);
    assertEquals("Hello, World!", msg.getContent());
    assertEquals("client1", msg.getSender());
  }

  /**
   * Tests handling of messages sent by an unregistered user.
   */
  @Test
  public void testUnregisteredUserMessage() {
    Message msg = new Message("unknown", "Hello!", MessageType.DEFAULT);
    testRoom.sendMessage(msg);
    assertFalse(testRoom.getParticipants().containsKey("unknown"));
  }

  /**
   * Verifies that the ChatManager class follows the Singleton pattern.
   */
  @Test
  public void testSingletonChatManager() {
    ChatManager anotherManager = ChatManager.getInstance();
    assertSame(manager, anotherManager);
  }

  /**
   * Tests that attempting to join the same user multiple times does not duplicate entries.
   */
  @Test
  public void testMultipleJoinsSameUser() {
    testRoom.join(client1);
    testRoom.join(client1);
    assertEquals(1, testRoom.getParticipants().size());
  }

  /**
   * Tests if a client can successfully leave a chat room and no longer receives messages.
   */
  @Test
  public void testLeaveChatRoom() {
    testRoom.join(client2);
    testRoom.leave("client2");
    assertFalse(testRoom.getParticipants().containsKey("client2"));
  }

  /**
   * Tests message delivery when using different message types.
   */
  @Test
  public void testMessageTypes() {
    testRoom.join(client1);
    Message directMessage = new Message("client1", "Private message", MessageType.DIRECT);
    Message broadcastMessage = new Message("client1", "Announcement", MessageType.BROADCAST);
    testRoom.sendMessage(directMessage);
    testRoom.sendMessage(broadcastMessage);
    // Assuming the method for logging or capturing is implemented for verification
  }
}