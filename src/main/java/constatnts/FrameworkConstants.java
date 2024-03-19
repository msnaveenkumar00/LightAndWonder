package constatnts;

public class FrameworkConstants {

	private FrameworkConstants() {
	}

	private final static String CONFIGPROP = System.getProperty("user.dir")
			+ "/src/test/resources/config/ConfigProp.Properties";
	private final static int IMPLICITWAIT = 10;

	public static String getConfigPropPath() {
		return CONFIGPROP;
	}

	public static int getImplicitWait() {
		return IMPLICITWAIT;
	}

}
