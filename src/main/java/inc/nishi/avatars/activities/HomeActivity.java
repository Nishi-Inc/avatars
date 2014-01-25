package inc.nishi.avatars.activities;

import android.os.Bundle;
import android.view.View;
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


    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.license) {

        } else if(1==1) {

        }
    }

    @Override
    public boolean onLongClick(View view) {
        return AvatarsActivitySupport.propagateEvent;
    }
}
