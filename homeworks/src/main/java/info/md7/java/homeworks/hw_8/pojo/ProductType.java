package info.md7.java.homeworks.hw_8.pojo;

public enum  ProductType {

  APPLIANCES ("Бытовая техника"),
  PHONES_TABLETS ("Телефоны и планшеты"),
  COMPUTERS ("Компьютеры"),
  TV_AUDIO_PHOTO_VIDEO ("Телевизоры, аудио, фото, видео"),
  MUSICAL_INSTRUMENTS ("Музыкальные инструменты");

  public String name;

  ProductType(String name) {
    this.name = name;
  }

}
