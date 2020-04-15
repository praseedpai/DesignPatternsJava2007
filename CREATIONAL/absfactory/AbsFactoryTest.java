import java.lang.*;


interface IWindow {

	public void Render();
}

interface IButton {

	public void Render();
}

interface IListBox {
	public void Render();
}


class MSWindow implements IWindow
{
	public void Render() { 
		System.out.println("Microsoft Windows Window");
	}

}

class MACWindow implements IWindow
{
	public void Render() { 
		System.out.println("Mac OS X Window");
	}

}

class XWindow implements IWindow
{
	public void Render() { 
		System.out.println("X Windows Window");
	}

}

class MSListBox implements IListBox
{
	public void Render() { 
		System.out.println("Microsoft Windows ListBox");
	}

}

class MACListBox implements IListBox
{
	public void Render() { 
		System.out.println("Mac OS X ListBox");
	}

}

class XListBox implements IListBox
{
	public void Render() { 
		System.out.println("X Windows ListBox");
	}

}

class MSButton implements IButton
{
	public void Render() { 
		System.out.println("Microsoft Windows Button");
	}

}

class MACButton implements IButton
{
	public void Render() { 
		System.out.println("Mac OS X Button");
	}

}

class XButton implements IButton
{
	public void Render() { 
		System.out.println("X Windows Button");
	}

}

interface GUIFactory {
    public IButton createButton();
    public IListBox createListBox();
    public IWindow createWindow();
}
 
 
class WinFactory implements GUIFactory {
    public IButton createButton() {
        return new MSButton();
    }

    public IListBox createListBox() { return new MSListBox(); }
    public IWindow createWindow() { return new MSWindow(); }
}
 
 
class OSXFactory implements GUIFactory {
     public IButton createButton() {
        return new MACButton();
    }

    public IListBox createListBox() { return new MACListBox(); }
    public IWindow createWindow() { return new MACWindow(); }
}

class XFactory implements GUIFactory {
     public IButton createButton() {
        return new XButton();
    }

    public IListBox createListBox() { return new  XListBox(); }
    public IWindow createWindow() { return new XWindow(); }
}



class Application {
    public Application(GUIFactory factory){
        IButton button = factory.createButton();
        button.Render();
    }
}
 
public class AbsFactoryTest {
    public static void main(String[] args) {
        new Application(createOsSpecificFactory("MS"));
    }
 
    public static GUIFactory createOsSpecificFactory(String OS) {
        
        if (OS == "MS") {
            return new WinFactory();
        } else if ( OS == "OSX") {
            return new OSXFactory();
        }
        else {
            return new XFactory();
        }  
    }
}
