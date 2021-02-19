package info.md7.java.homeworks.hw_4;

import java.util.StringTokenizer;

public class Exercise19 {

  /**
   * Первый вариант подсчета кол-во слов в строке
   *
   * @param text (строка, в которой нужно подсчитать кол-во слов)
   */
  public static int getWordsCount(String text) {
    if (text == null || text.isEmpty()) {
      return 0;
    }
    StringTokenizer tokens = new StringTokenizer(text);
    return tokens.countTokens();
  }

  /**
   * Второй вариант подсчета кол-ва слов в строке
   *
   * @param text (строка, в которой нужно подсчитать кол-во слов)
   */
  public static int getWordsCountInSentence(String text) {
    String[] words = text.replaceAll("\\p{P}", "").split("\\s+");
    return words.length;
  }

}
