package spring;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("ii")
public class iiImpl  {

    @Value("xiaoli")
    private  String name;

    public String getName() {
        return "name:" + name ;
    }

    public void setName(String name) {
        System.out.println("调用了set方法");
        this.name = name;
    }

    public void seat() {
        System.out.println("实现了seat方法");
    }


}
