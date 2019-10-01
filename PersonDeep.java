package lecture5Deep;

class Computer implements Cloneable {
	private String manufacturer; 
	private String processor; 
	private int ramSize; 
	private double processorSpeed;
	public Computer(String manufacturer,String processor,int ramSize,
			double processorSpeed) {
		this.manufacturer=manufacturer;
		this.processor=processor;
		this.ramSize=ramSize;
		this.processorSpeed=processorSpeed;
		
	}
	
	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public void setProcessorSpeed(double processorSpeed) {
		this.processorSpeed = processorSpeed;
	}

	public void setProcessor(String processor) {
		this.processor = processor;
	}

	public void setRamSize(int ramSize) {
		this.ramSize = ramSize;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public String getProcessor() {
		return processor;
	}

	public int getRamSize() {
		return ramSize;
	}
	public double getProcessorSpeed() {
		return processorSpeed;
	}
	public double computePower() {
		return ramSize *processorSpeed;
	}
	
	public Object Clone() throws CloneNotSupportedException {
		Computer pCopy=(Computer) super.clone();
		
		return pCopy;
	}
	
	public String toString() {
		return "\nManufacturer:"+this.manufacturer+
				"\nProcessor Type:"+this.processor+
				"\nRAM size: "+this.ramSize+"GB"+
				"\nSpeed: "+this.processorSpeed+"GHz";
	}

}

public class PersonDeep implements Cloneable {
	public String name;          
	public Computer computer;
	public PersonDeep(String name,Computer computer){
		this.name=name;
		this.computer=computer;
		
	}
	public Object Clone() throws CloneNotSupportedException {
		PersonDeep pCopy=(PersonDeep) super.clone();
		pCopy.computer = (Computer) this.computer.Clone();
		return pCopy;
	}
	@Override
	public String toString() {
		return "\nName-->" + name + "\ncomputer-->" + computer;
	}  
	public static void main(String[] args) throws CloneNotSupportedException {
		
		PersonDeep p1=new PersonDeep("Haile",new Computer("Apple", "Macintosh IIcx", 8, 3.1));

		
		System.out.println("Before Deep Copy");
		System.out.println(p1);
		System.out.println("===================");
		PersonDeep p2=(PersonDeep) p1.Clone();
		System.out.println("After Deep Copy");
		p2.name="Tesfai";
		p2.computer.setManufacturer("hp");
		p2.computer.setProcessor("Intel Core");
		p2.computer.setRamSize(16);
		p2.computer.setProcessorSpeed(2.7);
		
		System.out.println("Original P1:"+p1);
		System.out.println("______________________");
		System.out.println("Copy of P1(i.e P2):"+p2);
		
	}
}
