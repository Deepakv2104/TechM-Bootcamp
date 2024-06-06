package AssociateForGivenTechnology;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static Associate[] associatesForGivenTechnology(Associate[] associates, String searchTechnology) {
        List<Associate> filteredAssociates = new ArrayList<>();
        for (Associate associate : associates) {
            if (associate.getTechnology().equalsIgnoreCase(searchTechnology) &&
                associate.getExperienceInYears() % 5 == 0) {
                filteredAssociates.add(associate);
            }
        }
        return filteredAssociates.toArray(new Associate[0]);
    }
}
