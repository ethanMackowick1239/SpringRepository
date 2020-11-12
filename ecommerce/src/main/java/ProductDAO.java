public interface ProductDAO {
	
	public String createProduct(Product product);
	public Optional<Product> getProductById(int id);
	public Optional<List<Product>> getProducts();
	public String removeProduct(int id);
	public Optional<Product> updateProduct(int id, Product product);
	
	

}