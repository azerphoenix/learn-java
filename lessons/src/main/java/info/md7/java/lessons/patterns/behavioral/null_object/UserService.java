package info.md7.java.lessons.patterns.behavioral.null_object;

public class UserService {

  private Log log;

  public UserService(Log log) {
    this.log = log;
  }

  public void getUserInfo(String username) {
    log.info(username);
  }
}
