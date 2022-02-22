package COM.wdlele.sj01;

import com.sun.tracing.dtrace.ArgsAttributes;
import org.junit.Test;
import sun.plugin2.message.ShowDocumentMessage;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * java.lang.Class
 * java.lang.reflect.Method
 * java.lang.reflect.Field
 * java.lang.reflect.Constructor ......
 *
 * @author wdlele
 * @create 2022-02-21-9:54
 */
public class GitTest {
    public static void main(String[] args) {
        System.out.println("hello git");
        System.out.println("hello git");
        System.out.println("hello git");
        System.out.println("hello git");
        System.out.println("hello git");
        System.out.println("3hello git");
        System.out.println("2hello git");
        System.out.println("1hello git");
    }

    @Test
    public void test1() {
        Person p1 = new Person("Tom", 16);
        p1.age = 18;
        System.out.println(p1.toString());
        p1.show();

    }

    @Test
    public void test2() throws Exception {
        Class<Person> clazz = Person.class;
        Field[] field1 = clazz.getDeclaredFields();
        for (Field f : field1) {
            System.out.println(f);
        }
        Field[] fields1 = clazz.getFields();
        for (Field f : fields1) {
            System.out.println(f);
        }
        Constructor<?>[] con1 = clazz.getConstructors();
        for (Constructor con : con1) {
            System.out.println(con);

        }
        Constructor<Person> con2 = clazz.getDeclaredConstructor(String.class, int.class);
        Person p1 = con2.newInstance("Tom", 19);

//        Method[] methods = clazz.getDeclaredMethods();
//        for (Method m:
//             methods) {
//            System.out.println(methods);
//        }
        Method show = clazz.getDeclaredMethod("show");
        show.invoke(p1);
        System.out.println("****************************");
        con2.setAccessible(true);
        Person p3 = con2.newInstance("Jerry", 16);
        p3.show();
        System.out.println("****************************");
        System.out.println(p3);
        Method showNation = clazz.getDeclaredMethod("showNation", String.class);
        showNation.setAccessible(true);
        Constructor<Person> con3 = clazz.getDeclaredConstructor(String.class);
        con3.setAccessible(true);
        Person p4 = con3.newInstance("John");
        showNation.invoke(p4,"中国");


    }
}
