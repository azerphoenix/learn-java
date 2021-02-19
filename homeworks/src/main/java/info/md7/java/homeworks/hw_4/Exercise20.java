package info.md7.java.homeworks.hw_4;

public class Exercise20 {

  /**
   * Метод возвращает слово составленное из последних букв каждого слова содержащегося в строке
   */
  public static String getFinalWord(String text) {
    String[] strArr = text.replaceAll("\\p{P}", "").toLowerCase().split("\\s+");
    StringBuilder stringBuilder = new StringBuilder();
    for (String str : strArr) {
      stringBuilder.append(str.substring(str.length() - 1));
    }
    return stringBuilder.toString();
  }

}
