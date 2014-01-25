package inc.nishi.avatars.activities;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.view.View;

/**
 * @author Nishi Inc
 * @since v0.1.0
 */
public abstract class AvatarsActivitySupport extends Activity implements View.OnClickListener, View.OnLongClickListener {

    protected static final boolean propagateEvent       = false;
    protected static final boolean stopEventPropagation = true;

    /**
     *
     * @param url URL to open
     */
    public void openBrowser(String url) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        startActivity(intent);
    }

}
