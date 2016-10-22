package org.seuge.newsfetcher.model.feed_updates;

/**
 * New name of a feed.
 * @author Eugene
 * @since 1.0
 */
public class FeedNameUpdate extends FeedUpdate {

    private final String newName;

    public FeedNameUpdate(String newName) {
        this.newName = newName;
    }

    public String getNewName() {
        return newName;
    }

    @Override public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        if (!super.equals(o))
            return false;

        FeedNameUpdate that = (FeedNameUpdate) o;

        return !(newName != null ? !newName.equals(that.newName) : that.newName != null);

    }

    @Override public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (newName != null ? newName.hashCode() : 0);
        return result;
    }

    @Override public String toString() {
        return "FeedNameUpdate{" +
                "newName='" + newName + '\'' +
                "} " + super.toString();
    }
}
