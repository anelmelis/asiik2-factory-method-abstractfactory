package application;
import logistics.Logistics;
import ui.Button;
import ui.Checkbox;
import ui.GUIFactory;

public class DeliveryAp {
    private GUIFactory guiFactory;
    private Logistics logistics;

    public DeliveryAp(GUIFactory guiFactory, Logistics logistics) {
        this.guiFactory = guiFactory;
        this.logistics = logistics;
    }


    public void run() {
        Button button = guiFactory.createButton();
        Checkbox checkbox = guiFactory.createCheckbox();
        button.paint();
        checkbox.paint();

        logistics.planDelivery(
                "laboratory equipment",
                "Aktau warehouse"
        );
    }
}