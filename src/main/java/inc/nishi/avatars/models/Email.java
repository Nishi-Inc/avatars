package inc.nishi.avatars.models;

import inc.nishi.gravatar.utils.GravatarUtils;
import lombok.Data;

/**
 * @author Nishi Inc
 * @since v0.1.0
 */
@Data
public class Email {

    private String username;
    private String domain;

    public Email(){}

    public Email(String email) {
        if(GravatarUtils.isValidEmail(email)) {
            this.setUsername(email.split(GravatarUtils.AT)[0]);
            this.setDomain(email.split(GravatarUtils.AT)[1]);
        } else {
            throw new IllegalArgumentException();
        }
    }

}
