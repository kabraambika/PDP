package assignment6;

import java.io.DataInputStream;
import java.io.DataOutputStream;

public class ChatRoomProtocol {
  private String username;
  private DataInputStream in;
  private DataOutputStream out;
  private  ChatRoomServer server;

  public ChatRoomProtocol(DataInputStream in, DataOutputStream out, ChatRoomServer server) {
    this.username = null;
    this.in = in;
    this.out = out;
    this.server = server;
  }

  public void processInput(Integer messageIdentifier){

  }

  public String getUsername() {
    return this.username;
  }
}
