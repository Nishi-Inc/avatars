package inc.nishi.gravatar.models;

import android.media.Image;

/**
 * @author Nishi Inc
 * @since v0.0.1
 */
public class Profile {
    private Image image;
    private Info info;

    public Profile(Info info) {
        this(null, info);
    }

    public Profile(Image image) {
        this(image, null);
    }

    public Profile(Image image, Info info) {
        this.setImage(image);
        this.setInfo(info);
    }

    public Info getInfo() {
        return info;
    }

    public void setInfo(Info info) {
        this.info = info;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }
}
