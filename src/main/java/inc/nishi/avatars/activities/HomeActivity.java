package inc.nishi.avatars.activities;

import android.os.Bundle;
import inc.nishi.avatars.R;

/**
 * @author Nishi Inc
 * @since v0.0.1
 */
public class HomeActivity extends AvatarsActivitySupport {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.avatars);
    }


}
