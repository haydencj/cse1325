package emporium;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.BufferedWriter;

import product.IceCreamFlavor;
import product.MixInFlavor;
import product.Scoop;

public class Emporium {
    public Emporium() {
        this.mixInFlavors = new ArrayList<>();
        this.mixInFlavors = new ArrayList<>();
        this.mixInFlavors = new ArrayList<>();
    }

    public Emporium(BufferedReader in) {
        this();
    }

    public void save(BufferedWriter out) {

    }
    public void addMixInFlavor(MixInFlavor flavor) {
        mixInFlavors.add(flavor);
    }

    public void addIceCreamFlavor(IceCreamFlavor flavor) {
        iceCreamFlavors.add(flavor);
    }

    public void addScoop(Scoop scoop) {
        scoops.add(scoop);
    }

    public Object[] mixInFlavors() {
        return mixInFlavors.toArray();
    }

    public Object[] iceCreamFlavors() {
        return iceCreamFlavors.toArray();
    }

    public Object[] scoops() {
        return scoops.toArray();
    }

    private ArrayList<MixInFlavor> mixInFlavors;
    private ArrayList<IceCreamFlavor> iceCreamFlavors;
    private ArrayList<Scoop> scoops;
}