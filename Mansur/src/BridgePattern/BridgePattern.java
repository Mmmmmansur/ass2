package BridgePattern;

// Abstraction class (TV)
abstract class TV
{
    Remote remote;
    TV(Remote r)
    {
        this.remote = r;
    }
    abstract void on(); // Abstract method for turning the TV on
    abstract void off(); // Abstract method for turning the TV off
}

// Concrete implementation class for Sony TV
class Sony extends TV
{
    Remote remoteType;
    Sony(Remote r)
    {
        super(r);
        this.remoteType = r;
    }

    public void on()
    {
        System.out.print("Sony TV ON: ");
        remoteType.on(); // Delegating the 'on' functionality to the specific remote implementation
    }

    public void off()
    {
        System.out.print("Sony TV OFF: ");
        remoteType.off(); // Delegating the 'off' functionality to the specific remote implementation
    }
}

// Concrete implementation class for Philips TV
class Philips extends TV
{
    Remote remoteType;
    Philips(Remote r)
    {
        super(r);
        this.remoteType = r;
    }

    public void on()
    {
        System.out.print("Philips TV ON: ");
        remoteType.on(); // Delegating the 'on' functionality to the specific remote implementation
    }

    public void off()
    {
        System.out.print("Philips TV OFF: ");
        remoteType.off(); // Delegating the 'off' functionality to the specific remote implementation
    }
}

// Interface for implementation (Remote)
interface Remote
{
    public void on(); // Abstract method for turning the remote on
    public void off(); // Abstract method for turning the remote off
}

// Concrete implementation class for Old Remote
class OldRemote implements Remote
{
    @Override
    public void on()
    {
        System.out.println("ON with Old Remote");
    }

    @Override
    public void off()
    {
        System.out.println("OFF with Old Remote");
    }
}

// Concrete implementation class for New Remote
class NewRemote implements Remote
{
    @Override
    public void on()
    {
        System.out.println("ON with New Remote");
    }

    @Override
    public void off()
    {
        System.out.println("OFF with New Remote");
    }
}

// Main class to test the Bridge Pattern
public class BridgePattern
{
    public static void main(String[] args)
    {
        TV sonyOldRemote = new Sony(new OldRemote()); // Creating a Sony TV with an Old Remote
        sonyOldRemote.on(); // Turning on the Sony TV using the Old Remote
        sonyOldRemote.off(); // Turning off the Sony TV using the Old Remote
        System.out.println();

        TV sonyNewRemote = new Sony(new NewRemote()); // Creating a Sony TV with a New Remote
        sonyNewRemote.on(); // Turning on the Sony TV using the New Remote
        sonyNewRemote.off(); // Turning off the Sony TV using the New Remote
        System.out.println();

        TV philipsOldRemote = new Philips(new OldRemote()); // Creating a Philips TV with an Old Remote
        philipsOldRemote.on(); // Turning on the Philips TV using the Old Remote
        philipsOldRemote.off(); // Turning off the Philips TV using the Old Remote
        System.out.println();

        TV philipsNewRemote = new Philips(new NewRemote()); // Creating a Philips TV with a New Remote
        philipsNewRemote.on(); // Turning on the Philips TV using the New Remote
        philipsNewRemote.off(); // Turning off the Philips TV using the New Remote
    }
}
