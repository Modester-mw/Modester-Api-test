//Authors: Modester_Samwel
//github handles: Modester_Samwel

package dao;

import java.util.ArrayList;




import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Repository;

import model.Product;

@Repository("postgres")
public class ProdcutDataAccessService implements ProductDao {
	private static List<Product > DB = new ArrayList<>();
	
	@Override
	public int insertProduct(UUID id, Product product) {
		DB.add(new Product(id, product.getName(), product.getPrice(), product.getQuantity()));
		return 0;
	}

	@Override
	public List<Product> selectAllProducts() {
		return List.of(new Product(UUID.randomUUID(), "FROM POSTGRES DB", 0, 0));
	}

	@Override
	public Optional<Product> selectProductById(UUID id) {
		// TODO Auto-generated method stub
		return DB.stream()
				 .filter(product -> product.getId().equals(id))
				 .findFirst();
	}

	@Override
	public int deleteProductById(UUID id) {
		Optional<Product> productMaybe = selectProductById(id);
		if (productMaybe.isEmpty()) {
			return 0;
		}
		DB.remove(productMaybe.get());
		return 1;
	}

	@Override
	public int updateProductById(UUID id,Product update) {
		
		return selectProductById(id)
				.map(product ->{
					int indexOfProductDelete = DB.indexOf(product);
					
					if(indexOfProductDelete >= 0) {
						DB.set(indexOfProductDelete, new Product(id, update.getName(), update.getPrice(), update.getQuantity()));
						return 1;
					}
					return 0;
				})
				.orElse(0);
				
					}
	}
	
	


