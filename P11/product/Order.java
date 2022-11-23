package product;

/***************************************************************************************
*    Title: Order
*    Author: George Rice
*    Date: 11/22/2022
*    Code version: 1.0
*    Availability: https://github.com/prof-rice/cse1325-prof/tree/main/P11
*
***************************************************************************************/

import java.util.ArrayList;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

public class Order {
    public Order() {
        this.servings = new ArrayList<>();
    }
    
    public Order(BufferedReader br) throws IOException {
        this.servings = new ArrayList<>();
        int numServings = Integer.parseInt(br.readLine());
        while(numServings-- > 0) servings.add(new Serving(br));
    }
    
    public void save(BufferedWriter bw) throws IOException {
        bw.write("" + servings.size() + '\n');
        for(Serving s : servings) s.save(bw);
    }

    
    public void addServing(Serving serving) {
        servings.add(serving);
    }

    public int price() {
        int total = 0;
        for(Serving s : servings) total+=s.price();

        return total;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        String separator = "";
        if(servings.size() > 0) {
            for(Serving s : servings) {
                result.append(separator + s.toString());
                separator = "<br/>";
            }
        }
        return result.toString();
    }
    private ArrayList<Serving> servings;
}
