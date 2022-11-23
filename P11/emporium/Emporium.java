package emporium;

import product.IceCreamFlavor;
import product.MixInFlavor;
import product.Container;
import product.Order;
import product.Serving;
import person.Customer;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

import java.util.ArrayList;

/***************************************************************************************
*    Title: Emporium
*    Author: George Rice
*    Date: 11/22/2022
*    Code version: 1.0
*    Availability: https://github.com/prof-rice/cse1325-prof/tree/main/P11
*
***************************************************************************************/

public class Emporium {
    public Emporium() { }
    
    public Emporium(BufferedReader br) throws IOException { 
        int size = Integer.parseInt(br.readLine());
        while(size-- > 0) mixInFlavors.add(new MixInFlavor(br));

        size = Integer.parseInt(br.readLine());
        while(size-- > 0) iceCreamFlavors.add(new IceCreamFlavor(br));

        size = Integer.parseInt(br.readLine());
        while(size-- > 0) containers.add(new Container(br));

        size = Integer.parseInt(br.readLine());
        while(size-- > 0) orders.add(new Order(br));

        size = Integer.parseInt(br.readLine());
        for(int i = 0; i < size; ++i) {
            customers.add(new Customer(br));
        }
    }    
    public void save(BufferedWriter bw) throws IOException {
        bw.write("" + mixInFlavors.size() + '\n');
        for(MixInFlavor mif : mixInFlavors) mif.save(bw);

        bw.write("" + iceCreamFlavors.size() + '\n');
        for(IceCreamFlavor icf : iceCreamFlavors) icf.save(bw);

        bw.write("" + containers.size() + '\n');
        for(Container c : containers) c.save(bw);

        bw.write("" + orders.size() + '\n');
        for(Order o : orders) o.save(bw);

        bw.write("" + customers.size() + '\n');
        for(Customer c : customers) c.save(bw);
    }

    public void addMixInFlavor(MixInFlavor flavor) {
        mixInFlavors.add(flavor);
    }
    public void addIceCreamFlavor(IceCreamFlavor flavor) {
        iceCreamFlavors.add(flavor);
    }
    public void addContainer(Container container) {
        containers.add(container);
    }
    public void addOrder(Order order) {
        orders.add(order);
        Customer customer = order.getCustomer();

        for(var s : order.servings()) favoriteServings.put(customer, (Serving) s);
    }
    public void addCustomer(Customer customer) {
        customers.add(customer);
    }
    public Object[] iceCreamFlavors() {
        return this.iceCreamFlavors.toArray();
    }
    public Object[] mixInFlavors() {
        return this.mixInFlavors.toArray();
    }
    public Object[] containers() {
        return this.containers.toArray();
    }
    public Object[] orders() {
        return this.orders.toArray();
    }
    public Object[] customers() {
        return this.customers.toArray();
    }
    public Object[] favoriteServings(Customer customer) {
        return favoriteServings.get(customer);
    }

    private ArrayList<MixInFlavor> mixInFlavors = new ArrayList<>();
    private ArrayList<IceCreamFlavor> iceCreamFlavors = new ArrayList<>();
    private ArrayList<Container> containers = new ArrayList<>();
    private ArrayList<Order> orders = new ArrayList<>();
    private ArrayList<Customer> customers = new ArrayList<>();
    private MultiMap<Customer, Serving> favoriteServings = new MultiMap<>();
}
