import java.util.List;
import java.util.ArrayList;
 
/** "Component" */
interface Graphic {
 
    //Prints the graphic.
    public void print();
}
 
/** "Composite" */
class CompositeGraphic implements Graphic {
 
    //Collection of child graphics.
    private List<Graphic> mChildGraphics = new ArrayList<Graphic>();
 
    //Prints the graphic.
    public void print() {
        for (Graphic graphic : mChildGraphics) {
            graphic.print();
        }
    }
 
    //Adds the graphic to the composition.
    public void add(Graphic graphic) {
        mChildGraphics.add(graphic);
    }
 
    //Removes the graphic from the composition.
    public void remove(Graphic graphic) {
        mChildGraphics.remove(graphic);
    }
}
 
/** "Leaf" */
class Ellipse implements Graphic {
 
    //Prints the graphic.
    public void print() {
        System.out.println("Ellipse");
    }
}


/** "Leaf" */
class Rectangle implements Graphic {
 
    //Prints the graphic.
    public void print() {
        System.out.println("Rectangle");
    }
}


class Arc extends Ellipse {
    //Prints the graphic.
    public void print() {
        System.out.println("Arc");
    }

}
 
/** Client */
public class CompositeTest {
 
    public static void main(String[] args) {
        //Initialize four ellipses
        Ellipse ellipse1 = new Ellipse();
        Ellipse ellipse2 = new Ellipse();
        Graphic arc = new Arc();
        Graphic rect = new Rectangle();
 
        //Initialize three composite graphics
        CompositeGraphic graphic = new CompositeGraphic();
        CompositeGraphic graphic1 = new CompositeGraphic();
        CompositeGraphic graphic2 = new CompositeGraphic();
 
        //Composes the graphics
        graphic1.add(ellipse1);
        graphic1.add(ellipse2);
        graphic1.add(arc);
 
        graphic2.add(rect);
 
        graphic.add(graphic1);
        graphic.add(graphic2);
 
        //Prints the complete graphic (four times the string "Ellipse").
        graphic.print();
    }
}
