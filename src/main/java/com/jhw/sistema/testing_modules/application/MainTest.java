package com.jhw.sistema.testing_modules.application;

import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public class MainTest {

    public static void main(String args[]) throws Exception {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6);
        int pos = 2;

        System.out.println(list.get(pos));
    }

}
