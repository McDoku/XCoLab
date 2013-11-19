package org.xcolab.portlets.proposals.utils;

import java.util.Comparator;

import org.xcolab.portlets.proposals.wrappers.ContestWrapper;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;


public enum ContestsColumn {
    
    CONTEST_NAME (new Comparator<ContestWrapper>() {

        @Override
        public int compare(ContestWrapper o1, ContestWrapper o2) {
            return o1.getContestShortName().toLowerCase().compareTo(o2.getContestShortName().toLowerCase());
        }
    }),
    PROPOSALS_COUNT(new Comparator<ContestWrapper>() {

        @Override
        public int compare(ContestWrapper o1, ContestWrapper o2) {
            try {
                return (int) (o1.getProposalsCount() - o2.getProposalsCount());
            } catch (PortalException e) {
                _log.error("Can't get proposals count", e);
            } catch (SystemException e) {
                _log.error("Can't get proposals count", e);
            }
            return 0;
        }
    }),
    COMMENTS_COUNT(new Comparator<ContestWrapper>() {

        @Override
        public int compare(ContestWrapper o1, ContestWrapper o2) {
            try {
                return (int) (o1.getCommentsCount() - o2.getCommentsCount());
            } catch (PortalException e) {
                _log.error("Can't get comments count", e);
            } catch (SystemException e) {
                _log.error("Can't get comments count", e);
            }
            return 0;
        }
    }),
    VOTES_COUNT(new Comparator<ContestWrapper>() {

        @Override
        public int compare(ContestWrapper o1, ContestWrapper o2) {

            try {
                return (int) (o1.getVotesCount() - o2.getVotesCount());
            } catch (PortalException e) {
                _log.error("Can't get votes count", e);
            } catch (SystemException e) {
                _log.error("Can't get votes count", e);
            }
            return 0;
        }
    }),
    WHAT(new Comparator<ContestWrapper>() {

        @Override
        public int compare(ContestWrapper o1, ContestWrapper o2) {
            try {
                return o1.getWhatName().toLowerCase().compareTo(o2.getWhatName().toLowerCase());
            } catch (PortalException e) {
                _log.error("Can't get what for contest", e);
            } catch (SystemException e) {
                _log.error("Can't get what for contest", e);
            }
            return 0;
        }
    }),
    WHERE(new Comparator<ContestWrapper>() {

        @Override
        public int compare(ContestWrapper o1, ContestWrapper o2) {
            try {
                return o1.getWhereName().toLowerCase().compareTo(o2.getWhereName().toLowerCase());
            } catch (PortalException e) {
                _log.error("Can't get where for contest", e);
            } catch (SystemException e) {
                _log.error("Can't get where for contest", e);
            }
            return 0;
        }
    }),
    WHO(new Comparator<ContestWrapper>() {

        @Override
        public int compare(ContestWrapper o1, ContestWrapper o2) {
            try {
                return o1.getWhoName().toLowerCase().compareTo(o2.getWhoName().toLowerCase());
            } catch (PortalException e) {
                _log.error("Can't get who for contest", e);
            } catch (SystemException e) {
                _log.error("Can't get who for contest", e);
            }
            return 0;
        }
    }),
    DEFAULT(new Comparator<ContestWrapper>() {

        @Override
        public int compare(ContestWrapper o1, ContestWrapper o2) {
            return o1.getWeight() - o2.getWeight();
        }
    });
    
    private final Comparator<ContestWrapper> columnComparator;

    private ContestsColumn(Comparator<ContestWrapper> columnComparator) {
        this.columnComparator = columnComparator;
    }
    
    public Comparator<ContestWrapper> getColumnComparator() {
        return columnComparator;
    }

    private final static Log _log = LogFactoryUtil.getLog(ContestsColumn.class);
}