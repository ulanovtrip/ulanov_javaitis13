package multithreading.itis.filesinfo.app;


import com.beust.jcommander.JCommander;
import multithreading.itis.filesinfo.utils.Informator;

public class Program {
	public static void main(String[] args) {
		
		Arguments arguments = new Arguments();

		JCommander
				.newBuilder()
				.addObject(arguments)
				.build()
				.parse(args);

		Informator informator = new Informator();
		//informator.getInfo(arguments.path);
	}
}