package info.md7.java.lessons.patterns.behavioral.null_object.dynamic_null_object;

import java.lang.reflect.Proxy;

public class DynamicNullObject {

  @SuppressWarnings("unchecked")
  public static <T> T noOp(Class<T> someInterface) {
    return (T) Proxy.newProxyInstance(
        someInterface.getClassLoader(),
        new Class<?>[]{someInterface},
        (proxy, method, args) -> {
          if (method.getReturnType().equals(Void.TYPE)) {
            return null;
          } else {
            return method.getReturnType().getConstructor().newInstance();
          }
          }
    );
  }

}
