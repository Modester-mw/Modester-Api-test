//Authors: Modester_Samwel
//github handles: Modester_Samwel


package Loyal.Foods.LoyalFoods;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import model.Product;
import static org.assertj.core.api.Assertions.assertThat;
import java.util.List;
import java.util.UUID;
import dao.ProdcutDataAccessService;

@SpringBootTest
public class  ProdcutDataAccessServiceTest{
	
	private ProdcutDataAccessService UnderTest;

     
	 public void setUp() {  UnderTest = new ProdcutDataAccessService();
	 
	 }
	  
	   
	 @Test 
	 public void canPerformRestApi() {
		   //example product called rosemary leaves
		   UUID idOne = UUID.randomUUID();
		   Product productOne = new Product(idOne, "Rosemmary Leaves", 1500, 50);
		   
		   //another product called Rosemary powder
		   UUID idTwo = UUID.randomUUID();
		   Product productTwo = new Product(idTwo, "Rosemmary Powder", 2000, 70);
		   
		   //when the two products are added to database
		   UnderTest.insertProduct(idOne, productOne);
		   UnderTest.insertProduct(idTwo, productTwo);
		   
		   
		   //we are able to get product 1 by id
		    assertThat(UnderTest.selectProductById(idOne))
	     						.isPresent();

		    //we are able to get product 2 by id
		    assertThat(UnderTest.selectProductById(idTwo))
						.isPresent();
		    
		    //get all products
		    List<Product> product = UnderTest.selectAllProducts();
		    
		 // result List should contain the 2 products 
		    assertThat(product)
		        .hasSize(2)
		        .usingFieldByFieldElementComparator()
		        .containsExactlyInAnyOrder(productOne, productTwo);

		    // Initialise the product to be updated and its variables
		    Product productToUpdate = new Product(idOne, "Rosemmary Leaves", 1500, 50);

		    // updating
		    assertThat(UnderTest.updateProductById(idOne, productToUpdate)).isEqualTo(1);

		    // Then when get person with idOne then should have name as Rosemmary Leave to ginger black tea
		    assertThat(UnderTest.selectProductById(idOne))
		        .isPresent();

		    // delete productOne
		    assertThat(UnderTest.deleteProductById(idOne)).isEqualTo(1);

		    // when getting the product now personOne should be empty
		    assertThat(UnderTest.selectProductById(idOne)).isEmpty();

		    // then the  DB should only contain ginger black tea
		    assertThat(UnderTest.selectProductById(idTwo))
		        .hasValue(productTwo)
		        .usingFieldByFieldValueComparator();
		  }

		  @Test
		  public void ReturnZeroIfNoProductFoundToDelete() {
		    // while
		    UUID id = UUID.randomUUID();

		    // if
		    int deleteFoundProduct = UnderTest.deleteProductById(id);

		    // then
		    assertThat(deleteFoundProduct).isEqualTo(0);
		  }

		  @Test
		  public void ReturnZeroIfNoProductFoundToUpdate() {
		    // while
		    UUID id = UUID.randomUUID();
		    Product product = new Product(id, "Not Found", 1, 1);

		    // if
		    int deleteFoundProduct = UnderTest.updateProductById(id, product);

		    // then
		    assertThat(deleteFoundProduct).isEqualTo(0);
		  }
		}

	  
