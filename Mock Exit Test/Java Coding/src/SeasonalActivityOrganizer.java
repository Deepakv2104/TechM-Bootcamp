import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

enum Season {
    SPRING, SUMMER, AUTUMN, WINTER
}

enum Activity {
    HIKING, SWIMMING, SKIING, PUMPKIN_CARVING
}

public class SeasonalActivityOrganizer {
    private Map<Season, EnumSet<Activity>> seasonActivities;

    public SeasonalActivityOrganizer() {
        seasonActivities = new HashMap<>();
        for (Season season : Season.values()) {
            seasonActivities.put(season, EnumSet.noneOf(Activity.class));
        }
    }

    public Set<Activity> getActivitiesForSeason(Season season) {
        EnumSet<Activity> activities = seasonActivities.get(season);
        if (activities == null) {
            throw new IllegalArgumentException("Unknown season: " + season);
        }
        return activities;
    }

    public void addActivityForSeason(Activity activity, Season season) {
        EnumSet<Activity> activities = seasonActivities.get(season);
        if (activities == null) {
            throw new IllegalArgumentException("Unknown season: " + season);
        }
        activities.add(activity);
    }

    public void removeActivityFromAllSeasons(Activity activity) {
        for (Season season : Season.values()) {
            EnumSet<Activity> activities = seasonActivities.get(season);
            if (activities.contains(activity)) {
                activities.remove(activity);
            }
        }
    }

    public Set<Activity> getAllActivities() {
        EnumSet<Activity> allActivities = EnumSet.noneOf(Activity.class);
        for (EnumSet<Activity> activities : seasonActivities.values()) {
            allActivities.addAll(activities);
        }
        return allActivities;
    }

    public static void main(String[] args) {
        SeasonalActivityOrganizer organizer = new SeasonalActivityOrganizer();
        organizer.addActivityForSeason(Activity.HIKING, Season.SPRING);
        organizer.addActivityForSeason(Activity.SWIMMING, Season.SUMMER);
        organizer.addActivityForSeason(Activity.SKIING, Season.WINTER);

        System.out.println(organizer.getAllActivities());
        System.out.println(organizer.getActivitiesForSeason(Season.SPRING));
        System.out.println(organizer.getActivitiesForSeason(Season.SUMMER));
        System.out.println(organizer.getActivitiesForSeason(Season.WINTER));

        organizer.removeActivityFromAllSeasons(Activity.HIKING);
        System.out.println(organizer.getActivitiesForSeason(Season.SPRING));
    }
}
