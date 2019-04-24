/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FunctionLayer;

import static java.lang.Math.sqrt;
import java.util.ArrayList;

/**
 *
 * @author benja
 */
public class Calculate {

    public void caluclatepoles(Carport carport, Material pole, Material bolt, Material disc) {
        int depth = carport.getDepth();

        ArrayList<Part> parts = carport.getParts();
        //a pole is placed for each 2.5 meter on the right and left side of the carport
        int numberOfPoles = (depth / 200 * 2) + 2;
        int boltParts = numberOfPoles * 4;

        Part poles = new Part(pole, 300, numberOfPoles, "Stolper nedgraves 90 cm. i jord");
        Part bolts = new Part(bolt, 0, boltParts, "Til montering af rem	på stolper");
        Part discs = new Part(disc, 0, boltParts, "Til montering af rem	på stolper");
        parts.add(poles);
        parts.add(bolts);
        parts.add(discs);
        carport.setParts(parts);

    }

    public void caluclatRem(Carport carport, Material rem) {
        int depth = carport.getDepth();

        ArrayList parts = carport.getParts();
        //calculate rem and put in arraylist

        int remmen = depth;

        Part remmene = new Part(rem, remmen, 2, "Remme i sider, sadles ned	i stolper");
        parts.add(remmene);
        carport.setParts(parts);

    }

    public void caluclatFlatRoof(Carport carport, Material spær, Material beslag, Material BeslagSkruer,
            Material lægte, Material RoofScrews) {
        int depth = carport.getDepth();
        int width = carport.getWidth();

        ArrayList parts = carport.getParts();
        //calculate spær and put in arraylist
        int NumberOfSpær = depth / 60 + 1;
        if (depth % 60 != 0) {
            NumberOfSpær++;
        }

        Part spærene = new Part(spær, width, NumberOfSpær, "spær monteres på tværs af de 2 remme");
        parts.add(spærene);

        //for each spær there is 2 beslag
        int NumberOfBeslag = NumberOfSpær * 2;

        Part beslagene = new Part(beslag, 0, NumberOfBeslag, "til montering af spær på remmene");
        parts.add(beslagene);

        //for each beslag you need 9 beslagskruer
        int NumberOfBeslagskruer = NumberOfBeslag * 9;

        Part beslagskruer = new Part(BeslagSkruer, 0, NumberOfBeslagskruer, "til fastgørelse af beslag mellem spær og remmene");
        parts.add(beslagskruer);

         //calculate number of lægter that goes acress the spær
        int numberOfLægter = width / 70 + 1;

        if (width % 70 != 0) {
            numberOfLægter++;
        }

        Part lægterne = new Part(lægte, depth, numberOfLægter, "lægges på tværs af spær");
        parts.add(lægterne);

         //calculate number of screws used to fit plastmo to lægter
        int NumberOfScrews = numberOfLægter * NumberOfSpær;
        int PackagesOfScres = NumberOfScrews / 250;
        if (NumberOfScrews % 250 != 0) {
            PackagesOfScres++;
        }

        Part Screws = new Part(RoofScrews, 0, PackagesOfScres, "til montering af tag på lægter");
        parts.add(Screws);

        carport.setParts(parts);
    }

    public void caluclatFlatLastPartsRoof(Carport carport, Material Plastmo, Material Plastmotætning) {
        int depth = carport.getDepth();
        int width = carport.getWidth();
        ArrayList parts = carport.getParts();

        //on top of the roof is Plastmo Ecolite blåtonet 
        //plastmo is 120 wide and overlap with 20 cm which is why we devide with 100 insted of 120
        int numberOfPlastmo = width / 100;
        if (width % 120 != 0) {
            numberOfPlastmo++;
        }

        Part Plastmoen = new Part(Plastmo, depth, numberOfPlastmo, "tagplader monteres på lægter");
        parts.add(Plastmoen);

        //at the end of the plastmo there is a tætningsprofil
        Part Plastmotætningen = new Part(Plastmotætning, depth, 2, "monteres i for og bagside af Plastmo til tætning for regnvand");
        parts.add(Plastmotætningen);

        carport.setParts(parts);
    }

    public void caluclatSlopeRoof(Carport carport, Material spær, Material lægteBeslag, Material BeslagSkruer,
             Material taglægte, Material beslagRemToTaglægte) {
        int depth = carport.getDepth();
        int width = carport.getWidth();
        int slope = carport.getRoof().getSlope();
        ArrayList parts = carport.getParts();

        //length of roof from edge to top
        //which one? --- find out in next episode
        double halfRoofrad = (width / 2) / Math.toRadians(slope);

        double halfRoof = (width / 2) / Math.cos(slope);

        //hight of roof
        int hight = (int) (sqrt(halfRoof * halfRoof - width * width));

        //calculate spær and put in arraylist
        int NumberOfSpær = (int) (halfRoof / 60 + 1) * 2;
        if (depth % 60 != 0) {
            NumberOfSpær += 2;
        }

        Part spærene = new Part(spær, depth, NumberOfSpær, "spær monteres på taglægtererne");
        parts.add(spærene);

         //calculate parts for taglægter
        //first we find the number of taglægter and then the mesurments of each element of the taglægte
        int numberOfTaglægter = depth / 75 + 1;

        if (depth % 75 != 0) {
            numberOfTaglægter++;
        }

        //the buttom part of the taglægte is the width of the carport
        Part buttomTaglægtePart = new Part(taglægte, width, numberOfTaglægter, "bundstykke til taglægte");
        parts.add(buttomTaglægtePart);

        //the middle part is the hight of the roof (maybe it shoud be minused with the thicknes of the wood)
        Part middleTaglægtePart = new Part(taglægte, hight, numberOfTaglægter, "midterstykke til taglægte");
        parts.add(middleTaglægtePart);
        
        
        //the sides of the taglægte is the legth of the roof and there is 2 of them pr. taglægte
        
        
        Part sideTaglægtePart = new Part(taglægte, (int) halfRoof, numberOfTaglægter * 2, "siddestykker til taglægte");
        parts.add(sideTaglægtePart);
        
         //there is 3 of the beslag for the taglægter pr. taglægte
        
        
        Part beslagTaglægtePart = new Part(beslagRemToTaglægte, (int) halfRoof, numberOfTaglægter * 4, "beslag til at samle taglægter");
        parts.add(beslagTaglægtePart);
        
        //screws to mount the taglægte together with the beslag
        
        int ScrewsForTaglægte = numberOfTaglægter * 36;
        
        Part beslagscrews = new Part(BeslagSkruer, (int) halfRoof, ScrewsForTaglægte, "beslag til at samle taglægter");
        parts.add(beslagTaglægtePart);
        
        
        //beslag to connect the taglægter to rammen
        
         Part beslagTaglægteToRem = new Part(lægteBeslag, (int) halfRoof, numberOfTaglægter * 2, "beslag til at montere taglægte på rem");
        parts.add(beslagTaglægteToRem);
        
        
        
        carport.setParts(parts);
    }

}
