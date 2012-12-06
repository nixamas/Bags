import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Test;

import Interfaces.Computer;
import Interfaces.Disk;
import Interfaces.Storage;
import Objects.Laptop;
import Objects.Memory;
import Objects.Raid;
import Objects.Ssd;



public class BagsTest {

	@Test
	public void test() {
		Collection<Storage> storage = new ArrayList<Storage>();
		storage.add(new Memory(2048));
		storage.add(new Ssd(10, 10, 10));
		
		List<Disk> disks = new ArrayList<Disk>();
		disks.add(new Ssd(10, 20, 30));
		disks.add(new Ssd(15, 25, 35));
		
		storage.add(new Raid(disks));
		
		Laptop laptop = new Laptop("Lenovo", "Intel", storage);
		laptop.installApplication("Eclipse");
		laptop.installApplication("Putty");
		laptop.installApplication("Word");	
		
		System.out.println(laptop.toString());

	}

	
	public static int totalStorageCapacity(Computer comp){
		int tot = 0;
		Collection<Storage> store = comp.getStorage();
		for(Storage s : store){
			tot += s.getCapacity();
		}
		return tot;
	}
}
