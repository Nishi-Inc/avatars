package inc.nishi.avatars.services;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import inc.nishi.avatars.R;
import inc.nishi.avatars.adapters.GravatarAdapter;
import inc.nishi.avatars.adapters.ParseAdapter;
import inc.nishi.avatars.models.Profile;
import inc.nishi.avatars.utils.AvatarsUtils;

import java.util.List;

/**
 * @author Nishi Inc
 * @since v0.0.1
 */
public class CommunicationService extends Service {

    @Override
    public IBinder onBind(Intent intent) {
        // TODO examine intent
        return null;
    }

    /**
     *
     * @param emails emails
     * @return profile for given email addresses
     */
    public List<Profile> getProfiles(String... emails) {
        return this.getParseAdapter().getProfile(AvatarsUtils.getValidEmailIds(emails));
    }

    private GravatarAdapter getGravatarAdapter() {
        return GravatarAdapter.getInstance();
    }

    private ParseAdapter getParseAdapter() {
        return ParseAdapter.getInstance(this.getApplicationContext(), this.getString(R.string.parse_application_id), this.getString(R.string.parse_rest_api_key));
    }

}
