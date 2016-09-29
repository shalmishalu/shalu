package niit.foodgro.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name="product")
@Component
public class Product {
	@Id
	private String Id;
	private String Name;
	private String Price;
	@ManyToOne
	@JoinColumn(name="category_id", insertable=false, updatable=false,nullable=true)
	private Category category;
	@ManyToOne
	@JoinColumn(name="supplier_id", insertable=false, updatable=false,nullable=true)
	private Supplier supplier;
	public String getId() {
		return Id;
	}
	public void setId(String id) {
		Id = id;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getPrice() {
		return Price;
	}
	public void setPrice(String price) {
		Price = price;
	}
	

}
