import java.io.Serializable;

public class USD_object extends coin implements Serializable {
    private final double Value=3.52; //The foreign exchange rate
    @Override
    public double getValue(){
        return Value;
    }
    public double Calculate (double Arg){ //will multiply the user amount in the right foreign exchange rate
        return Arg*getValue();
    }

}