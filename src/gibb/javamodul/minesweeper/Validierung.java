package gibb.javamodul.minesweeper;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import static gibb.javamodul.minesweeper.Minesweeper.textausgaben;


/**
 * Created by Robin Berberat on 18.03.2017.
 */
public class Validierung {

    boolean kommandoValidierung(String[] kommando, Spielfeld spielfeld) {

        int spielFeldbreite = spielfeld.getBreite();
        int spielfeldLaenge = spielfeld.getLaenge();
        Pattern pattern = Pattern.compile("([MmTt])");
        Matcher matcher = pattern.matcher(kommando[0]);

        if (kommando.length != 3) {
            textausgaben.kommandoEingabeUngueltig();
            return false;
        }

        if (kommando[0].length() != 1){
            return false;
        }

        if (!matcher.find()){
            return false;
        }

        if (!tryParseInt(kommando[1]) ||  !tryParseInt(kommando[2])) {
            textausgaben.kommandoEingabeUngueltig();
            return false;
        }

        int xKoordinate = Integer.parseInt(kommando[1]);
        int yKoordinate = Integer.parseInt(kommando[2]);

        if (xKoordinate < 0 || yKoordinate < 0 || xKoordinate >= spielFeldbreite || yKoordinate >= spielfeldLaenge) {
            textausgaben.kommandoEingabeUngueltig();
            return false;
        }
        return true;
    }

    private boolean tryParseInt(String value) {
        try {
            Integer.parseInt(value);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
