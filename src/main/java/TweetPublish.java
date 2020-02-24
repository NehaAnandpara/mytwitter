import twitter4j.Twitter;
import twitter4j.TwitterException;


public class TweetPublish {
    public void PublishTweet(Twitter twitterInstance, String newPost) {
        try {
            twitterInstance.updateStatus(newPost);
        } catch (TwitterException te) {
            te.printStackTrace();
        }
    }
}
