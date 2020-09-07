import java.io.Serializable;

public class ILS_object extends coin implements Serializable {
    private final double Value=0.28; // The foreign exchange rate
    @Override
    public double getValue(){
        return Value;
    }
    public double Calculate (double Arg){ //will multiply the user amount in the right foreign exchange rate
        return Arg*getValue();

    }

}