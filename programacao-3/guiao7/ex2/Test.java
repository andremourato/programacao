package aula7.ex2;

public class Test {
	
	public static void main(String[] args) {
		
		//will load the image and print info about it
		Bitmap image = new Bitmap("Figura.bmp");
		System.out.println(image);
		
		//copies the image
		image.saveAsCopy();
		
		//saves the image as raw
		image.saveAsRawType();
		
		// resizes the image to 1/4 of the original image's size and saves as a bmp file
		image.resize();
		
		// flips the image horizontally
		image.flipHorizontal();
		
		// flips the image vertically
		image.flipVertical();
		
	}
}
