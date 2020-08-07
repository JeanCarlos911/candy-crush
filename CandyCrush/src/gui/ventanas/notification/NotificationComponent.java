package gui.ventanas.notification;

import javax.swing.JComponent;
import models.Componente;

public class NotificationComponent implements Componente {

    private NotificationTemplate notificationTemplate;

    public NotificationComponent(){
        this.notificationTemplate = new NotificationTemplate();
    }

    @Override
    public JComponent getGraphicComponent() {
        return notificationTemplate;
    }

    
    
}