package emporium;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

import product.IceCreamFlavor;
import product.MixInFlavor;
import product.Scoop;

public class Emporium {
    public Emporium() {

    }

    public Emporium(BufferedReader in) throws IOException{
        int mxSize = Integer.parseInt(in.readLine());
        for(int i = 0; i<mxSize; i++){
            mixInFlavors.add(new MixInFlavor(in));
        }

        int icSize = Integer.parseInt(in.readLine());
        for(int i = 0; i<icSize; i++){
            iceCreamFlavors.add(new IceCreamFlavor(in));
        }

        int scpSize = Integer.parseInt(in.readLine());
        for(int i = 0; i<scpSize; i++){
            scoops.add(new Scoop(in));
        }
    }

    public void save(BufferedWriter out) throws IOException{
        out.write("" + mixInFlavors.size() + '\n');
        for(MixInFlavor mx : mixInFlavors) {
            mx.save(out);
        }

        out.write("" + iceCreamFlavors.size() + '\n');
        for(IceCreamFlavor ic : iceCreamFlavors) {
            ic.save(out);
        }

        out.write("" + scoops.size() + '\n');
        for(Scoop s : scoops) {
            s.save(out);
        }
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

    private ArrayList<MixInFlavor> mixInFlavors = new ArrayList<>();;
    private ArrayList<IceCreamFlavor> iceCreamFlavors = new ArrayList<>();;
    private ArrayList<Scoop> scoops = new ArrayList<>();;
}