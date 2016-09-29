package niit.foodgro.test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import niit.foodgro.dao.Supplierdao;
import niit.foodgro.model.Supplier;


public class Suppliertest {
	public static void main(String[] args)
	{
	AnnotationConfigApplicationContext Context = new AnnotationConfigApplicationContext();
	Context.scan("niit.foodgro");
	Context.refresh();
    Supplierdao supplierdao = (Supplierdao) Context.getBean("supplierdao");
	Supplier supplier =(Supplier) Context.getBean("supplier");
	supplier.setId("08");
	supplier.setName("badam");
	supplier.setAddress("ccc");
	supplierdao.save(supplier);
	System.out.println("supplied successfully");
}
}

