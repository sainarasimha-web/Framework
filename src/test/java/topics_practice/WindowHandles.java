package topics_practice;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowHandles {

	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.hyrtutorials.com/p/window-handles-practice.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.id("newWindowsBtn")).click();
		String parent=driver.getWindowHandle();
		System.out.println(parent);
	//	Set<String> windowIds=driver.getWindowHandles();
		//System.out.println(windowIds);
//		for(String id:windowIds) {
//			if(!id.equals(parent)) {
//				driver.switchTo().window(id);
//				System.out.println(driver.getWindowHandle());
//			}
//		}
		Iterator<String> iterator=driver.getWindowHandles().iterator();
		System.out.println(iterator);
		while(iterator.hasNext()) {
			String id=iterator.next();
			if(!id.equals(parent)) {
				driver.switchTo().window(id);
				System.out.println(driver.getWindowHandle());
			}
		}
		
//		List<String> ids=new ArrayList<>(windowIds);
//		driver.switchTo().window(ids.get(1))

//		driver.switchTo().newWindow(WindowType.TAB);
//		driver.get("https://www.amazon.in/");
		
	}

}
