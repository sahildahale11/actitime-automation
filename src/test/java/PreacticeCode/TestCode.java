package PreacticeCode;

import org.checkerframework.checker.units.qual.C;

public class TestCode {

        int a=100;
        int b =200;



}
class Child extends TestCode
{
    public static void main(String[] args) {
        int c =1000;
        int d =50000;
        TestCode testCode = new TestCode();
        System.out.println(testCode.a);
        System.out.println(testCode.b);

        Child c1 = new Child();
        System.out.println(testCode.a);
        System.out.println(testCode.b);
        System.out.println(c);
        System.out.println(d);
System.out.println(d);
    }
}






