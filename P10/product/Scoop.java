package product;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

public class Scoop{
    public Scoop(IceCreamFlavor flavor){
        this.flavor = flavor;
        this.mixins = new ArrayList<>();
    }

    public Scoop(BufferedReader br) throws IOException {
        this.flavor = new IceCreamFlavor(br);
        this.mixins = new ArrayList<>();
        int numMixIns = Integer.parseInt(br.readLine());
        while(numMixIns-- > 0) mixins.add(new MixIn(br));
    }

    public void save(BufferedWriter bw) throws IOException {
        flavor.save(bw);
        bw.write("" + mixins.size() + '\n');
        for(MixIn mi : mixins) mi.save(bw);
    }

    public void addMixIn(MixIn mixin){
        mixins.add(mixin);
    }

    @Override
    public String toString(){
        if(mixins.isEmpty() == true){
            return flavor.name();
        }

        else if(mixins.size()==1){
            return flavor.name() + "with" + mixins;
        }

        else{ //i.e. more than one mix in
            String result = mixins.get(0).toString();
            for(int i=1; i<mixins.size(); i++){
                result += ", " + mixins.get(i);
            }

            return flavor.name() + " with " + result;
        }
    }

    private IceCreamFlavor flavor;
    private ArrayList<MixIn> mixins;
}