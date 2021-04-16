import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.ImageAsset
import androidx.compose.ui.res.imageResource
import java.awt.image.BufferedImage
import java.io.File
import javax.imageio.ImageIO
import androidx.compose.ui.graphics.ImageBitmap

@Composable
fun bevis(): ImageBitmap = imageResource("images/huckleberry.ico")

private var icon: BufferedImage? = null
fun icAppRounded(): BufferedImage {//TODO: Not working
    if (icon != null) {
        return icon!!
    }
    try {
        //val img = ImageIO.read(File("images/bevis.ico"))
        //return img

        val imageRes = "images/bevis.ico"
        val img = Thread.currentThread().contextClassLoader.getResource(imageRes)
        val bitmap: BufferedImage? = ImageIO.read(img)
        if (bitmap != null) {
            icon = bitmap
            return bitmap
        }
    } catch (e: Exception) {
        e.printStackTrace()
    }
    return BufferedImage(1, 1, BufferedImage.TYPE_INT_ARGB)
}



fun getWindowIcon(): BufferedImage {//TODO: Not working
    var image: BufferedImage? = null
    try {
        image = ImageIO.read(File("../resources/images/alienegg.png"))
    } catch (e: Exception) {
        e.printStackTrace()
    }

    if (image == null) {
        image = BufferedImage(1, 1, BufferedImage.TYPE_INT_RGB)
    }

    return image
}
