package com.lftechnology.task.dec31;

import java.util.logging.Level;
import java.util.logging.Logger;

public class BlaBla {
	private static final Logger log = Logger.getLogger(BlaBla.class.getName());

	public static void main(String[] args) {

		// Although we have two objects, static block is executed only once.
		// log.setLevel(Level.SEVERE);

		log.warning("lsd");
		log.info("This is the information");
		log.log(Level.SEVERE, log.getLevel() + "");
		Test t1 = new Test();
		Test t2 = new Test();
	}
}

class Test {
	static int i;
	int j;
	static {
		i = 10;
		System.out.println("static block called ");
	}
	static {
		i = 10;
		System.out.println("static block called 2");
	}

	Test() {
		System.out.println("Constructor called");
	}

}
