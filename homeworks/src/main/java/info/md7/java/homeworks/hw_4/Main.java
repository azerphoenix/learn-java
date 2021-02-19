package info.md7.java.homeworks.hw_4;

public class Main {

  public static void main(String[] args) {

    String text = "Lorem ipsum dolor sit amet, consectetuer adipiscing elit. " +
        "Aenean commodo ligula eget dolor. Aenean massa. " +
        "Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. " +
        "Donec quam felis, ultricies nec, pellentesque eu, pretium quis, sem. " +
        "Nulla consequat massa quis enim. Donec pede justo, fringilla vel, " +
        "aliquet nec, vulputate eget, arcu. In enim justo, rhoncus ut, " +
        "imperdiet a, venenatis vitae, justo. Nullam dictum felis eu pede " +
        "mollis pretium. Integer tincidunt. Cras dapibus. " +
        "Vivamus elementum semper nisi. Aenean vulputate eleifend tellus. " +
        "Aenean leo ligula, porttitor eu, consequat vitae, eleifend ac, enim. " +
        "Aliquam lorem ante, dapibus in, viverra quis, feugiat a, tellus. " +
        "Phasellus viverra nulla ut metus varius laoreet. Quisque rutrum. " +
        "Aenean imperdiet. Etiam ultricies nisi vel augue. " +
        "Curabitur ullamcorper ultricies nisi. Nam eget dui. ";

    /*
     * Задание #18
     * Найти в строке не только запятые, но и другие знаки препинания
     */
    int punctuationMarksCount = Exercise18.getPunctuationMarksCount(text);
    System.out
        .println("Общее кол-во знаков препинаний содержащихся в строке: " + punctuationMarksCount);

    int commasCount = Exercise18.getSelectedCharCount(text, ',');
    System.out.println("Общее кол-во запятых содержащихся в тексте: " + commasCount);

    /*
     * Задание #19
     * Подсчитать кол-во слов в тексте
     */
    int wordsCount = Exercise19.getWordsCount(text);
    System.out.println("Кол-во слов в строке: " + wordsCount);

    int totalWordsCount = Exercise19.getWordsCountInSentence(text);
    System.out.println("Кол-во слов в строке: " + totalWordsCount);

    /*
     * Задание #20
     * Имеется строка с текстом. Вывести текст, составленный из последних букв всех слов
     */
    String text2 = "Это текст, из которого нужно получить последние символы и составить слово";
    String finalWord = Exercise20.getFinalWord(text2);
    System.out.println("Это слово составленное из последних букв каждого слова: " + finalWord);
    if (finalWord.equals("отзооьеыиьо")) {
      System.out.println("Слово найдено корректно");
    }

    /*
     * Задание #21
     * Напишите 2 цикла выполняющих многократное сложение строк, один
     * с помощью оператора сложения и String, а другой с помощью StringBuilder
     * и метода append.
     */
    String[] wordsArr = text.split("\\s+");

    // Пример использования StringBuilder
    StringBuilder stringBuilder = new StringBuilder();
    for (String word : wordsArr) {
      stringBuilder.append(word);
      stringBuilder.append(" ");
    }
    System.out.println("Пример текста созданного при помощи StringBuilder: ");
    System.out.println(stringBuilder);

    // Пример использования конкатенации
    String customText = "";
    for (String s : wordsArr) {
      System.out.print(s  + " ");
    }

  }


}
