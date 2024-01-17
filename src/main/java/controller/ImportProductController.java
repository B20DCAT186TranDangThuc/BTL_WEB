package controller;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import bean.Product;
import dao.ProductDAO;
import db.DBConnection;

@WebServlet("/ImportProductController")
@MultipartConfig
public class ImportProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String storedImagePath = "C:\\Users\\Han2na\\Desktop\\WebBTL\\src\\main\\webapp\\images\\products";

	public ImportProductController() {
		super();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.sendRedirect("HomeForward");
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ArrayList<Product> listProduct = new ArrayList<>();
		try (FileInputStream fileInputStream = (FileInputStream) request.getPart("exelInput").getInputStream();
				XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream)) {
			Sheet sheet = workbook.getSheetAt(0);
			for (Row nextRow : sheet) {
				if (nextRow.getRowNum() == 0) {
					// Ignore header
					continue;
				}

				// Get all cells
				Iterator<Cell> cellIterator = nextRow.cellIterator();
				Product product = new Product();
				while (cellIterator.hasNext()) {
					// Read cell
					Cell cell = cellIterator.next();
					int columnIndex = cell.getColumnIndex();
					switch (columnIndex) {
					case 0 -> product.setProductID((int) cell.getNumericCellValue());
					case 1 -> product.setName(cell.getStringCellValue().trim());
					case 2 -> product.setPrice((long) cell.getNumericCellValue());
					case 3 -> product.setDescription(cell.getStringCellValue().trim());
					case 4 -> product.setQuantity((int) cell.getNumericCellValue());
					case 5 -> product.setCategory(cell.getStringCellValue().trim());
					}
				}
				listProduct.add(product);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println(listProduct);

		storeImageProduct(listProduct);
		getImageFile(listProduct);
		importDatabaseProduct(listProduct);

		response.sendRedirect("AdminProductForward");
	}

	private void getImageFile(ArrayList<Product> listProduct) {
		for (Product product : listProduct) {
			Path sourceDirectory = Paths.get("C:\\Users\\Han2na\\Desktop\\quan_ao\\" + product.getProductID());
			try {
				List<String> imageSrc = Files.walk(sourceDirectory).filter(Files::isRegularFile).map(Path::getFileName)
						.map(Path::toString).collect(Collectors.toList());
				product.setImage((ArrayList<String>) imageSrc);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	private void storeImageProduct(ArrayList<Product> listProduct) {
		for (Product product : listProduct) {
			Path sourceDirectory = Paths.get("C:\\Users\\Han2na\\Desktop\\quan_ao\\" + product.getProductID());
			System.out.println("C:\\Users\\Han2na\\Desktop\\quan_ao\\" + product.getProductID());
			try {
				// Đọc danh sách file trong thư mục nguồn
				DirectoryStream<Path> directoryStream = Files.newDirectoryStream(sourceDirectory);
				for (Path sourcePath : directoryStream) {
					// Tạo đường dẫn mới cho file ở thư mục đích
					Path destinationPath = Paths.get(storedImagePath).resolve(sourcePath.getFileName());
					// Copy file từ thư mục nguồn sang thư mục đích
					Files.copy(sourcePath, destinationPath, StandardCopyOption.REPLACE_EXISTING);
				}

				System.out.println("Files moved successfully.");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

	private void importDatabaseProduct(ArrayList<Product> listProduct) {
		Connection conn = DBConnection.CreateConnection();
		for (Product product : listProduct) {
			if (ProductDAO.themProduct(conn, product) == 1) {
				System.out.println("Thêm thành công: " + product.getProductID());
			} else {
				System.out.println("Thêm thất bại: " + product.getProductID());
			}
		}

	}

}
