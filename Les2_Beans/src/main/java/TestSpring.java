/**
 * 2. Первое приложение (IntelliJ Idea). Бины (Beans)
 */

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpring {
    public static void main(String[] args) {
        //Бин - это просто Java объект
        //Когда Java объекты создаются с помощью Spring'а они называются бинами (beans)
        //Бины создаются из Java классов (так же, как и обычные объекты)
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                "applicationContext.xml");
        TestBean testBean = context.getBean("testBean", TestBean.class);

        System.out.println(testBean.getName());

        context.close();
    }
}
