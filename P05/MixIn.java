public class MixIn{
    public MixIn(MixInFlavor flavor, MixInAmount amount){
        this.flavor = flavor;
        this.amount = amount;
    }

    @Override
    public String toString(){
        if(amount != MixInAmount.Normal){
            return flavor.name() + " " + "(" + amount + ")";
        }

        else {
            return flavor.name();
        }
    }

    private MixInFlavor flavor;
    private MixInAmount amount;
}s 