package gui.components.notification;


import models.Componente;
import javax.swing.JPanel;

public class NotificationComponent implements Componente {

    private NotificationTemplate notificationTemplate;

    public NotificationComponent(){
        this.notificationTemplate = new NotificationTemplate();
    }

    @Override
    public JPanel getGraphicComponent() {
        return notificationTemplate;
    }

    
    
}