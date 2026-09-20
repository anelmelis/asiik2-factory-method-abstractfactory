import application.DeliveryAp;
import logistics.Logistics;
import logistics.RoadLogistics;
import logistics.SeaLogistics;
import ui.GUIFactory;
import ui.MacOSFactory;
import ui.WindowsFactory;

import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Choose delivery mode (ROAD/SEA): ");
        String deliveryMode = scanner.nextLine().trim().toUpperCase();
        System.out.print("Choose UI platform (WINDOWS/MACOS): ");
        String platform = scanner.nextLine().trim().toUpperCase();

        System.out.println("Delivery mode: " + deliveryMode);
        System.out.println("UI platform: " + platform);

        Logistics logistics;
        if (deliveryMode.equals("ROAD")) {
            logistics = new RoadLogistics();
        } else if (deliveryMode.equals("SEA")) {
            logistics = new SeaLogistics();
        } else {
            System.out.println("Unsupported delivery mode");
            return;
        }


        GUIFactory factory;
        if (platform.equals("WINDOWS")) {
            factory = new WindowsFactory();
        } else if (platform.equals("MACOS")) {
            factory = new MacOSFactory();
        } else {
            System.out.println("Unsupported UI platform");
            return;
        }

        DeliveryAp app =
                new DeliveryAp(factory, logistics);
        app.run();
    }
}