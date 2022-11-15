package product;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

import java.util.ArrayList;

public class Serving {
    public Serving(Container container) {
        this.container = container;
        this.toppings = new ArrayList<>();
        this.scoops = new ArrayList<>();
    }

    public Serving(BufferedReader in) throws IOException {
        this.container = new Container(in);
        this.toppings = new ArrayList<>();
        this.scoops = new ArrayList<>();

        int size = Integer.parseInt(in.readLine());
        while(size-- > 0) toppings.add(new MixIn(in));
        
        size = Integer.parseInt(in.readLine());
        while(size-- > 0) scoops.add(new Scoop(in));
    }

    public void save(BufferedWriter out) throws IOException {
        container.save(out);
        out.write("" + toppings.size() + '\n');
        for(MixIn mi : toppings) mi.save(out);
        
        out.write("" + scoops.size() + '\n');
        for(Scoop scp : scoops) scp.save(out);
    }

    public void addScoop(Scoop scoop) {
        scoops.add(scoop);
    }

    public void addTopping(MixIn topping) {
        toppings.add(topping);
    }

    private Container container;
    private ArrayList<MixIn> toppings;
    private ArrayList<Scoop> scoops;
}
