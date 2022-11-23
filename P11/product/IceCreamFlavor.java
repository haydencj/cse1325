package product;

/***************************************************************************************
*    Title: IceCreamFlavor
*    Author: George Rice
*    Date: 11/22/2022
*    Code version: 1.0
*    Availability: https://github.com/prof-rice/cse1325-prof/tree/main/P11
*
***************************************************************************************/

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

public class IceCreamFlavor extends Item {
    public IceCreamFlavor(String name, String description, int cost, int price) {
        super(name, description, cost, price);
    }
    public IceCreamFlavor(BufferedReader br) throws IOException {
        super(br);
    }
    
    public void save(BufferedWriter bw) throws IOException {
        super.save(bw);
    }
}
