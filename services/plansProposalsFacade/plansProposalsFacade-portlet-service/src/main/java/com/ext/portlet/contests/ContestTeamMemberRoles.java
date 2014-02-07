package com.ext.portlet.contests;

/**
 * @author pdeboer
 *         First created on 07/02/14 at 15:03
 */
public enum ContestTeamMemberRoles {
    FELLOW("Fellow"), JUDGE("Judge");

    private String displayName;

    ContestTeamMemberRoles(String name) {
        this.displayName = name;
    }

    public String getDisplayName() {
        return displayName;
    }
}
