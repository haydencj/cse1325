import java.util.ArrayList;

public class Scoop{
    public Scoop(IceCreamFlavor flavor){
        this.flavor = flavor;
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
    private ArrayList<MixIn> mixins = new ArrayList<MixIn>();
}