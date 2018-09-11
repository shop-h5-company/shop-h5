package xframe.kit;

import com.google.zxing.*;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.HybridBinarizer;
import com.google.zxing.qrcode.QRCodeReader;
import com.google.zxing.qrcode.QRCodeWriter;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Hashtable;

/**
 * 二维码功能类
 *
 * @author : zhangqiang
 * @version : 2015-1-6 18:58
 */
public class QrcodeKit
{
    /**
     * 创建二维码图片。可用ImageIO类读取和写入图片文件
     *
     * @param text      二维码的文本内容
     * @param size      图片大小
     * @param logoImage LOGO图片数据，如果不设置，可为null
     * @return BufferedImage
     * @throws Exception
     */
    public static BufferedImage create(String text, int size, BufferedImage logoImage) throws Exception
    {
        Hashtable<EncodeHintType, Object> hints = new Hashtable<>();
        hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.H);
        hints.put(EncodeHintType.CHARACTER_SET, "utf-8");
        hints.put(EncodeHintType.MARGIN, 1);

        QRCodeWriter writer = new QRCodeWriter();
        BitMatrix matrix = writer.encode(text, BarcodeFormat.QR_CODE, size, size, hints);
        MatrixToImageWriter.toBufferedImage(matrix);

        int width = matrix.getWidth();
        int height = matrix.getHeight();
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        int black = 0xFF000000;
        int white = 0xFFFFFFFF;

        for (int x = 0; x < width; x++)
        {
            for (int y = 0; y < height; y++)
            {
                image.setRGB(x, y, matrix.get(x, y) ? black : white);
            }
        }

        //如果设置了LOGO图片数据，就插入LOGO图片数据
        //LOGO图片大小不要大于二维码图片的1/3，否则可能读取失败
        if (logoImage != null) insertLogo(image, logoImage);
        return image;
    }

    /**
     * 插入LOGO图片数据
     *
     * @param sourceImage 二维码图片数据
     * @param logoImage   LOGO图片数据
     * @throws Exception
     */
    private static void insertLogo(BufferedImage sourceImage, BufferedImage logoImage) throws Exception
    {
        int logoWidth = logoImage.getWidth(null);
        int logoHeight = logoImage.getHeight(null);
        int sourceWidth = sourceImage.getWidth(null);
        int sourceHeight = sourceImage.getHeight(null);
        System.out.println(logoWidth);
        System.out.println(sourceWidth);
        // 插入LOGO
        Graphics2D graph = sourceImage.createGraphics();
        int x = (sourceWidth - logoWidth) / 2;
        int y = (sourceHeight - logoHeight) / 2;
        graph.drawImage(logoImage, x, y, logoWidth, logoHeight, null);
        Shape shape = new RoundRectangle2D.Float(x, y, logoWidth, logoWidth, 6, 6);
        graph.setStroke(new BasicStroke(3f));
        graph.draw(shape);
        graph.dispose();
    }

    /**
     * 读取二维码信息
     *
     * @param image 二维码图片数据
     * @return String
     * @throws Exception
     */
    public static String parse(BufferedImage image) throws Exception
    {
        QRCodeReader reader = new QRCodeReader();
        LuminanceSource source = new BufferedImageLuminanceSource(image);
        Binarizer binarizer = new HybridBinarizer(source);
        BinaryBitmap imageBinaryBitmap = new BinaryBitmap(binarizer);
        Result result = reader.decode(imageBinaryBitmap);
        return result.getText();
    }

    /**
     * 读取二维码信息
     *
     * @param file 二维码文件
     * @return String
     * @throws Exception
     */
    public static String parse(String file) throws Exception
    {
        BufferedImage image = ImageIO.read(new File(file));
        return parse(image);
    }

    public static void main(String[] args) throws Exception
    {
//        BufferedImage image = QrcodeKit.create("我的中关村！@#sdlg", 200, null);
//        ImageIO.write(image, "png", new File("c:\\1.png"));
//        System.out.println(QrcodeKit.parse("c:\\1.png"));

//        BufferedImage logo = ImageIO.read(new File("c:\\icon.png"));
//        BufferedImage image1 = QrcodeKit.create("我的中关村！@#sdlg", 220, logo);
//        ImageIO.write(image1, "png", new File("c:\\2.png"));
//        System.out.println(QrcodeKit.parse("c:\\2.png"));
    }
}
