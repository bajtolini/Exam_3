package smurf;
import java.util.ArrayList;
import java.util.List;

public class SmurfDao {
	
	public static List<Smurf> getList() {
		List<Smurf> out = new ArrayList<>();
		
		for (int i = 0; i < 5; i++) {
			out.add(new Smurf(
					"Smurf" + (i+1),
					"clone" + (i+1),
					"no description for you!"));
		}
		
		return out;
	}

}
