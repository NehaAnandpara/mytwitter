
import twitter4j.*;
import twitter4j.auth.AccessToken;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class TwitterDemo {
    public static void main(String[] args) {
        System.out.println(System.getProperty("user.dir"));
        try (InputStream input = new FileInputStream("src/main/resources/credentials.properties")) {
            Twitter twitterInstance = new TwitterFactory().getInstance();
            ResponseList<Status> statuses;
            Properties prop = new Properties();
            prop.load(input);

            String consumerKeyStr = prop.getProperty("oauth.consumerKey");
            String consumerSecretStr = prop.getProperty("oauth.consumerSecret");
            String accessTokenStr = prop.getProperty("oauth.accessToken");
            String accessTokenSecretStr = prop.getProperty("oauth.accessTokenSecret");


            twitterInstance.setOAuthConsumer(consumerKeyStr, consumerSecretStr);
            AccessToken accessToken = new AccessToken(accessTokenStr,
                    accessTokenSecretStr);

            twitterInstance.setOAuthAccessToken(accessToken);

            TweetPublish publishTweet = new TweetPublish();
            UserTimeline printTimeline = new UserTimeline();

            publishTweet.PublishTweet(twitterInstance, "My New Post");
            System.out.println("Status are as follows:");
            statuses = printTimeline.GetTimeline(twitterInstance);
            System.out.println(statuses);
            System.out.println("Thank you.");

        } catch(FileNotFoundException te) {

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
