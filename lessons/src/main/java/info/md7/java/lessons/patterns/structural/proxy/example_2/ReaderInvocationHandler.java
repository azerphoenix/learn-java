package info.md7.java.lessons.patterns.structural.proxy.example_2;

import info.md7.java.lessons.patterns.structural.proxy.example_1.CustomReader;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class ReaderInvocationHandler implements InvocationHandler {

  @Override
  public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
    Object result = method.invoke(new CustomReader(), args);
    System.out.println(result.toString());
    return result;
  }

}


