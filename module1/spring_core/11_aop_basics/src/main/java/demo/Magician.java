package demo;

import org.springframework.stereotype.Component;

//When magician is showing the maginc then Audiance must do clapping after
//--target object-------
@Component(value = "m")
 public class Magician {
	public void doMagic(int a,String name) {
		System.out.println("abra ka dabra...");
	}

	public void f2() {
		System.out.println("f2.");
	}

	public void f3() {
		System.out.println("f3.");
	}

	public void f4() {
		System.out.println("f4..");
	}

}
