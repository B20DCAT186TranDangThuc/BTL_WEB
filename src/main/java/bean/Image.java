package bean;

public class Image {
	private int idImage;
	private String imageProduct;

	public int getIdImage() {
		return idImage;
	}

	public void setIdImage(int idImage) {
		this.idImage = idImage;
	}

	public String getImageProduct() {
		return imageProduct;
	}

	public void setImageProduct(String imageProduct) {
		this.imageProduct = imageProduct;
	}

	@Override
	public String toString() {
		return "Image [idImage=" + idImage + ", imageProduct=" + imageProduct + "]";
	}

}