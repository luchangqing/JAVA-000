package com.luchangqing.question02;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class HelloClassLoader extends ClassLoader {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException {
        Class<?> hello = new HelloClassLoader().findClass("Hello");
        Object instance = hello.newInstance();
        Method method = hello.getMethod("hello");
        method.invoke(instance);
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        InputStream resourceAsStream = this.getResourceAsStream("Hello.xlass");
        byte[] bytes = null;
        try {
            bytes = toByteArray(resourceAsStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return defineClass(name, bytes, 0, bytes.length);
    }

    public static byte[] toByteArray(InputStream input) throws IOException {
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024];
        int n = 0;
        while (-1 != (n = input.read(buffer))) {
            output.write(buffer, 0, n);
        }
        byte[] bytes = output.toByteArray();
        byte[] result = new byte[bytes.length];
        int i = 0;
        for (byte b : bytes) {
            result[i++] = (byte) (255 - b);
        }
        return result;
    }
}
;