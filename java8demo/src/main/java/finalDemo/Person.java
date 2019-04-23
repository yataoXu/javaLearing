package finalDemo;

import lombok.Data;

/**
 * @ Author : Evan.
 * @ Description :
 * @ Date : Crreate in 2019/4/18 16:56
 * @Mail : xuyt@zendaimoney.com
 */

public class Person {
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
