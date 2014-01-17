package inc.nishi.gravatar.adapters;

import inc.nishi.gravatar.models.Email;
import inc.nishi.gravatar.models.Profile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by alok on 1/11/14
 */
public class GravatarAdapter {

    private static final String REQUEST_METHOD_TYPE = "GET";
    private static GravatarAdapter instance;
    private static String NEW_LINE_CHARACTER = "\n";

    // Singleton
    private GravatarAdapter(){}

    public static GravatarAdapter getInstance() {
        GravatarAdapter.instance = GravatarAdapter.instance == null ? new GravatarAdapter() : GravatarAdapter.instance;
        return GravatarAdapter.instance;
    }

    /**
     * Calls Gravatar API
     * @param email to get profile of
     * @return Profile associated with the given email
     */
    public Profile getProfile(Email email) {
        URL url = GravatarAdapter.getUrlForEmail(email);
        StringBuilder response = new StringBuilder();
        try {
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod(GravatarAdapter.REQUEST_METHOD_TYPE);
            OutputStreamWriter request = new OutputStreamWriter(connection.getOutputStream());
            request.flush();
            request.close();

            InputStreamReader inputStreamReader = new InputStreamReader(connection.getInputStream());
            BufferedReader reader = new BufferedReader(inputStreamReader);
            String line;

            while ((line = reader.readLine()) != null) {
                response.append(line).append(GravatarAdapter.NEW_LINE_CHARACTER);
            }

            inputStreamReader.close();;
            reader.close();

        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }

        if(response.length() > 0) {
            return GravatarAdapter.getProfileFromResponse(response.toString());
        } else {
            // TODO check if http status was 200 else throw exception
            return null;
        }

    }

    /**
     *
     * @param response
     * @return
     */
    private static Profile getProfileFromResponse(String response) {
        // TODO inspect response once
        return null;
    }

    /**
     *
     * @param email
     * @return
     */
    private static URL getUrlForEmail(Email email) {
        return null;
    }



}
