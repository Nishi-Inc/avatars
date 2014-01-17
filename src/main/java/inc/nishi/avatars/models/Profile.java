package inc.nishi.avatars.models;

import android.media.Image;
import lombok.Data;

/**
 * @author Nishi Inc
 * @since v0.1.0
 */@Data
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

}
