package gb.sample.error;

public class CheckUtil {
  /**
   * Check empty text
   *
   * @param obj String
   * @return boolean
   */
  public static boolean isEmpty(String obj) {
    return obj == null || "".equals(obj.trim());
  }
}
