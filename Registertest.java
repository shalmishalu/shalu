package niit.foodgro.test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import niit.foodgro.dao.Userdao;
import niit.foodgro.model.Register;

public class Registertest {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		
		context.scan("niit.foodgro");
		context.refresh();
        Userdao userdao = (Userdao) context.getBean("userdao");
		Register register =(Register) context.getBean("register");
		register.setUsername("34");
		register.setEmail("abc");
		register.setPassword("sdfg");
		userdao.save(register);
		System.out.println("Data inserted into the database suucessfully");
		
		

	}

}



