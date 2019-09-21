import javafx.scene.image.Image;
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;

public class ImageMessage extends ChatMessage implements Serializable {

    private transient BufferedImage image;

    public BufferedImage getImage() {
        return image;
    }

    /**
     * Constucts an ImageMessage using the passed in file
     * @param sender
     * @param file
     */
    public ImageMessage(String sender, File file) {
        super(sender);
        if (file == null) this.image = null;
        else {
            try {
                this.image = ImageIO.read(file);
            } catch (IOException e) {
                System.out.println("Error reading in image");
                this.image = null;
            }
        }
    }

    /**
     * writes all BufferedImages as png's
     * @param out
     * @throws IOException
     */
    private void writeObject(ObjectOutputStream out) throws IOException {
        out.defaultWriteObject();// Create a buffered image with transparency
        ImageIO.write(this.image, "png", out); // png is lossless
    }

    /**
     * All incoming messages are png's
     * @param in
     * @throws IOException
     * @throws ClassNotFoundException
     */
    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();
        this.image = ImageIO.read(in);
    }
}
