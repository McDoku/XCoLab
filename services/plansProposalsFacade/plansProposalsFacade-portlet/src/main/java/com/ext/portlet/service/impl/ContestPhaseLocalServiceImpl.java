package com.ext.portlet.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import com.ext.portlet.JudgingSystemActions;
import com.ext.portlet.NoSuchContestPhaseException;
import com.ext.portlet.ProposalContestPhaseAttributeKeys;
import com.ext.portlet.contests.ContestStatus;
import com.ext.portlet.model.Contest;
import com.ext.portlet.model.ContestPhase;
import com.ext.portlet.model.ContestPhaseColumn;
import com.ext.portlet.model.PlanItem;
import com.ext.portlet.model.Proposal;
import com.ext.portlet.model.Proposal2Phase;
import com.ext.portlet.model.ProposalContestPhaseAttribute;
import com.ext.portlet.service.ContestLocalServiceUtil;
import com.ext.portlet.service.ContestPhaseColumnLocalServiceUtil;
import com.ext.portlet.service.ContestPhaseLocalService;
import com.ext.portlet.service.ContestPhaseLocalServiceUtil;
import com.ext.portlet.service.ContestPhaseTypeLocalServiceUtil;
import com.ext.portlet.service.PlanItemLocalServiceUtil;
import com.ext.portlet.service.Proposal2PhaseLocalServiceUtil;
import com.ext.portlet.service.ProposalContestPhaseAttributeLocalServiceUtil;
import com.ext.portlet.service.ProposalLocalServiceUtil;
import com.ext.portlet.service.ProposalVersionLocalServiceUtil;
import com.ext.portlet.service.base.ContestPhaseLocalServiceBaseImpl;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.OrderByComparator;

/**
 * The implementation of the contest phase local service.
 * <p/>
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * {@link com.ext.portlet.service.ContestPhaseLocalService} interface.
 * <p/>
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.ext.portlet.service.base.ContestPhaseLocalServiceBaseImpl
 * @see com.ext.portlet.service.ContestPhaseLocalServiceUtil
 */
public class ContestPhaseLocalServiceImpl extends ContestPhaseLocalServiceBaseImpl {
    /*
     * NOTE FOR DEVELOPERS:
     * 
     * Never reference this interface directly. Always use {@link
     * com.ext.portlet.service.ContestPhaseLocalServiceUtil} to access the
     * contest phase local service.
     */
    private final static Log _log = LogFactoryUtil.getLog(ContestPhaseLocalServiceImpl.class);

    public List<PlanItem> getPlans(ContestPhase contestPhase) throws SystemException, PortalException {
        return PlanItemLocalServiceUtil.getPlans(Collections.emptyMap(), Collections.emptyMap(), 0L,
                contestPhase.getContestPhasePK(), 0, Integer.MAX_VALUE, "", "", false);
        // return PlanItemLocalServiceUtil.getPlansInContestPhase(this);
    }

    public ContestStatus getContestStatus(ContestPhase contestPhase) throws SystemException, PortalException {
        String status = ContestPhaseTypeLocalServiceUtil.getContestPhaseType(contestPhase.getContestPhaseType())
                .getStatus();
        return status == null ? null : ContestStatus.valueOf(status);
    }

    public String getContestStatusStr(ContestPhase contestPhase) throws SystemException, PortalException {
        String status = ContestPhaseTypeLocalServiceUtil.getContestPhaseType(contestPhase.getContestPhaseType())
                .getStatus();
        return status;
    }

    public List<String> getPhaseColumns(ContestPhase contestPhase) throws SystemException {
        List<String> ret = new ArrayList<String>();
        for (ContestPhaseColumn phaseColumn : ContestPhaseColumnLocalServiceUtil.getPhaseColumns(contestPhase
                .getContestPhasePK())) {
            ret.add(phaseColumn.getColumnName());
        }
        return ret;
    }

    public List<ContestPhaseColumn> getPhaseColumnsRaw(ContestPhase contestPhase) throws SystemException {
        return ContestPhaseColumnLocalServiceUtil.getPhaseColumns(contestPhase.getContestPhasePK());
    }

    public List<ContestPhase> getPreviousPhases(ContestPhase contestPhase) throws SystemException, PortalException {
        List<ContestPhase> phases = ContestPhaseLocalServiceUtil.getPhasesForContest(getContest(contestPhase));
        List<ContestPhase> ret = new ArrayList<ContestPhase>();
        for (ContestPhase phase : phases) {
            if (phase.getPhaseStartDate().before(contestPhase.getPhaseStartDate())) {
                ret.add(phase);
            }
        }
        return ret;
    }

    public ContestPhase getNextContestPhase(ContestPhase contestPhase) throws SystemException, PortalException {
        boolean currentFound = false;
        for (ContestPhase phase : ContestPhaseLocalServiceUtil.getPhasesForContest(getContest(contestPhase))) {
            if (currentFound) {
                return phase;
            }
            if (phase.getContestPhasePK() == contestPhase.getContestPhasePK()) {
                currentFound = true;
            }
        }
        throw new SystemException("Can't find next phase for phase with id: " + contestPhase.getContestPhasePK());
    }

    public boolean getPhaseActive(ContestPhase contestPhase) {
        if (contestPhase.getPhaseActiveOverride()) {
            return contestPhase.getPhaseActiveOverride();
        }
        if (contestPhase.getPhaseInactiveOverride()) {
            return contestPhase.getPhaseInactiveOverride();
        }
        if (contestPhase.getPhaseStartDate() != null) {
            java.util.Date now = new java.util.Date();
            if (now.after(contestPhase.getPhaseStartDate())) {
                if (contestPhase.getPhaseEndDate() != null) {
                    return now.before(contestPhase.getPhaseEndDate());
                }
                return true;
            }
        }
        return false;
    }

    public List<ContestPhase> getPhasesForContest(Contest contest) throws SystemException {
        return contestPhasePersistence.findByContestId(contest.getContestPK());
    }

    public List<ContestPhase> getPhasesForContest(long contestPK) throws SystemException {
        return contestPhasePersistence.findByContestId(contestPK);
    }

    public ContestPhase getActivePhaseForContest(Contest contest) throws SystemException {
        Date now = new Date();
        try {
            return contestPhasePersistence.findByPhaseActiveOverride_Last(contest.getContestPK(), true,
                    new OrderByComparator() {

                        private final String[] ORDERY_BY_FIELDS = new String[]{"PhaseStartDate"};

                        @Override
                        public String[] getOrderByFields() {
                            return ORDERY_BY_FIELDS;
                        }

                        @Override
                        public int compare(Object arg0, Object arg1) {
                            if (((ContestPhase) arg0).getPhaseStartDate().before(
                                    ((ContestPhase) arg1).getPhaseStartDate())) {
                                return -1;
                            }
                            return 1;
                        }
                    });
        } catch (NoSuchContestPhaseException e) {
            // ignore
        }
        List<ContestPhase> phases = contestPhasePersistence.findByContestIdStartEnd(contest.getContestPK(), now, now);
        // Either there is no contest phase or there is a phase which enddate is open
        if (phases.isEmpty()) {

            // Check whether the contestPhase with the latest start date is open (no endDate)
            ContestPhase latestOpenPhase = null;
            long latestStartTime = 0;
            for (ContestPhase phase : contestLocalService.getPhases(contest)) {
                if (phase.getPhaseStartDate().getTime() > latestStartTime) {
                    if (phase.getPhaseEndDate() != null) {
                        latestOpenPhase = null;
                    } else {
                        latestOpenPhase = phase;
                    }
                }
            }

            if (latestOpenPhase == null) {
                throw new SystemException("Can't find active contest phase for contest " + contest.getContestPK());
            }

            return latestOpenPhase;

        }
        return phases.get(0);
    }

    /**
     * from ContestPhaseImpl *
     */

    public Contest getContest(ContestPhase contestPhase) throws SystemException, PortalException {
        return ContestLocalServiceUtil.getContest(contestPhase.getContestPK());
    }

    public String getName(ContestPhase contestPhase) throws PortalException, SystemException {
        return ContestPhaseTypeLocalServiceUtil.getContestPhaseType(contestPhase.getContestPhaseType()).getName();
    }

    public void promoteProposal(long proposalId, long nextPhaseId) throws SystemException, PortalException {
        Long currentProposalVersion = ProposalVersionLocalServiceUtil.countByProposalId(proposalId);
        if (currentProposalVersion == null || currentProposalVersion < 0)
            throw new SystemException("Proposal not found");

        ContestPhase nextPhase = getContestPhase(nextPhaseId);
        if (nextPhase == null) throw new SystemException("phase not found");

        //find phase the proposal is in currently in contest c
        List<Long> phases = Proposal2PhaseLocalServiceUtil.getContestPhasesForProposal(proposalId);
        List<ContestPhase> candidatePhase = new LinkedList<>();

        for (Long phId : phases) {
            ContestPhase ph = getContestPhase(phId);
            if (ph.getContestPK() == nextPhase.getContestPK()) { //this contestphase is in our target contest
                candidatePhase.add(ph);
            }
        }

        boolean isBoundedVersion = false;
        if (candidatePhase.size() > 0) {
            //candidate phase now contains all contestphases the proposal has been submitted to of the target contest
            //we now need to find the one that is closest to the next phase in order to provide a smooth promotion
            //set end version of previous phase to now
            ContestPhase closestPhase = candidatePhase.get(0);
            for (ContestPhase current : candidatePhase) {
                if (current.getPhaseStartDate().after(closestPhase.getPhaseStartDate())) {
                    closestPhase = current;
                }
            }

            Proposal2Phase o = Proposal2PhaseLocalServiceUtil.getByProposalIdContestPhaseId(proposalId, closestPhase.getContestPhasePK());
            if (o.getVersionTo() < 0) {
                o.setVersionTo(currentProposalVersion.intValue());
                Proposal2PhaseLocalServiceUtil.updateProposal2Phase(o);
            } else isBoundedVersion = true;
        }

        Proposal2Phase p2p = Proposal2PhaseLocalServiceUtil.create(proposalId, nextPhaseId);
        p2p.setVersionFrom(currentProposalVersion.intValue());
        p2p.setVersionTo(isBoundedVersion ? currentProposalVersion.intValue() : -1);
        Proposal2PhaseLocalServiceUtil.updateProposal2Phase(p2p);
    }

    /**
     * Method responsible for autopromotion of proposals between phases.
     *
     * @throws SystemException
     * @throws PortalException
     */
    public void autoPromoteProposals() throws SystemException, PortalException {
        Date now = new Date();
        for (ContestPhase phase : contestPhasePersistence.findByPhaseAutopromote("PROMOTE")) {
            if (phase.getPhaseEndDate() != null && phase.getPhaseEndDate().before(now) && !getPhaseActive(phase)) {
                // we have a candidate for promotion, find next phase
                try {
                    _log.info("promoting phase " + phase.getContestPhasePK());
                    ContestPhase nextPhase = getNextContestPhase(phase);
                    for (Proposal p : ProposalLocalServiceUtil.getProposalsInContestPhase(phase.getContestPhasePK())) {
                        promoteProposal(p.getProposalId(), nextPhase.getContestPhasePK());
                    }

                    // update phase for which promotion was done (mark it as
                    // "promotion done")
                    phase.setContestPhaseAutopromote("PROMOTE_DONE");
                    updateContestPhase(phase);
                    _log.info("done promoting phase " + phase.getContestPhasePK());
                } catch (SystemException | PortalException e) {
                    _log.error("Exception thrown when doing autopromotion for phase " + phase.getContestPhasePK(), e);
                    continue;
                }
            }
        }

        //Judging-based promotion
        for (ContestPhase phase : contestPhasePersistence.findByPhaseAutopromote("PROMOTE_JUDGED")) {
            if (phase.getPhaseEndDate() != null && phase.getPhaseEndDate().before(now) && !getPhaseActive(phase)) {
                _log.info("promoting phase " + phase.getContestPhasePK() + " (judging)");
                ContestPhase nextPhase = getNextContestPhase(phase);
                for (Proposal p : ProposalLocalServiceUtil.getProposalsInContestPhase(phase.getContestPhasePK())) {
                    ProposalContestPhaseAttribute data = getAttribute(p.getProposalId(), phase.getContestPhasePK(), ProposalContestPhaseAttributeKeys.JUDGE_ACTION);
                    Long intData = (data == null) ? JudgingSystemActions.JudgeAction.NO_DECISION.getAttributeValue() : data.getNumericValue();

                    if (JudgingSystemActions.JudgeAction.fromInt(intData.intValue()) == JudgingSystemActions.JudgeAction.MOVE_ON) {
                        promoteProposal(p.getProposalId(), nextPhase.getContestPhasePK());
                    }
                }
                phase.setContestPhaseAutopromote("PROMOTE_DONE");
                updateContestPhase(phase);
                _log.info("done promoting phase " + phase.getContestPhasePK());
            }
        }
    }

    private ProposalContestPhaseAttribute getAttribute(long proposalId, long phaseId, String key) {
        try {
            return ProposalContestPhaseAttributeLocalServiceUtil.getProposalContestPhaseAttribute(proposalId, phaseId, key);
        } catch (Exception e) {
            return null;
        }
    }
}
