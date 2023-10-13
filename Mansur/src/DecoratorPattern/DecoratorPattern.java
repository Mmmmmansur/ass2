package DecoratorPattern;

/*
 * The following code demonstrates the Decorator Design Pattern,
 * which allows behavior to be added to an individual object, either statically or dynamically,
 * without affecting the behavior of other objects from the same class.
 */

// Interface representing the Dress
interface Dress
{
    public void assemble();
}

// Concrete class representing the Basic Dress
class BasicDress implements Dress
{
    @Override
    public void assemble()
    {
        System.out.println("Basic Dress Features");
    }
}

// Abstract decorator class for extending Dress functionality
class DressDecorator implements Dress
{
    protected Dress dress;
    public DressDecorator(Dress c)
    {
        this.dress = c;
    }

    @Override
    public void assemble()
    {
        this.dress.assemble();
    }
}

// Concrete decorator class for adding Casual Dress features
class CasualDress extends DressDecorator
{
    public CasualDress(Dress c)
    {
        super(c);
    }

    @Override
    public void assemble()
    {
        super.assemble();
        System.out.println("Adding Casual Dress Features");
    }
}

// Concrete decorator class for adding Sporty Dress features
class SportyDress extends DressDecorator
{
    public SportyDress(Dress c)
    {
        super(c);
    }

    @Override
    public void assemble()
    {
        super.assemble();
        System.out.println("Adding Sporty Dress Features");
    }
}

// Concrete decorator class for adding Fancy Dress features
class FancyDress extends DressDecorator
{
    public FancyDress(Dress c)
    {
        super(c);
    }

    @Override
    public void assemble()
    {
        super.assemble();
        System.out.println("Adding Fancy Dress Features");
    }
}

// Main class to test the Decorator Pattern
public class DecoratorPattern
{
    public static void main(String[] args)
    {
        Dress sportyDress = new SportyDress(new BasicDress());
        sportyDress.assemble(); // Assembling a SportyDress with BasicDress features
        System.out.println();

        Dress fancyDress = new FancyDress(new BasicDress());
        fancyDress.assemble(); // Assembling a FancyDress with BasicDress features
        System.out.println();

        Dress casualDress = new CasualDress(new BasicDress());
        casualDress.assemble(); // Assembling a CasualDress with BasicDress features
        System.out.println();

        Dress sportyFancyDress = new SportyDress(new FancyDress(new BasicDress()));
        sportyFancyDress.assemble(); // Assembling a SportyDress with FancyDress and BasicDress features
        System.out.println();

        Dress casualFancyDress = new CasualDress(new FancyDress(new BasicDress()));
        casualFancyDress.assemble(); // Assembling a CasualDress with FancyDress and BasicDress features
    }
}
