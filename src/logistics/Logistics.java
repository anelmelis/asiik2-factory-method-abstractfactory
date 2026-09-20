package logistics;
import transport.Transport;
public abstract class Logistics {

    public abstract Transport createTransport();
    public void planDelivery(String cargo, String destination) {
        Transport transport = createTransport();
        System.out.println("Delivery planning started");
        transport.deliver(cargo, destination);
    }
}
