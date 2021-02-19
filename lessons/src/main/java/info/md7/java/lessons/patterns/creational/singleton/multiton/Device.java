package info.md7.java.lessons.patterns.creational.singleton.multiton;

import java.util.HashMap;

public class Device {

  private Device(){}

  private static HashMap<OS, Device> instances = new HashMap<>();

  public static Device getInstance(OS os) {
    if (instances.containsKey(os)) {
      return instances.get(os);
    }
    Device device = new Device();
    instances.put(os, device);
    return device;
  }


}
