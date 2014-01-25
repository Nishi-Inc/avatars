package inc.nishi.avatars.adapters;

import inc.nishi.avatars.models.Email;
import inc.nishi.avatars.models.Profile;

import java.util.List;

/**
 * @author Nishi Inc
 * @since v0.1.0
 */
public interface AvatarWebAdapter {

    /**
     * @param emails to get profile of
     * @return Profile associated with the given email
     */
    public List<Profile> getProfile(Email... emails);

}
