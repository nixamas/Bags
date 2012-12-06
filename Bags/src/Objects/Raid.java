package Objects;
import java.util.List;
import java.util.Set;

import Interfaces.Disk;



public class Raid implements Disk{
	
	private final List<Disk> disk;

	public Raid(List<Disk> disk) {
		super();
		this.disk = disk;
	}

	public List<Disk> getDisk() {
		return disk;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((disk == null) ? 0 : disk.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Raid other = (Raid) obj;
		if (disk == null) {
			if (other.disk != null)
				return false;
		} else if (!disk.equals(other.disk))
			return false;
		return true;
	}

	@Override
	public int getCapacity() {
		int total = 0;
		for(Disk d : disk){
			total += d.getWriteSpeed();
		}
		return total;
	}

	@Override
	public int getReadSpeed() {
		int min = Integer.MAX_VALUE;
		for(Disk d: disk){
			min = Math.min(min, d.getReadSpeed());
		}
		return 0;
	}

	@Override
	public int getWriteSpeed() {
		int min = 0;
		for(Disk d: disk){
			min = Math.min(min, d.getReadSpeed());
		}
		return 0;
	}
	
	
}
