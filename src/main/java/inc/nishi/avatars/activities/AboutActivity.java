package inc.nishi.avatars.activities;

import android.os.Bundle;
import inc.nishi.avatars.R;

/**
 * @author Nishi Inc
 * @since v0.1.0
 */
public class AboutActivity extends AvatarsActivitySupport {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.about);
    }

}
