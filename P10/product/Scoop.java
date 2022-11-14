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

    public Scoop(BufferedReader in) throws IOException {
        flavor = new IceCreamFlavor(in);
        int size = Integer.parseInt(in.readLine());
        for(int i = 0; i<size; i++){
            mixins.add(new MixIn(in));
        }
    }

    public void save(BufferedWriter out) throws IOException {
        flavor.save(out);
        out.write("" + mixins.size() + '\n');
        for(MixIn mx : mixins) {
            mx.save(out);
        }
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