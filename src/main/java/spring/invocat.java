package spring;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class invocat implements InvocationHandler {
    private Object target = null;
    public invocat(Object target){
        this.target = target;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
          new  one().doone();
          method.invoke(target,args);
          new three().dotgree();
          return null;
    }

}
