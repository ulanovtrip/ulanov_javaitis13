package multithreading.itis.filesinfo.app;

import com.beust.jcommander.Parameter;
import com.beust.jcommander.Parameters;

@Parameters(separators = "=")
public class Arguments {

	@Parameter(names = {"-path"})
	public String[] path;
}