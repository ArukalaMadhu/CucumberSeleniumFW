package commonutils;

import java.io.File;

public class FileUtilMetods {
	
	public static String getProjectLocation(){
		return new File("").getAbsolutePath();
	}
	
	public static String getSikuliImagesDIR(){
		return new File("").getAbsolutePath()+"\\sikuli_images";
	}
}
