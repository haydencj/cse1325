package product;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

import java.util.ArrayList;

public class Order {
    public Order() { }
    
    public Order(BufferedReader in) throws IOException {
        this.servings = new ArrayList<>();

        int size = Integer.parseInt(in.readLine());
        while(size-- > 0) servings.add(new Serving(in));
    }

    public void save(BufferedWriter out) throws IOException {
        out.write("" + servings.size() + '\n');
        for(Serving s : servings) s.save(out);
    }

    public void addServing(Serving serving) {
        servings.add(serving);
    }

    private ArrayList<Serving> servings;
}
