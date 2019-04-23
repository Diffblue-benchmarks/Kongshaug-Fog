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
 * @author sofieamalielandt
 */
public class Carport
{
    private int width;
    private int depth;
    private HashMap<String, HashMap<String, String>> materials;
    private ArrayList parts;
    private roof roof;
    private shed shed;

    public Carport(int width, int depth, roof roof, shed shed) {
        this.width = width;
        this.depth = depth;
        this.roof = roof;
        this.shed = shed;
     
    }

    public Carport(int width, int depth, roof roof) {
        this.width = width;
        this.depth = depth;
        this.roof = roof;
    }


    public int getWidth() {
        return width;
    }

    public int getDepth() {
        return depth;
    }

    public HashMap<String, HashMap<String, String>> getMaterials() {
        return materials;
    }

    public roof getRoof() {
        return roof;
    }

    public shed getShed() {
        return shed;
    }

    public void setMaterials(HashMap<String, HashMap<String, String>> materials) {
        this.materials = materials;
    }

    public ArrayList getParts() {
        return parts;
    }

    public void setParts(ArrayList parts) {
        this.parts = parts;
    }
    
    
}
