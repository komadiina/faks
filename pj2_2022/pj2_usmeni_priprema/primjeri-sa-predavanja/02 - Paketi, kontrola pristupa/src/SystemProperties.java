import java.util.Properties;

public class SystemProperties {

	public static void main(String[] args) {
		Properties properties = System.getProperties();
		System.out.println(properties.getProperty("java.vendor"));
		System.out.println(properties.getProperty("java.vendor.url"));
		System.out.println(properties.getProperty("java.home"));
		System.out.println(properties.getProperty("java.version"));
		System.out.println(properties.getProperty("java.vm.name"));
		System.out.println(properties.getProperty("os.name"));
		System.out.println(properties.getProperty("os.arch"));
		System.out.println(properties.getProperty("user.name"));
		System.out.println(properties.getProperty("user.home"));
	}

}
