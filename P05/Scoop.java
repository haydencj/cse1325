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
        if(mixins.isEmpty() == false){
            if(mixins.size()==1){
                return flavor.name() + "with" + mixins;
            }

            else{ //i.e. more than one mix in
                String result = "";
                for(var mixin : mixins) {
                    result += mixin + ", ";
                }
                return result;
            }

        }

        else return flavor.name();
    }

    private IceCreamFlavor flavor;
    private ArrayList<MixIn> mixins = new ArrayList<MixIn>();
}