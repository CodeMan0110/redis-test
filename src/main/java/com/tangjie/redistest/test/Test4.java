package com.tangjie.redistest.test;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

public class Test4 {

    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {

        Field myUnsafe = Unsafe.class.getDeclaredField("theUnsafe");
        //设置私有成员变量允许访问
        myUnsafe.setAccessible(true);
        Unsafe unsafe = (Unsafe) myUnsafe.get(null);
        System.out.println(unsafe);

        //获取域的偏移地址
        long id = unsafe.objectFieldOffset(Teacher.class.getDeclaredField("id"));
        long name = unsafe.objectFieldOffset(Teacher.class.getDeclaredField("name"));


        Teacher teacher = new Teacher();
        System.out.println(teacher);
        unsafe.compareAndSwapInt(teacher, id, 0, 1);
        unsafe.compareAndSwapObject(teacher, name, null, "张三");
        System.out.println(teacher);
    }
}


class Teacher {
    private volatile int id;
    private volatile String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
