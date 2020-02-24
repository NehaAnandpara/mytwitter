
import twitter4j.ResponseList;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;

public class UserTimeline {
    public ResponseList<Status> GetTimeline(Twitter twitterInstance) {
        try {
           return twitterInstance.getUserTimeline();
        } catch (TwitterException e) {
            e.printStackTrace();
        }
        return null;
    }
}
