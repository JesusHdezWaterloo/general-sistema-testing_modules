package com.jhw.sistema.testing_modules.application;

import java.awt.Desktop;
import java.net.URI;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public class MainTest {

    public static void main(String args[]) throws Exception {
        Desktop.getDesktop().mail(new URI("mailto:email@example.com?subject=bajajaja&attachment=/settings.gradle"));
    }

}
