package priv.wwb.sodis.starter;

import java.lang.reflect.Field;
import java.util.Random;

public class Starter {
    private static String getClassName(){
        return Starter.class.getSimpleName();
    }
    public static void main(String[] args) throws Exception{
        System.out.println(getClassName());
        System.out.println();
        /*Integer i = new Integer(1);
        if (i.equals(1))
            i = null;
        Double d = new Double(2.0);
        Object o = true ? i : d; // NullPointerException!
        System.out.println(o);*/

        // Extract the IntegerCache through reflection
        Class<?> clazz = Class.forName(
                "java.lang.Integer$IntegerCache");
        Field field = clazz.getDeclaredField("cache");

        field.setAccessible(true);
        Integer[] cache = (Integer[]) field.get(clazz);

        // Rewrite the Integer cache
        for (int i = 0; i < cache.length; i++) {
            cache[i] = new Integer(
                    new Random().nextInt(cache.length));
        }

        // Prove randomness
        for (int i = 0; i < 3; i++) {
            System.out.println((Integer) i);
        }


    }
}
