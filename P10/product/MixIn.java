package product;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

public class MixIn{
    public MixIn(MixInFlavor flavor, MixInAmount amount){
        this.flavor = flavor;
        this.amount = amount;
    }

    public MixIn(BufferedReader in) throws IOException {
        flavor = new MixInFlavor(in);
        amount = MixInAmount.valueOf(in.readLine());
    }

    public void save(BufferedWriter out) throws IOException {
        flavor.save(out);
        out.write("" + amount.toString() + '\n');
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
}