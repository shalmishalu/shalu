package niit.foodgro.test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import niit.foodgro.dao.Categorydao;
import niit.foodgro.model.Category;
public class Categorytest {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext Context = new AnnotationConfigApplicationContext();
		
		Context.scan("niit.foodgro");
		Context.refresh();
	    Categorydao categorydao = (Categorydao) Context.getBean("categorydao");
		Category category = (Category) Context.getBean("category");
		category.setId("04");
		category.setName("anjir");
		category.setDescription("dry");
		categorydao.save(category);
		System.out.println("Objects are created successfully");
	}

}


