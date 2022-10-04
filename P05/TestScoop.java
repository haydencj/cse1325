public class TestScoop {
    public static void main(String[] args){
        MixInFlavor one = new MixInFlavor("Nuts", "Yummy nuts", 5, 10);
        MixInFlavor two = new MixInFlavor("Gummies", "", 0, 0);
        MixInFlavor three = new MixInFlavor("", "", -5, -10);
        MixInFlavor four = new MixInFlavor("ぎ", "ツ", 13, 7);

        IceCreamFlavor iceCream = new IceCreamFlavor("Vanilla", "Creamy", 2, 4);

        Scoop scoopOne = new Scoop(iceCream);
        Scoop scoopTwo = new Scoop(iceCream);
        Scoop scoopThree = new Scoop(iceCream);

        scoopTwo.addMixIn(new MixIn(one, MixInAmount.Normal));
        scoopTwo.addMixIn(new MixIn(one, MixInAmount.Drenched));

        scoopThree.addMixIn(new MixIn(one, MixInAmount.Light));
        scoopThree.addMixIn(new MixIn(one, MixInAmount.Extra));
        scoopThree.addMixIn(new MixIn(one, MixInAmount.Drenched));

        test(one, "Nuts Yummy nuts 5 10");
        test(two, "Gummies  0 0");
        test(three, "  -5 -10");
        test(four, "ぎ ツ 13 7");
        System.out.println("------------");

        test(iceCream, "Vanilla Creamy 2 4");
        System.out.println("------------");

        test(scoopOne, "Vanilla");
        test(scoopTwo, "Vanilla with Nuts, Nuts (Drenched)");
        test(scoopThree, "Vanilla with Nuts (Light), Nuts (Extra), Nuts (Drenched) ");
    }
    
    private static void test(Item item, String expected){
        String actual = item.name() + " " + item.description() + " " + item.cost() + " " + item.price();
        System.out.println(actual);
        System.out.println(expected);
        System.out.println(actual.equals(expected));
    }

    private static void test(Scoop scoop, String expected){
        System.out.println(scoop);
        System.out.println(expected);
        System.out.println(scoop.toString() == expected);
    }

    //private static String errorFormat;
}
