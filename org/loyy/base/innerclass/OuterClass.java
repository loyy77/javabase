package org.loyy.base.innerclass;

/**
 * Created with IntelliJ IDEA.
 * User: LiShixi
 * Date: 13-5-20
 * Time: 上午10:29
 * To change this template use File | Settings | File Templates.
 */
public class OuterClass {
    String name = "1";

    public class InnerClass {
        String name = "0";

        public void fun() {
            String name = "-1";

            System.out.println(name);
            System.out.println(this.name);
            System.out.println(OuterClass.this.name);
        }
    }

    //Test Code |测试代码
    public static void main(String[] args) {
        OuterClass oc = new OuterClass();
        InnerClass ic = oc.new InnerClass();
        System.out.println();
        ic.fun();
    }
}
