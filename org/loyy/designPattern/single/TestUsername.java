package org.loyy.designPattern.single;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 13-4-25
 * Time: 上午11:21
 * To change this template use File | Settings | File Templates.
 */
public class TestUsername {
    private static TestUsername instance = null;

    private TestUsername() {

    }

    public static TestUsername getInstance() {
        if (instance == null) {
            instance = new TestUsername();
        }
        return instance;
    }
}
