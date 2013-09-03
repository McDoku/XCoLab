package org.xcolab.portlets.loginregister.conference;

import org.apache.poi.ss.usermodel.Row;

import java.util.Date;

/**
* @author pdeboer
*         First created on 8/28/13 at 5:24 PM
*/
class ConferenceUser {
    private String lastName, firstName, middleName, eMail, secondaryEmail;
    Date regDate;

    ConferenceUser(Row row) {
        lastName = row.getCell(1).getStringCellValue();
        firstName = row.getCell(2).getStringCellValue();
        middleName = row.getCell(3).getStringCellValue();
        eMail = row.getCell(4).getStringCellValue();
        secondaryEmail = row.getCell(5).getStringCellValue();
//            regDate = row.getCell(6).getDateCellValue();
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public String geteMail() {
        return eMail;
    }

    public String getSecondaryEmail() {
        return secondaryEmail;
    }

    public Date getRegDate() {
        return regDate;
    }
}