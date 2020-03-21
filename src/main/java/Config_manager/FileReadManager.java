package Config_manager;


public class FileReadManager {
	

		
	public static FileReadManager fm = new FileReadManager();
	
	public static FileReadManager getInstance() {
		return fm;
	}
	
	public static ConfigurationManager cr;

	public ConfigurationManager getCr() throws Throwable {
		if (cr==null) {
			cr = new ConfigurationManager();
		}
		return cr;
	}

}