<jsp:root xmlns:c="http://java.sun.com/jsp/jstl/core"
          xmlns:jsp="http://java.sun.com/JSP/Page"
          xmlns:fn="http://java.sun.com/jsp/jstl/functions"
          xmlns:fmt="http://java.sun.com/jsp/jstl/fmt"
          xmlns:spring="http://www.springframework.org/tags"
          xmlns:form="http://www.springframework.org/tags/form"
          xmlns:proposalsPortlet="urn:jsptagdir:/WEB-INF/tags/proposalsPortlet"
          xmlns:liferay-ui="http://liferay.com/tld/ui"
          xmlns:portlet="http://java.sun.com/portlet_2_0" version="2.0">
    <jsp:directive.include file="./init.jspx" />

    <jsp:directive.include file="./proposalDetails/header.jspx" />


    <div id="content">
        <liferay-ui:success key="membershipRequestSent" message="Membership request sent" />
        <liferay-ui:success key="memberInviteSent" message="Membership invitation sent" />

        <liferay-ui:error key="memberInviteRecipientError" message="The specified invitee is invalid." />
        <div class="headline prophead" style="position: relative;">
            <h2>
                <span>${fn:length(proposal.members)}</span> ${fn:length(proposal.members) == 1 ? 'member' : 'members'}
            </h2>
            <c:if test="${!proposalsPermissions.isTeamMember and !proposalsPermissions.userHasOpenMembershipRequest}">
                <div class="prop-butt-popover">
                    <img src="/climatecolab-theme/images/icon-request-membership.png"
                         width="24" height="22" alt="request membership" class="request-membership-icon"/>


                    <portlet:actionURL var="requestMembershipURL">
                        <portlet:param name="action_forwardToPage" value="proposalDetails_TEAM" />
                        <portlet:param name="contestId" value="${contest.contestPK }" />
                        <portlet:param name="planId" value="${proposal.proposalId }" />
                        <portlet:param name="action" value="requestMembership" />
                    </portlet:actionURL>

                    <form:form id="requestMembershipForm" action="${requestMembershipURL }" method="post" commandName="requestMembershipBean" style="float:left;">
                        <div class="requestMembershipDIV">
                            <form:textarea id="requestComment" cssClass="requestComment" path="requestComment" onfocus="this.value=''" value="Optional comment" style="display:none;"/>
                            <form:errors cssClass="alert alert-error" path="requestComment" />
                            <div id="requestButtons">
                                <div class="blue-button" style="display:block;">
                                    <a href="javascript:;" class="requestMembershipSubmitButton" onclick="if(deferUntilLogin()) requestMembership();">Request membership</a>
                                </div>
                            </div>
                        </div>
                    </form:form>
                </div>
            </c:if>
            <c:if test="${proposalsPermissions.isTeamMember}">
                <div class="prop-butt-popover">
                    <img src="/climatecolab-theme/images/icon-request-membership.png"
                         width="24" height="22" alt="request membership" class="request-membership-icon"/>


                    <portlet:actionURL var="inviteMemberURL">
                        <portlet:param name="action_forwardToPage" value="proposalDetails_TEAM" />
                        <portlet:param name="contestId" value="${contest.contestPK }" />
                        <portlet:param name="planId" value="${proposal.proposalId }" />
                        <portlet:param name="action" value="inviteMember" />
                    </portlet:actionURL>

                    <portlet:resourceURL id="inviteMembers-validateRecipient" var="inviteMemberValidationURL">
                    </portlet:resourceURL>

                    <form:form id="requestInviteForm" action="${inviteMemberURL }" method="post" commandName="requestMembershipInviteBean" style="float:left;">
                        <div class="requestMembershipDIV">
                            <form:textarea id="invite-recipient" cssClass="requestComment" path="inviteRecipient" placeholder="Enter screen name or last name" style="display:none;"/>
                            <div id="invite-member-validation-url" style="display: none">${inviteMemberValidationURL}</div>
                            <form:textarea id="invite-comment" cssClass="requestComment" path="inviteComment" placeholder="Optional comment" style="display:none;"/>
                            <!--<form:errors cssClass="alert alert-error" path="requestComment" />-->
                            <div id="requestButtons">
                                <div class="blue-button" style="display:block;">
                                    <a href="javascript:;" class="requestMembershipSubmitButton" onclick="if(deferUntilLogin()) inviteMember();">Invite team member</a>
                                </div>
                            </div>
                        </div>
                    </form:form>
                </div>
            </c:if>


        </div>
        <table class="contributors">
            <c:forEach var="member" items="${proposal.members }" varStatus="status">


                <portlet:actionURL var="removeUserFromTeam">
                    <portlet:param name="action_forwardToPage" value="proposalDetails_TEAM" />
                    <portlet:param name="contestId" value="${contest.contestPK }" />
                    <portlet:param name="planId" value="${proposal.proposalId }" />
                    <portlet:param name="action" value="removeUserFromTeam" />
                    <portlet:param name="member" value="${member.userId}" />
                </portlet:actionURL>



                <tr class="${status.index mod 2 > 0 ? 'even' : 'odd'}">
                    <td><proposalsPortlet:proposalTeamMember member="${member }" /></td>
                    <td>${member.memberType }</td>
                    <td>
                        <c:if test="${member.memberType != 'Owner'}">
                            <a href="${removeUserFromTeam }">Remove</a>
                        </c:if>
                    </td>
                </tr>
            </c:forEach>
        </table>


        <div class="headline propsubhead">
            <h2>
                <span>${fn:length(proposal.supporters)}</span> ${fn:length(proposal.supporters) == 1 ? 'supporter' : 'supporters' }
            </h2>
            <c:if test="${proposalsPermissions.canSeeSupportButton or proposalsPermissions.canSeeUnsupportButton  }">
                <portlet:actionURL var="supportProposalActionURL">
                    <portlet:param name="action_forwardToPage" value="proposalDetails_TEAM" />
                    <portlet:param name="contestId" value="${contest.contestPK }" />
                    <portlet:param name="planId" value="${proposal.proposalId }" />
                    <portlet:param name="proposalId" value="${proposal.proposalId }" />
                    <portlet:param name="action" value="supportProposalAction" />
                </portlet:actionURL>
                <div class="prop-butt">
                    <img src="/climatecolab-theme/images/icon-proposal-thumb.png" width="20" height="22" alt="support proposal" />
                    <div class="blue-button">
                        <a href="${proposalsPermissions.canSupportProposal ? supportProposalActionURL : '#' }" onclick="if(!deferUntilLogin()) return false;">
                                ${proposalsPermissions.canSeeSupportButton ? 'Support proposal' : 'Retract support' }
                        </a>
                    </div>
                </div>
            </c:if>
        </div>
        <c:if test="${not empty proposal.supporters }">
            <table class="contributors">
                <c:forEach var="supporter" items="${proposal.supporters }" varStatus="status" step="2">
                    <tr class="${(status.index / 2) mod 2 > 0 ? 'even' : 'odd'}">
                        <td><proposalsPortlet:userLinkSimple userId="${supporter.userId}" text="${supporter.screenName}" /></td>
                        <td>
                            <c:if test="${fn:length(proposal.supporters) > status.index}">
                                <proposalsPortlet:userLinkSimple userId="${proposal.supporters[status.index+1].userId}" text="${proposal.supporters[status.index+1].screenName}" />
                            </c:if>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </c:if>





    </div>
</jsp:root>