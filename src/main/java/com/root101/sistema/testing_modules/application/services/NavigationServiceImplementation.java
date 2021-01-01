package com.root101.sistema.testing_modules.application.services;

import com.root101.clean.core.app.services.NavigationHandler;
import com.root101.clean.core.app.services.NavigationService;
import static com.root101.sistema.testing_modules.application.Main.app;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public class NavigationServiceImplementation implements NavigationService {

    public static NavigationServiceImplementation init() {
        NavigationServiceImplementation nav = new NavigationServiceImplementation();
        NavigationHandler.registerNavigationService(nav);
        return nav;
    }

    private NavigationServiceImplementation() {
    }

    @Override
    public void navigateTo(String string, Object... o) {
        app.navigateTo(string, o);
    }

}
