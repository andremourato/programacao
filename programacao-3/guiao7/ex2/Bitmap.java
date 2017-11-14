package aula7.ex2;
import java.io.File;
import java.io.RandomAccessFile;

public class Bitmap implements Cloneable{
	private BitmapFileHeader bitmapFileHeader;
	private BitmapInfoHeader bitmapInfoHeader;
	private String name;
	private byte[] rgbQuad; // color pallete – opcional (ver abaixo)
	private byte[] data; // pixel data
	private Pixel[][] pixels;
	
	public Bitmap(File file) {
		this(file.getAbsolutePath());
	}

	public Bitmap(String path) {
		try{
			RandomAccessFile file = new RandomAccessFile(path,"r");
			
			this.name = path.split("\\.")[0]; // name.bmp
			
			//Reads the information about the image
			bitmapFileHeader = new BitmapFileHeader(
					Short.reverseBytes(file.readShort()),
					Integer.reverseBytes(file.readInt()),
					Short.reverseBytes(file.readShort()),
					Short.reverseBytes(file.readShort()),
					Integer.reverseBytes(file.readInt())
			);
			
			bitmapInfoHeader = new BitmapInfoHeader(
					Integer.reverseBytes(file.readInt()),
					Integer.reverseBytes(file.readInt()),
					Integer.reverseBytes(file.readInt()),
					Short.reverseBytes(file.readShort()),
					Short.reverseBytes(file.readShort()),
					Integer.reverseBytes(file.readInt()),
					Integer.reverseBytes(file.readInt()),
					Integer.reverseBytes(file.readInt()),
					Integer.reverseBytes(file.readInt()),
					Integer.reverseBytes(file.readInt()),
					Integer.reverseBytes(file.readInt())
			);
			
			/* If the bit count is 16 or higher, than there is no RGBQUAD */
			if(bitmapInfoHeader.bitCount < 16) {
				System.out.println("This program does not support a bit count of less than 16-bit");
				System.exit(0);
			}
			
			/*READS THE PIXEL DATA*/
			int byteDataLength = (int)file.length()-bitmapFileHeader.offBits;
			data = new byte[byteDataLength];
			file.read(data);
			file.close();
			
			/*CREATED A 2D ARRAY FOR THE PIXELS*/
			pixels = byteToPixelArray(data, Math.abs(bitmapInfoHeader.height), Math.abs(bitmapInfoHeader.width));
			
		} catch (Exception e) {
			System.out.println("ERROR: Cannot read from file");
			System.exit(1);
		}
		
	}
	
	public void saveAsCopy(String newName) { //Used to test if data is being read correctly
		write(pixelToByteArray(pixels),newName+".bmp",bitmapInfoHeader.height,bitmapInfoHeader.width,bitmapFileHeader.size);
	}
	
	public void saveAsRawType(String newName) {
		write(pixelToByteArray(pixels),newName+".raw",bitmapInfoHeader.height,bitmapInfoHeader.width,bitmapFileHeader.size-bitmapFileHeader.offBits);		
	}	
	
	//Resizes a copy of the image and saves it
	//Preserves the original BMP image
	public void saveResize(String newName) {
        
		int width = Math.abs(bitmapInfoHeader.width);
		int height = Math.abs(bitmapInfoHeader.height);
        int newWidth = (int) width/2; 
        int newHeight = (int) height/2;
        write(pixelToByteArray(scaleDown(pixels)),newName+".bmp",newHeight,newWidth,bitmapFileHeader.size/4);
	}
	
	public static Bitmap resize(Bitmap bmp) {
		bmp.pixels = scaleDown(bmp.pixels);
		bmp.bitmapInfoHeader.width = bmp.bitmapInfoHeader.width/2;
		bmp.bitmapInfoHeader.height = bmp.bitmapInfoHeader.height/2;
		bmp.data = Bitmap.pixelToByteArray(bmp.pixels);
		return bmp;
	}
	
	//Simple algorithm that produces a good quality image
	//This algorithm skips every 2 pixels in order to make the whole image 1/4 smaller
	private static Pixel[][] scaleDown(Pixel[][] pixelData){
		Pixel[][] newPixelData = new Pixel[pixelData.length/2][pixelData[0].length/2];
		
		int pixelsX = 0;
        int pixelsY = 0;
        
		for(int y = 0; y < pixelData.length/2; y++) {
			for(int x = 0; x < pixelData[0].length/2; x++) {
				newPixelData[y][x] = pixelData[pixelsY][pixelsX];
				pixelsX += 2;
			}
			pixelsX = 0;
			pixelsY += 2;
		}
		return newPixelData;
	}
	
	public void saveFlipHorizontal(String newName) {
		write(pixelToByteArray(flipHorizontal(pixels)),newName+".bmp",bitmapInfoHeader.height,bitmapInfoHeader.width,bitmapFileHeader.size);
	}
	
	public static Bitmap flipHorizontal(File file) {
		return flipHorizontal(new Bitmap(file));
	}
	
	public static byte[] flipHorizontal(byte[] byteArray, int height, int width) {
		return pixelToByteArray(flipHorizontal(byteToPixelArray(byteArray,height,width)));
	}
	
	public static Bitmap flipHorizontal(Bitmap bmp) {
		bmp.pixels = flipHorizontal(bmp.pixels);
		bmp.data = Bitmap.pixelToByteArray(bmp.pixels);
		return bmp;
	}
	
	private static Pixel[][] flipHorizontal(Pixel[][] pixelData){
		Pixel[][] newPixelData = new Pixel[pixelData.length][pixelData[0].length];
		for(int y = 0; y < pixelData.length; y++) {
			for(int x = 0; x < pixelData[0].length; x++) {
				newPixelData[y][x] = pixelData[pixelData.length-y-1][x];
			}
		}
		
		return newPixelData;
	}
	
	public void saveFlipVertical(String newName) {
		write(pixelToByteArray(flipVertical(pixels)),newName+".bmp",bitmapInfoHeader.height,bitmapInfoHeader.width,bitmapFileHeader.size);
	}
	
	public static Bitmap flipVertical(Bitmap bmp) {
		bmp.pixels = flipHorizontal(flipVertical(flipHorizontal(bmp.pixels)));
		bmp.data = Bitmap.pixelToByteArray(bmp.pixels);
		return bmp;
	}
	
	private static Pixel[][] flipVertical(Pixel[][] pixelData){
		Pixel[][] newPixelData = new Pixel[pixelData.length][pixelData[0].length];
		
		for(int y = 0; y < pixelData.length; y++) {
			for(int x = 0; x < pixelData[0].length; x++) {
				newPixelData[y][x] = pixelData[y][pixelData[0].length-x-1];
			}
		}
		
		return newPixelData;
	}
	
	private static byte[] pixelToByteArray(Pixel[][] pixelArray) {
		byte[] retVal = new byte[pixelArray.length * pixelArray[0].length * 3];
		//pixelArray.length => height
		//pixelArray[0].length => width
		
		int i = 0;
		for(int y = 0; y < pixelArray.length; y++) {
			for(int x = 0; x < pixelArray[0].length; x++) {
				retVal[i++] = pixelArray[y][x].B;
				retVal[i++] = pixelArray[y][x].G;
				retVal[i++] = pixelArray[y][x].R;
			}
		}
		return retVal;
	}
	
	public void write(byte[] byteArray, String newFileName, int height, int width, int size) {
		write(this,byteArray,newFileName,height,width,size);
	}
	
	public static void write(Bitmap bmp, byte[] byteArray, String newFileName, int height, int width, int size) {
		try {
			RandomAccessFile newFile = new RandomAccessFile(newFileName, "rw");
	        newFile.writeShort(Short.reverseBytes(bmp.bitmapFileHeader.type));
	        newFile.writeInt(Integer.reverseBytes(size));
	        newFile.writeShort(Short.reverseBytes(bmp.bitmapFileHeader.reserved1));
	        newFile.writeShort(Short.reverseBytes(bmp.bitmapFileHeader.reserved2));
	        newFile.writeInt(Integer.reverseBytes(bmp.bitmapFileHeader.offBits));
	        
	        newFile.writeInt(Integer.reverseBytes(bmp.bitmapInfoHeader.size));
	        newFile.writeInt(Integer.reverseBytes(width));
	        newFile.writeInt(Integer.reverseBytes(-Math.abs(height))); //because the pixel data is stored upside down
	        newFile.writeShort(Short.reverseBytes(bmp.bitmapInfoHeader.planes));
	        newFile.writeShort(Short.reverseBytes(bmp.bitmapInfoHeader.bitCount));
	        newFile.writeInt(Integer.reverseBytes(bmp.bitmapInfoHeader.compression));
	        newFile.writeInt(Integer.reverseBytes(bmp.bitmapInfoHeader.sizeImage));
	        newFile.writeInt(Integer.reverseBytes(bmp.bitmapInfoHeader.xPelsPerMeter));
	        newFile.writeInt(Integer.reverseBytes(bmp.bitmapInfoHeader.yPelsPerMeter));
	        newFile.writeInt(Integer.reverseBytes(bmp.bitmapInfoHeader.clrUsed));
	        newFile.writeInt(Integer.reverseBytes(bmp.bitmapInfoHeader.clrImportant));
        
        	newFile.write(byteArray);
            newFile.close();
        }catch(Exception e) {
        	System.out.println("ERROR: Cannot write to file");
        	System.exit(1);
        }
		
	}
	
	private static Pixel[][] byteToPixelArray(byte[] data, int height, int width) {
		Pixel[][] newPixels = new Pixel[height][width];
		int i = 0;
		for(int y = 0; y < newPixels.length; y++) {
			for(int x = 0; x < newPixels[0].length; x++) {
				newPixels[y][x] = new Pixel(data[i++],data[i++],data[i++]);
			}
		}
		return newPixels;
	}

	public int width() {
		return Math.abs(bitmapInfoHeader.width);
	}
	
	public int height() {
		return Math.abs(bitmapInfoHeader.height);
	}
	
	public byte[] data() {
		return data;
	}
	
	public int offBits() {
		return bitmapFileHeader.offBits;
	}
	
	public String name() {
		return name;
	}
	
	@Override
	public String toString() {
		return String.format("** Information about file '%s' **\n\n"
							+"%s\n"
							+"%s\n"
							,name,bitmapFileHeader,bitmapInfoHeader);
	}
	
}

class BitmapFileHeader{
	
	short type; // must be 'BM' to declare a bmp-file
	int size; // specifies the size of the file in bytes
	short reserved1; // must always be set to zero
	short reserved2; // must always be set to zero
	int offBits; // specifies the offset from the
	// beginning of the file to the bitmap data
	
	public BitmapFileHeader(short type, int size, short reserved1, short reserved2, int offBits) {
		this.type = type;
		this.size = size;
		this.reserved1 = reserved1;
		this.reserved2 = reserved2;
		this.offBits = offBits;
	}

	@Override
	public String toString() {
		return String.format("-- File Header --\n"+
							 "Type: %d\n"+
							 "File Size: %d\n"+
							 "Reserved1: %d\n"+
							 "Reserved2: %d\n"+
							 "OffBits: %d\n",type,size,reserved1,reserved2,offBits);
	}
	
}

class BitmapInfoHeader{
	int size; // the size of this header (40 bytes)
	int width; // the bitmap width in pixels
	int height; // the bitmap height in pixels
	short planes; // the number of color planes being used. Must be set to 1
	short bitCount; // the number of bits per pixel (color depth) - 1, 4, 8, 16, 24, 32
	int compression; // the compression method being used
	int sizeImage; // the image size. This is the size of the raw bitmap data
	int xPelsPerMeter; // the horizontal resolution of the image (pixel per meter)
	int yPelsPerMeter; // the vertical resolution of the image (pixel per meter)
	int clrUsed; // the number of colors in the color palette,
	// or 0 to default to 2n
	int clrImportant; // the number of important colors used,
	// or 0 when every color is important
	
	public BitmapInfoHeader(int size, int width, int height, short planes, short bitCount, int compression,
			int sizeImage, int xPelsPerMeter, int yPelsPerMeter, int clrUsed, int clrImportant) {
		this.size = size;
		this.width = width;
		this.height = height;
		this.planes = planes;
		this.bitCount = bitCount;
		this.compression = compression;
		this.sizeImage = sizeImage;
		this.xPelsPerMeter = xPelsPerMeter;
		this.yPelsPerMeter = yPelsPerMeter;
		this.clrUsed = clrUsed;
		this.clrImportant = clrImportant;
	}
	
	@Override
	public String toString() {
		return String.format("-- Info Header --\n"+
							 "Header Size: %d\n"+
							 "Width: %d\n"+
							 "Height: %d\n"+
							 "Planes: %d\n"+
							 "BitCount: %d\n"+
							 "Compression: %d\n"+
							 "Image Size: %d\n"+
							 "Horizontal Resolution: %d\n"+
							 "Vertical Resolution: %d\n"+
							 "Number of Colors: %d\n"+
							 "Number of Important Colors: %d\n",
							 size,width,Math.abs(height),planes,bitCount,compression,sizeImage,xPelsPerMeter,yPelsPerMeter,clrUsed,clrImportant);
	}
	
}

