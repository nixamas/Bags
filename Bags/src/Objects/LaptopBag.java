package Objects;
import Exceptions.LaptopOverheatException;




public class LaptopBag {
	private final String brand;
	private final double capacity;
	private final String color;
	private boolean open;
	private Laptop laptop;
	
	public LaptopBag(String brand, double capacity, String color, boolean open, Laptop laptop) {
		this.brand = brand;
		this.capacity = capacity;
		this.color = color;
		this.open = open;
		this.setLaptop(laptop);
	}
	@Override
	public String toString() {
		return "LaptopBag [brand=" + brand + ", capacity=" + capacity
				+ ", color=" + color + ", open=" + open + ", laptop=" + laptop
				+ "]";
	}
	public Laptop getLaptop() {
		return laptop;
	}
	public void setLaptop(Laptop laptop) throws LaptopOverheatException {
		if(laptop.isOn() == true){
			throw new LaptopOverheatException();
		}
		this.laptop = laptop;
	}
	public String getBrand() {
		return brand;
	}
	public double getCapacity() {
		return capacity;
	}
	public String getColor() {
		return color;
	}
	public boolean isOpen() {
		return open;
	}
	public void setOpen(boolean open) {
		this.open = open;
	}
}
