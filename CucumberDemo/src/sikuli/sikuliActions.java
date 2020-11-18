package sikuli;

import org.sikuli.script.App;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Match;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

import commonutils.FileUtilMetods;

public class sikuliActions {
	
	private String imagesDIR = null;
	private Screen screen = null;
	public sikuliActions(){
		imagesDIR = FileUtilMetods.getSikuliImagesDIR();
		screen = new Screen();
	}
	public Match getElement(String imageName, float similar, long waitTime) throws FindFailed{
		return screen.wait(new Pattern(getImagePath(imageName)).similar(similar),waitTime);
	}
	public void find(String imageName, float similar, long waitTime) throws FindFailed{		
		screen.find(new Pattern(getImagePath(imageName)).similar(similar));
	}
	public void click(String imageName, float similar, long waitTime) throws FindFailed{
		getElement(imageName,similar,waitTime).click();
		//screen.click(getImagePath(imageName));
	}
	public void type(String imageName, String text, float similar, long waitTime) throws FindFailed{
		getElement(imageName,similar,waitTime).type(text);
	}
	
	public String getImagePath(String imageName){
		return imagesDIR+"\\"+imageName;
	}
	public static void main(String args[]) throws FindFailed{
		sikuliActions s1 = new sikuliActions();
//		App app = new App("notepad.exe");
//		app.focus();
		//s1.find("test1.jpg",0.6f,10);
		s1.click("test3.jpg",0.6f,10);
		s1.type("test3.jpg","dasdas",0.6f,10);
		
//		s1.find("Notepad.jpg",0.6f,10);
//		s1.click("NotepadTextArea.jpg",0.6f,10);
//		s1.type("NotepadTextArea.jpg","Welcome to Sikuli...",0.6f,10);
		
		
		
	}

}
