package assignment6;

import java.io.IOException;
import java.net.CookieHandler;
import java.net.ServerSocket;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class ChatRoomServer {
  private ServerSocket server;
  private ConcurrentMap<String, ClientInterface> clients;
  private Integer port;

  public ChatRoomServer() throws IOException {
    this.clients = new ConcurrentHashMap<>();
    this.port = getFreePort();
    this.server = new ServerSocket(this.port);
  }

  private Integer getFreePort(){
    return 9999;
  }

  public void startServer(){
    //TODO: server started message and start a new thread for clientInterface
  }

  public static void main(String[] args) {

  }

  /**
   * This public method is used to get clients map
   *
   * @return represented as ConcurrentMap where key is String,username of client and value is object of ClientInterface
   */
  public ConcurrentMap<String, ClientInterface> getClients() {
    return this.clients;
  }

  /**
   * This public method is used to check if username is present in client map
   *
   * @param username represented as String, username
   * @return represented as boolean
   */
  public boolean hasClient(String username) {
    return this.clients != null && this.clients.containsKey(username);
  }
}
