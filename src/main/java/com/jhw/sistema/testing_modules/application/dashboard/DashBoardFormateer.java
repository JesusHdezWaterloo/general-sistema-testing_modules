package com.jhw.sistema.testing_modules.application.dashboard;

import com.jhw.module.util.personalization.core.domain.Personalization;
import com.jhw.module.util.personalization.services.PersonalizationHandler;
import com.jhw.swing.material.components.container.panel._PanelGradient;
import com.jhw.swing.material.components.dashboard.taskpane.expanded.DashBoardExtends;
import com.jhw.swing.material.components.dashboard.taskpane.expanded.DownPanel;
import com.jhw.swing.material.components.dashboard.taskpane.expanded.UpPanel;
import com.jhw.swing.material.components.taskpane.CollapseMenu;
import com.jhw.swing.material.components.taskpane.TaskButton;
import com.jhw.swing.material.standards.MaterialColors;
import com.jhw.swing.material.standards.MaterialFontRoboto;
import com.jhw.swing.util.Utils;
import com.jhw.swing.util.enums.GradientEnum;
import java.awt.Color;
import java.awt.Dimension;
import java.util.function.Consumer;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

public class DashBoardFormateer {

    private static final Color SECUNDARY_0 = MaterialColors.BLUE_300;
    private static final Color SECUNDARY_1 = MaterialColors.BLUE_400;
    private static final Color SECUNDARY_2 = MaterialColors.BLUE_500;
    private static final Color SECUNDARY_3 = MaterialColors.BLUE_800;
    private static final Color SECUNDARY_4 = MaterialColors.BLUE_900;

    public static Consumer<TaskButton> buttonFormatter = (TaskButton btn) -> {
        btn.setFont(MaterialFontRoboto.MEDIUM.deriveFont(16f));
        btn.setForeground(MaterialColors.BLACK);

        btn.setDeselectedColor(SECUNDARY_0);
        btn.setMauseOverColor(Utils.darken(SECUNDARY_1));
        btn.setSelectedColor(Utils.darken(Utils.darken(SECUNDARY_2)));

        btn.setPreferredSize(new Dimension(btn.getPreferredSize().width, 40));
        btn.deselect();//marcar el deselect para que pinte
    };

    public static Consumer<CollapseMenu> collapseMenuFormatter = (CollapseMenu menu) -> {
        menu.setDeselectedColor(SECUNDARY_3);
        menu.setSelectedColor(SECUNDARY_4);
        menu.setMainPanelForeground(MaterialColors.BLACK);

        //menu.setCollapsablePanelBackground(Color.green);
        menu.setMainPanelFont(MaterialFontRoboto.MEDIUM.deriveFont(20f));
        menu.setButtonNameHorizontalAlignment(SwingConstants.LEFT);

        menu.setComponentsGap(0);
        //menu.setPanelCollapsibleGaps(0, 20, 0, 0);
        menu.setHeight(50);
        menu.setWidth(250);
    };

    public static Consumer<DashBoardExtends> dashBoardFormatter = (DashBoardExtends dash) -> {
        dash.setPanelSideMenuColor(SECUNDARY_0);
        dash.getDashboardCore().removeDownButton();
        //dash.getDashboardCore().removeUpButton();
    };

    public static Consumer<UpPanel> upPanelFormatter = (UpPanel up) -> {
        ((_PanelGradient) up.getBackgroundPanel()).setPrimaryColor(SECUNDARY_0);//TODO: estandar para gradient
        ((_PanelGradient) up.getBackgroundPanel()).setSecundaryColor(PersonalizationHandler.getColor(Personalization.KEY_COLOR_SECUNDARY));
        ((_PanelGradient) up.getBackgroundPanel()).setGradient(GradientEnum.VERTICAL_3_4);
    };

    public static Consumer<DownPanel> downPanelFormatter = (DownPanel down) -> {
        down.getBackgroundPanel().setBackground(MaterialColors.GREY_200);
        down.getBackgroundPanel().setBorder(new LineBorder(MaterialColors.GREY_500, 1));
    };
}
