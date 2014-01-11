package inc.nishi.gravatar.models;

import inc.nishi.gravatar.utils.GravatarUtils;

/**
 * Created by alok on 1/11/14.
 */
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }
}
