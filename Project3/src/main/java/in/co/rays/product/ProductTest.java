package in.co.rays.product;

import java.text.SimpleDateFormat;

public class ProductTest {
	public static void main(String[] args) throws Exception {
		testAdd();
	}
	
	private static void testAdd() throws Exception {

		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		
		ProductDTO dto = new ProductDTO();
		
		dto.setId(1);
		dto.setName("Shivanshi");
		dto.setPrize("123456789");
		dto.setAddress("kalaniNagar");
       dto.setDate(sdf.parse("12-12-2012"));		
		ProductModel model = new ProductModel();
		model.add(dto);
		
		System.out.println("Data ADED");
		
	}

}
