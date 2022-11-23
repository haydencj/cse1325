package product;

/***************************************************************************************
*    Title: Container
*    Author: George Rice
*    Date: 11/22/2022
*    Code version: 1.0
*    Availability: https://github.com/prof-rice/cse1325-prof/tree/main/P11
*
***************************************************************************************/

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

public class Container {
    public Container(String name, String description, int maxScoops) {
        this.name = name;
        this.description = description;
        this.maxScoops = maxScoops;
    }
    public Container(BufferedReader br) throws IOException {
        this.name = br.readLine();
        this.description = br.readLine();
        this.maxScoops = Integer.parseInt(br.readLine());
    }
    
    public void save(BufferedWriter bw) throws IOException {
        bw.write(name + '\n');
        bw.write(description + '\n');
        bw.write("" + maxScoops + '\n');
    }
    public String name() {return name;}
    public String description() {return description;}
    public int maxScoops() {return maxScoops;}

    @Override
    public String toString() {
        return name;
    }
    private String name;
    private String description;
    private int maxScoops;
}
