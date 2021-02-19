package info.md7.java.homeworks.hw_4;

import java.util.regex.Pattern;

public class Exercise18 {

  /**
   * Подсчет общего кол-ва выбранного символа в тексте
   *
   * @param text (строка, в которой нужно произвести поиск)
   * @param ch (символ кол-во которого нужно подсчитать)
   */
  public static int getSelectedCharCount(String text, char ch) {
    int commasCount = 0;
    for (Character character : text.toCharArray()) {
        if (character == ch) {
            commasCount++;
        }
    }
    return commasCount;
  }

  /**
   * Подсчитать количество всех знаков препинания в тексте
   *
   * @param text (строка, в которой нужно произвести поиск)
   */
  public static int getPunctuationMarksCount(String text) {
    int puncMarksCount = 0;
    for (Character character : text.toCharArray()) {
        if (Pattern.matches("\\p{P}", character.toString())) {
            puncMarksCount++;
        }
    }
    return puncMarksCount;
  }


}
