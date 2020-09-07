public class Factory{ // create the right coin element - ILS vs USD
    public static coin GetCoinInstance(Coins coin1){
        switch (coin1){
            case ILS : return new ILS_object();
            case USD : return new USD_object();
        }
        return null;
    }
}