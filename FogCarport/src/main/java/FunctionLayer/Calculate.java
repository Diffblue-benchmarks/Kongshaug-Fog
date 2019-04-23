/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FunctionLayer;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author benja
 */
public class Calculate {

    public Carport caluclatepoles(Carport carport, Material pole, Material bolt, Material disc) {
        int depth = carport.getDepth();

        ArrayList parts = carport.getParts();
        //a pole is placed for each 2.5 meter on the right and left side of the carport
        int numberOfPoles = depth / 200 * 2;
        int boltParts = numberOfPoles * 4;

        Part poles = new Part(pole, 300, numberOfPoles, "Stolper nedgraves 90 cm. i jord");
        Part bolts = new Part(bolt, 0, boltParts, "Til montering af rem	på stolper");
        Part discs = new Part(disc, 0, boltParts, "Til montering af rem	på stolper");
        parts.add(poles);
        parts.add(bolts);
        parts.add(discs);
        carport.setParts(parts);

        return carport;

    }

    public Carport caluclatRem(Carport carport, Material rem) {
        int depth = carport.getDepth();

        ArrayList parts = carport.getParts();
    //calculate rem and put in arraylist

        int remmen = depth;

        Part remmene = new Part(rem, remmen, 2, "Remme i sider, sadles ned	i stolper");
        parts.add(remmene);
        carport.setParts(parts);

        return carport;

    }

 

}