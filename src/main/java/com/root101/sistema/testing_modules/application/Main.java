/*
 * Copyright 2021 Root101 (jhernandezb96@gmail.com, +53-5-426-8660).
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Or read it directly from LICENCE.txt file at the root of this project.
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.root101.sistema.testing_modules.application;

import com.root101.module.admin.seguridad.ui.module.SeguridadSwingModule;
import com.jhw.module.util.company.ui.module.CompanySwingModule;
import com.jhw.module.util.tec.TecSwingModule;
import com.jhw.swing.bundles.loading.LoadingProcess;
import com.jhw.swing.bundles.loading.LoadingWorker;
import com.jhw.module.util.bug.module.BugSwingModule;
import com.jhw.module.util.calc.CalcSwingModule;
import com.jhw.swing.material.components.container.panel._PanelGradient;
import javax.swing.JOptionPane;
import com.jhw.module.util.default_config.DefaultConfigSwingModule;
import com.root101.module.control.licence.ui.module.LicenceSwingModule;
import com.jhw.module.util.local_server.ui.module.LocalServerSwingModule;
import com.jhw.module.util.rest_config.ui.module.RestConfigSwingModule;
import com.jhw.module.util.authentication_manager.ui.module.AuthSwingModule;
import com.root101.module.admin.kanban.ui.module.KanbanSwingModule;
import com.root101.module.gestion.contabilidad.ui.module.ContabilidadSwingModule;
import com.root101.module.gestion.gastos.ui.module.GastoSwingModule;

/**
 *
 * @author Root101 (jhernandezb96@gmail.com, +53-5-426-8660)
 * @author JesusHdezWaterloo@Github
 */
public class Main {

    public static final SwingApplication app = new SwingApplication();

    public static void main(String args[]) throws Exception {
        new LoadingWorker<Void>(new _PanelGradient()/*new SplashScreen() {
            @Override
            public JPanel mainSplash() {
                _PanelGradient back = new _PanelGradient();
                back.setIcon(MaterialIcons.CARD_GIFTCARD.deriveIcon(500));
                return back;
            }
        }*/, new LoadingProcess<Void>() {
            @Override
            public Void process() throws Exception {
                app.run();
                app.registerModule(
                        DefaultConfigSwingModule.init(),
                        BugSwingModule.init(),
                        CalcSwingModule.init(),
                        TecSwingModule.init(),
                        LicenceSwingModule.init(),
                        CompanySwingModule.init(),
                        RestConfigSwingModule.init(),
                        AuthSwingModule.init(),
                        LocalServerSwingModule.init(),
                        
                        
                        ContabilidadSwingModule.init(),
                        GastoSwingModule.init(),
                        KanbanSwingModule.init(),
                        SeguridadSwingModule.init()
                );
                //AuthenticationHandler.login("admin", "admin");
                //app.navigateTo("DASHBOARD");
                return null;
            }

            @Override
            public void completed(Void result) throws Exception {
                System.out.println("Iniciando el sistema....");
                //app.registerModule(ConsoleSwingModule.init());
                app.show();
            }

            @Override
            public void errorInProcess(Exception result) {
                System.out.println("Error iniciando el sistema....");
                result.printStackTrace();

                JOptionPane.showConfirmDialog(null,
                        "Error iniciando el sistema. Contacte con soporte.",
                        "Error",
                        JOptionPane.OK_CANCEL_OPTION,
                        JOptionPane.ERROR_MESSAGE);

                System.exit(-1);
            }
        });
    }

}
