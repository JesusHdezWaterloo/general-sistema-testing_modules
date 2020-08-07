package com.jhw.clean.example.application;

import com.clean.core.app.services.Notification;
import com.clean.core.app.services.NotificationsGeneralType;
import com.clean.swing.app.DefaultSwingApplication;
import static com.clean.swing.app.RootView.LOGIN_NAME;
import com.jhw.clean.example.application.services.ExceptionServiceImplementation;
import com.jhw.clean.example.application.services.NavigationServiceImplementation;
import com.jhw.clean.example.application.services.NotificationServiceImplementation;
import com.jhw.clean.example.application.services.ResourceServiceImplementation;
import com.jhw.clean.example.application.services.LoginServiceImplementation;
import com.jhw.licence.services.LicenceHandler;
import com.jhw.swing.ui.MaterialLookAndFeel;
import javax.swing.UIManager;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public class SwingApplication extends DefaultSwingApplication {

    @Override
    public void init() throws Exception {
        System.out.println("Configurando sistema");

        initRootView(new RootViewFrame(this));

        UIManager.setLookAndFeel(new MaterialLookAndFeel());

        ExceptionServiceImplementation.init();
        NotificationServiceImplementation.init();
        NavigationServiceImplementation.init();
        ResourceServiceImplementation.init();
        LoginServiceImplementation.init();
    }

    @Override
    public void navigateTo(String string, Object... o) {
        if (LicenceHandler.isLicenceCorrect()) {
            super.navigateTo(string, o);
        } else {
            super.navigateTo(LOGIN_NAME);
        }
    }

    @Override
    public void closeApplication() {
        Notification.showConfirmDialog(NotificationsGeneralType.CONFIRM_ERROR, "CERRANDO LA APP");
    }

}
