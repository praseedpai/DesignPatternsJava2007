////////////////////
//
// An Example of Facade pattern
//
//
//
class CPU {
 
    public void freeze() { 
	
	System.out.println("CPU Freeze ...");
    }


    public void jump(long position) {
	System.out.println("Jumping to the position....");
    }
    public void execute() { 
	System.out.println("started execution.....");
    }
 
}
 
class Memory {
 
    public void load(long position, byte[] data) { System.out.println("Loading data..."); return;}
 
}
 
class HardDrive {
 
    public byte[] read(long lba, int size) { System.out.println("Reading the boot sector.."); return null; }
 
}
 
/* Facade */
 
class Computer {
 
    private CPU cpu;
    private Memory memory;
    private HardDrive hardDrive;
    final static int BOOT_SECTOR = 256;
    final static int SECTOR_SIZE = 512;
    final static int BOOT_ADDRESS = 0xFF00;  

    public Computer() {
        this.cpu = new CPU();
        this.memory = new Memory();
        this.hardDrive = new HardDrive();
    }
 
    public void startComputer() {
        cpu.freeze();
        memory.load(Computer.BOOT_ADDRESS, hardDrive.read(Computer.BOOT_SECTOR, Computer.SECTOR_SIZE));
        cpu.jump(Computer.BOOT_ADDRESS);
        cpu.execute();
    }
 
}
 
/* Client */
 
class FacadeTest {
 
    public static void main(String[] args) {
        Computer facade = new Computer();
        facade.startComputer();
    }
 
}
