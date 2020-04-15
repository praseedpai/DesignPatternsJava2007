interface Image 
{
    public abstract void displayImage();
}
 
//on System A 
class RealImage implements Image 
{
    private String filename;
 
    public RealImage(String filename) 
    { 
        this.filename = filename;
        loadImageFromDisk();
    }
 
    private void loadImageFromDisk() 
    {
        System.out.println("Loading   " + filename);
    }
 
    public void displayImage() 
    { 
        System.out.println("Displaying " + filename); 
    }
 
}
 
//on System B 
class ProxyImage implements Image 
{
    private String filename;
    private RealImage image;
 
    public ProxyImage(String filename) 
    { 
        this.filename = filename; 
    }
 
    public void displayImage() 
    {
        if (image == null) 
        {
           image = new RealImage(filename);
        } 
        image.displayImage();
    }
}
 
class ProxyTest
{
    public static void main(String[] args) 
    {
        Image image1 = new ProxyImage("HiRes_10MB_Photo1");
        Image image2 = new ProxyImage("HiRes_10MB_Photo2");     
 
        image1.displayImage(); // loading necessary
        image2.displayImage(); // loading necessary
        image1.displayImage(); // loading unnecessary
    }
}
